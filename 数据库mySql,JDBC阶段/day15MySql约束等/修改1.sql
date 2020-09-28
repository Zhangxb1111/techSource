CREATE TABLE categroy1(
	id INT,
	cname VARCHAR(10)
);
INSERT INTO categroy1(id,cname)VALUES(1,'张三');
INSERT INTO categroy1 VALUES(2,'李四'),(3,'王五');
UPDATE  categroy1 SET cname = '赵柳'WHERE id = 2;
#添加列
ALTER TABLE categroy1 ADD details VARCHAR(20);
#修改列的类型,长度或者约束
ALTER TABLE categroy1 MODIFY details INT;
ALTER TABLE categroy1 MODIFY details VARCHAR(20);
#修改列名
ALTER TABLE categroy1 CHANGE details xinlieming VARCHAR(20);
#删除列
ALTER TABLE categroy1 DROP xinlieming;
#修改表名
RENAME TABLE categroy1 TO bitch;
#修改表的编码
ALTER TABLE bitch CHARACTER SET 
#删除表
DROP TABLE categroy1;

