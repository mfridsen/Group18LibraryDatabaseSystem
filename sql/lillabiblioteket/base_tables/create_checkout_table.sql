CREATE TABLE `Checkout` (
  `Checkout_ID` INT AUTO_INCREMENT,
  `Patron_ID` INT,
  `Staff_ID` INT,
  `Checkout_Date` DATETIME NOT NULL,
  `Return_Date` DATE,
  `Fine` DECIMAL(10,2),
  `Status` TINYINT, -- ENUM('Checked Out', 'Returned', 'Overdue')
  PRIMARY KEY (`Checkout_ID`),
  FOREIGN KEY (`Patron_ID`) REFERENCES `Patron`(`Patron_ID`),
  FOREIGN KEY (`Staff_ID`) REFERENCES `Staff`(`Staff_ID`)
);


/*
In MySQL, an ENUM is a data type that allows you to specify a list of predefined values that a column can 
contain. When you define a column with the ENUM data type, you specify the possible values that the column 
can have, and MySQL will only allow those values to be inserted into that column. This is useful when you 
want to ensure that a column only contains certain predefined values and can help prevent errors and data 
inconsistencies.
*/