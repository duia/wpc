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
<style>
.ztree li span.button.add {margin-left:2px; margin-right: -1px; background-position:-144px 0; vertical-align:top; *vertical-align:middle}
</style>
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
                	<form id="form">
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
                                    <input type="checkbox" name="isActive" id="isActive" value="1"> 是否启用
                                </label>
                            </div>
                            <input type="hidden" name="pId" value="" id="pId">
                            <input type="hidden" name="id" value="" id="id">
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
		edit: {
			enable: true,
			showRemoveBtn: showRemoveBtn,
			showRenameBtn: false
		},
   		data: {
			simpleData: {
				enable: true,
				pIdKey: "pid",
			},
			key: {
				url: ''
			}
		},
		view: {
			addHoverDom: addHoverDom,
			removeHoverDom: removeHoverDom,
			//dblClickExpand: false,
			showLine: true,
			selectedMulti: false,
			nameIsHTML: true, //为了可以使用fontawesome
			showTitle:false,
			showIcon: false
		},
		callback: {
			//beforeRemove: beforeRemove,
			onRemove: onRemove,
			onClick: onClick,
			onDblClick: onDblClick
		}
	}, treeObj;

    /* function beforeRemove(treeId, treeNode) {
		treeObj.selectNode(treeNode);
		return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
	} */
	function onRemove(e, treeId, treeNode) {
		$.ajax({
	    	url:'menu/delete',
	    	data:{id:treeNode.id},
	    	type:'post',
	    	success:function(result){
	    		if(result.code == '200'){
	    		}else{
	    		}
	    	}
	    });
	}
	var TimeFn = null;
	function onClick(event, treeId, treeNode){
		// 取消上次延时未执行的方法
	    clearTimeout(TimeFn);
	    //执行延时
	    TimeFn = setTimeout(function(){
	        //do function在此处写单击事件要执行的代码
			console.log('单击');
	        console.log(treeNode);
	        $('#name').val($(treeNode.name).text().trim() || treeNode.name);
	        $('#url').val(treeNode.url);
	        $('#icon').val(treeNode.icon);
	        treeNode.isActive?$('#isActive').attr('checked',true):$('#isActive').attr('checked',false);
	        $('#pId').val(treeNode.pid);
	        $('#id').val(treeNode.id);
	    },200);
	}
	function onDblClick(event, treeId, treeNode){
		// 取消上次延时未执行的方法
	    clearTimeout(TimeFn);
	    //双击事件的执行代码
		console.log('双击');
        console.log(treeNode);
	}
	function showRemoveBtn(treeId, treeNode) {
		return !treeNode.isParent;
	}
	function getTime() {
		var now= new Date(),
		h=now.getHours(),
		m=now.getMinutes(),
		s=now.getSeconds(),
		ms=now.getMilliseconds();
		return (h+":"+m+":"+s+ " " +ms);
	}

	function addHoverDom(treeId, treeNode) {
		if ((treeNode.id == 0 || treeNode.pid == 0 || treeNode.pid == null) && $("#addBtn_"+treeNode.tId).length==0){
			var sObj = $("#" + treeNode.tId + "_span");
			var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
				+ "' title='add node' onfocus='this.blur();'></span>";
			sObj.after(addStr);
			var btn = $("#addBtn_"+treeNode.tId);
			if (btn) btn.bind("click", function(){
				treeObj.addNodes(treeNode, {id:null, pId:treeNode.id, name:"新增菜单"});
				return false;
			});
		}
		
	};
	function removeHoverDom(treeId, treeNode) {
		$("#addBtn_"+treeNode.tId).unbind().remove();
	};

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
		var menus = [];
		menus.push({ id:0, pId:null, name:"菜单", open:true});
		$.ajax({
			url:'menu/getAllMenus',
	    	data:{},
	    	type:'post',
	    	success:function(result){
	    		$(result).each(function(index, menu){
	    			menu.name = '<i class="'+menu.icon+'"></i> '+menu.name;
	    			//menu.pId = menu.pid;
	    			menus.push(menu);
	    		});
	    		treeObj = $.fn.zTree.init($("#treeDemo"), setting, menus);
	    		treeObj.expandAll(true);
	    	}
		});
	}
	
	initMenus();
	
})();
</script>
</body>
</html>