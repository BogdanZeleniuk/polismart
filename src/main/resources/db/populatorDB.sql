DELETE FROM users;
DELETE FROM user_roles;
DELETE FROM insurance_companies;
ALTER SEQUENCE global_seq RESTART WITH 1;

INSERT INTO users
  (name,email,password) VALUES
  ('User', 'user@ukr.net', 'user');

INSERT INTO users
  (name,email,password) VALUES
  ('Admin','admin@gmail.com','admin');

INSERT INTO user_roles
  (role, user_id) VALUES
  ('USER_ROLE',1),
  ('ADMIN_ROLE',2);

INSERT INTO insurance_companies
(name,description,franchise,amount) VALUES
  ('INGO Ukraine','The best Russian insurance company',0,1037),
  ('PZU Ukraine','The best Polish insurance company',0,1037),
  ('UNIVES','The best Ukrainian insurance company',0,798),
  ('AXA','The best French insurance company',0,1296),
  ('TALISMAN','The worse Ukrainian insurance company',0,695),
  ('GRAWE','The best Austrian insurance company',0,1102);