CREATE TABLE IF NOT EXISTS countries (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    continent VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS authors (
    id BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    country_id BIGINT REFERENCES countries(id)
);

CREATE TABLE IF NOT EXISTS books (
    id BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(50) NOT NULL,
    author_id BIGINT REFERENCES authors(id),
    state VARCHAR(50) NOT NULL,
    available_copies INTEGER NOT NULL
);