BEGIN;
    CREATE TABLE class_reservations(
         id SERIAL PRIMARY KEY,
         register_email varchar(255),
         confirm_msg varchar(255),
         created_at DATE default NOW(),
         updated_at DATE default NOW()
     );

COMMIT