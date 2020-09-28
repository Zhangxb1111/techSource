/*
	删除语句
	delete from 表名 [where 条件];
	
	用于对表中的数据进行删除。
	
	while用作条件筛选，可以省略，如果省略，会删除掉所有的数据
	
*/
# 使用delete，不加条件，会删除所有数据
DELETE FROM category;

# 如果要删除指定的数据，那么需要加上条件
# 删除id是5的这条数据
DELETE FROM category WHERE id = 5;


# 还有一种删除，可以直接删除掉表中所有的数据。（不能加条件）
# truncate table 表名;
TRUNCATE TABLE category;