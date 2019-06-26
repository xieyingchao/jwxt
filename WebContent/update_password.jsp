<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="./bootstrap337/css/zui.min.css">
		<link rel="stylesheet" href="./bootstrap337/css/chosen.min.css">
		<script type="text/javascript" src="./bootstrap337/js/jquery-3.4.1.min.js"></script>
		<script type="text/javascript" src="./bootstrap337/js/zui.min.js"></script>
		<script type="text/javascript" src="./bootstrap337/js/chosen.min.js"></script>
		<style type="text/css">
			.text-center {
				margin-top: 0;
				margin-bottom: 0;
			}
			.article {
				padding-bottom: 0;
			}
			.input-control {
				width: 400px;
				margin: 0 auto;
				margin-bottom: 20px;
			}
			.input-control button {
				width: 100px;
				margin-right: 20px;
			}
			.input-group {
				width: 400px;
				margin: 0 auto;
				margin-bottom: 20px;
			}
			.select_pre {
				margin: 0 auto;
				width: 400px;
				margin-bottom: 20px;
			}
			.select {
				width: 100px;
				float:left;
			}
			.addr {
				width: 280px;
				float: right;
			}
			.clr {
				clear: both;
			}
			.result {
				color:red;
			}
		</style>
	</head>
<body>
	<div class="container">
		<div class="article">
			<header>
				<h3 class="text-center" >修改密码</h3>
			</header>
		</div>
		<hr>
		<form action="updatepwd">
			<div class="input-control has-label-left">
			  <input id="inputAccountExample2" type="password" class="form-control " placeholder="" name="oldpwd">
			  <label for="inputAccountExample2" class="input-control-label-left">旧密码:</label>
			</div>
			<div class="input-control has-label-left">
			  <input id="inputAccountExample2" type="password" class="form-control newpwd" placeholder="" name= "newpwd">
			  <label for="inputAccountExample2" class="input-control-label-left">新密码:</label>
			</div>
			<div class="input-control has-label-left-lg">
			  <input id="inputAccountExample2" type="password" class="form-control repwd" placeholder="" name="repwd">
			  <label for="inputAccountExample2" class="input-control-label-left">确认密码:</label>
			</div>
			<div class="clr"></div>
			<div class="input-control">
				<button class="btn btn-primary confirm_btn" type="submit">确认</button>
				<button class="btn " type="button">取消</button>
				<span class="result">${result}</span>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		$('.confirm_btn').click(function(){
			if($('.newpwd').val() != $('.repwd').val()){
				alert('新密码与确认密码不一致！');
				return false;
			}
		})
	});
</script>
</html>