<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>课程安排表</title>
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
					<h3 class="text-center" >课程安排</h3>
				</header>
		</div>
	    <hr>
			<div class="form_pre">
				<form action="studentclass" method="get">
					<div class="col-sm-3">
							<select data-placeholder="选择学年" class="chosen-select form-control" id="exampleInputAddress7" name="xuenian" tabindex="2">
								<option value="2020~2019学年">2020~2019学年</option>
								<option value="2019~2018学年">2019~2018学年</option>
								<option value="2018~2017学年">2018~2017学年</option>
								<option value="2017~2016学年">2017~2016学年</option>
							</select>
						</div>
						
						<div class="col-sm-3">
							<select class="form-control" id="exampleInputAddress7" name="xueqi">
								<option value="第一学期">第一学期</option>
								<option value="第二学期">第二学期</option>
							</select>
						</div>
					
					<div class="right">
						<button class="btn search" type="submit">检索</button>
						<a class="btn" href="download?filename=course.xls">下载</a>
					</div>
			</form>
		</div>
		<div class="clr"></div>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>序号</th>
					<th>课程名称</th>
					<th>课程学分</th>
					<th>任课教师</th>
					<th>上课时间</th>
					<th>上课地点</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="grade">
					<c:set var="i" value="${j = j + 1 }"></c:set>
					<tr>
						<td>${j}</td>
						<td>[${grade.getNum()}]${grade.getName()}</td>
						<td>${grade.getXuefen()}</td>
						<td>${grade.getTeacher() }</td>
						<td>${grade.getTime()}</td>
						<td>${grade.getClassroom()}</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="2">合计</th>
					<c:forEach items="${list}" var = "grade">
						<c:set var="xuefen_sum" value="${xuefen_sum+grade.getXuefen()}"></c:set>
					</c:forEach>
					<th colspan="4">课程总数：${j}  总学分：${xuefen_sum}</th>
				</tr>
			</tfoot>
		</table>
	</div>
</body>
<script>

</script>
</html>