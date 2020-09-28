# 删除原来的数据库
DROP DATABASE mydb;

# 创建这个数据库
CREATE DATABASE mydb;

# 创建表并且添加数据
#商品表
CREATE TABLE product(
	pid INT PRIMARY KEY AUTO_INCREMENT, -- 商品id
	pname VARCHAR(50), -- 商品名
	price INT, -- 价格
	flag VARCHAR(2) #是否上架标记为：1表示上架、0表示下架
);


INSERT INTO product(pname,price,flag) VALUES('联想',5000,'1');
INSERT INTO product(pname,price,flag) VALUES('海尔',3000,'1');
INSERT INTO product(pname,price,flag) VALUES('雷神',5000,'1');
INSERT INTO product (pname,price,flag) VALUES('JACKJONES',800,'1');
INSERT INTO product (pname,price,flag) VALUES('真维斯',200,'1');
INSERT INTO product (pname,price,flag) VALUES('花花公子',440,'1');
INSERT INTO product (pname, price, flag) VALUES ('苹果', 8000, '1');

SELECT * FROM product;
SELECT * FROM product WHERE pid = 4;
SELECT pid FROM product WHERE pid = 4;