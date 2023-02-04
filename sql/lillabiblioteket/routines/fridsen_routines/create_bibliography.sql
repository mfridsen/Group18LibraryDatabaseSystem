-- This query will return all the books that are linked to the author with id = 1, through the book_author table.
SELECT books.* FROM books
JOIN book_author ON book_author.book_id = books.id
JOIN authors ON book_author.author_id = authors.id
WHERE authors.id = 1;
