BEGIN;
CREATE TABLE gym_rooms(
     id SERIAL PRIMARY KEY,
     map varchar(255),
     location_name varchar(255),
     location_address varchar(255),
     location_contact varchar(255),
     location_max_people varchar(255),
     latitude varchar(255),
     longitude varchar(255)
 );

COMMIT