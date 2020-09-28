<%@ page isELIgnored="false" language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>用户数据展示</title>
    <meta charset="UTF-8">
    <!-- 引入CSS样式 -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style type="text/css">
        .pager .previous>a, .pager .previous>span {
            float: none;
        }
    </style>
    <!-- 引入JS文件 -->
    <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/user.js"></script>
</head>

<body>

<h1>用户数据展示</h1>
<br /><br />
<table class="table">
    <tr class="active">
        <th colspan="6">
            共查询出${totalCount}条数据,
            每页展示${pageSize}条,
            共${totalPage}页,当前是${pageIndex}页;
        </th>
    </tr>
    <tr class="success">
        <th>序号</th>
        <th>姓名</th>
        <th>生日</th>
        <th>性别</th>
        <th>地址</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${list}" var="user" varStatus="s">
        <c:if test="${(s.index+1)%2==0}">
            <!-- 偶数行 -->
            <tr class="danger">
        </c:if>
        <c:if test="${(s.index+1)%2!=0}">
            <tr class="active">
        </c:if>

        <!-- g.getId() -->
        <th>${s.index+1+(pageIndex-1)*pageSize}</th>
        <th>${user.username}</th>
        <th>
            <fmt:formatDate value="${user.birthday}" pattern="yyyy年MM月dd日"/>
        </th>
        <th>
            ${user.sex}
        </th>
        <th>${user.address}</th>
        <th>
            <button type="button" class="btn btn-primary" onclick="goUpdateUser(${user.id});">更新</button>
            ||
            <button onclick="goDeleteUser(${user.id});" type="button" class="btn btn-danger">删除</button>
        </th>
        </tr>
    </c:forEach>
    <tr>
        <th colspan="6" style="text-align: center;">
            <ul class="pager">
                <li class="previous"><a href="#" onclick="goPage(1);">首页</a></li>


                <c:choose>
                    <c:when test="${pageIndex > 1}">
                        <li class="previous">
                            <a href="#" onclick="goPage(${pageIndex-1});">&larr; 上一页</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="previous disabled">
                            <a href="###">没有啦!</a>
                        </li>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${totalPage > pageIndex}">
                        <li class="previous">
                            <a href="#" onclick="goPage(${pageIndex+1});">下一页 &rarr;</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="previous disabled">
                            <a href="###">没有啦!</a>
                        </li>
                    </c:otherwise>
                </c:choose>
                <li class="previous"><a href="#" onclick="goPage(${totalPage});">末页</a></li>
            </ul>
        </th>
    </tr>
</table>
</body>
</html>
