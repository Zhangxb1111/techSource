/*
	排序查询 order by
	
	可以将查询后的结果根据指定的字段进行排序。
	
	格式：
		select * from 表名 order by 要排序的字段 [asc | desc];
	
	asc：表示要进行升序排序
	desc：表示降序排序
	asc 和  desc都可以省略，如果全部省略默认是升序排序
*/
# 查询商品表中的所有的数据，并且根据价格从小到大进行排序
SELECT * FROM product ORDER BY price ASC;

# 可以省略asc，默认也是升序
SELECT * FROM product ORDER BY price;

# 查询商品表中所有的数据，并且根据价格从大到小进行排序
SELECT * FROM product ORDER BY price DESC;

# 在价格升序排序的基础上， 对pid进行降序排序
# 如果有相同的价格，那么再根据pid排序
# 如果排多个字段，使用逗号隔开。
SELECT * FROM product ORDER BY price ASC, pid DESC;

#显示商品的价格(去重复)，并排序(降序)
SELECT DISTINCT price FROM product ORDER BY price DESC;