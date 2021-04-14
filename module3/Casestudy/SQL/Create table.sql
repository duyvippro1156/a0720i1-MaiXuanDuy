CREATE TABLE services (
    id INT AUTO_INCREMENT,
		PRIMARY KEY (id),
    name VARCHAR(50) NOT NULL ,
    area INT NOT NULL default 0,
    floor INT DEFAULT 0,
    amounts VARCHAR(50) NOT NULL default 0,
    price VARCHAR(50) NOT NULL default 0,
    status VARCHAR(50) NOT NULL,
		check(status = 'booked' or status = 'empty'),
    id_type_rents INT,
    CONSTRAINT id_type_rents_fk FOREIGN KEY (id_type_rents)
        REFERENCES type_rents (id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    idcustomer_type_services INT,
    CONSTRAINT id_type_services_fk FOREIGN KEY (id_type_services)
        REFERENCES type_services (id)
        ON DELETE CASCADE ON UPDATE CASCADE
);
     
CREATE TABLE type_rents (
    id INT AUTO_INCREMENT,
		PRIMARY KEY (id),
    name VARCHAR(50) NOT NULL,
		check(name = 'year' or name = 'month' or name = 'day' or name = 'hour'),
    price INT NOT NULL
);

CREATE TABLE type_services (
    id INT AUTO_INCREMENT,
		PRIMARY KEY (id),
    name VARCHAR(50) NOT NULL,
		check(name = 'villa' or name = 'house' or name = 'room')
);

-- CUSTOMER

CREATE TABLE customer (
    id INT,
		CONSTRAINT id_customer_pk PRIMARY KEY (id),
    name VARCHAR(50) NOT NULL,
    birthday DATE NOT NULL,
    gender VARCHAR(50) NOT NULL,
		check(gender = 'male' or gender = 'female' or gender = 'other'),
    id_card VARCHAR(50) NOT NULL UNIQUE,
    phone_number VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL unique,
    address VARCHAR(50) NOT NULL,
    
    id_type_customer INT,
		CONSTRAINT id_type_customer_fk FOREIGN KEY (id_type_customer)
			REFERENCES type_customer (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE type_customer (
	id INT AUTO_INCREMENT,
		CONSTRAINT id_type_customer_pk PRIMARY KEY (id),
    name VARCHAR(50) NOT NULL,
		check(name = 'Diamond' or name = 'Platinum' or name = 'Gold' or name = 'Silver' or name = 'Member')
);

-- EMPLOYEE
CREATE TABLE employee (
    id INT AUTO_INCREMENT,
		CONSTRAINT id_employee_pk PRIMARY KEY (id),
    name VARCHAR(50) NOT NULL,
    birthday DATE NOT NULL,
    employee_id_card VARCHAR(50) NOT NULL unique,
    phone_number VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL unique,
    address varchar(50),
    salary VARCHAR(50) NOT NULL,
    
    id_level_employee INT,
		CONSTRAINT id_level_employee_fk FOREIGN KEY (id_level_employee)
        REFERENCES exp_employee (id) ON DELETE CASCADE ON UPDATE CASCADE,
    id_position_employee INT,
		CONSTRAINT id_position_employee_fk FOREIGN KEY (id_position_employee)
        REFERENCES position_employee (id) ON DELETE CASCADE ON UPDATE CASCADE,
    id_department_employee INT,
		CONSTRAINT id_department_employee_fk FOREIGN KEY (id_department_employee) 
        REFERENCES department_employee (id) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE exp_employee (
    id INT AUTO_INCREMENT,
		CONSTRAINT id_level_employee_pk PRIMARY KEY (id),
    name VARCHAR(50) NOT NULL,
		check(name = 'intermediate' or name = 'Higher' or name = 'university' or name = 'after university')
);

CREATE TABLE position_employee (
    id INT AUTO_INCREMENT,
		CONSTRAINT id_position_employee_pk PRIMARY KEY (id),
    name VARCHAR(50) NOT NULL,
		check(name = 'protocol' or name = 'serve' or name = 'Specialist' or name = 'supervise' 
				or name = 'manager' or name = 'director')
);

CREATE TABLE department_employee (
    id INT AUTO_INCREMENT,
		CONSTRAINT id_department_employee_pk PRIMARY KEY (id),
    name VARCHAR(50) NOT NULL,
		check(name = 'Sale – Marketing' or name = 'Aministration' or  name = 'serve' or  name = 'manager')
);

-- CONTRACT
CREATE TABLE contract_detail (
    id INT AUTO_INCREMENT,
		CONSTRAINT id_contract_detail_pk PRIMARY KEY (id),
    amount INT NOT NULL,
    
    id_contract INT,
    CONSTRAINT id_contract_fk FOREIGN KEY (id_contract)
        REFERENCES contract (id) ON DELETE CASCADE ON UPDATE CASCADE,
        
    id_services_include INT,
    CONSTRAINT id_services_include_fk FOREIGN KEY (id_services_include)
        REFERENCES services_include (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE contract (
    id INT AUTO_INCREMENT,
		CONSTRAINT id_contract_pk PRIMARY KEY (id),
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
		check(end_date >= start_date ),
    deposit INT NOT NULL,
		check(deposit < total),
    total INT NOT NULL,
    
    id_services INT,
    CONSTRAINT id_services_fk FOREIGN KEY (id_services)
        REFERENCES services (id) ON DELETE CASCADE ON UPDATE CASCADE,
    id_customer INT,
    CONSTRAINT id_customer_fk FOREIGN KEY (id_customer)
        REFERENCES customer (id) ON DELETE CASCADE ON UPDATE CASCADE,
    id_employee INT,
    CONSTRAINT id_employee_fk FOREIGN KEY (id_employee)
        REFERENCES employee (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE services_include (
	id INT AUTO_INCREMENT,
		CONSTRAINT id_services_include_pk PRIMARY KEY (id),
    name VARCHAR(50) NOT NULL,
		check(name = 'karaoke' or name = 'massage' or name = 'food' or name = 'water' 
				or name = 'car'),
    unit INT NOT NULL,
		check(unit >= 0),
    price INT NOT NULL,
    status VARCHAR(50) NOT NULL,
		check(status = 'still' or status = 'full')
);
