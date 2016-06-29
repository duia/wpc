<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试</title>
</head>
<body>
	<button id="add">添加任务5</button>
	<button id="pause">暂停任务1</button>
	<button id="resume">恢复任务1</button>
	<button id="delete">删除任务2</button>
	<button id="running">运行中任务</button>
	<button id="waiting">等待中任务</button>
<script type="text/javascript" src="static/js/jquery-2.1.3.min.js"></script>
<script type="text/javascript">
$(function(){
  $('#add').click(function(){
    $.ajax({
      url:'times/add',
      type:'GET',
      success:function(result){
        
      }
    });
  });
  $('#pause').click(function(){
    $.ajax({
      url:'times/pause',
      type:'GET',
      success:function(result){
        
      }
    });
  });
  $('#resume').click(function(){
    $.ajax({
      url:'times/resume',
      type:'GET',
      success:function(result){
        
      }
    });
  });
  $('#delete').click(function(){
    $.ajax({
      url:'times/delete',
      type:'GET',
      success:function(result){
        
      }
    });
  });
  $('#running').click(function(){
    $.ajax({
      url:'times/running',
      type:'GET',
      success:function(result){
        console.log(result);
      }
    });
  });
  $('#waiting').click(function(){
    $.ajax({
      url:'times/waiting',
      type:'GET',
      success:function(result){
        console.log(result);
      }
    });
  });
});
</script>
</body>
</html>	