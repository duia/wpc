﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>admin|User</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
</head>
<body>
<div id="content" class="content">
	<ol class="breadcrumb pull-right">
        <li><a href="javascript:;">系统配置</a></li>
        <li class="active">人员管理</li>
    </ol>
    <h1 class="page-header">人员管理  <small></small></h1>
	<div class="panel panel-inverse">
	    <div class="panel-heading">
	        <div class="panel-title">
	        	人员列表
	        </div>
	    </div>
	    <div class="panel-body">
            <div class="btn-toolbar">
                <div class="pull-right">
                    <div class="input-group">
	                    <!-- <input type="text" placeholder="Enter message" class="form-control bg-silver"> -->
	                    <span class="btn-group">
	                        <!-- <button type="button" class="btn" id="btn-simple-search"><i class="fa fa-search"></i></button> -->
	                        <button type="button" class="btn" title="高级查询" id="toggle-advanced-search">
                                <i class="fa fa-angle-double-down"></i>
                            </button>
	                    </span>
	                </div>
                </div>
                <button type="button" class="btn btn-primary" id="btn-add" data-toggle="modal" data-target="#myModal"><i class="fa fa-plus"></i> 添加</button>
                <button type="button" class="btn btn-danger" id="btn-del"><i class="fa fa-remove"></i> 批量删除</button>
            </div>
            <div class="row-fluid" style="display: none; margin-top: 15px;" id="div-advanced-search">
				<form class="form-inline well">
					<span>姓名:</span>
					<input type="text" class="form-control" placeholder="姓名" id="name-search">
					<span>职位:</span>
					<input type="text" class="form-control" placeholder="职位" id="position-search">
					<span>工作地点:</span>
					<input type="text" class="form-control" placeholder="工作地点" id="office-search">
					<span>编号:</span>
					<input type="text" class="form-control" placeholder="编号" id="extn-search">
					<span>在线状态:</span>
					<select class="form-control" id="status-search">
						<option value="">全部</option>
						<option value="1">在线</option>
						<option value="0">离线</option>
					</select>
					<select class="form-control" id="role-search">
						<option value="">全部</option>
						<option value="1">管理员</option>
						<option value="0">操作员</option>
					</select>
					<button type="button" class="btn" id="btn-advanced-search"><i class="fa fa-search"></i> 查询</button>
					<button class="btn btn-default" type="submit">重置</button>
				</form>
			</div>
			<table id="user_table" class="table table-bordered table-striped table-hover">
				<thead>
					<tr>
						<th><input type='checkbox' name='checklist' id='checkall' /></th>
						<th>ID</th>
						<th>用户名</th>
						<th>登陆账号</th>
						<th>密码</th>
						<th>年龄</th>
						<th>更新时间</th>
						<th>操作</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">新增人员</h4>
            </div>
            <div class="modal-body">
				<form method="POST" action="/" class="form-horizontal" id="userform">
                    <div class="form-group">
                        <label class="col-md-3 control-label">用户名</label>
                        <div class="col-md-9">
                            <input type="text" name="username" placeholder="用户名" class="form-control required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">登陆账号</label>
                        <div class="col-md-9">
                            <input type="text" name="account" placeholder="登陆账号" class="form-control required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">密码</label>
                        <div class="col-md-9">
                            <input type="text" name="password" placeholder="登陆密码" class="form-control required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">年龄</label>
                        <div class="col-md-9">
                            <input type="number" name="age" placeholder="年龄" class="form-control required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">添加时间</label>
                        <div class="col-md-9">
                            <input type="datetime" name="" placeholder="添加时间" class="form-control">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="saveUser">保存</button>
            </div>
        </div>
    </div>
</div>
<script>
(function(){
	App.restartGlobalFunction();
    App.setPageTitle('人员管理');
    
    $("#toggle-advanced-search").click(function(){
		$("i",this).toggleClass("fa-angle-double-down fa-angle-double-up");
		$("#div-advanced-search").slideToggle("fast");
	});
    
    var table = $('#user_table').DataTable({
        //ajax: "/static/data/objects.txt",
        ajax:{
        	url:'/user/searchPage',
        	type:'post',
        	data:function (data) {
        		data.condition = {
        			/* username:'123',//添加额外参数
        			password:'123456' */
        		}
                return JSON.stringify(data);
            },
            dataType: "json",
            processData: false,
            contentType: 'application/json;charset=UTF-8'
        },
        processing: true,
        serverSide: true,
        language: {
		    url:'/static/plugins/DataTables-1.10.12/media/Chinese.json'
        },
        pagingType: "full_numbers",
        columns: [{
       		data: null
       	},{
       		data: "id"
  		},{
  			data: "username"
   		},{
   			data: "account"
		},{
			data: "password"
		},{
			data: "age"
		},{
			data: "updateTime"
		},{
			data: null
 		}],
        columnDefs: [
			{
			    //   指定第一列，从0开始，0表示第一列，1表示第二列……
			    targets: 0,
			    render: function(data, type, row, meta) {
			        return '<input type="checkbox" name="checklist" value="' + row.id + '" />'
			    }
			},
	        {
	            targets: 7,
	            render: function (data, type, row, metad) {
	                var html = [];
	                html.push('<button type="button" class="btn btn-primary btn-sm updateUserBtn">修改</button>');
	                html.push('<button type="button" class="btn btn-danger btn-sm deleteUserBtn">删除</button>');
	                return html.join(' ');
	            }
	        }
	
	    ],
        dom: "<'row'<'#mytool.col-xs-3'><'col-xs-9'>>t<'row'<'col-xs-3'i><'col-xs-2'l><'col-xs-7'p>>",
		initComplete: function () {
		    //$("#mytool").append('<button id="datainit" type="button" class="btn btn-primary btn-sm">增加基础数据</button>&nbsp');
		    //$("#mytool").append('<button type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#myModal">添加</button>');
		    //$("#datainit").on("click", initData);
		}
    });
    
    $('#saveUser').on('click', function(){
    	$('#userform').submit();
    });
    
    $('#userform').validate({
		submitHandler: function(form) {
			console.log('a');
		    $.ajax({
		    	url:'/user/addOrUpdate',
		    	data:$('#userform').serialize(),
		    	type:'post',
		    	success:function(result){
		    		if(result.code == '200'){
			    		console.log('ok');
			    		$('#myModal').modal('hide')
			    		//table.draw(false);
			    		table.ajax.reload(null, false);
		    		}else{
						alert(result.msg);		    			
		    		}
		    	}
		    });
	    }
    });
    
    $('#user_table').delegate('.updateUserBtn', 'click', function(e){
    	BootstrapDialog.alert('修改用户');
    });
    
    $('#user_table').delegate('.deleteUserBtn', 'click', function(e){
    	BootstrapDialog.alert('删除用户');
    });
    
})();
</script>
</body>
</html>