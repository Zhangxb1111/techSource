/*	
	非空约束（NOT NULL）
	
	作用：可以限制指定列的数据不能是NULL值。
	
*/

# 添加非空约束方式一
# 在创建表时，在字段的后面添加
# 字段名 数据类型 [约束]
DROP TABLE student;

CREATE TABLE student (
	# id列，设置成了主键，并且会自动增长
	id INT PRIMARY KEY AUTO_INCREMENT, 
	# 对name 加上非空约束
	`name` VARCHAR(20) NOT NULL,
	address VARCHAR(20)
);

# 添加数据
INSERT INTO student (`name`, address) VALUES ('刘备', '召烈皇帝庙');

# 添加失败，因为这列的数据不能是null
INSERT INTO student (`name`, address) VALUES (NULL, '我是谁，我在哪');
# 可以添加''
INSERT INTO student (`name`, address) VALUES ('', '你是谁，你在哪');

# 非空约束添加方式二
# 创建表之后使用alter语句修改约束

CREATE TABLE student (
	# id列，设置成了主键，并且会自动增长
	id INT PRIMARY KEY AUTO_INCREMENT, 
	# 对name 加上非空约束
	`name` VARCHAR(20),
	address VARCHAR(20)
);

# alter table 表名 modify 字段名 数据类型(长度) [约束];
ALTER TABLE student MODIFY `name` VARCHAR(20) NOT NULL;


# 删除非空约束
# 也是使用alter语句修改结构
# alter table 表名 modify 字段名 数据类型(长度);
ALTER TABLE student MODIFY `name` VARCHAR(20);