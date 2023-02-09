--min rutin
-------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/Kod som kollar hur många lån kunden har beroende på vad det är för kund*/
CREATE DEFINER=`root`@`localhost` PROCEDURE `new_procedure_kollarhurmångaböckerdelånat`(in kundnr int,IN staffnr INT,IN bokid int)
BEGIN
DECLARE EXIT HANDLER FOR SQLSTATE '45000';
BEGIN
    SET MYSQL_ERRNO = 1644
        MESSAGE_TEXT = 'för många böcker';
    END;
DECLARE ANTALLÅN int;
DECLARE MAXBÖCKER int;
DECLARE lånetid int;

SET ANTALLÅN = (SELECT Items_Rented FROM Patron JOIN Patron_Type ON Patron.Patron_Type_ID = Patron_Type.Patron_Type_ID WHERE Patron_ID = kundnr
GROUP BY Patron_ID);
/*kollar hur många lån kunden har*/

SET MAXBÖCKER = (SELECT Max_Items FROM Patron_Type JOIN Patron ON Patron_Type.Patron_Type_ID = Patron.Patron_Type_ID WHERE Patron_ID = kundnr
GROUP BY Patron_ID);
/* kollar max antallet lån en kund får ha beroende på vad det är för kund*/

SET lånetid = (SELECT Rent_Time_Weeks FROM Item WHERE Item_ID = bokid);

IF ANTALLÅN >= MAXBÖCKER THEN
    SIGNAL SQLSTATE '45000' SET
    MYSQL_ERRNO = 1644,
    MESSAGE_TEXT = 'Du Kan Inte Låna Mer';

ELSE INSERT INTO Item_Checkout(Item_ID, Due_Date) VALUES (bokid, ADDDATE(CURRENT_DATE(),INTERVAL lånetid WEEK));
INSERT INTO Checkout(Patron_ID, Staff_ID, Status) VALUES (kundnr, staffnr, 1);


END IF;
END


-------------------------------------------------------------------------------------------------------------------------------------------------------------------


/*Kod för att ändra antal lånade böcker en kund har i “patron” efter man lägger in något i “Checkout”
kan behöva lägga till en "update" trigger som tar bort "antal lån en kund har" om kunden lämnar tillbaka böcker
för den här koden lägger endast till lån.*/
CREATE DEFINER = CURRENT_USER TRIGGER `sys`.`Checkout_AFTER_INSERT` AFTER INSERT ON `Checkout` FOR EACH ROW
BEGIN
update sys.Patron, (SELECT Patron_ID as hejsan, COUNT(Patron_ID) AS hej FROM Checkout WHERE Status = 1  GROUP by Patron_ID
ORDER BY Patron_ID ASC) as nyatabellen

set Items_Rented = hej WHERE Patron.Patron_ID = nyatabellen.hejsan;

END


-------------------------------------------------------------------------------------------------------------------------------------------------------------------


*/trigger i tabellen "Item_Checkout" som kollar om det man försöker låna är en referenseliteratur
-- När man kör den första proceduren så lägger den automatiskt in 4 eller 8 veckor av lånetid på dagens datum
--Eftersom Referensliteratur har en lånetid på 0 veckor så kollar den här koden om "Due_Date" är samma som idag */
CREATE DEFINER = CURRENT_USER TRIGGER `sys`.`Item_Checkout_BEFORE_INSERT_kollar_referenseliteratur` AFTER INSERT ON `Item_Checkout` FOR EACH ROW
BEGIN
IF NEW.Due_Date <= current_timestamp() THEN
/*-- om "Due_Date" <= Nu, då får man inte låna eftersom boken är referensliteratur*/
	SIGNAL SQLSTATE '45000' SET
		MYSQL_ERRNO = 1644,
        MESSAGE_TEXT = 'ReferensLiteratur';
END IF;
END


-------------------------------------------------------------------------------------------------------------------------------------------------------------------


/*--räknar hur många kopior av en bok biblioteket har som inte är referensliteratur*/
CREATE DEFINER=`root`@`localhost` FUNCTION `new_function_också_försök_till_endast_låna_ut_aaa_du_fattar`(hej int) RETURNS int
    DETERMINISTIC
BEGIN
DECLARE Boknamn varchar(100);
DECLARE hurmånga INT;
set Boknamn = (SELECT Title FROM Item WHERE Item_ID = hej);
*/--'Boknamn' = namnet på boken som kunden försöker hyra*/
set hurmånga = (SELECT COUNT(Title) FROM Item WHERE Title = Boknamn AND Rent_Time_Weeks > 1);
*/--'hurmånga' = hur många böcker vi har som heter det variabeln 'Boknamn' är.*/
RETURN hurmånga;
END


-------------------------------------------------------------------------------------------------------------------------------------------------------------------


/*--trigger på “Item_Checkout” som endast tillåter låna ut så många böcker*/
CREATE DEFINER = CURRENT_USER TRIGGER `sys`.`Item_Checkout_BEFORE_INSERT_Antal_Böcker_Kvar` BEFORE INSERT ON `Item_Checkout` FOR EACH ROW
BEGIN
DECLARE HEJ int;
DECLARE HEJSAN INT;
SET HEJSAN = new_function_också_försök_till_endast_låna_ut_aaa_du_fattar(NEW.Item_ID);
SET HEJ = new_function_hitta_namn_på_senast_insatta(NEW.Item_ID);
IF HEJ >= HEJSAN THEN
SIGNAL SQLSTATE '45000' SET
		MYSQL_ERRNO = 1644,
        MESSAGE_TEXT = 'Slut På Den Boken';
END IF;
END


-------------------------------------------------------------------------------------------------------------------------------------------------------------------


CREATE DEFINER=`root`@`localhost` FUNCTION `new_function_hitta_namn_på_senast_insatta`(hej int) RETURNS int
    DETERMINISTIC
BEGIN
DECLARE APA VARCHAR(100);
DECLARE ORANGUTANG int;
SET APA = (SELECT Title FROM Item WHERE Item_ID = hej);
SET ORANGUTANG = (SELECT COUNT(Title)FROM Item_Checkout JOIN Item ON Item_Checkout.Item_ID = Item.Item_ID
JOIN Checkout ON Item_Checkout.Checkout_ID = Checkout.Checkout_ID WHERE Title = APA AND Status = 1);
RETURN ORANGUTANG;
END