
INSERT INTO users (fullname, username, password, qrcode, age, gender, email, mobile_number, icon, expired_date, status, is_admin) VALUES ('James Lam','James', '$2a$10$IpU.rTE7Olsdr.X.ku2TzeioQLJySdeuOHy5jH8ULEzkTvq1yQ0sm', 'test', '30', 'male', 'james@tecky.io', '99998888', 'image', '2025-01-31', false, false);
INSERT INTO users (fullname, username, password, qrcode, age, gender, email, mobile_number, icon, expired_date, status, is_admin) VALUES ('Alfred Ko','Alfred', '$2a$10$IpU.rTE7Olsdr.X.ku2TzeioQLJySdeuOHy5jH8ULEzkTvq1yQ0sm', 'test', '30', 'male', 'james@tecky.io', '99998888', 'image', '2025-01-31', true, false);
INSERT INTO users (fullname, username, password, qrcode, age, gender, email, mobile_number, icon, expired_date, status, is_admin) VALUES ('Navy','Navy', '$2a$10$IpU.rTE7Olsdr.X.ku2TzeioQLJySdeuOHy5jH8ULEzkTvq1yQ0sm', 'test', '30', 'male', 'james@tecky.io', '99998888', 'image', '2027-03-31', true, true);

INSERT INTO admins (username, password, email) VALUES ('Navy', '$2a$10$IpU.rTE7Olsdr.X.ku2TzeioQLJySdeuOHy5jH8ULEzkTvq1yQ0sm', 'navy@tecky.io');
--

INSERT INTO gym_rooms (map, location_name, location_address, location_contact, location_email, location_max_people, latitude, longitude) VALUES ('<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3691.9514862070278!2d114.1789262827426!3d22.279827491316784!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x34040056c37d08bb%3A0xe2b51a38d4d91669!2z5biM5oWO5buj5aC0!5e0!3m2!1szh-TW!2shk!4v1708587670980!5m2!1szh-TW!2shk" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>', 'Hysan Place - Causeway Bay', '500 Hennessy Road, Lee Garden, Causeway Bay, Hong Kong', '2688 8888', 'cwbpowerfitness@email.com', '200', '22.279800', '114.183937');
INSERT INTO gym_rooms (map, location_name, location_address, location_contact, location_email, location_max_people, latitude, longitude) VALUES ('<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3690.8079518656714!2d114.16957527548625!3d22.323101792068133!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x340400c9191f912f%3A0xd16ca721c7b4a85!2zTU9LTyDmlrDkuJbntIDlu6PloLQ!5e0!3m2!1szh-TW!2shk!4v1708587490479!5m2!1szh-TW!2shk" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>', 'MOKO - Mongkok', '193 Prince Edward Road West, Mong Kok', '2688 8899', 'cwbpowerfitness@email.com', '150', '22.321550', '114.171112');
--

INSERT INTO check_in_records (user_id, gym_room_id, check_in_date, check_in_at, check_out_at) VALUES (1, 1, '2024-01-20', '2024-01-20T10:00:00Z+00:00', '2024-01-20T11:00:00Z+00:00');
INSERT INTO check_in_records (user_id, gym_room_id, check_in_date, check_in_at, check_out_at) VALUES (2, 1, '2024-01-20', '2024-01-20T10:00:00Z+00:00', '2024-01-20T11:00:00Z+00:00');
--

INSERT INTO check_in_records (user_id, gym_room_id, check_in_date, check_in_at, check_out_at) VALUES (1, 1, '2024-02-02', '2024-02-02T10:00:00Z+00:00', '2024-02-02T11:00:00Z+00:00');
INSERT INTO check_in_records (user_id, gym_room_id, check_in_date, check_in_at, check_out_at) VALUES (2, 1, '2024-02-02', '2024-02-02T10:00:00Z+00:00', '2024-02-02T11:00:00Z+00:00');

--

INSERT INTO course_lists (name, tutor, tutor_icon, max_people_limit, open_datetime, end_datetime, gym_room_id) VALUES
('yoga', 'Amy', 'Amy Icon', 8, '2024-02-05T17:00:00Z+08:00', '2024-02-05T10:00:00Z+00:00', 1),
('Program', 'Amy', 'Amy Icon', 8, '2024-02-05T17:00:00Z+08:00', '2024-02-05T10:00:00Z+00:00', 2);
--

INSERT INTO class_reservations (register_email, confirm_msg, user_id, course_id) VALUES ('james@tecky.io', 'Please click thee link to complete the reservation', 1, 1);
--

INSERT INTO friends_lists (user_id, username) VALUES (1, 'James');
INSERT INTO friends_lists (user_id, username) VALUES (2, 'Alfred');
--
