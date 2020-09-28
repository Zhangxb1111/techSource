<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>


<a href="print">打印1</a>
<a href="${pageContext.request.contextPath}/print">打印2</a>


<a href="${pageContext.request.contextPath}/user/print">打印2</a>

<%-- requestMapper注解--%>
<h2>requestMapper注解</h2>

<form action="${pageContext.request.contextPath}/user/print" method="get">
    <input type="submit" value="get请求">
</form>

<form action="${pageContext.request.contextPath}/user/print" method="post">
    <input type="submit" value="post请求">
</form>

<h2>requestMapper注解的params</h2>
<a href="${pageContext.request.contextPath}/user/testParams?money>100">保存用户</a>

<%-- 请求参数--%>
<h2>请求参数</h2>
<form action="${pageContext.request.contextPath}/user/saveUser" method="post">
    姓名：<input name="username" type="text"> <br>
    年龄：<input name="age" type="text"><br>
    标记：<input name="flag" type="text"><br>
    性别：<input name="sex" type="text"><br>
    角色名称：<input name="role.roleName" type="text"><br>
    生日：<<input type="text" name="birthday">

    爱好：   <input type="checkbox" name="play" value="chouyan">  抽烟
            <input type="checkbox" name="play" value="hejiu"> 喝酒
            <input type="checkbox" name="play" value="tangtou"> 烫头
            <input type="checkbox" name="play" value="sleep">  睡觉
            <input type="checkbox" name="play" value="qiaodaima">  敲代码<br>

    <%--不常用，尽量看明白--%>
    <%--pojo对象中的list集合通过索引赋值--%>
    字符串list集合的第一个元素：<input name="strList[0]" type="text"><br>
    字符串list集合的第二个元素：<input name="strList[1]" type="text"><br>
    角色list集合的第一个元素：<input name="roleList[0].roleName" type="text"><br>
    角色list集合的第二个元素：<input name="roleList[1].roleName" type="text"><br>
    <%--pojo对象中的Map集合赋值: one=role  two = role --%>
    角色Map集合的第一个元素：<input name="roleMap['one'].roleName" type="text"><br>
    角色Map集合的第二个元素：<input name="roleMap['two'].roleName" type="text"><br>

    <input type="submit" value="保存用户">
</form>
<%--类型转换器--%>
<form action="${pageContext.request.contextPath}/user/saveUser" method="post">
    生日：<<input type="text" name="birthday">
    <input type="submit" value="保存用户">
</form>


</body>
</html>
