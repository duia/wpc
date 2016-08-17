<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%    
String path = request.getContextPath();    
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->

<head>
<meta charset="utf-8" />
<title>首页</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />

<!-- ================== BEGIN BASE CSS STYLE ================== -->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet" />
<link href="static/plugins/jquery-ui-1.11.4.custom/jquery-ui.min.css" rel="stylesheet" />
<link href="static/plugins/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet" />
<link href="static/plugins/font-awesome-4.5.0/css/font-awesome.min.css" rel="stylesheet" />
<link href="static/plugins/color_admin/css/animate.min.css" rel="stylesheet" />
<link href="static/plugins/color_admin/css/style.min.css" rel="stylesheet" />
<link href="static/plugins/color_admin/css/style-responsive.min.css" rel="stylesheet" />
<link href="static/plugins/color_admin/css/theme/default.css" rel="stylesheet" id="theme" />
<!-- ================== END BASE CSS STYLE ================== -->

<!-- ================== BEGIN PAGE LEVEL STYLE ================== -->

<!-- ================== END PAGE LEVEL STYLE ================== -->
</head>
<body>
	<!-- begin #page-loader -->
	<div id="page-loader" class="fade in">
		<span class="spinner"></span>
	</div>
	<!-- end #page-loader -->
	<!-- begin #page-container -->
	<div id="page-container"
		class="fade page-sidebar-fixed page-header-fixed">
		<!-- 头部 -->
		<div id="header" class="header navbar navbar-default navbar-fixed-top">
			<!-- begin container-fluid -->
			<div class="container-fluid">
				<!-- begin mobile sidebar expand / collapse button -->
				<div class="navbar-header">
					<a href="javascript:;" class="navbar-brand">
						<span class="navbar-logo"></span> wpc
					</a>
				</div>
				<!-- end mobile sidebar expand / collapse button -->

				<!-- begin header navigation right -->
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown navbar-user">
						<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown">
							<img src="static/plugins/color_admin/img/user-11.jpg" alt="" />
							<span class="hidden-xs">Adam Schwartz</span> <b class="caret"></b>
						</a>
						<ul class="dropdown-menu animated fadeInLeft">
							<li class="arrow"></li>
							<li><a href="javascript:;">Edit Profile</a></li>
							<li><a href="javascript:;"><span class="badge badge-danger pull-right">2</span> Inbox</a></li>
							<li><a href="javascript:;">Calendar</a></li>
							<li><a href="javascript:;">Setting</a></li>
							<li class="divider"></li>
							<li><a href="javascript:;">Log Out</a></li>
						</ul>
					</li>
				</ul>
				<!-- end header navigation right -->
			</div>
			<!-- end container-fluid -->
		</div>
		<!-- 头部 -->

		<!-- 菜单 -->
		<div id="sidebar" class="sidebar">
			<!-- begin sidebar scrollbar -->
			<div data-scrollbar="true" data-height="100%">
				<!-- begin sidebar user -->
				<ul class="nav">
					<li class="nav-profile">
						<div class="image">
							<a href="javascript:;">
								<img src="static/plugins/color_admin/img/user-11.jpg" alt="" />
							</a>
						</div>
						<div class="info">
							W鹏程 <small>个人网站</small>
						</div>
					</li>
				</ul>
				<!-- end sidebar user -->
				<!-- begin sidebar nav -->
				<ul class="nav">
					<li class="nav-header">菜单</li>
					<li>
						<a href="#"><i class="fa fa-laptop"></i> <span>Dashboard</span></a>
					</li>
					<li>
						<a href="#"> 
							<i class="fa fa-inbox"></i> <span>Inbox</span>
						</a>
					</li>
					<li class="has-sub">
						<a href="javascript:;">
							<i class="fa fa-suitcase"></i> 
							<b class="caret pull-right"></b> 
							<span>UI Elements</span>
						</a>
						<ul class="sub-menu">
							<li><a href="ui_general.html">General</a></li>
							<li><a href="ui_typography.html">Typography</a></li>
							<li><a href="ui_tabs_accordions.html">Tabs & Accordions</a></li>
							<li><a href="ui_modal_notification.html">Modal & Notification</a></li>
							<li><a href="ui_widget_boxes.html">Widget Boxes</a></li>
							<li><a href="ui_media_object.html">Media Object</a></li>
							<li><a href="ui_buttons.html">Buttons</a></li>
							<li><a href="ui_icons.html">Icons</a></li>
						</ul>
					</li>
					<!-- begin sidebar minify button -->
					<li>
						<a href="javascript:;" class="sidebar-minify-btn" data-click="sidebar-minify"><i class="fa fa-angle-double-left"></i></a>
					</li>
					<!-- end sidebar minify button -->
				</ul>
				<!-- end sidebar nav -->
			</div>
			<!-- end sidebar scrollbar -->
		</div>
		<div class="sidebar-bg"></div>
		<!-- 菜单 -->

		<!-- 内容 -->
		<div id="content" class="content">
			<!-- 面包屑 -->
			<ol class="breadcrumb pull-right">
				<li><a href="javascript:;">Home</a></li>
				<li><a href="javascript:;">Page Options</a></li>
				<li class="active">Blank Page</li>
			</ol>
			<!-- 面包屑  -->
			
			<!-- begin page-header -->
			<h1 class="page-header">
				Blank Page <small>header small text goes here...</small>
			</h1>
			<div class="panel panel-inverse">
				<div class="panel-heading">
					<div class="panel-heading-btn">
						<a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-default" data-click="panel-expand"><i class="fa fa-expand"></i></a> 
						<a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-success" data-click="panel-reload"><i class="fa fa-repeat"></i></a> 
						<a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-warning" data-click="panel-collapse"><i class="fa fa-minus"></i></a>
						<a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-danger" data-click="panel-remove"><i class="fa fa-times"></i></a>
					</div>
					<h4 class="panel-title">Panel Title here</h4>
				</div>
				<div class="panel-body">
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
				</div>
			</div>
			<!-- end panel -->
			<div class="panel panel-inverse">
				<div class="panel-heading">
					<div class="panel-heading-btn">
						<a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-default" data-click="panel-expand"><i class="fa fa-expand"></i></a> 
						<a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-success" data-click="panel-reload"><i class="fa fa-repeat"></i></a> 
						<a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-warning" data-click="panel-collapse"><i class="fa fa-minus"></i></a>
						<a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-danger" data-click="panel-remove"><i class="fa fa-times"></i></a>
					</div>
					<h4 class="panel-title">Panel Title here</h4>
				</div>
				<div class="panel-body">
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
					<p>Panel Content Here</p>
				</div>
			</div>

		</div>
		<!-- 内容 -->
		
		<!-- 页尾 -->
		<div id="footer" class="footer">
			wpcfree@qq.com
		</div>
		<!-- 页尾 -->
	
		<!-- 回到顶部 -->
		<a href="javascript:;" class="btn btn-icon btn-circle btn-success btn-scroll-to-top fade" data-click="scroll-top"> 
			<i class="fa fa-angle-up"></i>
		</a>
		<!-- 回到顶部 -->
		
		<!-- 主题设置 -->
		<div class="theme-panel">
			<a href="javascript:;" data-click="theme-panel-expand" class="theme-collapse-btn"> <i class="fa fa-cog"></i>
			</a>
			<div class="theme-panel-content">
				<h5 class="m-t-0">Color Theme</h5>
				<ul class="theme-list clearfix">
					<li class="active"><a href="javascript:;" class="bg-green" data-theme="default" data-click="theme-selector" data-toggle="tooltip" data-trigger="hover" data-container="body" data-title="Default"> </a></li>
					<li><a href="javascript:;" class="bg-red" data-theme="red" data-click="theme-selector" data-toggle="tooltip" data-trigger="hover" data-container="body" data-title="Red"> </a></li>
					<li><a href="javascript:;" class="bg-blue" data-theme="blue" data-click="theme-selector" data-toggle="tooltip" data-trigger="hover" data-container="body" data-title="Blue"></a> </li>
					<li><a href="javascript:;" class="bg-purple" data-theme="purple" data-click="theme-selector" data-toggle="tooltip" data-trigger="hover" data-container="body" data-title="Purple"> </a></li>
					<li><a href="javascript:;" class="bg-orange" data-theme="orange" data-click="theme-selector" data-toggle="tooltip" data-trigger="hover" data-container="body" data-title="Orange"> </a></li>
					<li><a href="javascript:;" class="bg-black" data-theme="black" data-click="theme-selector" data-toggle="tooltip" data-trigger="hover" data-container="body" data-title="Black"> </a></li>
				</ul>
				<div class="divider"></div>
				<div class="row m-t-10">
					<div class="col-md-5 control-label double-line">Header Styling</div>
					<div class="col-md-7">
						<select name="header-styling" class="form-control input-sm">
							<option value="1">default</option>
							<option value="2">inverse</option>
						</select>
					</div>
				</div>
				<div class="row m-t-10">
					<div class="col-md-5 control-label">Header</div>
					<div class="col-md-7">
						<select name="header-fixed" class="form-control input-sm">
							<option value="1">fixed</option>
							<option value="2">default</option>
						</select>
					</div>
				</div>
				<div class="row m-t-10">
					<div class="col-md-5 control-label double-line">Sidebar Styling</div>
					<div class="col-md-7">
						<select name="sidebar-styling" class="form-control input-sm">
							<option value="1">default</option>
							<option value="2">grid</option>
						</select>
					</div>
				</div>
				<div class="row m-t-10">
					<div class="col-md-5 control-label">Sidebar</div>
					<div class="col-md-7">
						<select name="sidebar-fixed" class="form-control input-sm">
							<option value="1">fixed</option>
							<option value="2">default</option>
						</select>
					</div>
				</div>
			</div>
		</div>
		<!-- 主题设置 -->
		
	</div>

<!-- ================== BEGIN BASE JS ================== -->
<script src="static/js/jquery-2.1.3.min.js"></script>
<script src="static/js/jquery-migrate-1.1.0.min.js"></script>
<script src="static/plugins/jquery-ui-1.11.4.custom/jquery-ui.min.js"></script>
<script src="static/plugins/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<!--[if lt IE 9]>
<script src="static/plugins/color_admin/crossbrowserjs/html5shiv.js"></script>
<script src="static/plugins/color_admin/crossbrowserjs/respond.min.js"></script>
<script src="static/plugins/color_admin/crossbrowserjs/excanvas.min.js"></script>
<![endif]-->
<script src="static/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="static/plugins/jquery-cookie/jquery.cookie.js"></script>
<!-- ================== END BASE JS ================== -->

<!-- ================== BEGIN PAGE LEVEL JS ================== -->
<script src="static/plugins/color_admin/js/apps.min.js"></script>
<!-- ================== END PAGE LEVEL JS ================== -->
<script>
	$(document).ready(function() {
	  App.init();
	});
</script>
</body>
</html>