BEGIN;
CREATE TABLE admins(
    id SERIAL PRIMARY KEY,
    username varchar(64) not null,
    password varchar(255) not null,
    email varchar(255),
    created_at DATE default NOW(),
    updated_at DATE default NOW()
);
COMMIT