<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
      <h3>商品登録入力画面</h3>
        <form action="<%= request.getContextPath()%>/Goods_InsertConfirm"
         method="post" >

<%
String [] errorMsg = (String []) request.getAttribute("errorMessage");

if(errorMsg != null){
for(int x = 0; x < 5 ; x++){
	if (errorMsg[x] != null){
		out.println(errorMsg[x]);
}
}
}
%>

<p>
					商品番号：自動登録
</p>
<p>
					商品名：
				<input type="text" name="GoodsName" value="" />
</p>
<!-- エラーチェック -->
<%if(errorMsg != null){if (errorMsg[1] != null){ %>
<p class="error">
errorMsg[1]
</p>
<%}} %>

<p>
					値段：
				<input type="text" name="Price" value="" />円
</p>
<p>
					仕入れ先：
				<input type="text" name="Supplier" value="" />
</p>
<p>
					カテゴリID：
				<input type="text" name="CategoryId" value="" />
</p>
<p>
					数量：
				<input type="text" name="Quantity" value="" />枚
</p>
<p>
					画像ファイル名：
				<input type="text" name="Save" value="" />
</p>
<p>
					詳細情報：
				<input type="text" name="Detail" value="" />
</p>
				<input type="submit" value="登録">
				</form>

        <form action="<%= request.getContextPath()%>/Allgoods" method="post">
			<input class="big" type="submit" value="戻る">
        </form>
	</div>
	<div class="footer">
		<p>
			<small>&copy; purple pink</small>
		</p>
	</div>

</html>