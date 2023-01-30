CREATE TABLE `Item_Author` (
  `Item_ID` INT,
  `Author_ID` INT,
  PRIMARY KEY (`Item_ID`, `Author_ID`),
  FOREIGN KEY (`Item_ID`) REFERENCES `Item`(`Item_ID`),
  FOREIGN KEY (`Author_ID`) REFERENCES `Author`(`Author_ID`)
);