select productCode, productName, buyprice, quantilylnStock from products
where buyprice > 56.76 and quantilylnStock > 10;

SELECT productCode,productName, buyprice, textDescription
FROM products
INNER JOIN productlines
ON products.productline = productlines.productline
WHERE buyprice > 56.76 AND buyprice < 95.59;

select productCode, productName, buyprice, quantilylnStock, productVendor, productLine 
from products 
where productLine = 'Classic Cars' or productVendor = 'Min Lin Diecast';