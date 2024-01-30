CREATE TABLE users(
    id SERIAL PRIMARY KEY,
    username varchar(64),
    password varchar(255),
    qrcode varchar(255),
    age int,
    email varchar(255),
    mobile_number int,
    icon varchar(255),
    expired_date varchar(255),
    status boolean,
    created_at DATE default NOW(),
    updated_at DATE default NOW()
)