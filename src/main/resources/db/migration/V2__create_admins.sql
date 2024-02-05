BEGIN;
CREATE TABLE admins(
    id SERIAL PRIMARY KEY,
    username varchar(64) not null,
    password varchar(255) not null,
    email varchar(255),
    created_at TIMESTAMP default NOW(),
    updated_at TIMESTAMP default NOW()
);
COMMIT