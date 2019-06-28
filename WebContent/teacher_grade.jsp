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
			.grade {
				width:110px;
			}
		</style>
	</head>
<body>
	<div class="container">
	    <div class="article">
				<header>
					<h3 class="text-center" >考试成绩</h3>
				</header>
		</div>
	    <hr>
			<div class="form_pre">
				<form action="teachergrade" method="get">
					<div class="col-sm-3">
						<select class="form-control" id="exampleInputAddress7" name="coid">
							<c:forEach items="${list}" var="grade">
								<option value="${grade.getNum()}">${grade.getName() }</option>
							</c:forEach>
						</select>
					</div>
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
					<th>学生姓名</th>
					<th>学生学号</th>
					<th>学生班级</th>
					<th>学生分数</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list1}" var="grade1">
					<c:set var="i" value="${j = j + 1 }"></c:set>
					<tr>
						<td>${j}</td>
						<td class="hide">${grade1.getScid()}</td>
						<td>${grade1.getName()}</td>
						<td>${grade1.getNum()}</td>
						<td>${grade1.getCname()}</td>
						<td>
							<div class="input-control">
							  <input id="inputAccountExample" type="number" class="form-control grade" placeholder="已给分： ${grade1.getGrade() }">
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="2">总分 / 平均分</th>
					<c:forEach items="${list1}" var = "grade1">
						
						<c:set var="grade_sum" value="${grade_sum+grade1.getGrade()}"></c:set>
					</c:forEach>
					<th colspan="2">${grade_sum} / ${grade_sum/j}</th>
					<th>
						<button class="btn btn-primary commit" type="button">提交修改</button>
					</th>
				</tr>
			</tfoot>
		</table>
	</div>
</body>
<script>
	$(function(){
		$('.search').click(function(){
			$('.hide').show();
		});
		
		$('.commit').click(function(){
			var all = '';
			$('tbody tr').each(function(){
				var scid = $(this).children('.hide').text();
				var grade = $(this).find('input').val();
				if('' != grade){
					var i = scid + ':'+ grade + '/';
					all = all + i;
				}
			});
			var param = 'all='+all;
			$.ajax({
				url:"updategrade",
				type:"post",
				data:param,
				dataType:"json",
				async:true,
				success:function(data){
					if(data == '0'){
						new $.zui.Messager('修改成功', {
						    type: 'success' // 定义颜色主题
						}).show();
					}else {
						new $.zui.Messager('第'+data+'个修改失败', {
						    type: 'danger' // 定义颜色主题
						}).show();
					}
				}
			});
		});
	});
</script>
</html>