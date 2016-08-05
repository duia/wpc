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
</head>
<body>
<div class="content" id="content1" contenteditable="true" style="width:60%; border: 1px solid #ccc;"></div>
<div class="content" id="content2">内容2</div>
<div class="content" id="content3">内容3</div>
<div class="content" id="content4">内容4</div>
<div class="content" id="content5">内容5</div>
<script src="/static/plugins/ckeditor/ckeditor.js"></script>
<script src="/static/plugins/ckeditor/lang/zh-cn.js"></script>
<script src="/static/plugins/ckeditor/config.js"></script>
<script src="/static/js/jquery-2.1.3.min.js"></script>
<script type="text/javascript">

</script>
</body>
</html>	