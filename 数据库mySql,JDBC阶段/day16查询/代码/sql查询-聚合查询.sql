/*
	聚合查询。
	
	我们之前的查询都是横向查询， 这个聚合函数是纵向查询
	
	聚合函数：
		count(列)： 统计指定列有多少条数据.不会统计null
		max(列)： 统计指定列的最大值
		min(列)：统计指定列的最小值
		sum(列)： 统计指定列的所有数据的和
		avg(列): 统计指定列的平均值
	
	使用格式：
		select 聚合函数(列) from 表名;
*/

# 查询商品表中商品名这一列有多少条数据
SELECT COUNT(pname) FROM product;

# 查询商品表中分类id这一列有多少条数据
SELECT COUNT(category_id) FROM product;

# 查询商品表中有多少条数据
# 如果要统计有多少条数据，那么可以使用count(*)
SELECT COUNT(*) FROM product;

# 查询价格大于200商品的总条数
SELECT COUNT(*) FROM product WHERE price > 200;

# 查询所有商品的商品价格总和
SELECT SUM(price) FROM product;

# 查询分类为'c001'的所有商品的价格总和
SELECT SUM(price) FROM product WHERE category_id = 'c001';

#查询分类为'c002'所有商品的平均价格
SELECT AVG(price) FROM product WHERE category_id = 'c002';

#查询商品的最大价格和最小价格
SELECT MAX(price) FROM product;
SELECT MIN(price) FROM product;
SELECT MAX(price) AS 最大值, MIN(price) AS 最小值 FROM product;