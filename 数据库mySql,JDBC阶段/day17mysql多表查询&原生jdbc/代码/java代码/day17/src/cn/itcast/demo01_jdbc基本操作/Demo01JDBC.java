package cn.itcast.demo01_jdbc基本操作;
/*
    JDBC的准备工作：
        1. 向数据库表中添加数据。
        2. JDBC中的相关API
            DriverManager： 类，这个类用来管理数据库的驱动。
            Connection： 接口，这个接口表示数据库连接对象。
            Statement： 接口， 这个接口表示sql语句执行者对象。
            ResultSet： 接口， 这个接口表示查询后的结果集。
            上面API大多数都是接口，实现类 在驱动包中。
            这些接口是java定义的规范接口。其他数据库想要使用java，一定要在驱动包中实现这些接口。
            对应数据库的驱动包不是有java提供的，是由数据库生产厂商（第三方）提供的，如果要使用第三方
            的提供的东西，需要导入jar包。 mysql驱动，就是以jar包的形式提供的。
        3. 导入mysql 驱动jar包
            jar包其实就是java的压缩包，里面放的是.class的文件。
 */
public class Demo01JDBC {
}
