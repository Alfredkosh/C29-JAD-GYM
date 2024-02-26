BEGIN;
CREATE TABLE friends_lists(
     id SERIAL PRIMARY KEY,
     user_a_id Integer not null,
     user_b_id Integer not null
 );

     ALTER TABLE friends_lists ADD CONSTRAINT fk_friends_lists_a_users FOREIGN KEY (user_a_id) references users(id);
  ALTER TABLE friends_lists ADD CONSTRAINT fk_friends_lists_b_users FOREIGN KEY (user_b_id) references users(id);
COMMIT