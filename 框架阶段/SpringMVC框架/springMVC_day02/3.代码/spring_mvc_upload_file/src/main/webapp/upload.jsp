<%--
  Created by IntelliJ IDEA.
  User: sun
  Date: 2018/9/26
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
        <input type="file" name="uploadFile">
        <input type="submit">
    </form>
</body>
</html>
