DELETE FROM meals;
DELETE FROM user_roles;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password');

INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

INSERT INTO meals (user_id, date_time, description, calories) VALUES
  (100000, '2016-09-27 10:00:00', 'user breakfast', 500),
  (100000, '2016-09-27 13:00:00', 'user lunch', 1000),
  (100000, '2016-09-27 18:00:00', 'user dinner', 600),
  (100001, '2016-09-28 10:00:00', 'admin breakfast', 500),
  (100001, '2016-09-28 13:00:00', 'admin lunch', 1200),
  (100001, '2016-09-28 18:00:00', 'admin dinner', 500);
