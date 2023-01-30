-- Trigger 1
DELIMITER $$

CREATE TRIGGER unique_privatkund BEFORE INSERT ON privatkund
FOR EACH ROW BEGIN
  DECLARE c INT;
  SELECT COUNT(*) INTO c FROM företagskund WHERE kundnr = NEW.kundnr;
  IF (c > 0) THEN
    signal sqlstate '45000';
  END IF;

END$$
DELIMITER ;

-- Trigger 2
DELIMITER $$

CREATE TRIGGER unique_företagskund BEFORE INSERT ON företagskund
FOR EACH ROW BEGIN
  DECLARE c INT;
  SELECT COUNT(*) INTO c FROM privatkund WHERE kundnr = NEW.kundnr;
  IF (c > 0) THEN
    signal sqlstate '45000';
  END IF;

END$$
DELIMITER ;