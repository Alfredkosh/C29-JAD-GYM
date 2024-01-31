BEGIN;
CREATE TABLE users(
     id SERIAL PRIMARY KEY,
     username varchar(64) not null,
     password varchar(255) not null,
     qrcode varchar(255),
     age int,
     email varchar(255),
     mobile_number int,
     icon varchar(255),
     expired_date varchar(255),
     status boolean,
     created_at DATE default NOW(),
     updated_at DATE default NOW()
 );

-- ALTER TABLE check_in_records ADD user_id integer not null;
-- ALTER TABLE check_in_records ADD CONSTRAINT fk_check_in_records_users FOREIGN KEY (user_id) references users(id);

-- ALTER TABLE class_reservations ADD user_id integer not null;
-- ALTER TABLE class_reservations ADD CONSTRAINT fk_class_reservations_users FOREIGN KEY (user_id) references users(id);

COMMIT