CREATE TABLE category (
	id INT NOT NULL AUTO_INCREMENT,	
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	
	CONSTRAINT pk_category_id PRIMARY KEY(id)
);

INSERT INTO category (name, description, image_url, is_active) VALUES ('Laptop','This is a laptop!','Cat_3.png',true);
INSERT INTO category (name, description, image_url, is_active) VALUES ('Television','This is a television!','Cat_2.png',true);
INSERT INTO category (name, description, image_url, is_active) VALUES ('Mobile','This is a mobile!','Cat_1.png',true);

CREATE TABLE user_details (
	id INT AUTO_INCREMENT,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(60),
	email VARCHAR(100),
	contact_number VARCHAR(15),	
	CONSTRAINT pk_user_id PRIMARY KEY(id)
);

INSERT INTO user_details (first_name, last_name, role, enabled, password,email, contact_number) 
VALUES ('Abhay','Kumar','ADMIN',true,'admin','ak@gmail.com','6666666666');
INSERT INTO user_details (first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Basil','Abdusalam','SUPPLIER',true,'12345','ba@gmail.com','9999999999');
INSERT INTO user_details (first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Azam','Shezad','SUPPLIER',true,'12345','as@gmail.com','7777777777');

CREATE TABLE product (
	id INT NOT NULL AUTO_INCREMENT,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY(id),
	CONSTRAINT fk_product_category_id FOREIGN KEY(category_id) REFERENCES category(id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY(supplier_id) REFERENCES user_details(id)
);

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDABC123DEFX', 'iPhone 5s', 'apple', 'This is one of the best phone available in the market right now!', 18000, 5, true, 3, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRD3707BEDE5B', 'Samsung s7', 'samsung', 'A smart phone by samsung!', 32000, 2, true, 3, 3, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDPQR123WGTX', 'Google Pixel', 'google', 'This is one of the best android smart phone available in the market right now!', 57000, 5, true, 3, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDMNO123PQRX', ' Macbook Pro', 'apple', 'This is one of the best laptops available in the market right now!', 54000, 3, true, 1, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDABCXYZDEFX', 'Dell Latitude E6510', 'dell', 'This is one of the best laptop series from dell that can be used!', 48000, 5, true, 1, 3, 0, 0 );