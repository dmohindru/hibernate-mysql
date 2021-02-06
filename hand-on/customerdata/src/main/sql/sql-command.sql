-- command to use database
use mydb;

-- command to create customer database
create table customer(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(20),
email varchar(50)
);

-- command to select a row from database
select * from customer;

-- drop customer table
drop table customer;
-- command to delete a row from database
delete from customer where id=1;

-- command to create customer table for embedded Address object
create table customer(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(20),
email varchar(50),
streetaddress varchar(30),
city varchar(20),
state varchar(20),
zipcode varchar(20),
country varchar(20)
);