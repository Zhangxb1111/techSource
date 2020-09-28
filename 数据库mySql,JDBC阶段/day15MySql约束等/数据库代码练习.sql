#创建表格式
CREATE TABLE Person(
	id INT,
	cname VARCHAR(10)
);

#使用库
USE mydb;

#查看当前数据库下面有哪些表
SHOW TABLES;

#查看当前表的表结构
DESC Person;

#使用deletee,不加条件,会删除所有数据
DELETE FROM Perosn;
#


