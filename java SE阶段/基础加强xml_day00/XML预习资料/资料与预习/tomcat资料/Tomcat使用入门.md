# Tomcat使用入门

## 1 Tomcat概述

Tomcat 服务器是一个免费的开放源代码的Web应用服务器软件，是Apache 软件基金会（Apache Software Foundation的Jakarta 项目中的一个核心项目，由Apache、Sun 和其他一些公司及个人共同开发而成。由于有了Sun 的参与和支持，最新的Servlet 和JSP 规范总是能在Tomcat 中得到体现，因为Tomcat 技术先进、性能稳定，而且免费，因而深受Java 爱好者的喜爱并得到了部分软件开发商的认可，成为目前比较流行的Web 应用服务器。目前（2018年3月12号为止）最新版本是9.0.6。



## 2 下载，安装，启动和停止Tomcat

### 2.1下载Tomcat 

进入https://tomcat.apache.org/download-90.cgi网址

  ![01](tomcat_img\01.png)

点击Tomcat9

 ![02](tomcat_img\02.png)

选中windows版本64位的Tomcat9进行下载到本地

 ![03](tomcat_img\03.png)

确认本地已经下载完毕

 ![04](tomcat_img\04.png)

### 2.2 安装Tomcat

因为Tomcat是基于Java编写的Web应用服务器软件，所以安装Tomcat之前，先要确保

你的电脑中已成功安装JDK软件，版本建议至少JDK8或以上。我这里安装的JDK信息如下：

 ![05](tomcat_img\05.png)

因为我们下载的Tomcat9属于非安装版本，只需解压后，直接使用。我们将刚刚下载的Tomcat9进行解压到当前目录下。

 ![06](tomcat_img\06.png)

解压完后，如下图所示：

![07](tomcat_img\07.png)

最后，我们在电脑中，配置一个名叫TOMCAT_HOME的环境变量，以指向Tomcat9安装目录的位置。

 ![08](tomcat_img\08.png)

  ![09](tomcat_img\09.png)

 ![10](tomcat_img\10.png)

 ![11](tomcat_img\11.png)

 ![12](tomcat_img\12.png)

至此，我们在电脑中，配置一个名叫TOMCAT_HOME的环境变量完毕。

### 2.3 启动Tomcat并测试

进入Tomcat9安装目录中的bin目录下，找到一个名叫startup.bat的文件，双击执行。

即启动Tomcat了。

 ![13](tomcat_img\13.png)

如果成功启动Tomcat9，会出现如下提示信息：

![14](tomcat_img\14.png)

因为Tomcat也是一个JavaWeb项目，它默认占用8080端口，所以可以通过浏览器访问这个JavaWeb项目，那么我们打开浏览器，输入如下网址，http://127.0.0.1:8080或http://localhost:8080。如果成功启动Tomcat9，会出现如下提示信息：

![15](tomcat_img\15.png)

### 2.4 停止Tomcat并测试

进入Tomcat9安装目录中的bin目录下，找到一个名叫shutdown.bat的文件，双击执行。

即停止Tomcat了。

![16](tomcat_img\16.png)

如果成功停止Tomcat9，刚刚启动时弹出的cmd窗口会自动消失。

同时你打开浏览器，输入如下网址，http://127.0.0.1:8080或http://localhost:8080。如果成功停止Tomcat9，会出现如下提示信息：

 ![17](tomcat_img\17.png)



## 3 Tomcat启动常见错误与解决方案

### 3.1 启动常见错误1

错误描述：双击startup.bat文件后，cmd窗口一闪而过。

 ![18](tomcat_img\18.png)

错误原因：你电脑中，没有配置JAVA_HOME环境变量，或者JAVA_HOME环境变量配了但指定路径错了。

解决方案：在你电脑中，配置JAVA_HOME 环境变量，并指向JDK安装目录。

 ![19](tomcat_img\19.png)  

### 3.2 启动常见错误2

错误描述：双击startup.bat文件后，cmd窗口显示端口号已被占用。

![20](tomcat_img\20.png)

错误原因：一个软件在电脑中会占用至少一个端口，如果这个端口已被其它软件占用，那么其它软件如果

​                   再使用这个端口的话，一定会出错。

解决方案：查询出对应端口被占用软件，并强行停止它。

 ![21](tomcat_img\21.png)

 ![22](tomcat_img\22.png)

 ![23](tomcat_img\23.png)



## 4 Tomcat主要目录介绍

  下图是Tomcat9安装成功后的目录结构，以及对主要目录的解释：

 ![24](tomcat_img\24.png)

- bin 目录：存放 Tomcat 的一些脚本文件，包含启动和关闭 Tomcat 服务脚本。
- conf目录：存放 Tomcat 服务器的各种全局配置文件，其中最重要的是 server.xml 和 web.xml。
- webapps目录：Tomcat 的主要 Web 发布目录，默认情况下把 Web 应用文件放于此目录。
- logs目录：存放 Tomcat 执行时的日志文件。
- work目录：存放 Tomcat 执行JSP时翻译成Servlet的java和class文件。



## 5 部署JavaWeb项目到Tomcat

在Tomcat9的webapps目录中，创建一个itheima文件夹：

 ![25](tomcat_img\25.png)

在itheima文件夹中创建index.html文件，写如下内容：

![26](tomcat_img\26.png)

上面的itheima目录，相当于一个JavaWeb项目，现在已经将JavaWeb项目部署到了Tomcat中了，

最后，双击Tomcat9中bin目录下的startup.bat文件，以启动Tomcat9。

![27](tomcat_img\27.png)

## 6 浏览器访问Tomcat中的JavaWeb应用 

启动浏览器，在浏览器中输入http://127.0.0.1:8080/itheima/index.html这个网址，就可以看到如下内容：

 ![28](tomcat_img\28.png)

http：协议名

127.0.0.1或localhost：Tomcat9所在服务器的IP地址或域名

8080：Tomcat9所在服务器中占用的端口号

itheima：访问JavaWeb项目名，也可以理解为项目根目录

index.html：访问JavaWeb项目中的资源名



