CREATE TABLE `Item_Type` (
  `Type_ID` INT AUTO_INCREMENT,
  `Type` VARCHAR(255),
  `Rent_Time_Allowed` INT,
  PRIMARY KEY (`Type_ID`)
);

CREATE TABLE `Item` (
  `Item_ID` INT AUTO_INCREMENT,
  `Title` VARCHAR(255) NOT NULL,
  `ISBN` VARCHAR(13) UNIQUE,
  `Barcode` VARCHAR(255),
  `Location` VARCHAR(255),
  `Description` TEXT,
  `Type_ID` INT,
  PRIMARY KEY (`Item_ID`),
  FOREIGN KEY (`Type_ID`) REFERENCES `Item_Type`(`Type_ID`)
);

CREATE TABLE `Book` (
  `Book_ID` INT PRIMARY KEY,
  `Number_of_Pages` INT,
  FOREIGN KEY (`Book_ID`) REFERENCES `Item`(`Item_ID`)
);

CREATE TABLE `DVD` (
  `DVD_ID` INT PRIMARY KEY,
  `Runtime` TIME,	-- HH:MM:SS
  `Format` VARCHAR(255),
  FOREIGN KEY (`DVD_ID`) REFERENCES `Item`(`Item_ID`)
);