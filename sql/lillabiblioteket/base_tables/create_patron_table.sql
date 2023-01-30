CREATE TABLE `Patron` (
  `Patron_ID` INT AUTO_INCREMENT,
  `Sur_Name` VARCHAR(255) NOT NULL,
  `Last_Name` VARCHAR(255) NOT NULL,
  `Phone_Num` VARCHAR(255),
  `E-Mail` VARCHAR(255),
  `Street_Num` INT,
  `Street_Name` VARCHAR(255),
  `Town` VARCHAR(255),
  `Zip_Code` VARCHAR(255),
  `Date_Created` DATE,
  PRIMARY KEY (`Patron_ID`)
);

CREATE TABLE `Student` (
  `Student_ID` INT AUTO_INCREMENT,
  PRIMARY KEY (`Student_ID`)
);

CREATE TABLE `Teacher` (
  `Teacher_ID` INT AUTO_INCREMENT,
  PRIMARY KEY (`Teacher_ID`)
);

CREATE TABLE `Researcher` (
  `Researcher_ID` INT AUTO_INCREMENT,
  PRIMARY KEY (`Researcher_ID`)
);