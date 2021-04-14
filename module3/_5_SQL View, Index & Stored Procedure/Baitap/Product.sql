create database demo;
use demo;

create table product(
	id int not null primary key,
    product_code int not null,
    product_name varchar(255),
    product_price double not null,
    product_amount int not null,
    product_description varchar(255),
    product_status varchar(255)
    );
    
    -- chen du lieu cho table product.
    insert into product values
    (1,111,'nokia',5000000,10,'black','99%'),
    (2,112,'apple',5000000,10,'black','99%'),
    (3,113,'samsumg',5000000,10,'black','99%'),
    (4,114,'xiaomi',5000000,10,'black','99%'),
    (5,115,'sony',5000000,10,'black','99%');
    
   -- 1. tao chi muc cho cot product_code.
alter table product
add index index_code(product_code);
    
alter table product
add index name_price(product_name,product_price);

explain select*
from product;

-- 2. tao view.

create or replace view showinformation 
as
select id,product_code, product_name, product_price, product_amount, product_description,
 product_status 
 from product ;

 -- sua view
 create or replace view showinformation 
as
select id,product_code, product_name, product_price
 from product ;
 
 drop view showinformation;
 
 -- 3.tao procedure
 delimiter //
 create procedure showinfor()
 begin
	select*
    from product;
end;//
delimiter ;  

call showinfor();

-- tao moi san pham
delimiter //
drop procedure if exists add_new_product;
 create procedure add_new_product()
 begin
	insert into demo.product values
		(8,199,'samsumg',5000000,20,'red','99%');
end; //
delimiter ;  

call add_new_product();

-- edit name product theo id
delimiter //
drop procedure if exists edit_product;
create procedure edit_product(in id int ,in product_name varchar(255))
begin
	update demo.product
    set product.product_name = product_name
    where product.id = id;
end; //
delimiter ;

call edit_product(3,'huawei');
select*from product;

-- xoa product theo id
delimiter //
drop procedure if exists delete_product;
create procedure delete_product(id int)
begin
	delete
    from demo.product
    where product.id = id;
end; //
delimiter ;

call delete_product(3);
select*from product;