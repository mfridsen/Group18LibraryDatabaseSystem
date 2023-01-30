CREATE TABLE `Staff` (
  `Staff_ID` INT AUTO_INCREMENT,
  `Sur_Name` VARCHAR(255) NOT NULL,
  `Last_Name` VARCHAR(255) NOT NULL,
  `Phone_Num` VARCHAR(255) ,
  `E-Mail` VARCHAR(255) ,
  `Street_Num` INT,
  `Street_Name` VARCHAR(255) ,
  `Town` VARCHAR(255) ,
  `Zip_Code` VARCHAR(255) ,
  `Date_Hired` DATE,
  PRIMARY KEY (`Staff_ID`)
);

CREATE TABLE `Manager` (
  `Manager_ID` INT AUTO_INCREMENT,
  PRIMARY KEY (`Manager_ID`)
);

CREATE TABLE `SysAdmin` (
  `Admin_ID` INT AUTO_INCREMENT,
  PRIMARY KEY (`Admin_ID`)
);