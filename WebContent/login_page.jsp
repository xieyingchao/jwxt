<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>login_page</title>
		<link rel="stylesheet" href="./bootstrap337/css/zui.min.css">
		<script type="text/javascript" src="./bootstrap337/js/jquery-3.4.1.min.js"></script>
		<script type="text/javascript" src="./bootstrap337/js/zui.min.js"></script>
		<style>
			.login_form {
				/* margin-top: 50px; */
			}
			.top{
				/* background: blue; */
			}
			.top>img {
				margin: 0 auto;
			}
			.container {
				height: 487px;
				width: 1296px;
				background: url(./images/bg.png) no-repeat center center;
			}
			.username {
				margin-top: 10px;
				width: 300px;
				margin-left: 50px;
			}
			.userpwd {
				margin-top: 10px;
				width: 300px;
				margin-left: 50px;
			}
			.par_captcha {
				margin-top: 10px;
				width: 300px;
				margin-left: 50px;
				
			}
			.captcha {
				width: 140px;	
				display: inline-block;
			}
			.par_captcha>img {
				float: right;
				height: 32px;
			}
			.btn {
				margin-top: 10px;
				width: 100px;
				margin-left: 50px;
			}
			.userpwd>.text-success {
				color: #38b03f;
			}
			.page-header {
				margin-top: 120px;
				margin-left: 50px;
				width: 300px;
			}
			.userbtn {
				margin-left: 50px;
				margin-top: 10px;
			}
			.radio-primary {
				float: left;
				margin-right: 10px;
			}
			.clr {
				clear: both;
			}
			.code{
				font-size: 15px;
				color: red;
			}
		</style>
	</head>
<body>
	<form action="login" class="login_form" method="post">
		<div class="top">
			<img src="./images/logo17.jpg" width="1160px" height="100px" class="img-responsive">
		</div>
		<div class="container">
			<div class="page-header">
			  <h2>用户登录 <span class="code">${info}</span></h2>
			</div>
			<div class="input-control has-label-left username">
			  <input id="inputAccountExample2" type="text" class="form-control" placeholder="" name="user_name">
			  <label for="inputAccountExample2" class="input-control-label-left">学(工)号:</label>
			</div>
			<div class="input-control has-label-left has-label-right userpwd">
			  <input id="inputPasswordExample2" type="password" class="form-control" placeholder="" name="user_pwd">
			  <label for="inputPasswordExample2" class="input-control-label-left">密码:</label>
			  <label for="inputPasswordExample2" class="input-control-label-right text-right text-success">安全!!!</label>
			</div>
			<div class="par_captcha">
				<div class="input-control has-icon-right captcha">
				  <input id="inputPasswordExample1" type="text" class="form-control" placeholder="验证码" name="user_code">
				  <label for="inputPasswordExample1" class="input-control-icon-right"><i class="icon icon-key"></i></label>
				</div>
				<img src="code" width="140px" height="200px" class="img-responsive" alt="响应式图片测试">
			</div>
			<div class="userbtn">
				<div class="radio-primary"><input type="radio" name="primaryRadioGroup1" checked="checked" id="primaryradio1" value="student">
					<label for="primaryradio1">学生用户</label>
				</div>
				<div class="radio-primary"><input type="radio" name="primaryRadioGroup1" id="primaryradio2" value="teacher">
					<label for="primaryradio2">教师用户</label>
				</div>
				<div class="clr"></div>
			</div>
			<button class="btn btn-primary" type="submit">登录</button>
		</div>
	</form>
	
</body>
<script type="text/javascript">
	$(function(){
		$(".par_captcha>img").click(function(){
			//点击图片换验证码
			this.src = "code?" + new Date().getTime();
		});
		$(".btn").click(function(){
			if($("#inputAccountExample2").val() == ""){
				alert("请输入学号或工号！");
				return false;
			}else if($("#inputPasswordExample2").val() == ""){
				alert("请输入密码！");
				return false;
			}else if($("#inputPasswordExample1").val() == ""){
				alert("请输入验证码！");
				return false;
			}
			$(".login_form").submit();
		});
	});
</script>
</html>