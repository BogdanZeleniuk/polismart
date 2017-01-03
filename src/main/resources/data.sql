INSERT INTO users
  (name,email,password) VALUES
  ('User', 'user@ukr.net', 'useruser');

INSERT INTO users
  (name,email,password) VALUES
  ('Admin','admin@gmail.com','adminadmin');

INSERT INTO user_roles
  (role, user_id) VALUES
  ('ROLE_USER',1),
  ('ROLE_ADMIN',2);

INSERT INTO insurance_companies
(name,description,franchise,population, engine_power, amount) VALUES
  ('INGO Ukraine','The best Russian insurance company',0,'Kiev','to 1.6',1037),
  ('PZU Ukraine','The best Polish insurance company',0,'Kiev','to 1.6',1037),
  ('UNIVES','The best Ukrainian insurance company',0,'Kiev','to 1.6',798),
  ('AXA','The best French insurance company',0,'Kiev','to 1.6',1296),
  ('TALISMAN','The worse Ukrainian insurance company',0,'Kiev','to 1.6',695),
  ('GRAWE','The best Austrian insurance company',0,'Kiev','to 1.6',1102);