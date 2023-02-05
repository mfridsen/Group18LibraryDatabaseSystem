CREATE TABLE `Publisher` (
  `Publisher_ID` INT AUTO_INCREMENT PRIMARY KEY,
  `Publisher_Name` VARCHAR(255) NOT NULL,
  `Street_Num` INT,
  `Street_Name` VARCHAR(255),
  `Town` VARCHAR(255),
  `Zip_Code` VARCHAR(255), 	-- Various formats
  `Country` VARCHAR(255),
  `Phone_Num` VARCHAR(255),	-- Various formats
  `E-Mail` VARCHAR(255) UNIQUE,	-- Various formats
  `Website` VARCHAR(255),	-- URLs
  `Date_Founded` DATE,	-- DD:MM:YYYY
  `Description` TEXT
);