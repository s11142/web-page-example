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

      <h3>商品削除確認画面</h3>

<p>
				商品番号：<%= goods.getGoodsId() %>
</p>
<p>
				商品名：<%= goods.getGoodsName() %>
</p>
<p>
				値段：<%= goods.getPrice() %>
</p>
<p>
				仕入れ先：<%= goods.getSupplier() %>
</p>
<p>
				カテゴリ：<%= goods.getCategoryId() %>

</p>
<p>
				仕入れ時間：<%= goods.getQuantity() %>
</p>
</div>
        <form action="<%=request.getContextPath()%>/Goods_deleteComplete" method="post" >
              <input type="hidden" name="GoodsId" value="<%= goods.getGoodsId() %>">
              <input class="big" type="submit" value="削除" />
        </form>
        <form action="<%=request.getContextPath()%>/Allgoods" method="post">

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