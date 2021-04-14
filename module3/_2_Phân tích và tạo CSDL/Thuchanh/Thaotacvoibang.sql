CREATE TABLE contacts
( contact_id INT(11) NOT NULL AUTO_INCREMENT,
  last_name VARCHAR(30) NOT NULL,
  first_name VARCHAR(25),
  birthday DATE,
  CONSTRAINT contacts_pk PRIMARY KEY (contact_id)
);

CREATE TABLE suppliers
( supplier_id INT(11) NOT NULL AUTO_INCREMENT,
  supplier_name VARCHAR(50) NOT NULL,
  account_rep VARCHAR(30) NOT NULL DEFAULT 'TBD',
  CONSTRAINT suppliers_pk PRIMARY KEY (supplier_id)
);
-- Xóa bảng
-- DROP TABLE customers;

-- thêm cột
-- ALTER TABLE contacts
--   ADD last_name varchar(40) NOT NULL
--     AFTER contact_id,
--   ADD first_name varchar(35) NULL
--     AFTER last_name;

-- Sửa mô tả
-- ALTER TABLE contacts
--   MODIFY last_name varchar(50) NULL;

-- Xóa cột  
-- ALTER TABLE contacts
--   DROP COLUMN contact_type;

-- Thay đổi tên cột  
-- ALTER TABLE contacts
--   CHANGE COLUMN contact_type ctype
--     varchar(20) NOT NULL;
    
-- ALTER TABLE contacts
--   RENAME TO people;