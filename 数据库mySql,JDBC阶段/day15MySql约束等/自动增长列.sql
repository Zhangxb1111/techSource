/*
约束可以对字段进行限制
主键约束 primary key
主键约束可以限制该列的不能为空,且唯一
主键约束的列一般没有特殊作用,只是做一个标记
主键不推荐是业务数据
一个表中最多只能有一个主键
从表达设计角度说,一个表都应该有一个主键

*/
#字段名 数据类型 约束
CREATE TABLE person(
	id INT ,
	first_name VARCHAR(10),
	address VARCHAR(20)
);
ALTER TABLE person ADD PRIMARY KEY(id,first_name);
INSERT INTO person (id,first_name,address)VALUES(1,'张三','中国');
INSERT INTO person (id,first_name,address)VALUES(1,'张三2','中1国');
INSERT INTO person VALUES(2,'李四','二道黑子'),(3,'王五','辽宁');
INSERT INTO person VALUES(2,'李四','二道黑子'),(3,'王五','辽宁');
#方式二
CREATE TABLE person1(
	id INT,
	cname VARCHAR,
	--CONSTRAINT pk PRIMARY KEY(id)
	--CONSTRAINT PRIMARY KEY(id)
	PRIMARY KEY(id)
);
DROP TABLE person;
CREATE TABLE Person2(
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(20),
	address VARCHAR(20) 
);

INSERT INTO person2(`name`,address)VALUES('张一抹','中国');
INSERT INTO person2(`name`,address)VALUES('刘亦菲','长白');

INSERT INTO person2(id,`name`,address)VALUES(10,'Harry Potter','Britain');
INSERT INTO person2(`name`,address)VALUES('Hermes','british');
