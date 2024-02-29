
INSERT INTO users (fullname, username, password, age, gender, email, mobile_number, expired_date, status, is_admin, grading) VALUES ('James Lam','James', '$2a$10$IpU.rTE7Olsdr.X.ku2TzeioQLJySdeuOHy5jH8ULEzkTvq1yQ0sm', '30', 'male', 'james@tecky.io', '99998888', '2025-01-31', false, false, 'Normal');
INSERT INTO users (fullname, username, password, age, gender, email, mobile_number, expired_date, status, is_admin, grading) VALUES ('Alfred Ko','Alfred', '$2a$10$IpU.rTE7Olsdr.X.ku2TzeioQLJySdeuOHy5jH8ULEzkTvq1yQ0sm', '30', 'male', 'alfred@tecky.io', '99998888', '2025-06-31', true, false, 'Normal');
INSERT INTO users (fullname, username, password, age, gender, email, mobile_number, expired_date, status, is_admin, grading) VALUES ('Navy Tong','Navy', '$2a$10$IpU.rTE7Olsdr.X.ku2TzeioQLJySdeuOHy5jH8ULEzkTvq1yQ0sm', '30', 'female', 'navy@tecky.io', '99998888', '2027-03-31', true, true, 'Normal');
INSERT INTO users (fullname, username, password, age, gender, email, mobile_number, expired_date, status, is_admin, grading) VALUES ('Peter','Peter', '$2a$10$IpU.rTE7Olsdr.X.ku2TzeioQLJySdeuOHy5jH8ULEzkTvq1yQ0sm', '30', 'male', 'peter@tecky.io', '99998888', '2025-05-31', false, false, 'Normal');
INSERT INTO users (fullname, username, password, age, gender, email, mobile_number, expired_date, status, is_admin, grading) VALUES ('Kate Chan','Kate', '$2a$10$IpU.rTE7Olsdr.X.ku2TzeioQLJySdeuOHy5jH8ULEzkTvq1yQ0sm', '30', 'female', 'kate@tecky.io', '99998888', '2026-01-31', false, false, 'Normal');
INSERT INTO users (fullname, username, password, age, gender, email, mobile_number, expired_date, status, is_admin, grading) VALUES ('Mary Chan','Mary', '$2a$10$IpU.rTE7Olsdr.X.ku2TzeioQLJySdeuOHy5jH8ULEzkTvq1yQ0sm', '30', 'female', 'mary@tecky.io', '99998888', '2027-01-31', false, false, 'Gold');
INSERT INTO users (fullname, username, password, age, gender, email, mobile_number, expired_date, status, is_admin, grading) VALUES ('Tom Lam','Tom', '$2a$10$IpU.rTE7Olsdr.X.ku2TzeioQLJySdeuOHy5jH8ULEzkTvq1yQ0sm', '30', 'male', 'tom@tecky.io', '99998888', '2025-12-31', false, false, 'Gold');
INSERT INTO users (fullname, username, password, age, gender, email, mobile_number, expired_date, status, is_admin, grading) VALUES ('John','John', '$2a$10$IpU.rTE7Olsdr.X.ku2TzeioQLJySdeuOHy5jH8ULEzkTvq1yQ0sm', '30', 'male', 'john@tecky.io', '99998888', '2025-08-31', false, false, 'Gold');
INSERT INTO users (fullname, username, password, age, gender, email, mobile_number, expired_date, status, is_admin, grading) VALUES ('Terry','Terry', '$2a$10$IpU.rTE7Olsdr.X.ku2TzeioQLJySdeuOHy5jH8ULEzkTvq1yQ0sm', '30', 'male', 'terry@tecky.io', '99998888', '2028-01-31', false, false, 'Gold');
INSERT INTO users (fullname, username, password, age, gender, email, mobile_number, expired_date, status, is_admin, grading) VALUES ('Josh','Josh', '$2a$10$IpU.rTE7Olsdr.X.ku2TzeioQLJySdeuOHy5jH8ULEzkTvq1yQ0sm', '30', 'male', 'Josh@tecky.io', '99998888', '2026-03-31', false, false, 'Gold');

--INSERT INTO admins (username, password, email) VALUES ('Navy', '$2a$10$IpU.rTE7Olsdr.X.ku2TzeioQLJySdeuOHy5jH8ULEzkTvq1yQ0sm', 'navy@tecky.io');
--

INSERT INTO gym_rooms (map, location_name, location_address, location_contact, location_email, location_max_people, latitude, longitude) VALUES ('<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3691.9514862070278!2d114.1789262827426!3d22.279827491316784!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x34040056c37d08bb%3A0xe2b51a38d4d91669!2z5biM5oWO5buj5aC0!5e0!3m2!1szh-TW!2shk!4v1708587670980!5m2!1szh-TW!2shk" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>', 'Hysan Place - Causeway Bay', '500 Hennessy Road, Lee Garden, Causeway Bay, Hong Kong', '2688 8888', 'cwbpowerfitness@email.com', '200', '22.279800', '114.183937');
INSERT INTO gym_rooms (map, location_name, location_address, location_contact, location_email, location_max_people, latitude, longitude) VALUES ('<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3690.8079518656714!2d114.16957527548625!3d22.323101792068133!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x340400c9191f912f%3A0xd16ca721c7b4a85!2zTU9LTyDmlrDkuJbntIDlu6PloLQ!5e0!3m2!1szh-TW!2shk!4v1708587490479!5m2!1szh-TW!2shk" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>', 'MOKO - Mongkok', '193 Prince Edward Road West, Mong Kok', '2688 8899', 'cwbpowerfitness@email.com', '150', '22.321550', '114.171112');
--

INSERT INTO check_in_records (user_id, gym_room_id, check_in_date, check_in_at, check_out_at) VALUES (1, 1, '2024-01-20', '2024-01-20T10:00:00Z+00:00', '2024-01-20T11:00:00Z+00:00');
INSERT INTO check_in_records (user_id, gym_room_id, check_in_date, check_in_at, check_out_at) VALUES (2, 1, '2024-01-20', '2024-01-20T10:00:00Z+00:00', '2024-01-20T11:00:00Z+00:00');
--

INSERT INTO check_in_records (user_id, gym_room_id, check_in_date, check_in_at, check_out_at) VALUES (1, 1, '2024-02-02', '2024-02-02T10:00:00Z+00:00', '2024-02-02T11:00:00Z+00:00');
INSERT INTO check_in_records (user_id, gym_room_id, check_in_date, check_in_at, check_out_at) VALUES (2, 1, '2024-02-02', '2024-02-02T10:00:00Z+00:00', '2024-02-02T11:00:00Z+00:00');

INSERT INTO check_in_records (user_id, gym_room_id, check_in_date, check_in_at, check_out_at) VALUES (3, 1, '2024-02-23', '2024-02-23T10:00:00Z+00:00', '2024-02-23T11:00:00Z+00:00');
INSERT INTO check_in_records (user_id, gym_room_id, check_in_date, check_in_at, check_out_at) VALUES (4, 1, '2024-02-23', '2024-02-23T10:00:00Z+00:00', '2024-02-23T11:00:00Z+00:00');
INSERT INTO check_in_records (user_id, gym_room_id, check_in_date, check_in_at, check_out_at) VALUES (5, 2, '2024-02-23', '2024-02-23T12:00:00Z+00:00', '2024-02-23T14:00:00Z+00:00');
INSERT INTO check_in_records (user_id, gym_room_id, check_in_date, check_in_at, check_out_at) VALUES (6, 1, '2024-02-25', '2024-02-25T14:00:00Z+00:00', '2024-02-25T15:00:00Z+00:00');
INSERT INTO check_in_records (user_id, gym_room_id, check_in_date, check_in_at, check_out_at) VALUES (7, 2, '2024-02-25', '2024-02-25T13:00:00Z+00:00', '2024-02-25T15:00:00Z+00:00');
INSERT INTO check_in_records (user_id, gym_room_id, check_in_date, check_in_at, check_out_at) VALUES (8, 1, '2024-02-25', '2024-02-25T15:00:00Z+00:00', '2024-02-25T16:00:00Z+00:00');
INSERT INTO check_in_records (user_id, gym_room_id, check_in_date, check_in_at, check_out_at) VALUES (5, 1, '2024-02-27', '2024-02-27T13:00:00Z+00:00', '2024-02-27T17:00:00Z+00:00');
INSERT INTO check_in_records (user_id, gym_room_id, check_in_date, check_in_at, check_out_at) VALUES (1, 2, '2024-02-27', '2024-02-27T15:00:00Z+00:00', '2024-02-27T18:00:00Z+00:00');
INSERT INTO check_in_records (user_id, gym_room_id, check_in_date, check_in_at, check_out_at) VALUES (2, 1, '2024-02-27', '2024-02-27T17:00:00Z+00:00', '2024-02-27T19:00:00Z+00:00');
INSERT INTO check_in_records (user_id, gym_room_id, check_in_date, check_in_at, check_out_at) VALUES (4, 2, '2024-02-27', '2024-02-27T18:00:00Z+00:00', '2024-02-27T20:00:00Z+00:00');
--

INSERT INTO course_lists (name, tutor, tutor_icon, max_people_limit, open_datetime, end_datetime, gym_room_id) VALUES
('Yoga', 'MANDY WONG', 'MANDY WONG Icon', 8, '2024-03-01T17:00:00Z+08:00', '2024-03-01T19:00:00Z+00:00', 1),
('Gym', 'JOHN CHAN', 'JOHN CHAN Icon', 8, '2024-03-01T20:00:00Z+08:00', '2024-03-01T22:00:00Z+00:00', 2);
--

INSERT INTO class_reservations (register_email, confirm_msg, user_id, course_id) VALUES ('james@tecky.io', 'Please click thee link to complete the reservation', 1, 1);
--

INSERT INTO friends_lists (user_a_id, user_b_id) VALUES (1, 2);
INSERT INTO friends_lists (user_a_id, user_b_id) VALUES (1, 3);

INSERT INTO friends_lists (user_a_id, user_b_id) VALUES (2, 3);
--
