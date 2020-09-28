/*
	sql语句对于表的操作
	
	创建表格式：
	create table 表名 (
		字段名 数据类型(长度) [约束], 
		字段名 数据类型(长度) [约束], 
		字段名 数据类型(长度) [约束]
	);
	
	字段名就是每个列的列名
	
	数据类型和java的数据差不过，都是用来对字段的值进行限制。
	mysql中常见的数据类型有以下几种：
	int： 整数类型
	double： 小数类型
	date： 日期 这个日期只有年月日，没有时分秒。 如果要有时分秒，可以使用datetime
	varchar: 字符串
	
	在常见的数据类型中，其中如果类型是varchar必须要指定长度，其他类型可以省略。
	
	每个字段都可以加一些约束，并且这个约束是可选的，可以有也可以没有。
	有一个约束叫做主键约束 primary key， 被主键约束的列必须唯一且不能为空。
*/

# 创建一个库 
CREATE DATABASE mydb;

# 使用
USE mydb;

# 创建一个分类表（category）， 里面给出两个字段（id， cname）
CREATE TABLE category(
	id INT,
	cname VARCHAR(10)
);