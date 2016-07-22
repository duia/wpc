**************************************************************************************************

2016-07-22
添加百度富文本编辑器（UEditor）功能
	|——java
	|	|——controller
	|	|	|——UEditorController.java
	|	|——core.ueditor
	|		|——百度提供的编辑器上传文件所需要的一些java源码
	|——resources
	|	|——spring-mvc.xml下添加以下代码：<mvc:resources mapping="/ueditor/**" location="/ueditor/" />
	|——webapps
	|	|——static
	|	|	|——plugins
	|	|		|——UEditor(ueditor相关的js和配置文件)
	|	|——ueditor(该目录需要和controller配置的路由相匹配，存放配置文件config.json，否则会读取不到，还可以作为文件上传的位置)
	|	|——WEB-INF
	|		|——views
	|			|——ueditor
	|				|——index.jsp(测试页面)
	|——pom.xml(添加commons-fileupload、commons-io、commons-codec、org.json（已）)

说明：spring-mvc.xml中的multipartResolver会拦截编辑器上传过来的文件，进行解析后后台无法识别，可以重写拦截器或注掉。

***************************************************************************************************