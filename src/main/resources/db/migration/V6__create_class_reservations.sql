BEGIN;
    CREATE TABLE class_reservations(
         id SERIAL PRIMARY KEY,
         user_id integer not null,
         course_id integer not null,
         register_email varchar(255),
         confirm_msg varchar(255),
         created_at TIMESTAMP default NOW(),
         updated_at TIMESTAMP default NOW()
     );

      ALTER TABLE check_in_records ADD CONSTRAINT fk_check_in_records_users FOREIGN KEY (user_id) references users(id);
      ALTER TABLE check_in_records ADD CONSTRAINT fk_check_in_records_gym_rooms FOREIGN KEY (gym_room_id) references gym_rooms(id);
      ALTER TABLE class_reservations ADD CONSTRAINT fk_class_reservations_users FOREIGN KEY (user_id) references users(id);
      ALTER TABLE class_reservations ADD CONSTRAINT fk_class_reservations_course_lists FOREIGN KEY (course_id) references course_lists(id);
      ALTER TABLE course_lists ADD CONSTRAINT fk_course_lists_gym_rooms FOREIGN KEY (gym_room_id) references gym_rooms(id);
COMMIT