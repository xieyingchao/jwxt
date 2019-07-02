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
				<h3 class="text-center" >修改信息</h3>
			</header>
		</div>
		<hr>
		<form action="updateinfo"method="post">
			<div class="input-control has-label-left">
			  <input disabled="disabled" id="inputAccountExample2" type="text" class="form-control xuehao" placeholder="">
			  <label for="inputAccountExample2" class="input-control-label-left">学号:</label>
			</div>
			<div class="input-control has-label-left">
			  <input disabled="disabled" id="inputAccountExample2" type="text" class="form-control xingming" placeholder="">
			  <label for="inputAccountExample2" class="input-control-label-left">姓名:</label>
			</div>
			<div class="input-control has-label-left">
			  <input id="inputAccountExample2" type="email" class="form-control" placeholder="" name="email">
			  <label for="inputAccountExample2" class="input-control-label-left">邮箱:</label>
			</div>
			<div class="input-control has-label-left">
			  <input id="inputAccountExample2" type="number" class="form-control telnum" placeholder="" name="tel">
			  <label for="inputAccountExample2" class="input-control-label-left">电话:</label>
			</div>
			<div class="select_pre">
				<div class="select">
					<select data-placeholder="省份" class="chosen-select form-control" tabindex="2" name="provice">
					  <option value=""></option>
					  <option value="北京市" data-keys="beijing bj ">北京市</option>
					  <option value="上海市" data-keys="shanghai sh">上海市</option>
					  <option value="广东省" data-keys="guangdong gd">广东省</option>
					  <option value="湖南省" data-keys="hunan hn">湖南省</option>
					  <option value="湖北省" data-keys="hubei hb">湖北省</option>
					  <option value="重庆市" data-keys="chongqing cq">重庆市</option>
					  <option value="江西省" data-keys="jiangxi jx">江西省</option>
					  <option value="广西省" data-keys="guangxi gx">广西省</option>
					</select>
				</div>
				<div class="input-control has-label-left addr">
				  <input id="inputAccountExample2" type="text" class="form-control" placeholder="" name="address">
				  <label for="inputAccountExample2" class="input-control-label-left">地址:</label>
				</div>
			</div>
			<div class="clr"></div>
			<div class="input-control">
				<button class="btn btn-primary " type="submit">确认</button>
				<button class="btn " type="button">取消</button>
				<span class="result">${result}</span>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		$('select.chosen-select').chosen({
			no_results_text: '没有找到',    // 当检索时没有找到匹配项时显示的提示文本
			disable_search_threshold: 1, // 10 个以下的选择项则不显示检索框
			search_contains: true         // 从任意位置开始检索
		});
		var user = '<%= session.getAttribute("user")%>';
		var name = '<%= session.getAttribute("name")%>';
		$('.xuehao').val(user);
		$('.xingming').val(name);
		$('.btn-primary').click(function(){
			if($('.telnum').val().length != 11){
				alert('请输入合法的11位联系电话！');
				return false;
			}
		});
		
	});
</script>
</html>