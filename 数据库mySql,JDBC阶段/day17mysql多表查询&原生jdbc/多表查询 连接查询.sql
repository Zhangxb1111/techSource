CREATE DATABASE myyb;
USE myyb;

CREATE TABLE category(
	cid VARCHAR(32) PRIMARY KEY,
	cname VARCHAR(50)
); 

CREATE TABLE products(
	pid VARCHAR(32) PRIMARY KEY, 
	pname VARCHAR(50),
	price INT,
	flag VARCHAR(2),
	category_id VARCHAR(20)
);

INSERT INTO category(cid,cname) VALUES('c001','家电');
INSERT INTO category(cid,cname) VALUES('c002','服饰');
INSERT INTO category(cid,cname) VALUES('c003','化妆品');

INSERT INTO products(pid, pname,price,flag,category_id) VALUES('p001','联想',5000,'1','c001');
INSERT INTO products(pid, pname,price,flag,category_id) VALUES('p002','海尔',3000,'1','c001');
INSERT INTO products(pid, pname,price,flag,category_id) VALUES('p003','雷神',5000,'1','c001');
INSERT INTO products (pid, pname,price,flag,category_id) VALUES('p004','JACKJONES',800,'1','c002');
INSERT INTO products (pid, pname,price,flag,category_id) VALUES('p005','真维斯',200,'1','c002');
INSERT INTO products (pid, pname,price,flag,category_id) VALUES('p006','花花公子',440,'1','c002');
INSERT INTO products (pid, pname,price,flag,category_id) VALUES('p007','劲霸',2000,'1','c002');
INSERT INTO products (pid, pname,price,flag,category_id) VALUES('p008','香奈儿',800,'1','c003');
INSERT INTO products (pid, pname,price,flag,category_id) VALUES('p009','相宜本草',200,'1','c003');

SELECT * FROM products,category; 

SELECT * FROM products,category WHERE products.category_id = category.cid;

SELECT p.pname,p.price,p.flag,c.cname FROM products p,category c WHERE p.category_id = c.cid AND p.flag = 0; 

SELECT * FROM products p INNER JOIN category c ON p.category_id = c.cid;

SELECT * FROM products p JOIN category c ON p.category_id = c.cid;

SELECT DISTINCT c.cname FROM products p JOIN category c ON p.category_id = c.cid AND p.flag = 1;

SELECT * FROM products p LEFT OUTER JOIN category c ON p.category_id = c.cid;

SELECT * FROM products p RIGHT JOIN category c ON p.category_id = c.cid ;


