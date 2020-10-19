<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
<%@ page import="beans.OrderBean" %>
<%@ page import="beans.UserBean" %>
<%
UserBean log = (UserBean)session.getAttribute("user");//ログイン者
List<OrderBean> orderList  = (List<OrderBean>)session.getAttribute("orderList");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/Confirm.css" />
<link rel="stylesheet" href="css/design.css" />
<title>決済画面</title>
</head>
<body>

	<h1><%= log.getUser_name() %>さんの決済画面です</h1>

<div class="block_b">
	<h2>購入商品伝票の確認</h2>
		<table>
				<tr>
					<th>商品ID</th>
					<th>商品名</th>
					<th>数量</th>
				</tr>

 		<%
		for ( OrderBean order : orderList) {
		%><tr>
			<td><%= order.getGoodsId() %></td>
			<td><%= order.getGoodsName() %></td>
			<td><%= order.getOrder_quantity() %></td>
		</tr>
			<%} %>
		</table>
</div>
			<h2>決済方法の選択</h2>
		<form action="<%=request.getContextPath()%>/PaymentComplete" method="post">
                <input type="radio" name="result" value="1" checked />クレジットカード&nbsp;
                <input type="radio" name="result" value="2" />銀行振り込み&nbsp;
                <input type="radio" name="result" value="3" />着払い&nbsp;
                <input type="radio" name="result" value="4" />電子マネー&nbsp;
                <input type="radio" name="result" value="5" />コンビニ決済&nbsp;

				<input type="submit" value="決済完了画面へ">
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