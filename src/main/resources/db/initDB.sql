DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS insurance_companies;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 1;

CREATE TABLE users
(
  id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name VARCHAR NOT NULL,
  email VARCHAR NOT NULL,
  password VARCHAR NOT NULL,
  enabled BOOL DEFAULT TRUE,
  registered TIMESTAMP DEFAULT now()
);
CREATE UNIQUE INDEX email_idx ON users(email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE insurance_companies
(
  id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name TEXT NOT NULL,
  description TEXT NOT NULL,
  franchise INTEGER NOT NULL,
  amount INTEGER NOT NULL
);




