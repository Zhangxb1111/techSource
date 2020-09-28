<%--
  Created by IntelliJ IDEA.
  User: sun
  Date: 2018/9/28
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- 引入CSS样式 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <title>Title</title>
</head>
<body>
    <form role="form" method="post" style="margin-left: 100px" enctype="multipart/form-data" action="${pageContext.request.contextPath}/account/upload">
    <div class="form-group">
        <label for="name">姓名</label>
        <input type="text" class="form-control" id="name" name="username"
                                              placeholder="请输入自己的姓名：">
    </div>
    <div class="form-group">
        <label for="inputfile">文件输入</label>
        <input type="file" id="inputfile" name="uploadFile">
    </div>

    <button type="submit" class="btn btn-default">上传文件</button></form>

</body>
<!-- 引入JS文件 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</html>
