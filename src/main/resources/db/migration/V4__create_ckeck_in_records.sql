BEGIN;
    CREATE TABLE check_in_records(
         id SERIAL PRIMARY KEY,
         user_id Integer not null,
         gym_room_id Integer not null,
         check_in_date DATE,
         check_in_at TIMESTAMP WITH TIME ZONE  default NOW(),
         check_out_at TIMESTAMP WITH TIME ZONE  default NOW(),
         created_at TIMESTAMP WITH TIME ZONE  default NOW(),
         updated_at TIMESTAMP WITH TIME ZONE default NOW()
     );

COMMIT