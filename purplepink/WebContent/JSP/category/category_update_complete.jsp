<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/complete.css" />
<link rel="stylesheet" href="css/design.css" />
<title>カテゴリー名変更完了</title>
</head>
<body class="back">

<<header> <%@include file="/JSP/common/header.jsp"%>
	</header>
	<div class="block_a">
		<img alt="うさぎ" src="picture/rabbit2.png">
	</div>
	<div class="block_b">
		<h2>カテゴリー名変更完了画面</h2>
	<p>カテゴリー名を変更しました。</p>
	</div>

<form action="<%=request.getContextPath()%>/Return" method="post">
<input class="big2" type="submit" value="管理者専用画面へ戻る" />
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