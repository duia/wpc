$(document).ready(function() {
	//App.init();
	$.ajax({
		url:'../static/data/menu.json',
		type:'get',
		data:{},
		dataType:'json',
		success:function(menus){
			var ms = [];
			$.each(menus, function(i, menu){
				ms.push('<li class="');
				menu.children.length && ms.push('has-sub');
				ms.push('">');
				menu.url?ms.push('<a href="'+menu.url+'" data-toggle="ajax">'):ms.push('<a href="javascript:;">');
				ms.push('<i class="'+menu.icon+'"></i>');
				menu.children.length && ms.push('<b class="caret pull-right"></b>');
				ms.push('<span>'+menu.name+'</span>');
				ms.push('</a>');
				if(menu.children.length){
					ms.push('<ul class="sub-menu">');
					$.each(menu.children, function(j, menuch){
						ms.push('<li><a href="'+menuch.url+'" data-toggle="ajax">'+menuch.name+'</a></li>');
					});
					ms.push('</ul>');
				}
				ms.push('</li>');
			});
			$('.nav-header').after(ms.join(''));
			App.init();
		}
	}); 
});