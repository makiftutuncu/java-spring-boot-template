CREATE TABLE books
(
    id         BIGSERIAL PRIMARY KEY,
    version    INTEGER                  NOT NULL DEFAULT 0,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    deleted_at TIMESTAMP WITH TIME ZONE          DEFAULT NULL,
    isbn       TEXT                     NOT NULL UNIQUE,
    title      TEXT                     NOT NULL,
    UNIQUE NULLS NOT DISTINCT (isbn, deleted_at)
);

CREATE TABLE authors_books
(
    author_id UUID NOT NULL REFERENCES authors(id),
    book_id   BIGINT NOT NULL REFERENCES books(id),
    PRIMARY KEY (author_id, book_id)
);
