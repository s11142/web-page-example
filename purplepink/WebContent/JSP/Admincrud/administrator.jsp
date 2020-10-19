<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理者閲覧画面</title>
</head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/user_page.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/design.css" />
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/admincrud.css" />
<body class="back">
<header>
		<%@include file="/JSP/common/header.jsp"%>
</header>
<div class="box1">
<h3>管理者専用画面</h3>

<h4>利用したい機能を選択して下さい</h4>


従業員変更
<form action="<%=request.getContextPath()%>/Admincrud" method="post">
<input class="big1" type="submit" value="利用">
</form>

<%if(log1.getAuthority()==2){ %>
商品情報変更
<form action="<%=request.getContextPath()%>/Allgoods" method="post">
<input class="big2" type="submit" value="利用">
</form>
<% }%>

ログアウト
<form action="<%=request.getContextPath()%>/LogoutServlet" method="post">
<input class="big3" type="submit" value="ログアウト">
</form>
</div>
<div class="footer">
	<p>
		<small>&copy; purple pink</small>
	</p>
</div>
</body>
</html>