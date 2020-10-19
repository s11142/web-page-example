<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.UserBean" %>

<%
    UserBean log1 = (UserBean)session.getAttribute("user");
%>
<div class="yoko">
	<div class="header">
		<div class="header_name">
		<a href="<%=request.getContextPath()%>/Home00" class="header_name">ぱーぷるぴんく</a>
		</div>
	<%if(log1 != null ){ %>
		<div class="header_name">
		ようこそ、<%=log1.getUser_name() %>さん
	</div>
	<div class="logout">
			<form action="<%=request.getContextPath()%>/LogoutServlet" method="post">
			<input type="submit" value="ログアウト" name="" class="logout">
			</form>
	</div>
	<%} %>
	</div>
</div>