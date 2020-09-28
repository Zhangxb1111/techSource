/*
	子查询
	一个查询语句作为另一个查询语句的一部分。
	可以是另一个查询语句的条件，也可以是另一个查询语句的表。
*/

# 内连接， 查询化妆品分类的商品详情
SELECT p.* FROM product p, category c WHERE p.category_id = c.cid AND c.cname = '化妆品';

# 子查询的写法
SELECT * FROM product WHERE category_id = 'c003';

# 查一下化妆品这个分类的分类id是什么
SELECT cid FROM category WHERE cname = '化妆品';

# 组合
# 子查询，一个查询语句作为另一个查询语句的条件出现。
SELECT * FROM product WHERE category_id = (SELECT cid FROM category WHERE cname = '化妆品');


# 一个查询结果作为另一个查询语句的表。

# 使用子查询查询 product和 temp（临时手动建立的表）
SELECT p.* FROM product p, temp t WHERE p.category_id = t.cid;

SELECT * FROM category WHERE cname = '化妆品';

# 最终结果
SELECT p.* FROM product p, (SELECT * FROM category WHERE cname = '化妆品') t
WHERE p.category_id = t.cid;


# 练习 查询“化妆品”和“家电”两个分类上架商品详情

# 查询化妆品和家电这两个分类的分类id到底是什么
SELECT cid FROM category WHERE cname IN ('化妆品', '家电');

SELECT * FROM product WHERE category_id IN('c001', 'c003') AND flag = '1';

# 最终结果
SELECT * FROM product 
WHERE category_id IN(SELECT cid FROM category WHERE cname IN ('化妆品', '家电')) 
AND flag = '1';