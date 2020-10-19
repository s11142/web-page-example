<%@page import="beans.CategoryBean"%>
<%@page import="beans.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.GoodsBean" %>
<%@page import="java.util.List"%>
<% GoodsBean goods = (GoodsBean)request.getAttribute("goods");

    UserBean log = (UserBean) session.getAttribute("user");
%>
<%
@SuppressWarnings("unchecked")
List<GoodsBean> category = (List<GoodsBean>)
    	request.getAttribute("CategoryList");

CategoryBean cb = (CategoryBean) request.getAttribute("categoryname");
%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/home.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/design.css" />
<link rel="stylesheet" href="css/detail.css">
<title>商品詳細ページ</title>
</head>
<body class="back">
	<header>
		<%@include file="/JSP/common/header.jsp" %>
	</header>
<div class="picture">
<p>
<img alt="画像"  src="<%=request.getContextPath() %>/picture/<%= goods.getSave() %>" height="500" width="500"/>
</p>
</div>
<div>
<div class="picture box">
<h2><%= goods.getGoodsName() %>商品の情報</h2>

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
				カテゴリー名：<%= cb.getCategory_name() %>

</p>
<p>
				仕入れ日：<%= goods.getStockingDate() %>
</p>

<p>
				数量：<%= goods.getQuantity() %>枚
</p>
<p>
				詳細情報：<%= goods.getDetail() %>
</p>

</div>
</div>
<%if(log != null) {%>
<form action="<%=request.getContextPath()%>/GoodsAdd" method="post">
   <input type="hidden" name="goodsId" value="<%= goods.getGoodsId() %>">
<input class="b" type="submit" value="買い物かごに追加">
</form>
<% }%>

		<form action="<%=request.getContextPath()%>/HomeServlet" method="get">
			<input type="submit" class="big" value="トップ画面に戻る">
		</form>

<%if(log != null) {%>
<% if(log.getAuthority() ==2){ %>
<form action="<%=request.getContextPath()%>/Goods_UpdateInput" method="post">
   <input type="hidden" name="GoodsId" value="<%= goods.getGoodsId() %>">
<input type="submit" value="更新">
</form>
<form action="<%=request.getContextPath()%>/Goods_deleteConfirm" method="post">
   <input type="hidden" name="GoodsId" value="<%= goods.getGoodsId() %>">
<input type="submit" value="削除">
</form>
<%} }%>
<footer>
 <div class="footer">
	<p><small>&copy; purple pink</small></p>
</div>
</footer>
</body>
</html>