DROP TABLE person IF EXISTS;
CREATE TABLE PERSON
(
  ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
  FIRSTNAME VARCHAR(255),
  LASTNAME VARCHAR(255)
);

INSERT INTO person (firstname, lastname) VALUES ('Iris3','Ramirez');
INSERT INTO person (firstname, lastname) VALUES ('Nichole','Ortega');
INSERT INTO person (firstname, lastname) VALUES ('Emma','Jones');
INSERT INTO person (firstname, lastname) VALUES ('Greg','Stevens');
INSERT INTO person (firstname, lastname) VALUES ('Esther','Haynes');
INSERT INTO person (firstname, lastname) VALUES ('Marguerite','Russell');
INSERT INTO person (firstname, lastname) VALUES ('Geraldine','Ballard');