CREATE TABLE authors
(
    id         UUID PRIMARY KEY,
    version    INTEGER                  NOT NULL DEFAULT 0,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    deleted_at TIMESTAMP WITH TIME ZONE          DEFAULT NULL,
    name       TEXT                     NOT NULL,
    birth_date DATE                     NOT NULL,
    UNIQUE NULLS NOT DISTINCT (name, birth_date, deleted_at)
);
