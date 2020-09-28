<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<%--栗子1：测试ModelAttribute--%>
<form action="${pageContext.request.contextPath}/test/testModelAttribute">
    <input type="text" name="age">
    <input type="text" name="id">
    <input type="submit" >
</form>

<%--栗子2： 测试restful风格的post请求--%>
<form action="${pageContext.request.contextPath}/testOperate/2" method="post">
    <input type="text" name="age">
    <input type="text" name="username">
    <input type="submit" >
</form>


<%--栗子3： 测试restful风格的PUT请求--%>
<%--如果使用put和delete提交方法，name表单的提交必须指定post提交--%>
<form action="${pageContext.request.contextPath}/testOperate/2" method="post">
    <%--设置隐藏域：属性名是_method ，值为put，name提交方式就变成了PUT提交--%>
    <input type="hidden" name="_method" value="PUT">
    <input type="text" name="age">
    <input type="text" name="username">
    <input type="submit" >
</form>

<%--栗子4： 测试restful风格的PUT请求--%>
<form action="${pageContext.request.contextPath}/testOperate/2" method="post">
    <%--设置隐藏域：属性名是_method ，值为put，name提交方式就变成了PUT提交--%>
    <input type="hidden" name="_method" value="DELETE">
    <input type="text" name="age">
    <input type="text" name="username">
    <input type="submit" >
</form>

<%--栗子5： 测试RequestBody注解--%>
<form action="${pageContext.request.contextPath}/testRequestBody" method="post">
    <input name="id" >
    <input name="name" >
    <input type="submit" value="提交">
</form>

<%--栗子5： 测试ResponseBody注解--%>
<input type="button" value="点击" id="btn">



</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript">

    $("#btn").click(function(){
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/testResponseBody.do",
            data:{"id":1},
            dataType:"json",
            success:function(data){
                //回调函数
                alert(data);
            }
        });
    });

</script>

</html>
