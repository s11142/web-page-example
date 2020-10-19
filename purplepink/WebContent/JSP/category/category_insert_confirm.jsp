<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.CategoryBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/Confirm.css" />
<link rel="stylesheet" href="css/design.css" />
<title>カテゴリー情報追加確認画面</title>
</head>
<body class="back">
<header> <%@include file="/JSP/common/header.jsp"%>
	</header>
<div class="block_b">
<h2>カテゴリー情報追加確認</h2>

カテゴリー名:
<%= request.getAttribute("newcat") %>
</div>
<form action="<%=request.getContextPath()%>/Category_InsertComplete" method="post">
<input type="hidden" name="newcat"   value="<%= request.getAttribute("newcat") %>" />
<input class="big" type="submit" value="確認" />
</form>
<form action="<%=request.getContextPath()%>/Category_InsertInput" method="post">
<input class="big2" type="submit" value="戻る" />
</form>

<footer>
<div class="footer">
		<p>
			<small>&copy; purple pink</small>
		</p>
	</div>
	</footer>
</body>
</html>