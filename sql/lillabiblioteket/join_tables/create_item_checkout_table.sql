CREATE TABLE `Item_Checkout` (
  `Checkout_ID` INT,
  `Item_ID` INT,
  `Due_Date` DATETIME NOT NULL,
  PRIMARY KEY (`Checkout_ID`, `Item_ID`),
  FOREIGN KEY (`Item_ID`) REFERENCES `Item`(`Item_ID`),
  FOREIGN KEY (`Checkout_ID`) REFERENCES `Checkout`(`Checkout_ID`)
);