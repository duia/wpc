**************************************************************************************************

多线程、可控制起停的的任务调度
	|——java
	|	|——controller
	|	|	|——TimesController.java(访问相关任务调度方法的控制器，控制任务线程的起停)
	|	|——times
	|		|——*(相关任务调度的一些实体类或工具类)
	|——resources
	|	|——applicationContext.xml(添加bean：schedulerFactoryBean)
	|——webapps
	|	|——views
	|		|——times(添加页面控制任务调度)
	|——pom.xml(需要spring使用的版本是4.2.4，添加org.quartz-scheduler2.2.1版本)
	
说明：启动任务调度的入口为JobTest.java,需要在spring容器中注入bean,也可以在该java中添加注解：@Component
	DataWorkContext.java实例化具体每个线程，可以链接数据库重数据库获取线程信息，ScheduleJob.java为具体的线程实体

**************************************************************************************************

解决轮询的性能问题，websocket
	|——java
	|	|——controller
	|	|	|——SocketController.java(页面入口)
	|	|——websocket
	|		|——*(websocket相关的配置)
	|——webapps
	|	|——views
	|		|——socket(页面入口，以及页面端调用的js)
	|——pom.xml(添加spring-websocket、spring-messaging、javax.servlet-api)
	
说明：必须搭配tomcat容器使用

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