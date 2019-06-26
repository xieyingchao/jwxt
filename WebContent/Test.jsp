<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>学生成绩</title>
		<link rel="stylesheet" href="./bootstrap337/css/zui.min.css">
		<script type="text/javascript" src="./bootstrap337/js/jquery-3.4.1.min.js"></script>
		<script type="text/javascript" src="./bootstrap337/js/zui.min.js"></script>
		<style type="text/css">
			.text-center {
				margin-top: 0;
				margin-bottom: 0;
			}
			.article {
				padding-bottom: 0;
			}
			table {
				margin-top: 30px;
			}
			.right {
				float: right;
			}
			hr {
				margin-top: 0;
			}
			.clr {
				clear: both;
			}
			.form_pre {
				height: 100%;
			}
		</style>
	</head>
<body>
	<div class="container">
	    <div class="article">
				<header>
					<h3 class="text-center" >考试安排表</h3>
				</header>
		</div>
	    <hr>
			<div class="form_pre">
				<form action="testinfo" method="get">
					<div class="col-sm-3">
						<select class="form-control" id="exampleInputAddress7" name="testkind">
							<option value="期末考试">期末考试</option>
							<option value="期中考试">期中考试</option>
						</select>
					</div>
					<div class="right">
						<button class="btn search" type="submit">检索</button>
						<button class="btn" type="button">下载</button>
					</div>
			</form>
		</div>
		<div class="clr"></div>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>序号</th>
					<th>课程名称</th>
					<th>考试地点</th>
					<th>考试时间</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="grade" >
					<c:set var="i" value="${i = i + 1 }"></c:set>
					<tr>
						<td>${i}</td>
						<td>${grade.getName()}</td>
						<td>${grade.getAddress()}</td>
						<td>${grade.getTime() }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
<script>
</script>
</html>