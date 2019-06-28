<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>学生成绩</title>
		<link rel="stylesheet" href="./bootstrap337/css/zui.min.css">
		<link rel="stylesheet" href="./bootstrap337/css/datetimepicker.min.css">
		<script type="text/javascript" src="./bootstrap337/js/jquery-3.4.1.min.js"></script>
		<script type="text/javascript" src="./bootstrap337/js/zui.min.js"></script>
		<script type="text/javascript" src="./bootstrap337/js/datetimepicker.min.js"></script>
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
					<h3 class="text-center" >考试安排表</h3>
				</header>
		</div>
	    <hr>
			<div class="form_pre">
				<form action="teachertest" method="get">
					<div class="col-sm-3">
						<select class="form-control" id="exampleInputAddress7" name="testkind">
							<option value="期末考试">期末考试</option>
							<option value="期中考试">期中考试</option>
						</select>
					</div>
					<span class="result" style="color:red;">${result}</span>
					<div class="right">
						<button class="btn search" type="submit">检索</button>
						<button class="btn" type="button">下载</button>
					</div>
			</form>
		</div>
		<div class="clr"></div>
		<table class="table table-striped table-bordered ">
			<thead>
				<tr>
					<th>序号</th>
					<th>课程名称</th>
					<th>考试人数</th>
					<th>考试地点</th>
					<th>考试时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="grade" >
					<c:set var="i" value="${i = i + 1 }"></c:set>
					<tr>
						<td>${i}</td>
						<td>[${grade.getCoid()}]${grade.getName()}</td>
						<td>${grade.getPpnum()}</td>
						<td class="hide coid">${grade.getCoid()}</td>
						<td class="hide kind">${grade.getKind()}</td>
						<td>
							<div class="input-control">
							  <input id="inputAccountExample" type="text" class="form-control classroom " placeholder="已选地点： ${grade.getAddress()}">
							</div>
						</td>
						<td>
							<input type="text" class="form-control form-datetime time " placeholder="已选时间： ${grade.getTime() }">
						</td>
						<td>
							<a class="btn btn-primary commit " >提交</a>
							
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
<script>
$(function(){
	//选择时间和日期
	$(".form-datetime").datetimepicker(
	{
	    weekStart: 1,
	    todayBtn:  1,
	    autoclose: 1,
	    todayHighlight: 1,
	    startView: 2,
	    forceParse: 0,
	    showMeridian: 1,
	    format: "yyyy-mm-dd hh:ii"
	});
	
	$(function(){
		$('.search').click(function(){
			$('.hide').show();
		});
		
		$('tbody tr').each(function(){
			var classroom,time,kind,coid;
			$(this).find('.commit').click(function(){
				classroom = $(this).parents('tr').find('.classroom').val();
				time = $(this).parents('tr').find('.time').val();
				kind = $(this).parents('tr').find('.kind').text();
				coid = $(this).parents('tr').find('.coid').text();
				param = "coid="+coid+"&&kind="+kind+"&&classroom="+classroom+"&&time="+time;
				$.ajax({
					url:"testmanage",
					type:"post",
					data:param,
					dataType:"json",
					async:true,
					success:function(data){
						if(data == '1'){
							new $.zui.Messager('修改成功！', {
							    type: 'success' // 定义颜色主题
							}).show();
						}else if(data == '-1'){
							new $.zui.Messager('与其他考试时间地点冲突！', {
							    type: 'danger' // 定义颜色主题
							}).show();
						}else{
							new $.zui.Messager('修改失败', {
							    type: 'danger' // 定义颜色主题
							}).show();
						}
					}
				});
			});
			
		});
	});
});
</script>
</html>