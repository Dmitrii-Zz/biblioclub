DROP TABLE IF EXISTS users, books, rentals CASCADE;

CREATE TABLE IF NOT EXISTS users (
    user_id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birthday TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS books (
    book_id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name VARCHAR(355) NOT NULL,
    author VARCHAR(355) NOT NULL,
    isbn VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS rentals (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    user_id BIGINT REFERENCES users (user_id) ON DELETE CASCADE,
    book_id BIGINT REFERENCES books (book_id) ON DELETE CASCADE,
    dateRental TIMESTAMP NOT NULL
);