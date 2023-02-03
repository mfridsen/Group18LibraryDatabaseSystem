CREATE TABLE `User` (
    `User_ID` INT AUTO_INCREMENT NOT NULL,
    `User_Name` VARCHAR(255) NOT NULL,
    `Password` VARCHAR(255) NOT NULL,
    `First_Name` VARCHAR(255) NOT NULL,
    `Last_Name` VARCHAR(255) NOT NULL,
    `Phone_Num` VARCHAR(255) NOT NULL,
    `E-Mail` VARCHAR(255) NOT NULL,
    `Street_Num` INT,
    `Street_Name` VARCHAR(255) ,
    `Town` VARCHAR(255) ,
    `Zip_Code` VARCHAR(255) ,
    `Date_Created` DATE NOT NULL,
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

--  Each user has a maximum number of items allowed to be on loan at a specific point in time.
--  The limit is dependent on the category of the member, e.g. researchers can borrow as many as 20 items,
--  teachers are limited to 10, and students are limited to 5 items
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

