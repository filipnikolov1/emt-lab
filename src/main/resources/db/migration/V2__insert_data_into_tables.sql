INSERT INTO countries (name, continent) VALUES
    ('Macedonia', 'Europe'),
    ('USA', 'North America'),
    ('UK', 'Europe'),
    ('France', 'Europe'),
    ('Russia', 'Europe');

INSERT INTO authors (created_at, updated_at, name, surname, country_id) VALUES
    (NOW(), NOW(), 'Petre', 'Andreevski', 1),
    (NOW(), NOW(), 'Stephen', 'King', 2),
    (NOW(), NOW(), 'J.K.', 'Rowling', 3),
    (NOW(), NOW(), 'Victor', 'Hugo', 4),
    (NOW(), NOW(), 'Leo', 'Tolstoy', 5);

INSERT INTO books (created_at, updated_at, name, category, author_id, state, available_copies) VALUES
    (NOW(), NOW(), 'Pirej', 'NOVEL', 1, 'GOOD', 5),
    (NOW(), NOW(), 'The Shining', 'THRILLER', 2, 'GOOD', 3),
    (NOW(), NOW(), 'Harry Potter', 'FANTASY', 3, 'GOOD', 7),
    (NOW(), NOW(), 'Les Miserables', 'CLASSICS', 4, 'GOOD', 2),
    (NOW(), NOW(), 'War and Peace', 'HISTORY', 5, 'BAD', 0);