<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="beans.UserBean"%>
<%
	UserBean log = (UserBean) session.getAttribute("user");//ログイン者
	UserBean user = (UserBean) request.getAttribute("user");//マイページ情報
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/user_page.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/design.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>マイページ</title>
</head>
<body class="back">
	<header>
		<%@include file="/JSP/common/header.jsp"%>
	</header>
	<div class="box1">
		<h1><%=user.getUser_name()%>さんのマイページです
		</h1>
		<h2>あなたの登録情報</h2>
		<p>
			パスワード：非表示<% user.getPass(); %>
		</p>

		<p>
			会員番号：<%=user.getUser_id()%>
		</p>
		<p>
			名前：<%=user.getUser_name()%>
		</p>
		<p>
			住所:<%=user.getAddress()%>
		</p>
		<p>
			性別:<%=user.getGender()  == 1 ? "男性" : "女性" %>
		</p>
		<p>
			メールアドレス:<%=user.getMail()%>
		</p>
	</div>
	<div class="box2">
		<form action="<%=request.getContextPath()%>/User_UpdateInput"
			method="post">
			<input type="hidden" value="<%=user.getUser_id()%>" name="user_id">
			<input type="submit" value="更新">
		</form>
		<form action="<%=request.getContextPath()%>/User_deleteConfirm"
			method="post">
			<input type="hidden" value="<%=user.getUser_id()%>" name="user_id">
			<input type="submit" value="退会">
		</form>


		<form action="<%=request.getContextPath()%>/HomeServlet">

		<input type="submit" value="戻る">
		</form>
	</div>
	<div class="footer">
		<p>
			<small>&copy; purple pink</small>
		</p>
	</div>
</body>

</html>