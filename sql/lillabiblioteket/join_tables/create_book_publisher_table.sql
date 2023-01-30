CREATE TABLE `Book_Publisher` (
  `Publisher_ID` INT,
  `Book_ID` INT,
  PRIMARY KEY (`Publisher_ID`, `Book_ID`),
  FOREIGN KEY (`Book_ID`) REFERENCES `Book`(`Book_ID`),
  FOREIGN KEY (`Publisher_ID`) REFERENCES `Publisher`(`Publisher_ID`)
);