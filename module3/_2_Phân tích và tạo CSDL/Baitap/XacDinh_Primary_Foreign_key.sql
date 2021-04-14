
create table Customers(
	customer_number varchar(10),
    fullname varchar(30),
    address varchar(40),
    email varchar(30) unique,
    phone varchar(10) unique,
    constraint primary key (customer_number)
);

create table Accounts (
	account_number varchar(10),
    account_type varchar(10),
    customer_number varchar(10),
    date_of_open date,
    balance decimal(30,2),
    constraint primary key (account_number),
    constraint foreign key (customer_number) references Customers (customer_number)
);

create table Transactions (
	tran_number varchar(10),
    account_number varchar(10),
    date_of_tran date,
    amounts decimal(30,2),
    descriptions text,
	constraint primary key (tran_number),
    constraint foreign key (account_number) references Accounts (account_number)
)