CREATE TABLE `Author` (
  `Author_ID` INT AUTO_INCREMENT,
  `Sur_Name` VARCHAR(255) NOT NULL,
  `Last_Name` VARCHAR(255) NOT NULL,
  `Date_of_Birth` DATE,	-- DD:MM:YYYY
  `Description` TEXT,
  PRIMARY KEY (`Author_ID`)
);