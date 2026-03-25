ALTER TABLE book_rent_activity ADD COLUMN event_type VARCHAR(50) NOT NULL DEFAULT 'RENTED';

CREATE TABLE book_unavailable_log (
    id BIGSERIAL PRIMARY KEY,
    book_id BIGINT NOT NULL,
    book_name VARCHAR(255) NOT NULL,
    logged_at TIMESTAMP NOT NULL
);