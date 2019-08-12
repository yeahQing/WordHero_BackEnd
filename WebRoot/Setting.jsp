<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/main.css">

  </head>
  
  <body>
  	<div class="container">
  		<header class="header">
  			<div class="title">
  				<p><a href="main.jsp">单词英雄后台管理系统</a></p>
  			</div>
  			<div class="user_info">
  				<a href="login.jsp">${user.admin_name},退出登录</a>
  			</div>
  		</header>
  		<nav class="menu">
  			<div class="option_list">
  				<ul>
	  				<li><a href="main.jsp">首页</a></li>
	  				<li><a href="User_Manager.jsp">用户管理</a></li>
	  				<li><a href="Word_Manager.jsp">单词管理</a></li>
					<li><a href="Question_Lib_Manager.jsp">题库管理</a></li>
	  				<li><a href="Setting.jsp">设置</a></li>
  				</ul>
  			</div>
  		</nav>
  		<div class="content">
  			<div class="list_part">
  				<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
					  <tr>
					   	 <td align="center" class="list_title" height="60">修改管理员信息</td>
					  </tr>
				</table>
  				 <form action="/Word_Hero/Admin?action=updateAdmin" method="post">
	  				 <input type="hidden" name="admin_id" value="${ user.admin_id }" />
	  				 <div class="info_style">
	  				 	 <div class="input-group">
	                        <i class="icon icon-user"></i>
	                       	<label class="input_label">管理员姓名:</label><input type="text" placeholder="请输入用户名" id="username" name="username" value="${user.admin_name}">
	                    </div>
	                    <div class="input-group">
	                        <i class="icon icon-password"></i>
	                       	<label class="input_label">管理员密码:</label><input type="password" placeholder="请输入密码" id="password" name="password" value="${user.admin_password}">
	                    </div>
	  				 </div>
	  				 <div class="button_group_style">
	  				 	<input type="submit" class="submit_style" value="保存"/>
	  				 </div>
                </form>
  			</div>
  			
  		</div>

  	</div>
 </body>
</html>
