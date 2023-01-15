CREATE TABLE authors
(
    id         UUID PRIMARY KEY,
    version    INTEGER                  NOT NULL DEFAULT '0',
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    deleted    BOOLEAN                  NOT NULL DEFAULT false,
    name       TEXT                     NOT NULL,
    birth_date DATE                     NOT NULL,
    UNIQUE (name, birth_date, deleted)
);
