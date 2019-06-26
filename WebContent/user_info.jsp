<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user_info</title>
		<link rel="stylesheet" href="./bootstrap337/css/zui.min.css">
		<script type="text/javascript" src="./bootstrap337/js/jquery-3.4.1.min.js"></script>
		<script type="text/javascript" src="./bootstrap337/js/zui.min.js"></script>
	</head>
	<style type="text/css">
		.table {
			//margin: 0 auto;
		}
	</style>
<body>
	<div class="container table-responsive">
		<table class="table table-striped table-bordered ">
		  <thead>
			<tr>
			  <th colspan="7" style="text-align: center;">基本信息</th>
			</tr>
		  </thead>
		  <tbody>
			<tr>
			  <td>学号</td>
			  <td>${student.getNum()}</td>
			  <td>姓名</td>
			  <td>${student.getName()}</td>
			  <td>性别</td>
			  <td>${student.getSex()==1?"男":"女"}</td>
			  <td rowspan="3" width="110px"><img alt="" width="100px" height="150px" src="${student.getPic()==null?'./images/pic.jpg':'student.getPic()'}"></td>
			</tr>
			<tr>
			  <td>身份证号</td>
			  <td>${student.getId()}</td>
			  <td>年龄</td>
			  <td>${student.getAge()}</td>
			  <td>民族</td>
			  <td>汉族</td>
			</tr>
			<tr>
			  <td>班级</td>
			  <td>${student.getCname()}</td>
			  <td>政治面貌</td>
			  <td>共青团员</td>
			  <td>宿舍</td>
			  <td>B203</td>
			</tr>
			<tr>
			  <td>邮箱</td>
			  <td>${student.getEmail()}</td>
			  <td>联系地址</td>
			  <td>${student.getAddress()}</td>
			  <td>联系电话</td>
			  <td colspan="2">${student.getTel()}</td>
			</tr>
		  </tbody>
		</table>
	</div>
</body>
</html>