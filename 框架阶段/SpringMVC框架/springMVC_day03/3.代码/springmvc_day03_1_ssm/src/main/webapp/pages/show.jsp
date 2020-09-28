<%--
  Created by IntelliJ IDEA.
  User: sun
  Date: 2018/9/28
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <!-- 引入CSS样式 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
</head>
<body>
<table class="table table-hover">
    <caption>
        <a href="${pageContext.request.contextPath}/pages/account-add.jsp" class="btn btn-default">添加</a>
    </caption>
    <thead>
    <tr>
        <th>id</th>
        <th>用户名</th>
        <th>余额</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${accountList}" var="account">
            <tr>
                <td>${account.id}</td>
                <td>${account.username}</td>
                <td>${account.money}</td>
                <td>
                    <a href="javascript:delAccount(${account.id})" class="btn btn-default">删除</a>
                    <a href="${pageContext.request.contextPath}/account/updateUI?id=${account.id}" class="btn btn-default">修改</a>

                </td>
            </tr>
        </c:forEach>
    </tbody></table>
</body>

<!-- 引入JS文件 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript">
    function delAccount(id){
        if(confirm("请确定要删除吗?")){
            location.href="${pageContext.request.contextPath}/account/del?id="+ id;
        }
    }
</script>
</html>
