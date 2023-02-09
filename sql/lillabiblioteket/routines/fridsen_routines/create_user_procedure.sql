DELIMITER $$
CREATE PROCEDURE `CreateUser` (
    IN p_UserName VARCHAR(255),
    IN p_Password VARCHAR(255),
    IN p_FirstName VARCHAR(255),
    IN p_LastName VARCHAR(255),
    IN p_PhoneNum VARCHAR(255),
    IN p_Mail VARCHAR(255),
    IN p_DateCreated DATE,
    IN p_UserType ENUM('Patron', 'Staff', 'Patron_and_Staff'),
    IN p_PatronType ENUM('Student', 'Teacher', 'Researcher'),
    IN p_ItemsRented INT,
    IN p_DateHired DATE,
    IN p_StaffType ENUM ('Staff', 'Manager', 'Admin')
)
BEGIN
    -- Insert new row into User table
    INSERT INTO `User` (
        `User_Name`,
        `Password`,
        `First_Name`,
        `Last_Name`,
        `Phone_Num`,
        `Mail`,
        `Date_Created`,
        `User_Type`
    )
    VALUES (p_UserName, p_Password, p_FirstName, p_LastName, p_PhoneNum, p_Mail, p_DateCreated, p_UserType);

    -- Get the User_ID of the newly inserted user
    SET @user_id = LAST_INSERT_ID();

    -- Insert new row into either Patron or Staff table, depending on the value of User_Type
    IF p_UserType = 'Patron' THEN
        INSERT INTO `Patron` (
            `Patron_ID`,
            `Patron_Type_ID`,
            `Items_Rented`
        )
        VALUES (@user_id, (SELECT `Patron_Type_ID` FROM `Patron_Type` WHERE `Patron_Type` = p_PatronType), p_ItemsRented);
    ELSEIF p_UserType = 'Staff' THEN
        INSERT INTO `Staff` (
            `Staff_ID`,
            `Date_Hired`,
            `Staff_Type_ID`
        )
        VALUES (@user_id, p_DateHired, (SELECT `Staff_Type_ID` FROM `Staff_Type` WHERE `Staff_Type` = p_StaffType));
    END IF;
END $$
DELIMITER ;