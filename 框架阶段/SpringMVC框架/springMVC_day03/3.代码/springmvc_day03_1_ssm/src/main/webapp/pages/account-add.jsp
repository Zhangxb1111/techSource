<%--
  Created by IntelliJ IDEA.
  User: sun
  Date: 2018/9/28
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- 引入CSS样式 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
</head>
<body>
<form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/account/save">

    <div class="form-group">
        <label for="firstname" class="col-sm-2 control-label">用户名</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="username" id="firstname"
                   placeholder="请输入用户名">
        </div>
    </div>
    <div class="form-group">
        <label for="lastname" class="col-sm-2 control-label">金额</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="money" id="lastname"
                   placeholder="请输入金额">
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">保存</button>
        </div>
    </div></form></body>

</body>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</html>
