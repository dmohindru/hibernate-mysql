use mydb;

-- create table with auto increment scheme
create table employee(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(20)
);

-- create table with only id
create table employee(
id int PRIMARY KEY,
name varchar(20)
);

-- drop employee table
drop table employee;

-- show all record in employee table
select * from employee;

-- create table to store primary key
create table id_gen(
gen_name varchar(60) PRIMARY KEY,
gen_val int(20)
);

-- show all records of id_gen table
select * from id_gen;

-- show all tables
show tables;