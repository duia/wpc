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
	        	基本的datatables
	        </div>
	    </div>
	    <div class="panel-body">
            <div class="btn-toolbar">
                <div class="pull-right">
                    <div class="input-append">
                        <input type="text" placeholder="模糊查询" id="fuzzy-search">
                        <div class="btn-group">
                            <button type="button" class="btn" id="btn-simple-search"><i class="fa fa-search"></i></button>
                            <button type="button" class="btn" title="高级查询" id="toggle-advanced-search">
                                <i class="fa fa-angle-double-down"></i>
                            </button>
                        </div>
                    </div>
                </div>
                <button type="button" class="btn btn-primary" id="btn-add"><i class="fa fa-plus"></i> 添加</button>
                <button type="button" class="btn btn-danger" id="btn-del"><i class="fa fa-remove"></i> 批量删除</button>
            </div>
			<table id="table_id_example" class="table table-bordered table-striped table-hover">
				 <thead>
				    <tr>
			            <th>姓名</th>
			            <th>地点</th>
			            <th>薪水</th>
			            <th>入职时间</th>
			            <th>办公地点</th>
			            <th>编号</th>
			            <th>操作</th>
			        </tr>
		        </thead>
		        <tbody></tbody>
		        <!-- tbody是必须的 -->
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
    
    $('#table_id_example').DataTable({
        ajax: "/static/data/objects.txt",
        processing: true,
        serverSide: true,
        columns: [
            {"data": "name"},
            {"data": "position"},
            {"data": "salary"},
            {"data": "start_date"},
            {"data": "office"},
            {"data": "extn"},
            {"data": null}
        ],
        columnDefs: [
	        {
	            targets: 6,
	            render: function (a, b, c, d) {
	                var html = [];
	                html.push('<button type="button" class="btn btn-primary btn-sm" onclick="">修改</button>');
	                html.push('<button type="button" class="btn btn-danger btn-sm" onclick="">删除</button>');
	                return html.join(' ');
	            }
	        }
	
	    ],
	    language: {
            "lengthMenu": "每页 _MENU_ 条记录",
            "zeroRecords": "没有找到记录",
            "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
            "infoEmpty": "无记录",
            "infoFiltered": "(从 _MAX_ 条记录过滤)",
            "paginate": {
            	"first":"第一页",
                "previous": "上一页",
                "next": "下一页"
            }
        },
        dom: "<'row'<'#mytool.col-xs-3'><'col-xs-9'f>>t<'row'<'col-xs-1'i><'col-xs-1'l><'col-xs-10'p>>",
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