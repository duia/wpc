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
<title>Hello</title>
<link href="static/plugins/bootstrap-3.3.5-dist/css/bootstrap.css" rel="stylesheet" />
<link href="/static/plugins/font-awesome-4.5.0/css/font-awesome.css" rel="stylesheet"/>
<style>

* {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
}
body {
    background: #2d2c41 none repeat scroll 0 0;
    font-family: "Open Sans",Arial,Helvetica,sans-serif,Verdana,Tahoma;
}
ul {
    list-style-type: none;
}
a {
    color: #b63b4d;
    text-decoration: none;
}
h1 {
    color: #fff;
    font-size: 24px;
    font-weight: 400;
    margin-top: 80px;
    text-align: center;
}
h1 a {
    color: #c12c42;
    font-size: 16px;
}
.accordion {
    background: #fff none repeat scroll 0 0;
    border-radius: 4px;
    margin: 30px auto 20px;
    max-width: 360px;
    width: 100%;
}
.accordion .link {
    border-bottom: 1px solid #ccc;
    color: #4d4d4d;
    cursor: pointer;
    display: block;
    font-size: 14px;
    font-weight: 700;
    padding: 15px 15px 15px 42px;
    position: relative;
    transition: all 0.4s ease 0s;
}
.accordion li:last-child .link {
    border-bottom: 0 none;
}
.accordion li i {
    color: #595959;
    font-size: 18px;
    left: 12px;
    position: absolute;
    top: 16px;
    transition: all 0.4s ease 0s;
}
.accordion li i.fa-chevron-down {
    font-size: 16px;
    left: auto;
    right: 12px;
}
.accordion li.open .link {
    color: #b63b4d;
}
.accordion li.open i {
    color: #b63b4d;
}
.accordion li.open i.fa-chevron-down {
    transform: rotate(180deg);
}
.submenu {
    background: #444359 none repeat scroll 0 0;
    display: none;
    font-size: 14px;
}
.submenu li {
    border-bottom: 1px solid #4b4a5e;
}
.submenu a {
    color: #d9d9d9;
    display: block;
    padding: 12px 12px 12px 42px;
    text-decoration: none;
    transition: all 0.25s ease 0s;
}
.submenu a:hover {
    background: #b63b4d none repeat scroll 0 0;
    color: #fff;
}

</style>
<base href="${basePath}">
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Brand</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class="row">
	<div class="col-md-2">
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
	<div class="col-md-10">
		<div id="ajax-content"></div>
	</div>
</div>

<script type="text/javascript" src="${basePath}/static/js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="${basePath}/static/plugins/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
<script type="text/javascript">
$(function() {
	var Accordion = function(el, multiple) {
		this.el = el || {};
		this.multiple = multiple || false;

		// Variables privadas
		var links = this.el.find('.link');
		// Evento
		links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)
	}

	Accordion.prototype.dropdown = function(e) {
		var $el = e.data.el;
			$this = $(this),
			$next = $this.next();

		$next.slideToggle();
		$this.parent().toggleClass('open');

		if (!e.data.multiple) {
			$el.find('.submenu').not($next).slideUp().parent().removeClass('open');
		};
	}	

	var accordion = new Accordion($('#accordion'), false);
	$.ajax({
        type: 'GET',
        url: 'buttons',
        dataType: 'html',	
        success: function(data) {
            $('#ajax-content').html(data);
            $('html, body').animate({
                scrollTop: $("body").offset().top
            }, 250);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            $('#ajax-content').html(default_content);
        }
    });
});
</script>
</body>
</html>	