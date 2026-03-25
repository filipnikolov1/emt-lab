CREATE TABLE book_rent_activity (
    id BIGSERIAL PRIMARY KEY,
    book_id BIGINT NOT NULL,
    book_name VARCHAR(255) NOT NULL,
    rented_at TIMESTAMP NOT NULL,
    copies_remaining INTEGER NOT NULL
);