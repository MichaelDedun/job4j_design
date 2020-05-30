CREATE TABLE body (
id SERIAL PRIMARY KEY,
number INT NOT NULL ,
color VARCHAR(30)
);

CREATE TABLE engine (
id SERIAL PRIMARY KEY,
power INT NOT NULL
);

CREATE TABLE gearbox (
id SERIAL PRIMARY KEY,
type VARCHAR(30) NOT NULL,
number_of_gears int4
);

CREATE TABLE car (
id SERIAL PRIMARY KEY,
model VARCHAR(30),
body_id INT4 REFERENCES "body"(id),
engine_id INT4 REFERENCES "engine"(id),
gearbox_id INT4 REFERENCES "gearbox"(id)
);

INSERT INTO body (number, color) VALUES (228, 'PINK');
INSERT INTO body (number, color) VALUES (231, 'GREEN');
INSERT INTO body (number, color) VALUES (100, 'RED');

INSERT INTO engine (power) VALUES (322);
INSERT INTO engine (power) VALUES (400);
INSERT INTO engine (power) VALUES (231);

INSERT INTO gearbox (type, number_of_gears) VALUES ('automatic', 5);
INSERT INTO gearbox (type, number_of_gears) VALUES ('mechanic', 6);
INSERT INTO gearbox (type, number_of_gears) VALUES ('variator', 4);

INSERT INTO car (model, body_id, engine_id, gearbox_id) VALUES ('BMW',1,1,1);
INSERT INTO car (model, body_id, engine_id, gearbox_id) VALUES ('LADA',2,2,2);

SELECT c.model, b.number, b.color, e.power, g.type, g.number_of_gears FROM car as c
 join body b on c.body_id = b.id
 join engine e on c.engine_id = e.id
 join gearbox g on c.gearbox_id = g.id;

 SELECT b.number, b.color, e.power, g.type, g.number_of_gears FROM car as c
  full outer join body b on c.body_id = b.id
  full outer join engine e on c.engine_id = e.id
  full outer join gearbox g on c.gearbox_id = g.id
  where c.id is null
