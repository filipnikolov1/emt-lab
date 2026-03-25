CREATE MATERIALIZED VIEW book_category_stats_view AS
SELECT
    b.category AS category,
    COUNT(b.id) AS total_books,
    SUM(b.available_copies) AS total_available_copies,
    COUNT(CASE WHEN b.state != 'GOOD' THEN 1 END) AS books_not_in_good_state
FROM books b
GROUP BY b.category;