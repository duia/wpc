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
			<table id="table_id_example" class="table table-bordered table-striped table-hover">
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
                <h4 class="modal-title" id="myModalLabel">新增</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <input type="text" class="form-control" id="name" placeholder="姓名">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="position" placeholder="位置">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="salary" placeholder="薪资">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="start_date" placeholder="时间"
                           data-date-format="yyyy/mm/dd">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="office" placeholder="工作地点">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="extn" placeholder="编号">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info" id="initData">添加模拟数据</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="save">保存</button>
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
    
    $('#table_id_example').DataTable({
        //ajax: "/static/data/objects.txt",
        ajax:{
        	url:'/user/search',
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
            /* "lengthMenu": "每页 _MENU_ 条记录",
            "zeroRecords": "没有找到记录",
            "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
            "infoEmpty": "无记录",
            "infoFiltered": "(从 _MAX_ 条记录过滤)",
            "paginate": {
            	"first":"第一页",
                "previous": "上一页",
                "next": "下一页"
            } */
		    url:'/static/plugins/DataTables-1.10.12/media/Chinese.json'
        },
        pagingType: "full_numbers",
        columns: [{
        	"title":"<input type='checkbox' name='checklist' id='checkall' />",
       		"data": null
       	},{
       		"title":"ID",
       		"data": "id"
  		},{
  			"title":"用户名",
  			"data": "username"
   		},{
   			"title":"登陆账号",
   			"data": "account"
		},{
			"title":"密码",
			"data": "password"
		},{
			"title":"年龄",
			"data": "age"
		},{
			"title":"更新时间",
			"data": "updateTime"
		},{
			"title":"操作",
			"data": null
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
	                html.push('<button type="button" class="btn btn-primary btn-sm" onclick="">修改</button>');
	                html.push('<button type="button" class="btn btn-danger btn-sm" onclick="">删除</button>');
	                return html.join(' ');
	            }
	        }
	
	    ],
        dom: "<'row'<'#mytool.col-xs-3'><'col-xs-9'>>t<'row'<'col-xs-3'i><'col-xs-2'l><'col-xs-7'p>>",
		initComplete: function () {
		    //$("#mytool").append('<button id="datainit" type="button" class="btn btn-primary btn-sm">增加基础数据</button>&nbsp');
		    //$("#mytool").append('<button type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#myModal">添加</button>');
		    $("#datainit").on("click", initData);
		}
    });
})();
</script>
</body>
</html>