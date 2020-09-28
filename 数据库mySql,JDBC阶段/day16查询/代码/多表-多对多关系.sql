/*
	多对多关系的实现
	多对多关系建表原则要建立三张表，其中有一个表示中间表。
	中间表和另外两张表产生关联关系，另外两张表也叫作主表。
	
	中间表中的外键和主表中的主键产生的关联关系。
	
	建立三张表：
		学生表
		学科表
		中间表
*/
# 建立学生表
CREATE TABLE student(
	id INT PRIMARY KEY AUTO_INCREMENT, 
	`name` VARCHAR(20), 
	age INT
);

# 建立学科表
CREATE TABLE `subject`(
	id INT PRIMARY KEY AUTO_INCREMENT, 
	`name` VARCHAR(20), 
	details VARCHAR(20)
);

# 建立中间表
CREATE TABLE stu_sub(
	stu_id INT,  -- 学生表中的学生id
	sub_id INT   -- 学科表中的学科id
);

# 添加外键约束
# 让中间表中的stu_id 和学生表中的主键id产生主外键关系
# 格式
# alter table 中间表 add [constraint 约束名] foreign key (外键列名) refereneces 主表名 (主键名);
ALTER TABLE stu_sub ADD FOREIGN KEY (stu_id) REFERENCES student (id);

# 让中间表中的sub_id 和学科表中的主键id产生主外键关系
ALTER TABLE stu_sub ADD FOREIGN KEY (sub_id) REFERENCES `subject` (id);


# 添加数据
# 往学生表添加数据
INSERT INTO student (`name`, age) VALUES ('张无忌', 18);
INSERT INTO student (`name`, age) VALUES ('张三丰', 118);
INSERT INTO student (`name`, age) VALUES ('东方不败', 38);
INSERT INTO student (`name`, age) VALUES ('谢逊', 48);

# 往学科表中添加数据
INSERT INTO `subject` (`name`, details) VALUES ('九阳神功', '他横由他横，明月照大江');
INSERT INTO `subject` (`name`, details) VALUES ('葵花宝典', '小葵花妈妈课堂开课啦');
INSERT INTO `subject` (`name`, details) VALUES ('七伤拳', '伤人伤己');
INSERT INTO `subject` (`name`, details) VALUES ('太极拳', '以柔克刚');

# 往中间表中添加数据
INSERT INTO stu_sub (stu_id, sub_id) VALUES (1, 1);
INSERT INTO stu_sub (stu_id, sub_id) VALUES (1, 3);
INSERT INTO stu_sub (stu_id, sub_id) VALUES (1, 4);
INSERT INTO stu_sub (stu_id, sub_id) VALUES (2, 1);
INSERT INTO stu_sub (stu_id, sub_id) VALUES (2, 4);

# 如果向中间表中添加数据时，对应的外键在主表中是不存在的，那么就会报错。
INSERT INTO stu_sub (stu_id, sub_id) VALUES (1, 10);
# NULL值不在限制范围内
INSERT INTO stu_sub (stu_id, sub_id) VALUES (1, NULL);

# 删除
# 如果删除主表中的数据，那么如果主表中的数据被其他表引用着，那么就会删除失败。
DELETE FROM student WHERE id = 1;


# 可选， 对中间表的两个列共同设置一个联合主键保证唯一
ALTER TABLE stu_sub ADD PRIMARY KEY (stu_id, sub_id);
