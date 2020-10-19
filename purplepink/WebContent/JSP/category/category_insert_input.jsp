<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String error = (String)request.getAttribute("errorMessage"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/design.css" />
	<link rel="stylesheet" href="css/Confirm.css" />
<title>カテゴリー情報追加</title>
</head>
<body class="back">
<header>
		<%@include file="/JSP/common/header.jsp"%>
	</header>
	<div class="block_b">
<h2>カテゴリー情報追加(新規登録)</h2>
<%
if (error != null){
out.println(error);
} else {
out.println("");
}
%>

<form action="<%=request.getContextPath()%>/Category_InsertConfirm" method="post">
<input type="text" name="newcat" value="">
<input type="submit" value="カテゴリー登録" />
</form></div>

<form action="<%=request.getContextPath()%>/AdminCategory" method="post">
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