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
</head>
<body>
<div id="content" class="content">
<h1>测试</h1>
<div data-sortable-id="ui-general-3" class="panel panel-inverse">
    <div class="panel-heading">
        <div class="panel-heading-btn">
            <a data-click="panel-expand" class="btn btn-xs btn-icon btn-circle btn-default" href="javascript:;"><i class="fa fa-expand"></i></a>
            <a data-click="panel-reload" class="btn btn-xs btn-icon btn-circle btn-success" href="javascript:;"><i class="fa fa-repeat"></i></a>
            <a data-click="panel-collapse" class="btn btn-xs btn-icon btn-circle btn-warning" href="javascript:;"><i class="fa fa-minus"></i></a>
            <a data-click="panel-remove" class="btn btn-xs btn-icon btn-circle btn-danger" href="javascript:;"><i class="fa fa-times"></i></a>
        </div>
        <h4 class="panel-title">Labels &amp; Badges</h4>
    </div>
    <div class="panel-body">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Class</th>
                    <th>Labels</th>
                    <th>Badges</th>
                    <th>Square Badges</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Default</td>
                    <td><span class="label label-default">Default</span></td>
                    <td><span class="badge badge-default">6</span></td>
                    <td><span class="badge badge-default badge-square">6</span></td>
                </tr>
                <tr>
                    <td>Danger</td>
                    <td><span class="label label-danger">Danger</span></td>
                    <td><span class="badge badge-danger">4</span></td>
                    <td><span class="badge badge-danger badge-square">4</span></td>
                </tr>
                <tr>
                    <td>Warning</td>
                    <td><span class="label label-warning">Warning</span></td>
                    <td><span class="badge badge-warning">7</span></td>
                    <td><span class="badge badge-warning badge-square">7</span></td>
                </tr>
                <tr>
                    <td>Success</td>
                    <td><span class="label label-success">Success</span></td>
                    <td><span class="badge badge-success">8</span></td>
                    <td><span class="badge badge-success badge-square">8</span></td>
                </tr>
                <tr>
                    <td>Info</td>
                    <td><span class="label label-info">Info</span></td>
                    <td><span class="badge badge-info">2</span></td>
                    <td><span class="badge badge-info badge-square">2</span></td>
                </tr>
                <tr>
                    <td>Primary</td>
                    <td><span class="label label-primary">Primary</span></td>
                    <td><span class="badge badge-primary">5</span></td>
                    <td><span class="badge badge-primary badge-square">5</span></td>
                </tr>
                <tr>
                    <td>Inverse</td>
                    <td><span class="label label-inverse">Inverse</span></td>
                    <td><span class="badge badge-inverse">12</span></td>
                    <td><span class="badge badge-inverse badge-square">12</span></td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
</div>
</body>
</html>