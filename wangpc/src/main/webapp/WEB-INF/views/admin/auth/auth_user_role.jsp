<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>admin|AuthUserRole</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
</head>
<body>
<div id="content" class="content">
	<ol class="breadcrumb pull-right">
        <li><a href="javascript:;">系统配置</a></li>
        <li class="active">人员授权</li>
    </ol>
    <h1 class="page-header">人员授权  <small></small></h1>
    <div class="row">
        <div class="col-md-4 ui-sortable">
            <div data-sortable-id="tree-view-0" class="panel panel-inverse">
                <div class="panel-heading">
                    <div class="panel-heading-btn">
                        <a data-click="panel-expand" class="btn btn-xs btn-icon btn-circle btn-default" href="javascript:;" data-original-title="" title=""><i class="fa fa-expand"></i></a>
                        <a data-click="panel-reload" class="btn btn-xs btn-icon btn-circle btn-success" href="javascript:;" data-original-title="" title=""><i class="fa fa-repeat"></i></a>
                        <a data-click="panel-collapse" class="btn btn-xs btn-icon btn-circle btn-warning" href="javascript:;"><i class="fa fa-minus"></i></a>
                        <a data-click="panel-remove" class="btn btn-xs btn-icon btn-circle btn-danger" href="javascript:;"><i class="fa fa-times"></i></a>
                    </div>
                    <h4 class="panel-title">角色列表</h4>
                </div>
                <div class="alert alert-info">
                    <i class="fa fa-info-circle fa-fw"></i> 角色树说明。
                </div>
                <div class="panel-body">
              		<div class="zTreeDemoBackground left">
						<ul id="treeDemo" class="ztree"></ul>
					</div>
                </div>
            </div>
        </div>
        <div class="col-md-8 ui-sortable">
            <div data-sortable-id="tree-view-1" class="panel panel-inverse">
                <div class="panel-heading">
                    <div class="panel-heading-btn">
                        <a data-click="panel-expand" class="btn btn-xs btn-icon btn-circle btn-default" href="javascript:;"><i class="fa fa-expand"></i></a>
                        <a data-click="panel-reload" class="btn btn-xs btn-icon btn-circle btn-success" href="javascript:;"><i class="fa fa-repeat"></i></a>
                        <a data-click="panel-collapse" class="btn btn-xs btn-icon btn-circle btn-warning" href="javascript:;"><i class="fa fa-minus"></i></a>
                        <a data-click="panel-remove" class="btn btn-xs btn-icon btn-circle btn-danger" href="javascript:;"><i class="fa fa-times"></i></a>
                    </div>
                    <h4 class="panel-title">角色人员</h4>
                </div>
                <div class="alert alert-info">
                    <i class="fa fa-info-circle fa-fw"></i> 属于该角色下的人员。
                </div>
                <div class="panel-body">
                	<form id="form" class="form-inline m-b-15">
                        <input type="text" placeholder="搜索人员名称进行添加" id="name" name="name" class="form-control width-md required">
                        <button class="btn btn-sm btn-primary m-r-5" type="submit">保存</button>
                    </form>
                    <div class="row">
                    	<div class="col-md-4 col-sm-6">
		                    <div class="widget widget-stats bg-purple">
				                <div class="stats-icon"><i class="fa fa-users"></i></div>
				                <div class="stats-info">
				                    <p>王鹏程</p>	
				                </div>
				                <div class="stats-link">
				                    <a href="javascript:;">删除 <i class="fa fa-trash-o"></i></a>
				                </div>
				            </div>
                    	</div>
                    	<div class="col-md-4 col-sm-6">
		                    <div class="widget widget-stats bg-purple">
				                <div class="stats-icon"><i class="fa fa-users"></i></div>
				                <div class="stats-info">
				                    <p>王鹏程</p>	
				                </div>
				                <div class="stats-link">
				                    <a href="javascript:;">删除 <i class="fa fa-trash"></i></a>
				                </div>
				            </div>
                    	</div>
                    	<div class="col-md-4 col-sm-6">
		                    <div class="widget widget-stats bg-purple">
				                <div class="stats-icon"><i class="fa fa-users"></i></div>
				                <div class="stats-info">
				                    <p>王鹏程</p>	
				                </div>
				                <div class="stats-link">
				                    <a href="javascript:;">删除 <i class="fa fa-trash"></i></a>
				                </div>
				            </div>
                    	</div>
                    	<div class="col-md-4 col-sm-6">
		                    <div class="widget widget-stats bg-purple">
				                <div class="stats-icon"><i class="fa fa-users"></i></div>
				                <div class="stats-info">
				                    <p>王鹏程</p>	
				                </div>
				                <div class="stats-link">
				                    <a href="javascript:;">删除 <i class="fa fa-trash"></i></a>
				                </div>
				            </div>
                    	</div>
                    	<div class="col-md-4 col-sm-6">
		                    <div class="widget widget-stats bg-purple">
				                <div class="stats-icon"><i class="fa fa-users"></i></div>
				                <div class="stats-info">
				                    <p>王鹏程</p>	
				                </div>
				                <div class="stats-link">
				                    <a href="javascript:;">删除 <i class="fa fa-trash"></i></a>
				                </div>
				            </div>
                    	</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
(function(){
	App.restartGlobalFunction();
    App.setPageTitle('admin|AuthUserRole');
    
})();
</script>
</body>
</html>