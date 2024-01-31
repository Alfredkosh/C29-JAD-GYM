BEGIN;
    CREATE TABLE course_lists(
         id SERIAL PRIMARY KEY,
         name varchar(255),
         tutor varchar(255),
         tutor_icon varchar(255),
         date varchar(255),
         time varchar(255),
         created_at DATE default NOW(),
         updated_at DATE default NOW()
     );

-- ALTER TABLE class_reservations ADD course_id integer not null;
-- ALTER TABLE class_reservations ADD CONSTRAINT fk_class_reservations_course_lists FOREIGN KEY (course_id) references course_lists(id);

COMMIT