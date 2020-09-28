/*
	一对多关系（多对一关系）

	部门和员工	
	一个部门可以有多个员工
	但是一个员工只能属于一个部门
	
	一对多关系建表原则要建立两张表，一个是主表，一个是从表。
	多的一方是从表，一的一方是主表。
	从表中需要添加外键列和主表中的主键列产生关联关系。
	
*/

# 建立部门表（主表）
CREATE TABLE department(
	id INT PRIMARY KEY AUTO_INCREMENT, -- 主键id
	`name` VARCHAR(20), -- 部门名称
	details VARCHAR(20) -- 部门详情
);


# 建立员工表(从表)
CREATE TABLE employee(
	id INT PRIMARY KEY AUTO_INCREMENT, -- 主键id
	`name` VARCHAR(20), -- 员工姓名
	age INT, -- 员工年龄
	dep_id INT -- 员工所属部门的id，用于和部门表中的主键id产生关联关系
);

# 添加外键约束
# 让员工表中的dep_id 和 部门表中的主键id产生关联关系。
# 格式
# atler table 从表名 add [constraint 约束名称] foreign key (外键列名) references 主表名 (主键);
ALTER TABLE employee ADD FOREIGN KEY (dep_id) REFERENCES department (id);


# 向表中添加数据
INSERT INTO department (`name`, details) VALUES ('武当', '都是大帅锅');
INSERT INTO department (`name`, details) VALUES ('峨眉', '除了老大女的都是美女');
INSERT INTO department (`name`, details) VALUES ('少林', '都是兔子');

INSERT INTO employee (`name`, age, dep_id) VALUES ('张三丰', 108, 1);
INSERT INTO employee (`name`, age, dep_id) VALUES ('张翠山', 30, 1);
INSERT INTO employee (`name`, age, dep_id) VALUES ('宋远桥', 40, 1);

INSERT INTO employee (`name`, age, dep_id) VALUES ('灭绝师太', 50, 2);
INSERT INTO employee (`name`, age, dep_id) VALUES ('周芷若', 20, 2);

# 如果向从表中添加数据，那么对应外键数据如果在主表中不存在，就会报错
INSERT INTO employee (`name`, age, dep_id) VALUES ('张无忌', 25, 10);
# NULL 不在限制范围内。
INSERT INTO employee (`name`, age, dep_id) VALUES ('张无忌', 25, NULL);

# 删除
# 如果删除主表中的数据，那么如果这个数据被从表使用着，那么不能删除。
DELETE FROM department WHERE id = 1;