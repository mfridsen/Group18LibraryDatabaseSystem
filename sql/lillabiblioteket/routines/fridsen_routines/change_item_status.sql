-- Note: Replace [ITEM_ID] with the actual ID of the item in the Item table that you want to change the status for.

-- Change status FROM 'Available'
-- Change status to 'Reserved'
UPDATE Item
SET Item_Status = 'Reserved'
WHERE Item_ID = [the ID of the item you want to change the status for]
AND Item_Status = 'Available';

-- Change status to 'Checked Out':
UPDATE Item
SET Item_Status = 'Checked Out'
WHERE Item_ID = [the ID of the item you want to change the status for]
AND Item_Status = 'Available';

-- Change status to 'Overdue':
UPDATE Item
SET Item_Status = 'Overdue'
WHERE Item_ID = [the ID of the item you want to change the status for]
AND Item_Status = 'Available';


-- Change status FROM 'Reserved'
-- Change status to 'Checked Out'
UPDATE Item
SET Item_Status = 'Checked Out'
WHERE Item_ID = [the ID of the item you want to change the status for]
AND Item_Status = 'Reserved';

-- Change status to 'Available':
UPDATE Item
SET Item_Status = 'Available'
WHERE Item_ID = [the ID of the item you want to change the status for]
AND Item_Status = 'Reserved';


-- Change status FROM 'Checked Out'
-- Change status to 'Available':
UPDATE Item
SET Item_Status = 'Available'
WHERE Item_ID = [the ID of the item you want to change the status for]
AND Item_Status = 'Checked Out';

-- Change status to 'Overdue':
UPDATE Item
SET Item_Status = 'Overdue'
WHERE Item_ID = [the ID of the item you want to change the status for]
AND Item_Status = 'Available';


-- Change status FROM 'Overdue'
-- Change status to 'Available':
UPDATE Item
SET Item_Status = 'Available'
WHERE Item_ID = [the ID of the item you want to change the status for]
AND Item_Status = 'Overdue';