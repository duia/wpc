<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%    
String path = request.getContextPath();    
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<base href="${basePath}">
<!-- <link href="static/plugins/bootstrap-3.3.5-dist/css/bootstrap.css" rel="stylesheet" /> -->
<link href="/static/plugins/bootflat/css/site.min.css" rel="stylesheet" />
<link href="/static/plugins/font-awesome-4.5.0/css/font-awesome.css" rel="stylesheet"/>
<link href="/static/css/index.css" rel="stylesheet"/>
</head>
<body>

<nav role="navigation" class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button data-target="#bs-example-navbar-collapse-4" data-toggle="collapse" class="navbar-toggle" type="button">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a href="#" class="navbar-brand">wpcfree</a>
    </div>
    <div id="bs-example-navbar-collapse-4" class="collapse navbar-collapse navbar-right">
      <a class="btn btn-warning navbar-btn" href="static/plugins/bootflat/documentation.html" target="_blank">查看</a>
    </div>
  </div>
</nav>

<div class="row" style="margin-top: 0px;">
	<div class="col-md-2">
		<div class="panel panel-default">
          <div class="panel-heading">
            <h3 class="panel-title" style="padding: 10px 15px 10px 0px; font-size: 16px; font-weight: 700;">Panel title</h3>
          </div>
          <ul class="accordion" id="accordion">
			<li>
				<div class="link"><i class="fa fa-paint-brush"></i>Diseño web<i class="fa fa-chevron-down"></i></div>
				<ul class="submenu">
					<li><a href="#">Photoshop</a></li>
					<li><a href="#">HTML</a></li>
					<li><a href="#">CSS</a></li>
					<li><a href="#">Maquetacion web</a></li>
				</ul>
			</li>
			<li>
				<div class="link"><i class="fa fa-code"></i>Desarrollo front-end<i class="fa fa-chevron-down"></i></div>
				<ul class="submenu">
					<li><a href="#">Javascript</a></li>
					<li><a href="#">jQuery</a></li>
					<li><a href="#">Frameworks javascript</a></li>
				</ul>
			</li>
			<li>
				<div class="link"><i class="fa fa-mobile"></i>Diseño responsive<i class="fa fa-chevron-down"></i></div>
				<ul class="submenu">
					<li><a href="#">Tablets</a></li>
					<li><a href="#">Dispositivos mobiles</a></li>
					<li><a href="#">Medios de escritorio</a></li>
					<li><a href="#">Otros dispositivos</a></li>
				</ul>
			</li>
			<li><div class="link"><i class="fa fa-globe"></i>Posicionamiento web<i class="fa fa-chevron-down"></i></div>
				<ul class="submenu">
					<li><a href="#">Google</a></li>
					<li><a href="#">Bing</a></li>
					<li><a href="#">Yahoo</a></li>
					<li><a href="#">Otros buscadores</a></li>
				</ul>
			</li>
		  </ul>
        </div>
	</div>
	<div class="col-md-10">
		<div id="ajax-content"></div>
	</div>
</div>

<script type="text/javascript" src="/static/js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="/static/plugins/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
<script type="text/javascript" src="/static/js/index.js"></script>
<script type="text/javascript">
</script>
</body>
</html>	