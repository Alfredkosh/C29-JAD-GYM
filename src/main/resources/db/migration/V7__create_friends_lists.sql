BEGIN;
CREATE TABLE friends_lists(
     id SERIAL PRIMARY KEY,
     user_id Integer not null,
     username varchar(64) not null
 );



COMMIT