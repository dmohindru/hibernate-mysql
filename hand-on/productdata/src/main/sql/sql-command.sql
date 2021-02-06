-- command to use database
use mydb;

-- command to create customer database
create table product(
id int PRIMARY KEY,
name varchar(20),
description varchar(100),
price decimal(8,3)
);

-- command to select a row from database
select * from product;

-- command to delete a row from database
delete from product where id=1;