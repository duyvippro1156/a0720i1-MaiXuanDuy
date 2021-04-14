
create table customers (
	customerNumber int,
    primary key (customerNumber),
    customerName nvarchar(50),
    contactLastName nvarchar(50),
    contactFirstName nvarchar(50),
    phone int(10),
    addressLine1 nvarchar(50),
    addressLine2 nvarchar(50),
    city nvarchar(50),
    state nvarchar(50),
    postalCode int,
    country nvarchar(50),
    saleRepEmployeeNumber int,
    creditLimit int
);

create table oders(
	orderNumber int,
    primary key (orderNumber),
    orderDate date,
    requireDate date,
    shippedDate date,
    status nvarchar(50),
    comments nvarchar(50),
    customerNumber int,
    foreign key (customerNumber) references customers(customerNumber)
);

create table payments(
	customerNumber int,
    foreign key (customerNumber) references customers(customerNumber),
    checkNumber varchar(20),
    primary key (customerNumber, checkNumber),
    paymentDate date,
    amount decimal(10,2)
);

select customers.customerNumber, customerName, phone, paymentDate, amount from customers
inner join payments
on customers.customerNumber = payments.customerNumber
where city = 'Las Vegas';

select customers.customerNumber, customers.customerName, oders.orderNumber, oders.status
from customers
left join oders
on customers.customerNumber = oders.customerNumber;

select customers.customerNumber, customers.customerName, oders.orderNumber, oders.status
from customers LEFT JOIN oders
on customers.customerNumber = oders.customerNumber
where orderNumber is null