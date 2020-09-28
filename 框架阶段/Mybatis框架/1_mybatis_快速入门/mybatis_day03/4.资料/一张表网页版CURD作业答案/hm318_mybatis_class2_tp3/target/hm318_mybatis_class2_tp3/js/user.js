function checkUpdateUser(){
    // 获取数据
    var username = $("#username");
    var birthday = $("#birthday");
    var address = $("#address");
    var sex = $("#sex");
    if(username.val() == '' || username.val() == null){
        $("#errorMsg").show();
        $("#errorMsg").html("姓名不能为空!");
        username.focus();
        return false;
    }
    if(birthday.val() == '' || birthday.val() == null){
        $("#errorMsg").show();
        $("#errorMsg").html("生日不能为空!");
        birthday.focus();
        return false;
    }else{
        //日期的正则表达式
        var reg = /^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
        var regExp = new RegExp(reg);
        if(!regExp.test(birthday.val())){
            $("#errorMsg").html("日期格式不正确，正确格式为：2014-01-01");
            return false;
        }
    }
    if(sex.val() == '' || sex.val() == null){
        $("#errorMsg").show();
        $("#errorMsg").html("性别不能为空!");
        sex.focus();
        return false;
    }
    if(address.val() == '' || address.val() == null){
        $("#errorMsg").show();
        $("#errorMsg").html("地址不能为空!");
        address.focus();
        return false;
    }
	// 提交
	$("form[action='UserOperateAction?method=update']").submit();
}

function goUpdateUser(id){
	window.location.href = "UserViewAction?method=findUserByID&id="+id;
}

function goDeleteUser(id){
	var con = confirm("确定要删除这个用户么?");
	if(con == true){
		// 确定删除
		window.location.href = "UserOperateAction?method=delete&id="+id;
	}
}

function UserInput(){
	// 获取数据
	var username = $("#username");
	var birthday = $("#birthday");
	var address = $("#address");
	var sex = $("#sex");
	if(username.val() == '' || username.val() == null){
		$("#errorMsg").show();
		$("#errorMsg").html("姓名不能为空!");
        username.focus();
		return false;
	}
    if(birthday.val() == '' || birthday.val() == null){
        $("#errorMsg").show();
        $("#errorMsg").html("生日不能为空!");
        birthday.focus();
        return false;
    }else{
        //日期的正则表达式
        var reg = /^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
        var regExp = new RegExp(reg);
        if(!regExp.test(birthday.val())){
            $("#errorMsg").html("日期格式不正确，正确格式为：2014-01-01");
            return false;
        }
	}
    if(sex.val() == '' || sex.val() == null){
        $("#errorMsg").show();
        $("#errorMsg").html("性别不能为空!");
        sex.focus();
        return false;
    }
	if(address.val() == '' || address.val() == null){
		$("#errorMsg").show();
		$("#errorMsg").html("地址不能为空!");
        address.focus();
		return false;
	}
	// 提交
	$("form[action='UserOperateAction?method=add']").submit();
	
	
}


function goPage(pageIndex){
	window.location.href = "UserViewAction?method=findUserByPage&pageIndex="+pageIndex;
}



function goUpdate(id){
	window.location.href = "FindGradeByIDAction?gid="+id;
}
function goDelete(id){
	var con = confirm("确定要删除此班级么?");
	if(con == true){
		// 确定删除
		window.location.href = "GradeDelAction?id="+id;
	}
}

function goAdd(){
	// 直接跳转到添加新用户界面
	window.location.href="user_add.jsp";
}

function checkInput1(){
	// 1. 获取页面的数据
	var gradeName = $("#gradeName"); // input标签转换为jquery对象
	var gradeDesc = $("#gradeDesc");
	// 2. 验证值是否非空
	if(gradeName.val() == '' || gradeName.val() == null){
		// 错误消息展示
		$("#errorMsg").show();// 隐藏变显示
		$("#errorMsg").html("<strong>请输入班级名称</strong>");
		// 让你要求输入的输入框获取标点
		gradeName.focus();
		return false;
	}
	if(gradeDesc.val() == '' || gradeDesc.val() == null){
		// 错误消息显示
		$("#errorMsg").show();
		$("#errorMsg").html("<strong>请输入班级描述</strong>");
		gradeDesc.focus();
		return false;
	}
	// 提交我指定的表单
	$("form[action='GradeUpdateAction']").submit();
}

function checkInput(){
	// 1. 获取页面的数据
	var gradeName = $("#gradeName"); // input标签转换为jquery对象
	var gradeDesc = $("#gradeDesc");
	// 2. 验证值是否非空
	if(gradeName.val() == '' || gradeName.val() == null){
		// 错误消息展示
		$("#errorMsg").show();// 隐藏变显示
		$("#errorMsg").html("<strong>请输入班级名称</strong>");
		// 让你要求输入的输入框获取标点
		gradeName.focus();
		return false;
	}
	if(gradeDesc.val() == '' || gradeDesc.val() == null){
		// 错误消息显示
		$("#errorMsg").show();
		$("#errorMsg").html("<strong>请输入班级描述</strong>");
		gradeDesc.focus();
		return false;
	}
	// 提交我指定的表单
	$("form[action='GradeAddAction']").submit();
}