-- liquibase formatted sql
-- changeset sombriks:2023-05-28-00-00-initial-schema.sql

create table products
(
    id          integer        not null auto_increment primary key,
    description varchar(255)   not null,
    price       decimal(10, 2) not null
);

create table clients
(
    id   integer      not null auto_increment primary key,
    name varchar(255) not null
);

create table orders
(
    id         integer   not null auto_increment primary key,
    clients_id integer   not null,
    creation   timestamp not null default now(),
    foreign key (clients_id) references clients (id)
);

create table orders_products
(
    orders_id       integer not null,
    products_id     integer not null,
    products_amount integer not null default 1,
    primary key (orders_id, products_id),
    foreign key (orders_id) references orders (id),
    foreign key (products_id) references products (id)
);

-- rollback drop table orders_products
-- rollback drop table orders
-- rollback drop table clients
-- rollback drop table products
