# 黄山水务信息查询系统

![hssw](https://markdownoss.oss-cn-hangzhou.aliyuncs.com/github/hssw/logo/logo2.png)
### 黄山水务信息查询系统是什么?
一个在线编辑markdown文档的编辑器

向Mac下优秀的markdown编辑器mou致敬

### 黄山水务信息查询系统有哪些功能？

* 方便的`导入导出`功能
    *  直接把一个markdown的文本文件拖放到当前这个页面就可以了
    *  导出为一个html格式的文件，样式一点也不会丢失
* 编辑和预览`同步滚动`，所见即所得（右上角设置）
* `VIM快捷键`支持，方便vim党们快速的操作 （右上角设置）
* 强大的`自定义CSS`功能，方便定制自己的展示
* 有数量也有质量的`主题`,编辑器和预览区域
* 完美兼容`Github`的markdown语法
* 预览区域`代码高亮`
* 所有选项自动记忆

**目录 (Table of Contents)**

[TOCM]

[TOC]

## 系统架构
* 本系统功能架构
![framework](https://markdownoss.oss-cn-hangzhou.aliyuncs.com/github/hssw/framework/framework.png)

* 开发工具及环境
	*  Java 1.8
	*  Eclipse 4.6+
	*  Tomcat 8.5
	*  Maven 3.2.5
	*  Mui

* 环境搭建说明

	*  eclipse配置：
		- 1.进入eclipse的[Windows]->[Preference]；
		![step1-1](https://markdownoss.oss-cn-hangzhou.aliyuncs.com/github/hssw/step/eclipse_set_1.png)
		- 2.在[Preference]中，将[web]->[JSP Files]中的[Creating files]->[Encoding]设置为`UTF-8`；
		![step1-2](https://markdownoss.oss-cn-hangzhou.aliyuncs.com/github/hssw/step/eclipse_set_2.png)
		- 3.在[Preference]中，将[General]->[Workspace]中的[Text file encoding]->[Other]设置为`UTF-8`；
		![step1-3](https://markdownoss.oss-cn-hangzhou.aliyuncs.com/github/hssw/step/eclipse_set_3.png)
		- 4.在[Preference]中，在[Java]->[Installed JREs]中添加本地JDK；
		![step1-4](https://markdownoss.oss-cn-hangzhou.aliyuncs.com/github/hssw/step/eclipse_set_4.png)
		- 5.在[Preference]中，在[Maven]->[Installations]中添加本地Maven；
		![step1-5](https://markdownoss.oss-cn-hangzhou.aliyuncs.com/github/hssw/step/eclipse_set_5.png)
		- 6.在[Preference]中，在[Maven]->[User Settings]中将"Global Settings"、"User Settings"设置为本工程中`settings.xml文件`在本地的路径；
		![step1-6](https://markdownoss.oss-cn-hangzhou.aliyuncs.com/github/hssw/step/eclipse_set_6.png)
		
	*  导入本工程：
		- 1.进入eclipse的[File]->[Import]；
		![step2-1](https://markdownoss.oss-cn-hangzhou.aliyuncs.com/github/hssw/step/eclipse_import_1.png)
		- 2.在[Import]中，搜索"maven"，点击搜素结果中的"Existing Maven Projects"；
		![step2-2](https://markdownoss.oss-cn-hangzhou.aliyuncs.com/github/hssw/step/eclipse_import_2.png)
		- 3.在[Import Maven Projects]中，点击右侧[Browse...]将本工程文件夹在本地电脑中的路径导入到[Root Directory]，然后点击[finish]；
		![step2-3](https://markdownoss.oss-cn-hangzhou.aliyuncs.com/github/hssw/step/eclipse_import_3.png)
		- 4.出现该界面则说明导入完成；
		![step2-4](https://markdownoss.oss-cn-hangzhou.aliyuncs.com/github/hssw/step/eclipse_import_4.png)
		- 5.由于本工程有部分jar包不能通过阿里云Maven中央仓库下载，因此需要手动添加；
		- 6.进入本地maven包的仓库./maven_repository中；
		![step2-6](https://markdownoss.oss-cn-hangzhou.aliyuncs.com/github/hssw/step/eclipse_import_6.png)
		- 7.点击`com`文件夹进入，解压本工程的`sun.zip`压缩包，对已存在的sun文件夹进行覆盖。
		![step2-7](https://markdownoss.oss-cn-hangzhou.aliyuncs.com/github/hssw/step/eclipse_import_7.png)
		- 8.本工程导入成功！
		- 9.在eclipse的程序目录中，`鼠标右键`点击[src]->[main]->[webapp]->`[index.jsp]`，在右侧菜单中点击[Run As]->[Run on Server]；
		![step2-9](https://markdownoss.oss-cn-hangzhou.aliyuncs.com/github/hssw/step/eclipse_import_9.png)
		- 10.在出现的页面中选择[Apache]->[Tomcat v8.5 Server]，并配置本地的Tomcat 8.5到当前工程；
		![step2-10](https://markdownoss.oss-cn-hangzhou.aliyuncs.com/github/hssw/step/eclipse_import_10.png)
		- 11.出现该页面则配置成功，等待其自动安装完成后方可在web中查看本程序。
		![step2-11](https://markdownoss.oss-cn-hangzhou.aliyuncs.com/github/hssw/step/eclipse_import_1.png)








##有问题反馈
在使用中有任何问题，欢迎反馈给我，可以用以下联系方式跟我交流

* 邮件: lzlrjok@vip.qq.com
* QQ: 493671495
* weibo: [@子瞻大魔王](http://weibo.com/lzlrjok)
* twitter: [@Leo](http://twitter.com/lzlrjok)

##捐助开发者
在兴趣的驱动下,写一个`免费`的东西，有欣喜，也还有汗水，希望你喜欢我的作品，同时也能支持一下。
当然，有钱捧个钱场（右上角的爱心标志，支持支付宝和PayPal捐助），没钱捧个人场，谢谢各位。

##感激
感谢以下的开发者,排名不分先后

* [合肥工业大学宣城校区黄山水务毕业设计团队](http://www.hfut.edu.cn/)
* [冯鑫涛](http://xc.hfut.edu.cn/) 
* [贺霄](http://xc.hfut.edu.cn/)
* [陈治宇](http://xc.hfut.edu.cn/)
* [邓家晟](http://xc.hfut.edu.cn/)
* [胡胜铭](http://xc.hfut.edu.cn/)
* [李仁杰](http://xc.hfut.edu.cn/)

##关于作者

* 合肥工业大学宣城校区黄山水务毕业设计团队



```javascript
  var hssw = {
    nickName  : "黄山水务",
    site : "http://www.hfut.edu.cn/"
  }
```