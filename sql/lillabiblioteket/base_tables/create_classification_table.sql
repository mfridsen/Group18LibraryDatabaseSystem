CREATE TABLE `Classification` (
  `Classification_ID` INT AUTO_INCREMENT,
  `Name` VARCHAR(255) NOT NULL,
  `Parent_ID` INT,
  `Description` TEXT,
  PRIMARY KEY (`Classification_ID`),
  FOREIGN KEY (`Parent_ID`) REFERENCES `Classification`(`Classification_ID`)
);