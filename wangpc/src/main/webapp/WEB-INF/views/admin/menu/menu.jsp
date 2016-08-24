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
<title>测试</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<link href="static/plugins/zTree_v3-master/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" />
<link href="static/plugins/jquery-validation-1.14.0/css/validation.css" rel="stylesheet" />
</head>
<body>
<div id="content" class="content">
    <ol class="breadcrumb pull-right">
        <li><a href="javascript:;">系统配置</a></li>
        <li class="active">菜单管理</li>
    </ol>
    <h1 class="page-header">菜单管理  <small></small></h1>
    <div class="row">
        <!-- begin col-6 -->
        <div class="col-md-5 ui-sortable">
            <div data-sortable-id="tree-view-3" class="panel panel-inverse">
                <div class="panel-heading">
                    <div class="panel-heading-btn">
                        <a data-click="panel-expand" class="btn btn-xs btn-icon btn-circle btn-default" href="javascript:;" data-original-title="" title=""><i class="fa fa-expand"></i></a>
                        <a data-click="panel-reload" class="btn btn-xs btn-icon btn-circle btn-success" href="javascript:;" data-original-title="" title=""><i class="fa fa-repeat"></i></a>
                        <a data-click="panel-collapse" class="btn btn-xs btn-icon btn-circle btn-warning" href="javascript:;"><i class="fa fa-minus"></i></a>
                        <a data-click="panel-remove" class="btn btn-xs btn-icon btn-circle btn-danger" href="javascript:;"><i class="fa fa-times"></i></a>
                    </div>
                    <h4 class="panel-title">菜单列表</h4>
                </div>
                <div class="alert alert-info">
                    <i class="fa fa-info-circle fa-fw"></i> 拖拽菜单可以改变菜单排序或调整菜单结构。
                </div>
                <div class="panel-body">
              		<div class="zTreeDemoBackground left">
						<ul id="treeDemo" class="ztree"></ul>
					</div>
                </div>
            </div>
        </div>
        <!-- end col-6 -->
        <!-- begin col-6 -->
        <div class="col-md-6 ui-sortable">
            <div data-sortable-id="tree-view-4" class="panel panel-inverse">
                <div class="panel-heading">
                    <div class="panel-heading-btn">
                        <a data-click="panel-expand" class="btn btn-xs btn-icon btn-circle btn-default" href="javascript:;"><i class="fa fa-expand"></i></a>
                        <a data-click="panel-reload" class="btn btn-xs btn-icon btn-circle btn-success" href="javascript:;"><i class="fa fa-repeat"></i></a>
                        <a data-click="panel-collapse" class="btn btn-xs btn-icon btn-circle btn-warning" href="javascript:;"><i class="fa fa-minus"></i></a>
                        <a data-click="panel-remove" class="btn btn-xs btn-icon btn-circle btn-danger" href="javascript:;"><i class="fa fa-times"></i></a>
                    </div>
                    <h4 class="panel-title">添加菜单</h4>
                </div>
                <div class="alert alert-info">
                    <i class="fa fa-info-circle fa-fw"></i> 添加菜单后需要在左边的菜单列表进行拖拽来调整结构。
                </div>
                <div class="panel-body">
                	<form method="POST" action="/" id="form">
                        <fieldset>
                            <legend>菜单信息</legend>
                            <div class="form-group">
                                <label for="exampleInputEmail1">菜单名称</label>
                                <input type="text" placeholder="名称" id="name" name="name" class="form-control required">
                            </div>
                            <div class="form-group">
                                <label for="url">菜单链接</label>
                                <input type="text" placeholder="链接" id="url" name="url" class="form-control required">
                            </div>
                            <div class="form-group">
                                <label for="icon">图标</label>
                                <input type="text" placeholder="图标代码" id="icon" name="icon" class="form-control">
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="isShow"> 是否启用
                                </label>
                            </div>
                            <button class="btn btn-sm btn-primary m-r-5" type="submit">保存</button>
                            <button class="btn btn-sm btn-default" type="reset">重置</button>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
        <!-- end col-6 -->
    </div>
</div>
<script src="static/plugins/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="static/plugins/jquery-validation-1.14.0/dist/localization/messages_zh.min.js"></script>
<script src="static/plugins/zTree_v3-master/js/jquery.ztree.all.min.js"></script>
<script>
(function(){
	App.restartGlobalFunction();
    App.setPageTitle('菜单管理');
    
    var setting = {
		data: {
			simpleData: {
				enable: true
			},
			key: {
				url: ''
			}
		},
		view: {
			dblClickExpand: false,
			showLine: true,
			selectedMulti: false,
			nameIsHTML: true, //为了可以使用fontawesome
			showTitle:false,
			showIcon: false
		}
	};

	/* var zNodes =[
		{ id:1, pId:0, name:'<i class="fa fa-home"></i> 父节点1 - 展开', open:true},
		{ id:11, pId:1, name:"父节点11 - 折叠"},
		{ id:111, pId:11, name:"叶子节点111"},
		{ id:112, pId:11, name:"叶子节点112"},
		{ id:113, pId:11, name:"叶子节点113"},
		{ id:114, pId:11, name:"叶子节点114"},
		{ id:12, pId:1, name:"父节点12 - 折叠"},
		{ id:121, pId:12, name:"叶子节点121"},
		{ id:122, pId:12, name:"叶子节点122"},
		{ id:123, pId:12, name:"叶子节点123"},
		{ id:124, pId:12, name:"叶子节点124"},
		{ id:13, pId:1, name:"父节点13 - 没有子节点", isParent:true},
		{ id:2, pId:0, name:"父节点2 - 折叠"},
		{ id:21, pId:2, name:"父节点21 - 展开", open:true},
		{ id:211, pId:21, name:"叶子节点211"},
		{ id:212, pId:21, name:"叶子节点212"},
		{ id:213, pId:21, name:"叶子节点213"},
		{ id:214, pId:21, name:"叶子节点214"},
		{ id:22, pId:2, name:"父节点22 - 折叠"},
		{ id:221, pId:22, name:"叶子节点221"},
		{ id:222, pId:22, name:"叶子节点222"},
		{ id:223, pId:22, name:"叶子节点223"},
		{ id:224, pId:22, name:"叶子节点224"},
		{ id:23, pId:2, name:"父节点23 - 折叠"},
		{ id:231, pId:23, name:"叶子节点231"},
		{ id:232, pId:23, name:"叶子节点232"},
		{ id:233, pId:23, name:"叶子节点233"},
		{ id:234, pId:23, name:"叶子节点234"},
		{ id:3, pId:0, name:"父节点3 - 没有子节点", isParent:true}
	]; */

	$("#form").validate({
		submitHandler: function(form) {
		    $.ajax({
		    	url:'menu/addOrUpdate',
		    	data:$(form).serialize(),
		    	type:'post',
		    	success:function(result){
		    		if(result.code == '200'){
			    		initMenus();
		    		}else{
						alert(result.msg);		    			
		    		}
		    	}
		    });
	    }
    });
	
	var initMenus = function(){
		$.ajax({
			url:'menu/getAllMenus',
	    	data:{},
	    	type:'post',
	    	success:function(result){
	    		$(result).each(function(index, menu){
	    			menu.name = '<i class="'+menu.icon+'"></i> '+menu.name;
	    		});
	    		$.fn.zTree.init($("#treeDemo"), setting, result);
	    	}
		});
	}
	
	initMenus();
	
})();
</script>
</body>
</html>