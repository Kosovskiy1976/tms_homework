drop table if exists orders;
create table orders(
                       id uuid primary key,
                       name varchar,
                       price int,
                       quantity int,
                       time timestamp,
                       deleted varchar
)