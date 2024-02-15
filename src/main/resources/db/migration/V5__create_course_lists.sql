BEGIN;
    CREATE TABLE course_lists(
         id SERIAL PRIMARY KEY,
         gym_room_id integer not null,
         name varchar(255),
         tutor varchar(255),
         tutor_icon varchar(255),
         max_people_limit integer,
         open_datetime TIMESTAMP WITH TIME ZONE not null,
         end_datetime TIMESTAMP WITH TIME ZONE not null,
         created_at TIMESTAMP WITH TIME ZONE default NOW(),
         updated_at TIMESTAMP WITH TIME ZONE default NOW()
     );


COMMIT