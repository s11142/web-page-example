<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List"%>
<%@ page import="beans.GoodsBean" %>

<%
@SuppressWarnings("unchecked")
List<GoodsBean> list = (List<GoodsBean>)session.getAttribute("goodsList");
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/design.css" />
<link rel="stylesheet" href="css/cart_list.css" />
<title>買い物かご</title>

</head>
<body class="back">
<header>
	<%@include file="/JSP/common/header.jsp"%>
	</header>

<div class="tagu">
<%if(list.size()!=0){ %>
	<h2>購入確認</h2>
	<p>次の商品を購入しますか？</p>
	</div>
<%
String [] errorMsg = (String []) request.getAttribute("errorMessage");
%>

<div class="block_b">
	<form action="<%=request.getContextPath()%>/PaymentConfirm" method="post">
		<table>
				<tr>
					<th>商品ID</th>
					<th>商品名</th>
					<th>価格</th>
					<th>画像名称保存先</th>
					<th>詳細情報</th>
					<th>購入数</th>
				</tr>

 		<%
int i = 0;
		for ( GoodsBean goods : list) {
		%><tr>
			<td><%= goods.getGoodsId() %></td>
			<td><%= goods.getGoodsName() %></td>
			<td><%= goods.getPrice() %></td>
			<td><%= goods.getSave() %></td>
			<td><%= goods.getDetail() %></td>
			<td><input type="text" name="<%= goods.getGoodsId()%>" value=""></td>
<% if(errorMsg != null){ %>
			<% if(errorMsg[i] != null){

				%> <td><%= errorMsg[i] %></td>
			<%  } %>
		</tr>
			<%}i++;}  %>
		</table>
				<input class="big"   type="submit" value="決済画面へ">
	</form>
	<%}else{ %>
	<div class="block_b2">
	<h2>商品情報はありません</h2>
	<img alt="うさぎ" src="<%=request.getContextPath()%>/picture/ぴんくのうさぎ.jpg">
	</div>
	<%} %>
	</div>
	<form action="<%=request.getContextPath()%>/HomeServlet" method="post">
		<input class="big2" type="submit" value="トップ画面に戻る">
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