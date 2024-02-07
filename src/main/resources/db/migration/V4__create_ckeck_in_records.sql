BEGIN;
    CREATE TABLE check_in_records(
         id SERIAL PRIMARY KEY,
         user_id Integer not null,
         gym_room_id Integer not null,
         check_in_date DATE,
         check_in_at TIMESTAMP default NOW(),
         check_out_at TIMESTAMP default NOW(),
         created_at TIMESTAMP default NOW(),
         updated_at TIMESTAMP default NOW()
     );

COMMIT