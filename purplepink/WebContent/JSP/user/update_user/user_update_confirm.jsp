<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.UserBean" %>
<% UserBean user = (UserBean)request.getAttribute("user"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" href="css/complete.css" />
<link rel="stylesheet" href="css/design.css" />
<link rel="stylesheet" href="user_page.css">
<title>会員管理システム</title>
</head>
<body>
<header>
		<%@include file="/JSP/common/header.jsp"%>
	</header>

	<div class="block_b ">

      <h3>会員更新確認画面</h3>
<p>
				パスワード：<%= user.getPass() %>
</p>

<p>
				会員番号：<%= user.getUser_id() %>
</p>
<p>
				名前：<%= user.getUser_name() %>
</p>
<p>
				生年月日：<%= user.getBirthday() %>
</p>
<p>
				住所：<%= user.getAddress() %>
</p>
<p>
				性別：<%= user.getGender() == 1 ? "男性" : "女性" %>
</p>
<p>
				メールアドレス：<%= user.getMail() %>
</p>
<p>
				権限：<%= user.getAuthority() %>
</p>

</div>

<div>

        <form action="<%=request.getContextPath()%>/User_UpdateComplete"
         method="post" >
         <input type="hidden" name="pass" value="<%= user.getPass() %>">
         <input type="hidden" name="user_id" value="<%= user.getUser_id() %>">
              <input type="hidden" name="user_name" value="<%= user.getUser_name() %>">
              <input type="hidden" name="gender" value="<%= user.getGender() %>">
              <input type="hidden" name="mail" value="<%= user.getMail() %>">
              <input type="hidden" name="address" value="<%= user.getAddress() %>">
              <input type="hidden" name="birthday" value="<%= user.getBirthday() %>">
              <input type="hidden" name="authority" value="<%= user.getAuthority() %>">
              <input class="big2" type="submit" value="更新" />
        </form>
        </div>

        <div>
        <form action="<%=request.getContextPath()%>/User_UpdateInput"
         method="post">
              <input type="hidden" name="pass" value="<%= user.getPass() %>">
              <input type="hidden" name="user_id" value="<%= user.getUser_id() %>">
              <input type="hidden" name="user_name" value="<%= user.getUser_name() %>">
              <input type="hidden" name="gender" value="<%= user.getGender() %>">
              <input type="hidden" name="mail" value="<%= user.getMail() %>">
              <input type="hidden" name="address" value="<%= user.getAddress() %>">
              <input type="hidden" name="birthday" value="<%= user.getBirthday() %>">
              <input type="hidden" name="authority" value="<%= user.getAuthority() %>">
              <input type="hidden" name="res" value="1">
              <input  class="big"type="submit" value="戻る" />
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