DROP TABLE IF EXISTS countries;

CREATE TABLE countries (
   id INT AUTO_INCREMENT  PRIMARY KEY,
   name VARCHAR(250) NOT NULL,
   continent VARCHAR(250) NOT NULL
);