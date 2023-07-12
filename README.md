# Educational_system
### 教务管理系统javaweb项目

**运行环境**：window系统，Apache Tomcat v7.0.84、JDK1.8

**开发环境**：J2EE eclipse、navicat for mysql

**运用的技术**：MVC设计模式、DAO模式、Servlet、JSP、Filter、MySQL数据库

**该系统的主要结构**：  

	1.登录（全部已实现）  
		（1）验证码  
		（2）找回密码  
		（3）修改密码  
		（4）注销  
 
	2.学生用户（全部已实现）  
		（1）选课报名  
				-选修报名  
				-考级报名  

		（2）业务办理  
				-缓考申请  
				-免修申请  

		（3）信息查询  
				-学籍信息  
				-课表查询  
				-成绩查询  
				-考试安排  
 
	3.教师用户  
		（1）信息查询  
				-个人信息（已实现）  
				-班级信息（待实现）  
				-课程信息（待实现）  

		（2）成绩管理  
				-录入成绩（待实现）  
				-修改成绩（待实现）  

	4.教务员用户（全部已实现）  
		（1）学籍管理  
		（2）考级管理  
			-考级报名学生  	
			-考级学生成绩  
		（3）教务管理  
			-成绩管理  
			-选修报名学生  
		
		（4）个人事务  
			-个人信息  
	5.管理员用户  
		（1）用户管理（已实现）  
		（2）系统维护（待实现））  

#### 启动系统的步骤：
1.打开mysql数据库（例如：打开navicat），运行jiaowusystem.sql文件。

2.打开 J2EE eclipse 软件，file那里选择导入已存在的项目，选择javaweb_project文件夹导入。

3.导入项目后如果遇到出现红色叉号或者感叹号，就是项目运行的java环境与你电脑安装的java环境不一致
	还有Tomcat服务器版本不一样。这时需要修改配置环境中的jre包，和 Tomcat包，
	修改成你电脑安装的版本就行了。还有再修改项目运行在服务器的环境改成你安装Tomcat服务器环境。
	不懂的话可以百度一下，有详细的解决步骤

4.点开项目，找到login文件夹下的login.jsp
	鼠标右键点击login.jsp,选择run as在服务器上，这时就是到了登录页面了。

5.登录的用户账号密码都在jiaowusystem数据库中的users表中，随便找到账号和密码登录，
	建议选择小明的账号登录，因为学生用户的功能已经全部完成，数据库中存的测试数据都是小明的。
	也可使用教务员的账户，教务员的大部分功能都已经实现了。

6.数据库中的数据比较少，写这个项目时存的数据主要是用来测试，所以可以再导入大量的数据。

7.系统可以继续完成未实现的功能，以及添加新的功能
  

**WebContent文件夹下**：

login文件夹下放着登录页面

acdemic_dean文件夹下放着教务员用户的jsp页面

administrator文件夹下放着管理员用户的jsp页面

student文件夹放着学生用户的jsp页面

teacher文件夹放着教师用户的jsp页面

modify文件夹放着修改密码的jsp页面

  
可关注我的博客：https://blog.csdn.net/Thanours/article/details/79681405?spm=1001.2014.3001.5502 有更详细的说明  
如果觉得可以请点一下star，谢谢！


## GitHub仓库星标统计

[![Stargazers over time](https://starchart.cc/Tanh-wink/Educational_system.svg)](https://starchart.cc/Tanh-wink/Educational_system)

