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
  			<div class="manager_list">
  				<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
					  <tr>
					   	 <td class="list_title">用户管理<a href="add_User.jsp">新增用户</a></td>
					  </tr>
				</table>
				<div class="outer-container  manager_style">
					<div class="inner-container  manager_style">
						<div class="table_content  manager_style">
							<table width="95%" border="0" cellspacing="0" cellpadding="4" bgcolor="#cccccc" class="table_main_style" align="center">
			  					<thead>
			  						<tr>
			  							<th>序号</th>
			  							<th>用户ID</th>
			  							<th>用户名</th>
			  							<th>密码</th>
			  							<th>手机号</th>
			  							<th>积分</th>
			  							<th>题库等级</th>
			  							<th colspan="2">操作</th>
			  						</tr>
			  					</thead>
			  					<tbody>
				  					<c:forEach varStatus="index" var="item" items="${userList}" >
					  					<tr>
				  							<td>${ index.count }</td>
				  							<td>${ item.user_id }</td>
				  							<td>${ item.username }</td>
				  							<td>${ item.password }</td>
				  							<td>${ item.mobile }</td>
				  							<td>${ item.score }</td>
				  							<td>${ item.level_id }</td>
				  							<td>
				  								<a href="/Word_Hero/User?action=saveUserData&user_id=${item.user_id}" class="manager_style_update_a">修改</a>
				  							</td>
				  							<td>
				  								<a href="/Word_Hero/User?action=deleteUser&user_id=${item.user_id}" class="manager_style_delete_a">删除</a>
				  							</td>
				  						</tr>
				  					</c:forEach>
			  					</tbody>
			  				</table>
						</div>
					</div>
				</div>
  			</div>
  		</div>
  	</div>
 </body>
</html>
