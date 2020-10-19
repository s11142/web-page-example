<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>会員登録完了画面</title>
<link rel="stylesheet" href="css/complete.css" />
<link rel="stylesheet" href="css/design.css" />
</head>
<body class="back">
	<header>
		<%@include file="/JSP/common/header.jsp"%>
	</header>
	<div class="block_a">
		<img alt="うさぎ" src="picture/rabbit2.png">
	</div>
	<div class="block_b">
      <h3>登録完了画面</h3>
       <p>登録処理が完了しました。</p>

        </div>
<% if(log1 == null){ %>

        <form action="<%=request.getContextPath()%>/HomeServlet">
                <input class="big" type="submit" value="トップ画面へ戻る"/>
      	</form>
<% }else{ %>

		<form action="<%=request.getContextPath()%>/Return">
                <input  class="big" type="submit" value="管理者専用画面へ戻る"/>
      	</form>
<%} %>

	<div class="footer">
		<p>
			<small>&copy; purple pink</small>
		</p>
	</div>
</body>

</html>