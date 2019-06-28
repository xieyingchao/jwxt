<%@page import="java.util.List"%>
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
			.result {
				font-size: 16px;
				color:red;
				margin-left: 20px;
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
							<option value="1">选修</option>
							<option value="0">主修</option>
						</select>
					</div>
					
					<div class="right">
						<button class="btn search ${refresh}" type="submit">检索</button>
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
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="grade">
					<c:set var="i" value="${j = j + 1 }"></c:set>
					<tr>
						<td class="tcid">${grade.getNum()}</td>
						<td>${grade.getName()}</td>
						<td>${grade.getXuefen()}</td>
						<td>${grade.getSept()}</td>
						<td>${grade.getTeacher()}</td>
						<td>${grade.getTime()}</td>
						<td>${grade.getClassroom()}</td>
						<td>60 / ${grade.getPpnum()}</td>
						<td class="choose">
							<c:forEach items="${list1}" var = "i">
								<c:set var="num" value="${grade.getNum()}"></c:set>
								<c:set var="i1" value="${i}"></c:set>
								<c:if test="${num == i1}">已选</c:if>
							</c:forEach>
						</td>
						<td>
							<a class="btn btn-primary commit">选择</a>
							<a class="btn cancel">退选</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
<script>
	$(function(){
		
		var i = 0;
		$('tbody tr').each(function(){
			i++;
			var tcid;
			$(this).find('.commit').click(function(){
				
				tcid = $(this).parents('tr').find('.tcid').text();
				param = "tcid="+tcid+"&&kind=1";
				$.ajax({
					url:"selectclass",
					type:"post",
					data:param,
					dataType:"json",
					async:true,
					success:function(data){
						if(data == '1'){
							new $.zui.Messager('选择成功！', {
							    type: 'success' // 定义颜色主题
							}).show();
							
							$(this).parents('tr').find('.choose').text('已选');
						}else if(data == '-1'){
							new $.zui.Messager('与已选课程时间冲突！', {
							    type: 'danger' // 定义颜色主题
							}).show();
						}else{
							new $.zui.Messager('选择失败', {
							    type: 'danger' // 定义颜色主题
							}).show();
						}
						setTimeout(function(){
							new $.zui.Messager('2秒后刷新！', {
							    type: 'info' // 定义颜色主题
							}).show();
						},500);
						setTimeout("$('.search').click();",2000);
					}
				});
			});
			$(this).find('.cancel').click(function(){
				tcid = $(this).parents('tr').find('.tcid').text();
				param = "tcid="+tcid+"&&kind=0";
				$.ajax({
					url:"selectclass",
					type:"post",
					data:param,
					dataType:"json",
					async:true,
					success:function(data){
						if(data == '1'){
							new $.zui.Messager('退选成功！', {
							    type: 'success' // 定义颜色主题
							}).show();
							$(this).parents('tr').find('.choose').text('');
						}else{
							new $.zui.Messager('退选失败', {
							    type: 'danger' // 定义颜色主题
							}).show();
						}
						setTimeout(function(){
							new $.zui.Messager('2秒后刷新！', {
							    type: 'info' // 定义颜色主题
							}).show();
						},500);
						
						setTimeout("$('.search').click();",2000);
					}
				});
			});
		});
	});
</script>
</html>