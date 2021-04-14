create table test (
	ID int(10) auto_increment,
    primary key (ID),
    TEN varchar(20),
    TUOI int(3),
    KHOAHOC varchar(10),
    SOTIEN decimal(10,2)
);

insert into test(TEN,TUOI,KHOAHOC,SOTIEN) values
('Hoang',21,'CNTT',400000),
('Viet',19,'DTVT',320000),
('Thanh',18,'KTDN',400000),
('Nhan',19,'CK',450000),
('Huong',20,'TCNH',500000),
('Huong',20,'TCNH',200000);	


select * from test where TEN = 'Huong';

select TEN,sum(SOTIEN) from test where TEN = 'Huong';

select distinct TEN from test;