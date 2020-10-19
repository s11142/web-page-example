<%@page import="beans.UserBean"%>
<%@page import="beans.GoodsBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%  UserBean user = (UserBean)session.getAttribute("user"); %>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/user_insert.css" />
<link rel="stylesheet" href="css/design.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/home.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/Confirm.css" />
<meta charset="UTF-8" />
<title></title>
</head>
<body class="back">
	<header>
		<%@include file="/JSP/common/header.jsp"%>
	</header>
	<div class="block_a">
		<img alt="うさぎ" src="picture/rabbit.png">
	</div>
	<div class="block_b">
		<h3>登録入力画面</h3>
		<form action="<%=request.getContextPath()%>/User_InsertConfirm"
			method="post">

			<%
String [] errorMsg = (String []) request.getAttribute("errorMessage");

if(errorMsg != null){
for(int x = 0; x < 5 ; x++){
	if (errorMsg[x] != null){
		out.println(errorMsg[x]);
}
}
}
%>


			<table>
				<tr>
					<th class="item">パスワード:</th>
					<td class="input"><input type="password" name="pass" value="" /></td>
				</tr>
				<tr>
					<th class="item">名前：</th>
					<td class="input"><input type="text" name="user_name" value="" /></td>
				</tr>
				<tr>
					<th class="item">生年月日：</th>
					<td class="input"><input type="text" name="birthday" value="" />
				</tr>
				<tr>
					<th class="item"></th>
					<td class="input">(YYYY/MM/DD)
				</tr>
				<tr>
					<th class="item">住所：</th>
					<td class="input"><input type="text" name="address" value="" />
				</tr>
				<tr>
					<th class="item">性別：</th>
					<td class="input"><input type="radio" name="gender" value="1"
						checked="checked" />男性&nbsp; <input type="radio" name="gender"
						value="2" />女性
				</tr>
				<tr>
					<th class="item">メールアドレス：</th>
					<td class="input"><input type="text" name="mail" value="" />
				</tr>
			</table>
			<% if(user == null){ %>
			<input type="hidden" name="authority" value="1" checked />
			<% } else {%>
			<% if(user.getUser_id() == 2) { %>
			<p>
				<input type="radio" name="authority" value="1" checked />会員&nbsp;  <input
					type="radio" name="authority" value="2" />運用&nbsp;<input
					type="radio" name="authority" value="3" />システム&nbsp;
			</p>
			<%} else if((user.getUser_id() == 3)) { %>
			<input type="radio" name="authority" value="1" checked />会員&nbsp; <input
					type="radio" name="authority" value="3" />システム

			<%} %>
			<%} %>

	</div>
			<input class="big" type="submit" value="登録">
		</form>

		<% if(log1 == null){ %>
		<form action="<%= request.getContextPath()%>/HomeServlet">
			<input class="big2" type="submit" value="トップ画面に戻る">
		</form>

		<% }else{ %>
		<form action="<%=request.getContextPath()%>/Admincrud" method="post">
			<input class="big2" type="submit" value="前画面へ戻る">
		</form>
	<% }%>

	<div class="footer">
		<p>
			<small>&copy; purple pink</small>
		</p>
	</div>
</html>