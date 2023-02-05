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
CREATE TABLE `Item_Type` (
  `Item_Type_ID` INT AUTO_INCREMENT NOT NULL,
  `Item_Type` ENUM ('Standard Literature', 'Course Literature', 'Reference Literature', 'DVD') NOT NULL,
  `Rent_Time_Weeks` INT NOT NULL,
  PRIMARY KEY (`Item_Type_ID`)
);

INSERT INTO `Item_Type` (`Item_Type`, `Rent_Time_Weeks`)
VALUES ('Standard Literature', 8),
       ('Course Literature', 4),
       ('Reference Literature', 0),
       ('DVD', 2);

CREATE TABLE `Item` (
  `Item_ID` INT AUTO_INCREMENT NOT NULL,
  `Title` VARCHAR(255) NOT NULL,
  `ISBN` VARCHAR(13) NOT NULL,
  `Barcode` VARCHAR(255) UNIQUE NOT NULL,
  `Location` VARCHAR(255),
  `Description` TEXT,
  `Item_Type_ID` INT NOT NULL,
  `Item_Status` ENUM ('Available', 'Reserved', 'Checked Out', 'Overdue') NOT NULL,
  PRIMARY KEY (`Item_ID`),
  FOREIGN KEY (`Item_Type_ID`) REFERENCES `Item_Type`(`Item_Type_ID`)
 );