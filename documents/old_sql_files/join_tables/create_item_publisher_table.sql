CREATE TABLE `Item_Publisher` (
  `Publisher_ID` INT,
  `Item_ID` INT,
  PRIMARY KEY (`Publisher_ID`, `Item_ID`),
  FOREIGN KEY (`Item_ID`) REFERENCES `Item`(`Item_ID`),
  FOREIGN KEY (`Publisher_ID`) REFERENCES `Publisher`(`Publisher_ID`)
);