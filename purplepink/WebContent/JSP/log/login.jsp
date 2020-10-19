<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン</title>
</head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/login.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/design.css" />
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/user_page.css" />
		<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/Confirm.css" />
<body class="back">
	<header> <%@include file="/JSP/common/header.jsp"%>
	</header>
	<div class="box1">
		<h3>ログイン画面</h3>

		<%
			String errorMsg = (String) request.getAttribute("errorMessage");
			if (errorMsg != null) {
				out.println(errorMsg);
			}
		%>

		<form action="<%=request.getContextPath()%>/LoginServlet"
			method="post">
			<p>メールアドレス</p>
			<input type="text" name="ID">
			<p>パスワード</p>
			<input type="password" name="Pass">
			<p></p>
			<input class="big" type="submit" value="ログイン" />

		</form>
	</div>
	<footer> <%@include file="../common/footer.jsp"%>
	</footer>
</body>

</body>
</html>