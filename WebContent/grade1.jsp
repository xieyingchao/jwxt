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
					<h3 class="text-center" >考试成绩</h3>
				</header>
		</div>
	    <hr>
			<div class="form_pre">
				<form action="studentgrade" method="get">
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
	</div>
</body>
<script>
</script>
</html>