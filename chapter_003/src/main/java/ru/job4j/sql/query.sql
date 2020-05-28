CREATE TABLE "type"
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(30)
);

CREATE TABLE "product"
(
    id           SERIAL PRIMARY KEY,
    name         VARCHAR(30),
    type_id      INT4 REFERENCES "type" (id),
    expired_date TIMESTAMP,
    price        int
);

INSERT INTO type (name)
VALUES ('СЫР');
INSERT INTO type (name)
VALUES ('МОЛОКО');

INSERT INTO product (name, type_id, expired_date, price)
VALUES ('мороженное', 2, '2020-06-08', 100);
INSERT INTO product (name, type_id, expired_date, price)
VALUES ('пармезан', 1, '2020-06-08', 2000);
INSERT INTO product (name, type_id, expired_date, price)
VALUES ('сметана', 2, '2020-07-08', 200);
INSERT INTO product (name, type_id, expired_date, price)
VALUES ('маскарпоне', 1, '2020-08-08', 400);


SELECT *
FROM product as p
         inner join type as t on p.type_id = t.id
where t.name = 'СЫР';

SELECT *
FROM product
WHERE name LIKE '%мороженное%';

SELECT *
FROM product
WHERE EXTRACT(MONTH FROM expired_date) = EXTRACT(MONTH FROM CURRENT_TIMESTAMP) + 1;

SELECT MAX(price)
FROM product;

SELECT COUNT(type.name)
from type
         inner join product p on type.id = p.type_id;

SELECT t.name, COUNT(type_id)
FROM product
         inner join type t on product.type_id = t.id
group by t.name;

SELECT name
FROM (SELECT t.name, COUNT(t.id) as count
      FROM product
               inner join type t on product.type_id = t.id
      group by t.name)
         as nc
WHERE nc.count < 10;

SELECT t.name, p.name
FROM product AS p
         join type t on p.type_id = t.id

