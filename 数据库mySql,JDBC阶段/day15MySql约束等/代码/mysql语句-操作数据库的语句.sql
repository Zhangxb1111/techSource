/*
	mysql语句对数据库的操作
	
	1. 创建数据库
	create database 数据库名; 
	create database 数据库名 character set 编码方式;  （了解）

	2. 查看有哪些数据库
		show databases;
	
	3. 查看某个数据库的定义信息(了解)
		show create database 数据库名;
		
	4. 查看正在使用哪个数据库（了解）
		select database();
		
	5. 使用数据库
		use 数据库名;
		
	6. 删除数据库
		drop database 数据库名;
*/

# 表示注释
-- 这个也是注释


# 创建数据库
# create database 数据库名;
CREATE DATABASE mydb;


# 查看有哪些数据库
# show databases;
SHOW DATABASES;

# 查看数据库的定义信息
# show create database 数据库名;
SHOW CREATE DATABASE mydb;

# 使用数据库
# use 数据库名;
USE mydb;

# 查看正在使用哪个数据库
# select database();
SELECT DATABASE();

# 删除数据库
# drop database 数据库名;
DROP DATABASE mydb;