CREATE DATABASE usermanagement;
USE usermanagement;

create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);

create table Permision(
id int(11) primary key,
name varchar(50)
);

 
create table User_Permision(
permision_id int(11),
user_id int(11)
);

insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');

insert into Permision(id, name) values(1,'add');
insert into Permision(id, name) values(2,'edit');
insert into Permision(id, name) values(3,'delete');
insert into Permision(id, name) values(4,'view');

DELIMITER $$
CREATE PROCEDURE get_user_by_id(IN user_id INT)
BEGIN
    SELECT users.name, users.email, users.country
    FROM users
    where users.id = user_id;
    END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE insert_user(
IN user_name varchar(50),
IN user_email varchar(50),
IN user_country varchar(50)
)
BEGIN
    INSERT INTO users(name, email, country) VALUES(user_name, user_email, user_country);
END$$
DELIMITER ;

DELIMITER $$
create procedure preview_list_users()
begin
SELECT users.id, users.name, users.email, users.country
    FROM users;
    END$$
DELIMITER ;

DELIMITER $$
create procedure delete_users(IN id int)
begin
	delete from users where users.id = id;
    end$$
DELIMITER ;

DELIMITER $$
drop procedure if exists update_users; 
create procedure update_users(in id int, in name varchar(120), in mail varchar(220), in address varchar(120))
begin
	update users 
    set users.name = name , users.email= mail, users.country = address where users.id = id;
end$$
DELIMITER ;
call update_users(7,'Mai Duy', 'maiduybigbang@gmail.com','VietNam');
call delete_users(5);
call preview_list_users;
CREATE USER 'duy'@'%' IDENTIFIED BY '123123';
GRANT ALL PRIVILEGES ON *.* TO 'duy'@'%';
