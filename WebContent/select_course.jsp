<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>学生选课</title>
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
					<h3 class="text-center" >课程选择</h3>
				</header>
		</div>
	    <hr>
			<div class="form_pre">
				<form action="selectcourse" method="get">
					<div class="col-sm-3">
						<select class="form-control" id="exampleInputAddress7" name="xuanxiu">
							<option value="0">主修</option>
							<option value="1">选修</option>
						</select>
						<span style="color:red;">${result}</span>
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
					<th>课程编号</th>
					<th>课程名称</th>
					<th>课程学分</th>
					<th>所在院系</th>
					<th>任课教师</th>
					<th>上课时间</th>
					<th>上课地点</th>
					<th>限选/已选</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="grade">
					<c:set var="i" value="${j = j + 1 }"></c:set>
					<tr>
						<td>${grade.getNum()}</td>
						<td>${grade.getName()}</td>
						<td>${grade.getXuefen()}</td>
						<td>${grade.getSept()}</td>
						<td>${grade.getTeacher()}</td>
						<td>${grade.getTime()}</td>
						<td>${grade.getClassroom()}</td>
						<td>60 / ${grade.getPpnum()}</td>
						<td>
							<a class="btn btn-primary" href="selectclass?tcid=${grade.getNum()}">选择</a>
							<button class="btn" type="button">退选</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
<script>

</script>
</html>