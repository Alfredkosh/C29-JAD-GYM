BEGIN;
    CREATE TABLE course_lists(
         id SERIAL PRIMARY KEY,
         gym_room_id integer not null,
         name varchar(255),
         tutor varchar(255),
         tutor_icon varchar(255),
         date varchar(255),
         time varchar(255),
         created_at DATE default NOW(),
         updated_at DATE default NOW()
     );


COMMIT