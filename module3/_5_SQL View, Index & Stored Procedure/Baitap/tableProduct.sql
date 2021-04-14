create table Products(
	Id int,
    primary key(Id),
    productCode varchar(10),
    productName nvarchar(50),
    productPrice decimal(20,2),
    productAmount decimal(20,2),
    productDescription nvarchar(50),
    productStatus varchar(10)
);

INSERT INTO `testprocedure`.`products` (`Id`, `productCode`, `productName`, `productPrice`, `productAmount`, `productDescription`, `productStatus`) VALUES ('1', '123', 'abc', '13221', '32131', 'adsa', '123');
INSERT INTO `testprocedure`.`products` (`Id`, `productCode`, `productName`, `productPrice`, `productAmount`, `productDescription`, `productStatus`) VALUES ('2', '1233', '123', '3123', '321312', '3123', '3123');
INSERT INTO `testprocedure`.`products` (`Id`, `productCode`, `productName`, `productPrice`, `productAmount`, `productDescription`, `productStatus`) VALUES ('3', 'e3213', '123', '32131', '31231', '31231', '321');
INSERT INTO `testprocedure`.`products` (`Id`, `productCode`, `productName`, `productPrice`, `productAmount`, `productDescription`, `productStatus`) VALUES ('4', '3123', '31231', '3213', '31231', '32131', '31231');

alter table products ADD INDEX product_index(productCode);
EXPLAIN SELECT * FROM products;

aLTER TABLE products ADD INDEX Composite_Index(productName , productPrice);
EXPLAIN SELECT * FROM products;

-- Tạo view
CREATE VIEW products_views AS
SELECT productCode, productName, productPrice, productStatus 
FROM  products;

-- Update view
select * from products_views;
CREATE OR REPLACE VIEW products_views AS
SELECT productCode, productName, productPrice, productStatus
FROM products;

DROP VIEW products_views;

