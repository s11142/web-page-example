<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.CategoryBean" %>
<%CategoryBean newcat = (CategoryBean) request.getAttribute("newcat"); %>
<%CategoryBean oldcat = (CategoryBean) request.getAttribute("oldBean"); %>
<%String error = (String)request.getAttribute("errorMessage"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/user_page.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/design.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>カテゴリー名変更</title>
</head>
<body class="back">
	<header>
		<%@include file="/JSP/common/header.jsp"%>
	</header>
	<div class="box1">
<h2>カテゴリー名変更画面</h2>

<%
if (error != null){
out.println(error);
} else {
out.println("");
}
%>
現在のカテゴリー名
<%=oldcat.getCategory_name() %>
<p></p>
<form action="<%=request.getContextPath()%>/Category_UpdateConfirm" method="post">
<input type="text" name="newcatname" value="" />
<input type="hidden" name="oldcatname" value="<%= newcat.getCategory_name() %>" />
<input type="hidden" name="oldcatid" value="<%= newcat.getCategory_id() %>" />
<input type="submit" value="名前変更" />
</form>

<form action="<%=request.getContextPath()%>/AdminCategory" method="post">
<input type="submit" value="戻る" />
</form>
</div>
	<div class="footer">
		<p>
			<small>&copy; purple pink</small>
		</p>
	</div>
</body>
</html>