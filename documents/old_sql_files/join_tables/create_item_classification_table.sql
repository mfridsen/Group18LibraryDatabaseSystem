CREATE TABLE `Item_Classification` (
  `Item_ID` INT,
  `Classification_ID` INT,
  PRIMARY KEY (`Item_ID`, `Classification_ID`),
  FOREIGN KEY (`Item_ID`) REFERENCES `Item`(`Item_ID`)
);