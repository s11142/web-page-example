<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.GoodsBean" %>
<% GoodsBean goods = (GoodsBean)request.getAttribute("goods"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>商品管理システム</title>
</head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/user_page.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/design.css" />
	<link rel="stylesheet" href="css/Confirm.css" />
<body class="back">
	<header>
		<%@include file="/JSP/common/header.jsp"%>
	</header>
		<div class="box1">
      <h3>商品更新入力画面</h3>
        <form action="<%= request.getContextPath()%>/Goods_UpdateConfirm"
         method="post" >

<p>
					商品番号：<%= goods.getGoodsId() %>
</p>
<p>
					商品名：
				<input type="text" name="GoodsName" value="<%= goods.getGoodsName() %>" />
</p>
<p>
					値段：
				<input type="text" name="Price" value="<%= goods.getPrice() %>" />円
</p>
<p>
					カテゴリID：
				<input type="text" name="CategoryId" value="<%= goods.getCategoryId() %>" />
</p>
<p>
					仕入れ先：
				<input type="text" name="Supplier" value="<%= goods.getSupplier() %>" />
</p>
<p>
					仕入れ日時：
				<input type="text" name="StockingDate" value="<%= goods.getStockingDate() %>" />
</p>
<p>
					数量：
				<input type="text" name="Quantity" value="<%= goods.getQuantity() %>" />枚
</p>
<p>
					画像ファイル名：
				<input type="text" name="Save" value="<%= goods.getSave() %>" />
</p>
<p>
					詳細情報：
				<input type="text" name="Detail" value="<%= goods.getDetail() %>" />
</p>

				<input type="hidden" name="GoodsId" value="<%= goods.getGoodsId() %>">
				<input class="big" type="submit" value="更新">
				</form>


        <form action="<%= request.getContextPath()%>/Allgoods" method="post">
		<input class="big2" type="submit" value="戻る">
        </form></div>

</html>