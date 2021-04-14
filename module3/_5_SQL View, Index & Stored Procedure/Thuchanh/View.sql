-- Tạo view
CREATE VIEW customer_views AS
SELECT customerNumber, customerName, phone
FROM  customers;

-- Update view
select * from customer_views;
CREATE OR REPLACE VIEW customer_views AS
SELECT customerNumber, customerName, contactFirstName, contactLastName, phone
FROM customers
WHERE city = 'Nantes';

-- Xóa view
DROP VIEW customer_views;