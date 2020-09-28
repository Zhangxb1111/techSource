/*
	条件查询
	
	条件查询需要使用运算符
	常见的运算符
		> < >= <= <> != =： 大于， 小于，大于等于....
		between...and...： 表示在区间范围内。  between 3 and 10。 表示在3到10区间范围内。 包含头和尾。
		in(...)： 表示包含其中之一。 in(1,3,5,7)。 表示可以是1 3 5 7 之间的任意一个
		like： 用作模糊查询。 like一定要结合通配符去使用
			通配符：
				%： 表示任意个任意的字符
				_： 表示一个任意字符	
		is null： 判断是否为空
		
		
	逻辑运算符：
		AND： 与。 所有条件全部成立才算成立。相当于java中的&&
		OR： 或。 有一个条件成立那么就成立。 相当于java中的||
		NOT： 非。 取反。 相当于java中的!
	
	运算符用作条件筛选。
	
	条件查询格式：
		select * from 表名 where 条件;
*/

# 查询商品名称为“花花公子”的商品所有信息
SELECT * FROM product WHERE pname = '花花公子';

# 查询商品名是海尔的商品名和商品价格
SELECT pname, price FROM product WHERE pname = '海尔';

# 查询价格为800商品
SELECT * FROM product WHERE price = 800;

# 查询价格不是800的所有商品
SELECT * FROM product WHERE price <> 800;
SELECT * FROM product WHERE price != 800;
SELECT * FROM product WHERE NOT(price = 800);

# 查询商品价格大于60元的所有商品信息
SELECT * FROM product WHERE price > 60;

# 查询商品价格在200到1000之间所有商品
SELECT * FROM product WHERE price >= 200 AND price <= 1000;
SELECT * FROM product WHERE price BETWEEN 200 AND 1000;

# 查询商品价格是200或800的所有商品
SELECT * FROM product WHERE price = 200 OR price = 800;
SELECT * FROM product WHERE price IN(200,800);

# 查询含有'霸'字的所有商品
# 查询含有什么，可以使用模糊查询 like
# like 要结合通配符去使用
# % 表示任意个任意的字符
# _ 表示一个任意的字符
SELECT * FROM product WHERE pname LIKE '%霸%';

# 查询以'香'开头的所有商品
SELECT * FROM product WHERE pname LIKE '香%';

# 查询第二个字为'想'的所有商品
# 第二个字为想，那么前面必须有一个字符，可以是任意字符
SELECT * FROM product WHERE pname LIKE '_想%';

# 查询商品名为三个字的所哟商品信息
SELECT * FROM product WHERE pname LIKE '___';

# 查询没有分类的商品信息
SELECT * FROM product WHERE category_id IS NULL;

# 查询有分类的商品
SELECT * FROM product WHERE category_id  IS NOT NULL;