/*
	sql语句的简单查询
	
	格式：
		select 列名,列名 from 表名;
		
	如果要查询表中所有的列，可以使用*代替
		select * from 表名;
		
*/

# 查询product表中的所有的数据
SELECT * FROM product;

# 查询product表中的所有的商品名
SELECT pname FROM product;

# 查询商品表中所有的商品名以及价格
SELECT pname,price FROM product;

# 别名查询 as
# 可以对查询结果的列或者表重写起一个名字
# 格式：
# select 列名 as 别名, 列名 as 别名 from 表名;
# 查询所有的商品名，并且给查询后的这一列重写起一个名字(商品名)
SELECT pname AS 商品名 FROM product;
SELECT pname AS '商品名' FROM product;

# 在别名查询中，可以省略as关键字
# select 列名 别名 from 表名;
SELECT pname 商品名 FROM product;
SELECT pname 商品名, price 价格 FROM product;

# 除了可以给列起别名之外，也可以给表起别名。
# select * from 表名 as 别名;
SELECT * FROM product AS 商品表; -- 必须多表查询阶段才能看出效果.
# as 可以省略
SELECT * FROM product 商品表;

# 查询所有的商品价格，并且去掉重复值
# 如果要去重，可以使用distinct关键字
# select distinct 要去重的列 from 表名;
SELECT DISTINCT price FROM product;

# 查询所有的商品名和商品价格，并且把商品价格加上50元进行显示
SELECT pname, price + 50 AS price FROM product;
