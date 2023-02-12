-- Creates all tables in the database ----------------------------------------------------------------------------------

-- BASE TABLES ---------------------------------------------------------------------------------------------------------

-- PUBLISHER -----------------------------------------------------------------------------------------------------------
CREATE TABLE `Publisher` (
  `Publisher_ID` INT AUTO_INCREMENT PRIMARY KEY,
  `Publisher_Name` VARCHAR(255) NOT NULL,
  `Phone_Num` VARCHAR(255) NOT NULL,
  `Mail` VARCHAR(255) NOT NULL,
  `Description` TEXT
);

-- USER-RELATED TABLES -------------------------------------------------------------------------------------------------
CREATE TABLE `User` (
    `User_ID` INT AUTO_INCREMENT NOT NULL,
    `User_Name` VARCHAR(255) NOT NULL,
    `Password` VARCHAR(255) NOT NULL,
    `First_Name` VARCHAR(255) NOT NULL,
    `Last_Name` VARCHAR(255) NOT NULL,
    `Phone_Num` VARCHAR(255) NOT NULL,
    `Mail` VARCHAR(255) NOT NULL,
    `Date_Created` DATE NOT NULL,
    `User_Type` ENUM('Patron', 'Staff', 'Patron_and_Staff') NOT NULL,
    PRIMARY KEY (`User_ID`)
);

-- Patron Stuff
CREATE TABLE `Patron_Type` (
    `Patron_Type_ID` INT AUTO_INCREMENT NOT NULL,
    `Patron_Type` ENUM ('Student', 'Teacher', 'Researcher') NOT NULL,
    `Max_Items` INT NOT NULL,
    PRIMARY KEY (`Patron_Type_ID`)
);
CREATE TABLE `Patron` (
    `Patron_ID` INT NOT NULL,
    `Patron_Type_ID` INT NOT NULL,
    `Items_Rented` INT NOT NULL,
    PRIMARY KEY (`Patron_ID`),
    FOREIGN KEY (`Patron_ID`) REFERENCES `User` (`User_ID`),
    FOREIGN KEY (`Patron_Type_ID`) REFERENCES `Patron_Type` (`Patron_Type_ID`)
);
-- Each user has a maximum number of items allowed to be on loan at a specific point in time.
-- The limit is dependent on the category of the member, e.g. researchers can borrow as many as 20 items,
-- teachers are limited to 10, and students are limited to 5 items
INSERT INTO `Patron_Type` (`Patron_Type`, `Max_Items`)
VALUES ('Student', 5),
       ('Teacher', 10),
       ('Researcher', 20);

-- Staff Stuff
CREATE TABLE `Staff_Type` (
    `Staff_Type_ID` INT AUTO_INCREMENT NOT NULL,
    `Staff_Type` ENUM ('Staff', 'Manager', 'Admin') NOT NULL,
    PRIMARY KEY (`Staff_Type_ID`)
);
CREATE TABLE `Staff` (
    `Staff_ID` INT NOT NULL,
    `Date_Hired` DATE NOT NULL,
    `Staff_Type_ID` INT NOT NULL,
    PRIMARY KEY (`Staff_ID`),
    FOREIGN KEY (`Staff_ID`) REFERENCES `User` (`User_ID`),
    FOREIGN KEY (`Staff_Type_ID`) REFERENCES `Staff_Type` (`Staff_Type_ID`)
);

-- CLASSIFICATION ------------------------------------------------------------------------------------------------------
CREATE TABLE `Classification` (
  `Classification_ID` INT AUTO_INCREMENT,
  `Name` VARCHAR(255) NOT NULL,
  `Parent_ID` INT,
  `Description` TEXT,
  PRIMARY KEY (`Classification_ID`),
  FOREIGN KEY (`Parent_ID`) REFERENCES `Classification`(`Classification_ID`)
);

-- ITEM ----------------------------------------------------------------------------------------------------------------
--  Generally, a library stocks a number of copies of each book title and each DVD. Each item has a physical location
--  and have attributes like: author, ISBN, a classification that is used for “keyword” searches e.g. “database”,
--  “database systems”, “database management” etc.

--  Book publishers are maintained, but not DVD publishers.

--  Books and DVDs have physically attached barcodes which are used for the identification of items that are
--  checked out (a barcode scanner will be used). In case the item does not scan then it should be also possible to
--  enter the barcode for the item manually.

--  All course literature also has a reference copy, that is not allowed to leave the library and therefore not
--  possible to borrow, in other words reference literature.

--  Different categories of items have different loan periods. Standard books are allowed a loan period of 2 months,
--  Course literature a period of 1 month, Reference literature cannot be borrowed, DVDs have a loan period of 2 weeks.
CREATE TABLE `Item` (
  `Item_ID` INT AUTO_INCREMENT NOT NULL,
  `Title` VARCHAR(255) NOT NULL,
  `ISBN` VARCHAR(13) NOT NULL,
  `Barcode` VARCHAR(255) UNIQUE NOT NULL,
  `Location` VARCHAR(255),
  `Description` TEXT,
  `Item_Type` ENUM ('Standard Literature', 'Course Literature', 'Reference Literature', 'DVD') NOT NULL,
  `Rent_Time_Weeks` INT NOT NULL,
  `Item_Status` ENUM ('Available', 'Reserved', 'Checked Out', 'Overdue') NOT NULL,
  PRIMARY KEY (`Item_ID`)
);

-- RESERVATION ---------------------------------------------------------------------------------------------------------
CREATE TABLE `Reservation` (
  `Reservation ID` INT AUTO_INCREMENT NOT NULL,
  `Patron_ID` INT NOT NULL,
  `Item_ID` INT NOT NULL,
  PRIMARY KEY (`Reservation ID`),
  FOREIGN KEY (`Patron_ID`) REFERENCES `Patron`(`Patron_ID`)
);

-- AUTHOR --------------------------------------------------------------------------------------------------------------
CREATE TABLE `Author` (
  `Author_ID` INT AUTO_INCREMENT,
  `First_Name` VARCHAR(255) NOT NULL,
  `Last_Name` VARCHAR(255) NOT NULL,
  `Date_of_Birth` DATE,
  `Description` TEXT,
  PRIMARY KEY (`Author_ID`)
);

-- CHECKOUT ------------------------------------------------------------------------------------------------------------
CREATE TABLE `Checkout` (
  `Checkout_ID` INT AUTO_INCREMENT,
  `Patron_ID` INT,
  `Staff_ID` INT,
  `Checkout_Date` DATETIME NOT NULL,
  `Fine` DECIMAL(10,2),
  PRIMARY KEY (`Checkout_ID`),
  FOREIGN KEY (`Patron_ID`) REFERENCES `Patron`(`Patron_ID`),
  FOREIGN KEY (`Staff_ID`) REFERENCES `Staff`(`Staff_ID`)
);

-- JOIN TABLES ---------------------------------------------------------------------------------------------------------

-- ITEM_PUBLISHER ------------------------------------------------------------------------------------------------------
CREATE TABLE `Item_Publisher` (
  `Publisher_ID` INT,
  `Item_ID` INT,
  PRIMARY KEY (`Publisher_ID`, `Item_ID`),
  FOREIGN KEY (`Item_ID`) REFERENCES `Item`(`Item_ID`),
  FOREIGN KEY (`Publisher_ID`) REFERENCES `Publisher`(`Publisher_ID`)
);

-- ITEM_AUTHOR ---------------------------------------------------------------------------------------------------------
CREATE TABLE `Item_Author` (
  `Item_ID` INT,
  `Author_ID` INT,
  PRIMARY KEY (`Item_ID`, `Author_ID`),
  FOREIGN KEY (`Item_ID`) REFERENCES `Item`(`Item_ID`),
  FOREIGN KEY (`Author_ID`) REFERENCES `Author`(`Author_ID`)
);

-- ITEM_CHECKOUT -------------------------------------------------------------------------------------------------------
CREATE TABLE `Item_Checkout` (
  `Checkout_ID` INT,
  `Item_ID` INT,
  `Due_Date` DATETIME NOT NULL,
  `Status` ENUM ('Reserved', 'Checked Out', 'Overdue') NOT NULL,
  PRIMARY KEY (`Checkout_ID`, `Item_ID`),
  FOREIGN KEY (`Item_ID`) REFERENCES `Item`(`Item_ID`),
  FOREIGN KEY (`Checkout_ID`) REFERENCES `Checkout`(`Checkout_ID`)
);

-- ITEM_CLASSIFICATION -------------------------------------------------------------------------------------------------
CREATE TABLE `Item_Classification` (
  `Item_ID` INT,
  `Classification_ID` INT,
  PRIMARY KEY (`Item_ID`, `Classification_ID`),
  FOREIGN KEY (`Item_ID`) REFERENCES `Item`(`Item_ID`)
);