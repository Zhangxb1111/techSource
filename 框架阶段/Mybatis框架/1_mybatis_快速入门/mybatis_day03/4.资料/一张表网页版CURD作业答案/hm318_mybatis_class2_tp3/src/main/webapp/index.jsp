<%@ page isELIgnored="false" language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>系统首页</title>
    <!-- 引入CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- 引入JS -->
    <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/user.js"></script>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h1>欢迎使用人员信息管理系统！</h1>
        <p>请选择您要操作的功能</p>
        <p><a href="UserViewAction?method=findUserByPage&pageIndex=1" class="btn btn-primary btn-lg"
              role="button">管理人员信息</a></p>
        <p><a href="###" onclick="goAdd();" class="btn btn-primary btn-lg"
              role="button">添加人员信息</a></p>
    </div>
</div>
</body>
</html>