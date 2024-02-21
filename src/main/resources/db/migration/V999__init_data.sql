
INSERT INTO users (fullname, username, password, qrcode, age, gender, email, mobile_number, icon, expired_date, status, is_admin) VALUES ('James Lam','James', '$2a$10$IpU.rTE7Olsdr.X.ku2TzeioQLJySdeuOHy5jH8ULEzkTvq1yQ0sm', 'test', '30', 'male', 'james@tecky.io', '99998888', 'image', '2025-01-31', false, false);
INSERT INTO users (fullname, username, password, qrcode, age, gender, email, mobile_number, icon, expired_date, status, is_admin) VALUES ('Alfred Ko','Alfred', '$2a$10$IpU.rTE7Olsdr.X.ku2TzeioQLJySdeuOHy5jH8ULEzkTvq1yQ0sm', 'test', '30', 'male', 'james@tecky.io', '99998888', 'image', '2025-01-31', true, false);
INSERT INTO users (fullname, username, password, qrcode, age, gender, email, mobile_number, icon, expired_date, status, is_admin) VALUES ('Navy','Navy', '$2a$10$IpU.rTE7Olsdr.X.ku2TzeioQLJySdeuOHy5jH8ULEzkTvq1yQ0sm', 'test', '30', 'male', 'james@tecky.io', '99998888', 'image', '2027-03-31', true, true);

INSERT INTO admins (username, password, email) VALUES ('Navy', '$2a$10$IpU.rTE7Olsdr.X.ku2TzeioQLJySdeuOHy5jH8ULEzkTvq1yQ0sm', 'navy@tecky.io');
--

INSERT INTO gym_rooms (map, location_name, location_address, location_contact, location_max_people, latitude, longitude) VALUES ('map test', 'Hysan Place - Causeway Bay', '500 Hennessy Road, Lee Garden, Causeway Bay, Hong Kong', '2688 8888', '200', '22.279800', '114.183937');
INSERT INTO gym_rooms (map, location_name, location_address, location_contact, location_max_people, latitude, longitude) VALUES ('map test', 'MOKO - Mongkok', '193 Prince Edward Road West, Mong Kok', '2688 8899', '150', '22.321550', '114.171112');
--

INSERT INTO check_in_records (user_id, gym_room_id, check_in_date, check_in_at, check_out_at) VALUES (1, 1, '2024-01-20', '2024-01-20T10:00:00Z+00:00', '2024-01-20T11:00:00Z+00:00');
INSERT INTO check_in_records (user_id, gym_room_id, check_in_date, check_in_at, check_out_at) VALUES (2, 1, '2024-01-20', '2024-01-20T10:00:00Z+00:00', '2024-01-20T11:00:00Z+00:00');
--

INSERT INTO check_in_records (user_id, gym_room_id, check_in_date, check_in_at, check_out_at) VALUES (1, 1, '2024-02-02', '2024-02-02T10:00:00Z+00:00', '2024-02-02T11:00:00Z+00:00');
INSERT INTO check_in_records (user_id, gym_room_id, check_in_date, check_in_at, check_out_at) VALUES (2, 1, '2024-02-02', '2024-02-02T10:00:00Z+00:00', '2024-02-02T11:00:00Z+00:00');

--

INSERT INTO course_lists (name, tutor, tutor_icon, max_people_limit, open_datetime, end_datetime, gym_room_id) VALUES
('yoga', 'Amy', 'Amy Icon', 8, '2024-02-05T17:00:00Z+08:00', '2024-02-05T10:00:00Z+00:00', 1),
('Program', 'Amy', 'Amy Icon', 8, '2024-02-05T17:00:00Z+08:00', '2024-02-05T10:00:00Z+00:00', 1);
--

INSERT INTO class_reservations (register_email, confirm_msg, user_id, course_id) VALUES ('james@tecky.io', 'Please click thee link to complete the reservation', 1, 1);
--

INSERT INTO friends_lists (user_id, username) VALUES (1, 'James');
INSERT INTO friends_lists (user_id, username) VALUES (2, 'Alfred');
--
