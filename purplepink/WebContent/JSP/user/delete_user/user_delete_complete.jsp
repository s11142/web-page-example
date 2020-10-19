<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>会員削除完了画面</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/home.css" />
<link rel="stylesheet"href="<%=request.getContextPath()%>/css/design.css" />
<link rel="stylesheet" href="css/complete.css" />
</head>
<body class="back">
	<header>
		 <%@include file="/JSP/common/header.jsp"%>
	</header>
<div class="block_a">
		<img alt="うさぎ" src="picture/rabbit2.png">
	</div>
	<div class="block_b">
      <h3>削除完了画面</h3>
              <p>会員削除処理が完了しました。</p>

               </div>
<% if(log1.getAuthority()==1){ %>

        <form action="<%=request.getContextPath()%>/LogoutServlet" method="post">
                <input class="big" type="submit" value="トップ画面へ戻る"/>
      	</form>

<% }else{ %>
		<form action="<%=request.getContextPath()%>/Return">
                <input class="big" type="submit" value="管理者専用画面へ戻る"/>
      	</form>

<%} %>


 <footer>
<div class="footer">
		<p>
			<small>&copy; purple pink</small>
		</p>
	</div>
	</footer>
</body>

</html>