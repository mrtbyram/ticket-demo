CREATE TABLE event (
  id INTEGER PRIMARY KEY,
  name VARCHAR(100) NULL,
  subject VARCHAR(1000) NULL,
  place VARCHAR(100) NULL,
  date DATE NULL);

CREATE TABLE session (
  id INTEGER PRIMARY KEY,
  event_id INTEGER NOT NULL,
  speaker VARCHAR(45) NULL,
  subject VARCHAR(100) NULL,
  image VARCHAR(1000) NULL);
