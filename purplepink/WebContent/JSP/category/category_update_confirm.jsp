<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.CategoryBean" %>
<%CategoryBean newcat = (CategoryBean) request.getAttribute("newcat"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/Confirm.css" />
<link rel="stylesheet" href="css/design.css" />
<title>カテゴリー名変更確認</title>
</head>
<body class="back">
<header> <%@include file="/JSP/common/header.jsp"%>
	</header>
<div class="block_b">

<h2>カテゴリー名変更確認画面</h2>

新しいカテゴリー名
<%= newcat.getCategory_name() %>
</div>
<form action="<%=request.getContextPath()%>/Category_UpdateComplete" method="post">
<input type="hidden" name="newcatname" value="<%= newcat.getCategory_name() %>" />
<input type="hidden" name="oldcatid" value="<%= newcat.getCategory_id() %>" />
<input  class="big" type="submit" value="確認" />
</form>

<form action="<%=request.getContextPath()%>/Category_UpdateInput" method="post">
<input type="hidden" name="catname" value="catname"/>
<input type="hidden" name="catid" value="<%= newcat.getCategory_id() %>"/>
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