/*
	自增长约束 auto_increment
	
	如果对某个列设置自增长，那么如果我们添加这列数据的时候不给出值，系统会自动维护这列的数据。
	
	一定要对整数列使用自动增长。
	
	一般会对主键列设置自动增长，让系统自动维护主键列的值。
	
	如果某个列或者表的名字是关键字，建议使用``包裹起来
*/
# 创建student表
CREATE TABLE student (
	# id列，设置成了主键，并且会自动增长
	id INT PRIMARY KEY AUTO_INCREMENT, 
	`name` VARCHAR(20),
	address VARCHAR(20)
);

# 往student表中添加数据，但是不给主键id添加
INSERT INTO student (`name`, address) VALUES ('刘备', '召烈皇帝庙');
INSERT INTO student (`name`, address) VALUES ('曹操', '没找到埋在哪了');
INSERT INTO student (`name`, address) VALUES ('关羽', '麦城');

# 指定id添加
INSERT INTO student (id, `name`, address) VALUES (10, '诸葛亮', '五丈原');

# 添加数据不指定id
INSERT INTO student (`name`, address) VALUES ('曹操的侍卫', '梦中');


/*
	delete 删除和 truncate删除的区别
	
	
*/

DELETE FROM student; -- 逐条删除每条数据， 并且不会重置自增长序列。

TRUNCATE TABLE student; -- 直接摧毁表，然后创建一个新的表。  会重置自增长序列。

