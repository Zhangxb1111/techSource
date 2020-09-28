/*	
	对表中的结构进行修改的语句（了解 ）
*/

# 创建一张表

CREATE TABLE category(
	id INT,
	cname VARCHAR(10)
);

# 对表中的结构进行修改

# 添加列
# alter table 表名 add 字段名 数据类型(长度) [约束];
ALTER TABLE category ADD details VARCHAR(20);

# 修改列的类型，长度或者约束
# alter table 表名 modify 列名 类型(长度) [约束];
ALTER TABLE category MODIFY details INT;
ALTER TABLE category MODIFY details VARCHAR(20);

# 修改列名（也可以修改列的类型长度以及约束）
# alter table 表名 change 旧列名 新列名 类型(长度) [约束];
ALTER TABLE category CHANGE details xiangqing VARCHAR(20);

# 删除列
# alter table 表名 drop 列名;
ALTER TABLE category DROP xiangqing;

# 修改表名
# rename table 表名 to 新表名;
RENAME TABLE category TO fenlei;

# 修改表的编码
# alter table 表名 character set 字符集(了解);
