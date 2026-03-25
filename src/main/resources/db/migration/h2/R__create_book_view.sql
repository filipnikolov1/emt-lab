CREATE OR REPLACE VIEW book_details_view AS
SELECT
    b.id AS id,
    b.name AS name,
    b.category AS category,
    b.state AS state,
    b.available_copies AS available_copies,
    CONCAT(a.name, ' ', a.surname) AS author_full_name,
    c.name AS country_name
FROM books b
         JOIN authors a ON b.author_id = a.id
         JOIN countries c ON a.country_id = c.id;

CREATE OR REPLACE VIEW book_category_stats_view AS
SELECT
    b.category AS category,
    COUNT(b.id) AS total_books,
    SUM(b.available_copies) AS total_available_copies,
    COUNT(CASE WHEN b.state != 'GOOD' THEN 1 END) AS books_not_in_good_state
FROM books b
GROUP BY b.category;