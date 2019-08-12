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
    <meta charset="UTF-8">
    <title>登录后台</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<link rel="stylesheet" type="text/css" href="css/animation.css">
  </head>
  
  <body>
  	<div class="container">
  		<div class="header"></div>
  		
  		<div class="content">
  			<div class="login_container">
				<div class="login_main">
					<div class="title">
	                    <img src="image/logo_v3.png" width="80px" height="80px"/>
	                    
	                    <p>欢迎登录单词英雄后台 </p>
	                    
	                    <c:if test="${not empty error}"><p style="color:#EF5350">${error} </p></c:if>
	                    <c:if test="${not empty info}"><p style="color:#9CCC65">${info} </p></c:if>
	                </div>
	                <form action="/Word_Hero/Admin?action=login" method="post">
	                    <div class="input-group" id="input-group">
	                        <i class="icon icon-user"></i>
	                        <input type="text" placeholder="用户名" id="username" name="username" value="">
	                    	 
	                    </div>
	                    <div class="input-group" id="input-group">
	                        <i class="icon icon-password"></i>
	                        <input type="password" placeholder="密码" id="password" name="password" value="">
	                    </div>
	                    
	                    <input type="submit" value="登录" class="login_button"/>
	                    
	                    <div class="info">
                       		还没有账号?<a href="register.jsp">去注册</a>
	                    </div>
	                </form>			
				</div>
  			</div>
  		</div>

 		<div class="footer">All rights reserved. &copy;Copyright (2019) – WordHero™</div>
  	</div>
 </body>
</html>
