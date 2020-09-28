/*
	数据库表中的数据的修改语句。
	
	如果要对表中的数据进行修改，那么可以使用关键字update
	格式：
		update 表名 set 列1=值1, 列2=值2 [where 条件];
		
	注意：
		在修改语句中where条件是可选的，如果省略，那么会对表中的所有数据进行修改
		where条件用作条件筛选
*/

# 不加条件，会修改所有的语句
# 会把所有数据的cname这个值都变成机器人
UPDATE category SET cname = '机器人';

# 对id是 3的商品分类名字进行修改，改成 芭比娃娃
UPDATE category SET cname = '芭比娃娃' WHERE id = 3;

# 如果要对多个列的数据进行修改，可以使用逗号隔开
# 把 id是5的分类名改成 数码产品。 分类详情改成 中关村直销
UPDATE category SET cname='数码产品', detail='中关村直销' WHERE id = 5;