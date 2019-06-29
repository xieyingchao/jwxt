<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>高校教务管理系统</title>
		<link rel="stylesheet" href="./bootstrap337/css/zui.min.css">
		<script type="text/javascript" src="./bootstrap337/js/jquery-3.4.1.min.js"></script>
		<script type="text/javascript" src="./bootstrap337/js/zui.min.js"></script>
	</head>
	<style>
		.top>img {
			margin: 0 auto;
			//float: left;
			width: 800px;
		}
		.top>div {
			float: right;
		}
		.clr {
			clear: both;
		}
		/* hr {
			margin-top:2px;
			
		} */
		/* #treeMenu active {
			background: green;
		} */
		.menu {
			margin-left: 50px;
			display: inline-block;
		}
		.date {
			margin-left: 9px;
			margin-top: 9px;
		}
		.date p {
			margin-top: 5px
			margin-bottom:3px;
		}
		.date span {
			color: cornflowerblue;
		}
		iframe {
			margin-left: 20px;
		}
		.main_table {
			margin: 0 auto;
		}
	</style>
<body>
	<div>
		<div class="top">
			<img src="./images/index_banner.gif" class="img-responsive">
		</div>
		<div class="clr"></div>
		<hr>
		<div>
			<nav class="menu" data-ride="menu" >
				<table class="main_table">
					<tr>
						<td valign="top" align="left">
							<ul id="treeMenu" class="tree tree-menu" data-ride="tree" style="width: 200px">
								<li class="active index"><a href="#"><i class="icon icon-home"></i>首页</a></li>
								<li class="search_grade"><a href="#"><i class="icon icon-bar-chart"></i>成绩查询</a></li>
								<li class="course"><a href="#"><i class="icon icon-table"></i>课表查询</a></li>
								<li class="select_course"><a href="#"><i class="icon icon-edit"></i>选课</a></li>
								<li class="test_info"><a href="#"><i class="icon icon-th-list"></i>考试查询</a></li>
								<li><a href="#"><i class="icon icon-edit-sign"></i>修改信息</a>
									<ul>
										<li class="update_info"><a href="#">修改信息</a></li>
										<li class="update_password"><a href="#">修改密码</a></li>
									</ul>
								</li>
								<li>
								  <a href="#"><i class="icon icon-tasks"></i>状态</a>
								  <ul>
									<li>
									  <a href="#" class="user_name"><i class="icon icon-user"></i>${user}</a>
									</li>
									<li class="loginout"><a href="loginout"><i class="icon icon-trash"></i>注销</a></li>
									<li><a href="index.jsp"><i class="icon icon-refresh"></i>刷新</a></li>
								  </ul>
								</li>
								<li>
									<div class="date">
										<p>已经开学<span class="day">117</span>天</p>
										<p class="time"></p>
										<p>2019-2018学年第二学期 第<span class="week">17</span>周</p>
									</div>
								</li>
							</ul>
						</td>
						<td valign="top" align="right">
							<iframe class="iframe" src="user_info" frameborder="0" scrolling="no" width="1000px" height="600px" style="background: #fff;"></iframe>
						</td>
					</tr>
				</table>
			</nav>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		// 手动通过点击模拟高亮菜单项
		$('#treeMenu').on('click', 'a', function() {
			$('#treeMenu li.active').removeClass('active');
			$(this).closest('li').addClass('active');
		});
		
		$(".index").on('click',function(){
			if($(this).hasClass('active') == false){
				$(".iframe").attr("src","user_info");
			}
		});
		//点击查询成绩就改变框架页面的src
		$(".search_grade").on('click',function(){
			if($(this).hasClass('active') == false){
				$(".iframe").attr("src","grade1.jsp");
			}
		});
		$(".update_info").on('click',function(){
			if($(this).hasClass('active') == false){
				$(".iframe").attr("src","update_info.jsp");
			}
		});
		$(".update_password").on('click',function(){
			if($(this).hasClass('active') == false){
				$(".iframe").attr("src","update_password.jsp");
			}
		});
		$(".test_info").on('click',function(){
			if($(this).hasClass('active') == false){
				$(".iframe").attr("src","Test.jsp");
			}
		});
		$(".course").on('click',function(){
			if($(this).hasClass('active') == false){
				$(".iframe").attr("src","course1.jsp");
			}
		});
		$(".select_course").on('click',function(){
			if($(this).hasClass('active') == false){
				$(".iframe").attr("src","select_course.jsp");
			}
		});
		
		//注销
		
		//通过点击展开子项,点击其他的关闭子项
		// $('#treeMenu').on('click', 'a', function() {
		// 	$('#treeMenu li .open').removeClass('open in');
		// 	$(this).closest('li').addClass('open in');
		// });
		//时间显示
		function showTime(){
			var datestr = '';
			var time = new Date();
			var year = time.getFullYear();
			var month = time.getMonth();
			var day = time.getDate();
			var week = time.getDay();
			var array = ['日','一','二','三','四','五','六'];
			datestr = datestr + year + '年' + month + '月' + day + '日 星期' + array[week];
			document.getElementsByClassName('time')[0].innerHTML = datestr;
			
			var old = new Date("2019/2/25 08:00:00");
			var diff = time.getTime() - old.getTime();
			var days = Math.floor(diff / (24 * 3600 * 1000));
			$('.day').text(days);
			var week = Math.ceil(days/7);
			$('.week').text(week);
		}
		showTime();
		setInterval(showTime,1000);
	});
</script>
</html>