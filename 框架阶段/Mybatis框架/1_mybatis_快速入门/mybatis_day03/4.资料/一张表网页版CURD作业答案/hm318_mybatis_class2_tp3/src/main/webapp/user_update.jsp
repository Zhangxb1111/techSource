<%@ page isELIgnored="false" language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>修改用户信息</title>
		<!-- 引入CSS -->
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<!-- 引入JS -->
		<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/user.js"></script>
	</head>
	<body>
		<h1>修改用户信息</h1>
		<div>
			<!-- 提示语句用于js验证(errorMsg) -->
			<div id="errorMsg" 
				 class="alert alert-danger"
				 style="display: none;"></div>
				 
			<form onsubmit="checkUpdateUser();return false;"
				  role="form" 
				  action="UserOperateAction?method=update"
				  method="post" >
				<input type="hidden" name="id" value="${user.id}" />
				<table class="table">
					<tr>
						<th>姓名:</th>
						<td>
							<input class="form-control" 
								   placeholder="请输入姓名"
								   type="text" 
								   id="username"
								   name="username"
								   value="${user.username}"
								    />
						</td>
					</tr>
					<tr>
						<th>生日:</th>
						<td>
							<input class="form-control"
								   placeholder="请输入生日,格式为yyyy-MM-dd,例如2017-09-01"
								   type="text"
								   id="birthday"
								   name="birthday"
								   value="<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/>"
							/>

						</td>
					</tr>

					<tr>
						<th>性别:</th>
						<td>
							<select class="form-control" id="sex" name="sex">
								<option value="">---请选择---</option>
								<option
										<c:if test="${user.sex eq \"男\"}">selected</c:if>
										value="1"
								>
									男
								</option>
								<option
										<c:if test="${user.sex eq \"女\"}">selected</c:if>
										value="0"
								>
									女
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>地址:</th>
						<td>
							<input class="form-control" 
								   placeholder="请输入地址"
								   type="text" 
								   id="address"
								   name="address"
								   value="${user.address}"
								    />
						</td>
					</tr>
					

					<tr>
						<th colspan="2" style="text-align: center;">
							<button type="submit" class="btn btn-success">确定</button>
							<button type="reset" class="btn btn-danger">取消</button>
						</th>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
