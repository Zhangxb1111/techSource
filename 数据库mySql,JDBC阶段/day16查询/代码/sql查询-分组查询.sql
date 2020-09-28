/*
	
	查询每个分类商品的价格总和
	
	我们可以根据商品的分类进行分组，每个分类的商品是一组数据，然后统计
	这一组的总和
	
	如果要根据指定字段进行分组，可以使用关键字 group by
	
	分组查询一定要结合聚合函数去使用.
*/

# 查询每个分类商品的价格总和
SELECT category_id, SUM(price) FROM product GROUP BY category_id;

# 查询每个分类的商品的个数
SELECT category_id, COUNT(*) FROM product GROUP BY category_id;

# 统计各个分类商品的个数, 且只显示个数大于1的信息
# where 和 having的区别
# where 和 having 都用作条件筛选
# where 只能用作分组之前， 是对分组前的数据进行条件筛选
# having  用作分组之后， 是对分组后的数据进行条件筛选的
SELECT category_id, COUNT(*) FROM product GROUP BY category_id HAVING COUNT(*) > 1;

