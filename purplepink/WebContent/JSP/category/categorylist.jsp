<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
@SuppressWarnings("unchecked")//警告消すアノテーション
List<CategoryBean> cat = (List<CategoryBean>)
request.getAttribute("categoryList");
%>
<%@ page import="java.util.List" %>
<%@ page import="beans.CategoryBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/user_page.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/design.css" />
<link rel="stylesheet" href="css/allGoods.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>カテゴリー変更画面</title>
</head>
<body class="back">
	<header>
		<%@include file="/JSP/common/header.jsp"%>
	</header>
	<div class="box1">
<h2>カテゴリー変更画面</h2>

      <table border="1">
        <tr>
          <th>カテゴリーID</th>
          <th>カテゴリー名</th>
        </tr>

        <tr>

        <% for (CategoryBean catinfo : cat) { %>
        	<td><%= catinfo.getCategory_id() %></td>
        	<td><%= catinfo.getCategory_name() %></td>
			<td>
				<form action="<%=request.getContextPath()%>/Category_UpdateInput" method="post">
				<input type="hidden" name="catname" value="<%= catinfo.getCategory_name() %>"/>
				<input type="hidden" name="catid" value="<%= catinfo.getCategory_id() %>"/>
				<input type="submit" value="名前変更" />
				</form>
            </td>
        </tr>
        <%} %>
      </table>
</div>

<form action="<%=request.getContextPath()%>/Category_InsertInput" method="post">
<input class="big2"  type="submit" value="新規カテゴリー追加ボタン" />
</form>

      <form action="<%=request.getContextPath()%>/Return" method="post">
<input class="big3" type="submit" value="管理者専用画面へ戻る" />
</form>

	<div class="footer">
		<p>
			<small>&copy; purple pink</small>
		</p>
	</div>
</body>
</html>