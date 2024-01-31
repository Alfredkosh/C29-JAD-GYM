BEGIN;
CREATE TABLE gym_rooms(
     id SERIAL PRIMARY KEY,
     map varchar(255),
     location_name varchar(255),
     location_address varchar(255),
     location_contact varchar(255),
     location_max_people varchar(255)
 );

--  ALTER TABLE check_in_records ADD gym_room_id integer not null;
--  ALTER TABLE check_in_records ADD CONSTRAINT fk_check_in_records_gym_rooms FOREIGN KEY (gym_room_id) references gym_rooms(id);

--  ALTER TABLE course_lists ADD gym_room_id integer not null;
--  ALTER TABLE course_lists ADD CONSTRAINT fk_course_lists_gym_rooms FOREIGN KEY (gym_room_id) references gym_rooms(id);
COMMIT