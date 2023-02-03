-- Change status of an Item to Reserved
UPDATE Item
SET Item_Status_ID = (SELECT Item_Status_ID FROM Item_Status WHERE Item_Status = 'Reserved')
WHERE Item_ID = <ID of the item you want to change>;