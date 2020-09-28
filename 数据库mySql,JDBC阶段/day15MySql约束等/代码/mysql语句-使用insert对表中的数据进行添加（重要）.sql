/*
	向表中添加数据（重要）
*/

# 创建表
CREATE TABLE category(
	id INT,
	cname VARCHAR(10),
	detail VARCHAR(20)
);

# 1. 全列名添加
# insert into 表名 (列名1, 列名2, 列名3) values (值1, 值2, 值3);
# 添加的时候列名和值必须要严格对应
# 添加的字段的数据不能超过长度
# 如果添加的数据不是数值类型,那么请使用单引号包裹
# 如果要添加的时候想添加空值，可以使用null。
INSERT INTO category (id, cname, detail) VALUES (1, '水果', '新鲜的水果');
INSERT INTO category (id, cname, detail) VALUES (2, '蔬菜', '新鲜的蔬菜');
INSERT INTO category (id, cname, detail) VALUES (3, '儿童用品', '小孩子玩的小孩子玩的小孩子玩的小孩子玩的哈哈哈哈啊');
INSERT INTO category (id, cname, detail) VALUES (4, '汽车用品', NULL);

# 2. 指定列添加(常用)
# insert into 表名 (列名1, 列名3) values (值1, 值3);
INSERT INTO category (id, detail) VALUES (5, '什么分类呀');

# 3. 全列值添加
# 全列值添加的时候不能够省略任何的列
# insert into 表名 values (值1, 值2, 值3);
INSERT INTO category VALUES (6, '鞋子', '人造鳄鱼皮的');

# 4. 批量添加
# insert into 表名 values (值1, 值2, 值3),(值1, 值2, 值3);
INSERT INTO category VALUES (7, '服装', '换季大促销'), (8, '帽子', '颜色非常鲜艳的帽子');

# 分开添加作用和上面一样
INSERT INTO category VALUES (7, '服装', '换季大促销');
INSERT INTO category VALUES (8, '帽子', '颜色非常鲜艳的帽子');
