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
				<form action="teacherclass" method="get">
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
					<th>课程学分</th>
					<th>上课时间</th>
					<th>上课地点</th>
					<th>上课人数</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="grade">
					<c:set var="j" value="${j = j + 1 }"></c:set>
					<tr>
						<td>${j}</td>
						<td>[${grade.getNum()}]${grade.getName()}</td>
						<td>${grade.getXuefen()}</td>
						<td>${grade.getTime()}</td>
						<td>${grade.getClassroom()}</td>
						<td>${grade.getPpnum() }</td>
						<td>
							<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal${j}">查看学生名单</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- 对话框HTML -->
	<c:forEach items="${list}" var="grade">
		<c:set var="i" value="${i = i + 1 }"></c:set>
		<div class="modal fade" id="myModal${i}">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      	<table class="table table-striped table-bordered">
		      		<thead>
		      			<tr>
		      				<th>序号</th>
		      				<th>姓名</th>
		      				<th>学号</th>
		      				<th>性别</th>
		      				<th>班级</th>
		      			</tr>
		      		</thead>
		      		<tbody>
		      			<c:forEach items="${LIST}" var="each">
		      				<c:set var="k" value="${k = k + 1 }"></c:set>
		      				<tr>
			      				<td>${k}</td>
			      				<td>${each.getName()}</td>
			      				<td>${each.getNum()}</td>
			      				<td>${each.getSex()==1?"男":"女"}</td>
			      				<td>${each.getCname()}</td>
			      			</tr>
		      			</c:forEach>
		      			<c:set var="k" value="${k =0 }"></c:set>
		      		</tbody>
		      	</table>
		    </div>
		  </div>
		</div>
	</c:forEach>
</body>
<script>
$(function(){
	$('.search').click(function(){
		$('.hide').show();
	});
});
</script>
</html>