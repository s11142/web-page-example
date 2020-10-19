<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.UserBean" %>
<% UserBean user = (UserBean)request.getAttribute("user"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>会員管理システム</title>

<link rel="stylesheet" href="css/Confirm.css" />
<link rel="stylesheet" href="css/design.css" />
</head>
<body class="back">
<header> <%@include file="/JSP/common/header.jsp"%>
	</header>
<div class="block_b">
      <h3>会員削除確認画面</h3>
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
				住所：<%= user.getAddress() %>

</p>
<p>
				性別：<%= user.getGender()  == 1 ? "男性" : "女性" %>

</p>
<p>
				生年月日：<%= user.getBirthday() %>

</p>
<p>
				メールアドレス：<%= user.getMail() %>

</p>
<p>
				権限：<%= user.getAuthority() %>

</p>

</div>
<% if(log1.getAuthority()==1){ %>
        <form action="<%=request.getContextPath()%>/User_deleteComplete"
         method="post" >
              <input type="hidden" name="user_id" value="<%= user.getUser_id() %>">
              <input  class="big" type="submit" value="退会" />
        </form>
        <% }else{ %>
         <form action="<%=request.getContextPath()%>/User_deleteComplete"
         method="post" >
              <input type="hidden" name="user_id" value="<%= user.getUser_id() %>">
              <input  class="big" type="submit" value="削除" />
        </form>
        <%} %>
 <% if(log1.getAuthority()==1){ %>
        <form action="<%=request.getContextPath()%>/User_Mypage"
         method="post">
<input type="hidden" name="user_id" value="<%= user.getUser_id() %>">
              <input class="big2" type="submit" value="戻る" />
        </form>
        <% }else{ %>
		<form action="<%=request.getContextPath()%>/Admincrud" method="post">
 		<input class="big2" type="submit" value="戻る">
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