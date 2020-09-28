#创建表
CREATE TABLE Category(
	id INT,
	cname VARCHAR(10),
	detail VARCHAR(20)
);

/*
 全列名添加
 添加时 列名和值必须严格对应
 添加的字段的数据不能超过长度
 如果添加的数据不是 数值类型,那么请用单引号包裹
 怒过要添加空值,可以使用null
 insert into 表名(列名1,列名2,列名3)values(1,'好东西','大宝贝')
*/
INSERT INTO Category(id,cname,detail)VALUES(1,'大宝贝','给你看个大宝贝');
INSERT INTO Category(id,cname,detail)VALUES(2,'小宝贝','给你看个小宝贝');

/*
 指定添加
*/
INSERT INTO Category(id,detail)VALUES(6,'AV阿达');
#全烈值添加
INSERT INTO category VALUES(7,'衣服','阿迪达斯');
#批量添加
INSERT INTO category VALUES(8,'裤子','阿迪达斯'),(9,'鞋','老北京布鞋'),(10,'眼镜','阿迪达斯');
/*
不会加条件,会修改所有条件的语句,需添加对应id
*/
UPDATE category SET cname = '内裤';
UPDATE category SET cname = '袜子'WHERE id = 1;
#若要修改多个列数据,可以使用逗号隔开
UPDATE category SET cname = '手机',detail = '中标方关村'WHERE id = 6;
