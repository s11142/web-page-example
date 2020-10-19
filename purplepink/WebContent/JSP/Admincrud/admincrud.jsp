<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
@SuppressWarnings("unchecked")//警告消すアノテーション
List<UserBean> user = (List<UserBean>)
request.getAttribute("userList");
%>
<%@ page import="java.util.List" %>
<%@ page import="beans.UserBean"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/Confirm.css" />
<link rel="stylesheet" href="css/design.css" />
<link rel="stylesheet" href="css/allGoods.css"/>
<title>従業員変更画面</title>
</head>
<body class="back">
<header> <%@include file="/JSP/common/header.jsp"%>
	</header>
<div class="Table">

<h2>従業員変更</h2>




      <table border="1">
        <tr>
          <th>ユーザーID</th>
          <th>従業員名</th>
          <th>誕生日</th>
          <th>性別</th>
          <th>メールアドレス</th>
          <th>住所</th>
          <th>権限</th>
          <th>更新</th>
          <th>削除</th>
        </tr>

        <tr>

        <% for (UserBean uinfo : user) { %>
        	<td><%= uinfo.getUser_id() %></td>
        	<td><%= uinfo.getUser_name() %></td>
        	<td><%= uinfo.getBirthday() %></td>
        	<td><%= uinfo.getGender() == 1 ? "男性" : "女性" %></td>
        	<td><%= uinfo.getMail() %></td>
        	<td><%= uinfo.getAddress() %></td>
        	<td><%= uinfo.getAuthority() == 2 ? "運用管理者" : "システム管理者" %></td>
			<td>
        	 <form action="<%=request.getContextPath()%>/User_UpdateInput" method="post">
                <input type="hidden" name="user_id" value="<%= uinfo.getUser_id() %>" />
                <input type="submit" value="変更" />
              </form>
            </td>
            <td>
              <form action="<%=request.getContextPath()%>/User_deleteConfirm">
                <input type="hidden" name="user_id" value="<%= uinfo.getUser_id() %>" />
                <input type="submit" value="削除"/>
              </form>
            </td>
        </tr>
        <%} %>
      </table>
      </div>
      <form action="<%=request.getContextPath()%>/Return">
                <input class="big" type="submit" value="管理者専用画面へ戻る"/>
      </form>

      <div>
		<form action="<%=request.getContextPath()%>/User_InsertInput">
               <input class="big3" type="submit" value="従業員新規登録"/>
        </form>
	</div>

<footer>
<div class="footer">
		<p>
			<small>&copy; purple pink</small>
		</p>
	</div>
	</footer>
</body>
</html>