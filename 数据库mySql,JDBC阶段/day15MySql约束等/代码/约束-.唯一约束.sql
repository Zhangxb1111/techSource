/*
	唯一约束（UNIQUE）
	
	保证某一列的值是唯一的，不能重复。
	
	
	唯一约束和主键约束的区别：
		1. 唯一约束可以是null值，但是主键不能
		2. 一个表表中可以有多个唯一约束，但是只能有一个主键。

	注意：
		唯一约束不能限制多个NULL值
*/

# 添加唯一约束方式一
# 在创建表时字段后面添加
# 字段名 数据类型(长度) [约束]
CREATE TABLE teacher(
	id INT PRIMARY KEY AUTO_INCREMENT, -- 主键id，自动增长
	`name` VARCHAR(20) UNIQUE, -- 姓名，是唯一的
	address VARCHAR(20)
);

# 添加数据
INSERT INTO teacher (`name`, address) VALUES ('刘备', '成都');
INSERT INTO teacher (`name`, address) VALUES ('曹操', '许昌');
INSERT INTO teacher (`name`, address) VALUES (NULL, '许昌');

-- 添加, name是使用了唯一约束，所以不能重复
INSERT INTO teacher (`name`, address) VALUES ('曹操', '许昌');

-- 添加，唯一约束不能限制多个NULL值
INSERT INTO teacher (`name`, address) VALUES (NULL, '许昌');


# 添加方式二
# 在创建表时constraint区域添加
# [constraint 约束名] unique (列名)
DROP TABLE teacher;

CREATE TABLE teacher(
	id INT PRIMARY KEY AUTO_INCREMENT, -- 主键id，自动增长
	`name` VARCHAR(20), 
	address VARCHAR(20),
	-- 在constraint区域添加唯一约束
	UNIQUE (`name`)
);

# 添加方式三
# 创建表之后使用alter语句添加
# alter table 表名 add [constraint 约束名] unique (列名);

DROP TABLE teacher;

CREATE TABLE teacher(
	id INT PRIMARY KEY AUTO_INCREMENT, -- 主键id，自动增长
	`name` VARCHAR(20), 
	address VARCHAR(20)
);

# 添加唯一约束
ALTER TABLE teacher ADD UNIQUE (`name`);


# 删除约束
# alter table 表名 drop index 约束名;
# 如果添加的时候没有给出约束名，那么约束名就是列名
ALTER TABLE teacher DROP INDEX `name`;