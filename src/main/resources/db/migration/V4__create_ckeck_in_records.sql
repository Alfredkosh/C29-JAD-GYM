BEGIN;
    CREATE TABLE check_in_records(
         id SERIAL PRIMARY KEY,
         check_in_date varchar(255),
         check_in_at DATE default NOW(),
         check_out_at DATE default NOW(),
         created_at DATE default NOW(),
         updated_at DATE default NOW()
     );

COMMIT