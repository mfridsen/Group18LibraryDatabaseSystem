INSERT INTO Classification (Classification_ID, Name, Parent_ID, Description)
VALUES
    (1, 'Science', NULL, 'Classification for science related books.'),
    (2, 'Fiction', NULL, 'Classification for fiction books.'),
    (3, 'History', 1, 'Classification for history related books.'),
    (4, 'Mystery', 2, 'Classification for mystery books.'),
    (5, 'Romance', 2, 'Classification for romance books.');