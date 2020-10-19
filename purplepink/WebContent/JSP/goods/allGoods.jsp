<%@page import="beans.GoodsBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

       <%
    @SuppressWarnings("unchecked")
    List<GoodsBean> goods_list = (List<GoodsBean>)
    	request.getAttribute("Goods");


    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/allGoods.css" />
<link rel="stylesheet" href="css/design.css" />
<title>Goodsの全件表示画面</title>
</head>
<body class="back">

<header>
		<%@include file="/JSP/common/header.jsp"%>
	</header>
<div class="Table">
<table border="2">
			<tr>
				<th>商品番号</th>
				<th>商品名</th>
				<th>カテゴリー名</th>
				<th>価格</th>
				<th>仕入れ先</th>
				<th>仕入れた日付</th>

			</tr>



			<%for(GoodsBean cb : goods_list){ %>
			<tr>
				<td><%=cb.getGoodsId()%></td>
				<td><%=cb.getGoodsName() %></td>
				<td><%=cb.getCategoryName() %></td>
				<td><%=cb.getPrice() %></td>
				<td><%=cb.getSupplier() %></td>
				<td><%=cb.getStockingDate() %></td>
			<td>

			<form action="<%=request.getContextPath()%>/Goods_UpdateInput" method="post">
                	<input type="hidden" name="GoodsId" value="<%=cb.getGoodsId()%>" />
                	<input type="submit" value="変更" />
             	 </form>
				</td>
				<td>
				 <form action="<%=request.getContextPath()%>/Goods_deleteConfirm" method="post">
                	<input type="hidden" name="GoodsId" value="<%=cb.getGoodsId()%>" />
                	<input type="submit" value="削除" />
             	 </form>
				</td>
			</tr>
			<%} %>
		</table>
</div>
<form action="<%=request.getContextPath()%>/AdminCategory" method="post"><input class="big" type="submit" value="カテゴリー名変更"></form>

<form action="<%=request.getContextPath()%>/Goods_InsertInput" method="post"><input class="big2" type="submit" value="商品追加"></form>

<form action="<%=request.getContextPath()%>/Return" method="post" method="post"><input  class="big3" type="submit" value="前画面に戻る"></form>
<footer>
<div class="footer">
		<p>
			<small>&copy; purple pink</small>
		</p>
	</div>
	</footer>
</body>
</html>