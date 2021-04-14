INSERT INTO type_services(name) VALUE 
('Villa'), 
('House'), 
('Room');

INSERT INTO type_rents(name, price ) VALUE 
('Year', 105000), 
('Month', 35000), 
('Day', 25000),
('Hour', 7984);

INSERT INTO services (name,area,floor,amounts,price,id_type_rents,id_type_services,status) VALUE 
('Villa', 30, 99, 30, 900, 1, 1,'booked'),
('House', 20, 15, 45, 800, 2, 2,'booked'),
('House', 20, 15, 45, 800, 3, 2,'booked'),
('Room', 10, 66, 15, 500, 4, 3, 'booked'),
('Room', 5, 75, 15, 400, 4, 3, 'booked'),
('Villa', 50, 12, 6, 900, 3, 1, 'booked'),
('Villa', 60, 78, 69, 899, 2, 1,'booked');

INSERT INTO contract (start_date, end_date, deposit, total, id_services, id_customer, id_employee) VALUE
('2018-12-06', '2019-02-24', 5000000, 99999999, 15, 1, 1001),
('2017-01-06', '2018-02-18', 6000000, 1560000000, 16, 2, 1002);

INSERT INTO services_include (name, unit, price, status) VALUE
('massage', 50000, 350000, 'full'),
('karaoke', 6000, 9000000, 'full'),
('food', 99510, 999000, 'still');

INSERT INTO contract_detail (amount, id_contract, id_services_include) VALUE
(1, 13, 1),
(3, 14, 2),
(4, 14, 3);