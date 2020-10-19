<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.GoodsBean" %>
<% GoodsBean goods = (GoodsBean)request.getAttribute("goods"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>商品管理システム</title>
<link rel="stylesheet" href="css/Confirm.css" />
<link rel="stylesheet" href="css/design.css" />
</head>
<body class="back">
<header> <%@include file="/JSP/common/header.jsp"%>
	</header>
<div class="block_b">
      <h3>商品更新確認画面</h3>
<p>
				商品番号：<%= goods.getGoodsId() %>
</p>
<p>
				商品名：<%= goods.getGoodsName() %>

</p>
<p>
				値段：<%= goods.getPrice() %>円

</p>
<p>
				仕入れ先：<%= goods.getSupplier() %>

</p>
<p>
				カテゴリ：<%= goods.getCategoryId() %>

</p>
<p>
				仕入れ時間：<%= goods.getStockingDate() %>
</p>

<p>
				数量：<%= goods.getQuantity() %>枚
</p>
<p>
				画像ファイル名：<%= goods.getSave() %>
</p>
<p>
				詳細情報：<%= goods.getDetail() %>
</p>

</div>

        <form action="<%=request.getContextPath()%>/Goods_UpdateComplete"
         method="post" >
              <input type="hidden" name="GoodsId" value="<%= goods.getGoodsId() %>">
              <input type="hidden" name="GoodsName" value="<%= goods.getGoodsName() %>">
              <input type="hidden" name="Price" value="<%= goods.getPrice() %>">
              <input type="hidden" name="Supplier" value="<%= goods.getSupplier() %>">
              <input type="hidden" name="CategoryId" value="<%= goods.getCategoryId() %>">
              <input type="hidden" name="StockingDate" value="<%= goods.getStockingDate() %>">
              <input type="hidden" name="Quantity" value="<%= goods.getQuantity() %>">
              <input type="hidden" name="Save" value="<%= goods.getSave() %>">
              <input type="hidden" name="Detail" value="<%= goods.getDetail() %>">
              <input class="big" type="submit" value="登録" />
        </form>
        <form action="<%=request.getContextPath()%>/Goods_UpdateInput"
         method="post">
			  <input type="hidden" name="GoodsId" value="<%= goods.getGoodsId() %>">
              <input type="hidden" name="GoodsName" value="<%= goods.getGoodsName() %>">
              <input type="hidden" name="Price" value="<%= goods.getPrice() %>">
              <input type="hidden" name="Supplier" value="<%= goods.getSupplier() %>">
              <input type="hidden" name="CategoryId" value="<%= goods.getCategoryId() %>">
              <input type="hidden" name="StockingDate" value="<%= goods.getStockingDate() %>">
              <input type="hidden" name="Quantity" value="<%= goods.getQuantity() %>">
              <input type="hidden" name="Save" value="<%= goods.getSave() %>">
              <input type="hidden" name="Detail" value="<%= goods.getDetail() %>">
              <input class="big2" type="submit" value="戻る" />
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