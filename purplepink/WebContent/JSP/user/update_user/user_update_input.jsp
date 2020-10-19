<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="beans.UserBean"%>
<%
	UserBean user = (UserBean) request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>会員管理システム</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/home.css" />
<link rel="stylesheet" href="css/user_page.css" />
<link rel="stylesheet" href="css/design.css" />
<link rel="stylesheet" href="css/Confirm.css" />
</head>
<body>
	<header>
		<%@include file="/JSP/common/header.jsp"%>
	</header>
	<div class="box1">
		<h3>会員更新入力画面</h3>
		<form action="<%=request.getContextPath()%>/User_UpdateConfirm"
			method="post">
			<%
				String[] errorMsg = (String[]) request.getAttribute("errorMessage");

				if (errorMsg != null) {
					for (int x = 0; x < 5; x++) {
						if (errorMsg[x] != null) {
							out.println(errorMsg[x]);
						}
					}
				}
			%>
			<p>
				パスワード： <input type="password" name="pass"
					value="<%=user.getPass()%>" />
			</p>
			<p>
				会員番号：<%=user.getUser_id()%>
				<input type="hidden" name="user_id" value="<%=user.getUser_id()%>" />
			</p>
			<p>
				名前： <input type="text" name="user_name"
					value="<%=user.getUser_name()%>" />
			</p>
			<p>
				生年月日 <input type="text" name="birthday"
					value="<%=user.getBirthday()%>" />(YYYY/MM/DD)
			</p>
			<p>
				住所 <input type="text" name="address"
					value="<%=user.getAddress()%>" />
			</p>
			<p>
				性別 <input type="radio" name="gender" value="1"
					checked="<%=user.getGender()%>" />男性&nbsp; <input type="radio"
					name="gender" value="2" checked="<%=user.getGender()%>" />女性
			</p>
			<p>
				メールアドレス <input type="text" name="mail" value="<%=user.getMail()%>" />
			</p>
	</div>
	<p>
	<div class="box2">

		権限

		<%if(log1.getAuthority()==1){ %>
				<input type="radio" name="authority" value="1" <%if(user.getAuthority()==1){ %> checked<%} %>/>会員&nbsp;
<%}else if(log1.getAuthority()==2){ %>
				<input type="radio" name="authority" value="1" <%if(user.getAuthority()==1){ %> checked<%} %>/>会員&nbsp;
				<input type="radio" name="authority" value="2" <%if(user.getAuthority()==2){ %> checked<%} %>  />運用者&nbsp;
				<input type="radio" name="authority" value="3" <%if(user.getAuthority()==3){ %> checked<%} %>   />システム管理者
<%}else if (log1.getAuthority()==3){%>
	<%if(user.getAuthority()==2){ %>
		<input type="radio" name="authority" value="2" <%if(user.getAuthority()==2){ %> checked<%} %>  />運用者&nbsp;
	<%}else if (user.getAuthority()==3){%>
				<input type="radio" name="authority" value="1" <%if(user.getAuthority()==1){ %> checked<%} %>/>会員&nbsp;
				<input type="radio" name="authority" value="3" <%if(user.getAuthority()==3){ %> checked<%} %>   />システム管理者
<%}} %>
		</p>


		<input class="big" type="submit" value="更新">
		</form>

		<%
			if (log1.getAuthority() == 1) {
		%>
		<form action="<%=request.getContextPath()%>/User_Mypage"
			method="post">
			<input type="hidden" name="user_id" value="<%=user.getUser_id()%>">
			<input  class="big1" type="submit" value="戻る">
		</form>

		<%
			} else {
		%>
		<form action="<%=request.getContextPath()%>/Admincrud" method="post">
			<input class="big2" type="submit" value="戻る">
		</form>
	</div>

	<%
		}
	%>
	<div class="footer">
		<p>
			<small>&copy; purple pink</small>
		</p>
	</div>
</html>