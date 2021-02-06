use mydb;

-- Queries for SINGLE_TABLE strategy
create table payment(
id int PRIMARY KEY,
pmode varchar(2),
amount decimal(8,3) ,
cardnumber varchar(20),
checknumber varchar(20)
);

select * from payment

-- Queries for TABLE_PER_CLASS strategy
drop table payment;

select * from payment;

create table card(
id int PRIMARY KEY,
amount decimal(8,3),
cardnumber varchar(20)
);

create table bankcheck(
id int PRIMARY KEY,
amount decimal(8,3),
checknumber varchar(20)
);

select * from card;

select * from bankcheck;

-- Queries for JOINED strategy
use mydb;

drop table card;

drop table bankcheck;

create table payment(
id int PRIMARY KEY,
amount decimal(8,3)
);

create table card(
id int ,
cardnumber varchar(20),
 FOREIGN KEY (id)
REFERENCES payment(id)
);

create table bankcheck(
id int ,
checknumber varchar(20),
FOREIGN KEY (id)
REFERENCES payment(id)
);