CREATE TABLE `Reservation` (
  `Reservation ID` INT AUTO_INCREMENT NOT NULL,
  `Patron_ID` INT NOT NULL,
  `Item_ID` INT NOT NULL,
  PRIMARY KEY (`Reservation ID`),
  FOREIGN KEY (`Patron_ID`) REFERENCES `Patron`(`Patron_ID`)
);