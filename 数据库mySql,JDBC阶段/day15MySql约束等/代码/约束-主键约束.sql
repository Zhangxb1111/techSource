/*
	约束可以对字段进行限制
	
	主键约束 primary key
	主键约束可以限制该列的值不能为空，且不能重复。
	
	主键约束的列一般没有特殊作用，只是做一个标记。
	
	主键不推荐是业务数据
	
	一个表中最多只能有一个主键，
	从表的设计角度说，一个表应该都有一个主键。
*/

# 添加主键约束（方式一）（常用）
# 直接创建表的时候在字段的后面添加
# 字段名 数据类型 [约束]
CREATE TABLE person(
	id INT PRIMARY KEY, -- 表示对id进行主键约束，id这列的值非空且唯一。
	first_name VARCHAR(10), 
	last_name VARCHAR(10),
	address VARCHAR(10)
);

# 添加数据 
INSERT INTO person (id, first_name, last_name, address) VALUES (1, '不知道', '不清楚', '在哪啊');
# 下面语句会添加失败，因为主键不能重复
INSERT INTO person (id, first_name, last_name, address) VALUES (1, '你知道', '你清楚', '在这啊');

INSERT INTO person (id, first_name, last_name, address) VALUES (2, '你知道', '你清楚', '在这啊');
# 下面语句添加失败因为主键不能为null
INSERT INTO person (id, first_name, last_name, address) VALUES (NULL, '叫啥啊', '到底叫啥啊', '到底在哪啊');


# 添加主键的方式二
# 在创建表时，在constraint区域添加约束
# constraint区域指的是创建表时，最后一个字段的后面。
# [constraint 约束名] primary key (列名)
# 约束名可以随意起，如果省略，约束名就是列名

CREATE TABLE person(
	id INT,
	first_name VARCHAR(10), 
	last_name VARCHAR(10),
	address VARCHAR(10),
	-- 这个位置就是constraint区域，是最后一个字段的后面
	-- constraint pk primary key (id)
	-- 约束名可以省略
	-- constraint primary key (id)
	-- constraint 和约束名都可以省略
	PRIMARY KEY (id)
);

# 添加方式三
# 创建表之后使用alter语句添加
DROP TABLE person;

# 创建person表，但是不添加任何约束

CREATE TABLE person(
	id INT,
	first_name VARCHAR(10), 
	last_name VARCHAR(10),
	address VARCHAR(10)
);

# 使用alter语句添加
# alter table 表名 add [constraint 约束名] primary key (列名);
ALTER TABLE person ADD PRIMARY KEY (id);

# 删除约束
# alter table 表名 drop primary key;
ALTER TABLE person DROP PRIMARY KEY;

# 联合主键
# 多个列共同组成一个主键
# 联合主键组成的所有的列必须全部相同，才表示这两条数据是相同的。
# alter table 表名 add [constraint 约束名] primary key (列名,列名);
ALTER TABLE person ADD PRIMARY KEY (first_name, last_name);

