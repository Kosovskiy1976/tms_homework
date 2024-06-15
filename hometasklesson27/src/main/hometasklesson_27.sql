insert into orders (id, ordername, orderdate, quantity, priсe, delivery) values
 (1, 'milk', '2024-01-01', 3, 1000, false),
 (2, 'bread', '2024-02-01', 2, 1500, true),
 (3, 'cheese', '2024-03-02', 3, 2000, true);

alter table orders add column transport varchar;

select * from orders;

alter table orders drop column transport;

delete from orders where orderdate > '2024-02-15';

update orders set quantity = 20 where id = 2;

TRUNCATE TABLE orders;

