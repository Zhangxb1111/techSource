/*
	一. 交叉连接查询
	
	select * from 表A, 表B;
	
	交叉连接查询结果是两个表的乘积（笛卡尔积），是一个错误的写法
*/

# 查询商品表以及对应的分类的详情信息
SELECT * FROM product, category;


/*
	二. 内连接查询
	隐式内连接（推荐）：
		select * from 表A, 表B where 条件;
	显示内连接：
		select * from 表A inner join 表B on 条件;
	
	多表查询的时候，如果要使用某个表中的字段（列名），建议前面加上表名
	表名.列名
	内连接只会查询两张表关联着的数据
*/

# 隐式内连接
# 查询商品表中的所有的信息以及对应的分类详情
SELECT * FROM product, category WHERE product.category_id = category.cid;

# 可以给表起一个别名，以后再使用表名.列名的时候，就简单的多
SELECT * FROM product AS p, category AS c WHERE p.category_id = c.cid;

# 在别名查询中，可以省略AS
SELECT * FROM product p, category c WHERE p.category_id = c.cid;

# 起完别名后，就相当于把这个表名给改了。所以一定要使用别名。
SELECT * FROM product p, category c WHERE product.category_id = category.cid;

# 查询所有的商品id，商品名，商品价格，以及分类名称
SELECT p.pid,p.pname,p.price,c.cname FROM product p, category c WHERE p.category_id = c.cid;

# 显式内连接
# select * from 表A inner join 表B on 条件;
# 使用显示内连接查询商品表和分类表所有的数据
# 显式内连接 一定要加上条件，不然也会产生笛卡尔积

SELECT * FROM product p INNER JOIN category c ON p.category_id = c.cid;
# 显式内连接中inner可以省略
SELECT * FROM product p JOIN category c ON p.category_id = c.cid;

# 练习-查询哪些分类的商品已经上架
SELECT DISTINCT c.cname FROM product p, category c WHERE p.category_id = c.cid AND p.flag = 1;


/*
	三. 外连接查询
	左外连接查询：
		select * from 表A left outer join 表B on 条件;
		会查询左表中的所有的数据，以及右表中关联着的数据
	右外连接查询：
		select * from 表A right outer join 表B on 条件;
		会查询右表中的所有的数据，以及左表中关联着的数据
	
	在外连接查询中，可以省略outer关键字
*/
# 使用左外连接查询商品表和分类表中所有的数据
SELECT * FROM product LEFT JOIN category ON product.category_id = category.cid;
# 使用别名
SELECT * FROM product p LEFT JOIN category c ON p.category_id = c.cid;
SELECT * FROM category c LEFT JOIN product p ON p.category_id = c.cid;

# 使用右外
SELECT * FROM product p RIGHT JOIN category c ON p.category_id = c.cid;

# 练习查询所有分类商品的个数
SELECT cname,COUNT(pid) FROM category c LEFT JOIN product p ON p.category_id = c.cid GROUP BY cid;