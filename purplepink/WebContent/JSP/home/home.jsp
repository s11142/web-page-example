<%@page import="beans.CategoryBean"%>
<%@page import="beans.UserBean"%>
<%@page import="beans.GoodsBean"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	@SuppressWarnings("unchecked")
	List<GoodsBean> category = (List<GoodsBean>) request.getAttribute("CategoryList");

	UserBean log = (UserBean) session.getAttribute("user");
%>

<%
	@SuppressWarnings("unchecked")
	List<CategoryBean> name = (List<CategoryBean>) request.getAttribute("CategoryName");

	String top = (String) request.getAttribute("top");
	if ((top != null) || (log != null)) {
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/home.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/design.css" />
</head>
<body class="back">

	<header> <%@include file="/JSP/common/header.jsp"%>
	</header>
	<%
		if (log != null) {
				if (log.getAuthority() != 1) {
	%>
	<div>
		<%@include file="/JSP/common/adminHidden.jsp"%>
	</div>
	<%
		}
			}
	%>



	<div class="allside">
		<!-- 左サイド -->
		<div class="leftSide">
			<div class="leftUpSide">
				<h3>カテゴリー検索</h3>
				<form action="<%=request.getContextPath()%>/Category" method="post">

					<select name="CategoryId">
						<%
							int i = 1;
						%>
						<%
							for (CategoryBean bb : name) {
						%>

						<option value="<%=i%>"><%=bb.getCategory_name()%></option>

						<%
							i++;
								}
						%><option value="all">すべて</option>
					</select> <input type="submit" value="選択">
				</form>

			</div>
			<div class="leftDownSide">
				<h3>価格帯別検索</h3>
				<form action="<%=request.getContextPath()%>/Price" method="post">
					<select name="price">
						<option value="1">100円～1000円</option>
						<option value="2">1000円～1100円</option>
						<option value="3">1100円～2000円</option>
						<option value="4">2000円～4000円</option>
						<option value="5">すべて</option>
					</select> <input type="submit" value="選択">
				</form>
			</div>
		</div>

		<!-- 中央 -->
		<div class="center">
			<table class="tableArea" id="makeImg" border="2">
				<tr>
					<th>カテゴリー名</th>
					<th>商品名</th>
					<th>価格</th>
					<th>仕入れ先</th>
					<th>仕入れ日</th>
					<th></th>
					<th></th>

				</tr>
				<!-- GoodsBeanから情報を取ってくる -->
				<%
					for (GoodsBean cb : category) {
				%>
				<tr>
					<td><%=cb.getCategoryName()%></td>
					<td><%=cb.getGoodsName()%></td>
					<td><%=cb.getPrice()%>円</td>
					<td><%=cb.getSupplier()%></td>
					<td><%=cb.getStockingDate()%></td>
					<td>
						<form action="<%=request.getContextPath()%>/Goods_page">
							<input type="hidden" name="goodsId" value="<%=cb.getGoodsId()%>" />
							<input type="submit" value="詳細" />
						</form>
					</td>
					<%
						if (log != null) {
					%>
					<td>
						<form action="<%=request.getContextPath()%>/GoodsAdd"
							method="post">
							<input type="hidden" name="goodsId" value="<%=cb.getGoodsId()%>" />
							<input type="submit" value="買い物かご" />
						</form>
					</td>
					<%
						}
					%>
				</tr>
				<%
					}
				%>
			</table>


		</div>

		<!-- 右サイド -->
		<div class="rightSide">
			<div class="rightUpSide">
				<a href="<%=request.getContextPath()%>/ShoppingCart"> <img
					alt="買い物カゴ"
					src="<%=request.getContextPath()%>/picture/kaimono1.png">
				</a>
			</div>
			<div class="rightDownSide">
				<%
					if (log == null) {
				%>
				<div class="rightDownUpSide">
					<form action="<%=request.getContextPath()%>/User_InsertInput"
						method="get">
						<input type="submit" value="新規登録" name="">
					</form>
				</div>

				<div class="rightDownCenterSide">
					<form action="<%=request.getContextPath()%>/LoginServlet">
						<input type="submit" value="ログイン" name="">
					</form>
				</div>

				<%
					}
				%>
				<%
					if (log == null) {
				%>
				<div>
					<p>
					<form action="<%=request.getContextPath()%>/User_InsertInput"
						method="get">
						<input type="submit" value="ようこそゲストさん">
					</form>
					</p>
				</div>
				<%
					} else {
				%>
				<!-- ヘッダーの部分だからいらないかも -->
				<div>
					<p>
					<form action="<%=request.getContextPath()%>/User_Mypage"
						method="post">
						<input type="hidden" name="user_id" value="<%=log.getUser_id()%>">
						<input type="submit" value="マイページ">
					</form>
					</p>
				</div>
				<%
					}
				%>

			</div>
		</div>
	</div>
	<footer> <%@include file="../common/footer.jsp"%>
	</footer>
</body>
</html>
<%
	} else {
		RequestDispatcher rd = request.getRequestDispatcher("/Home00");
		rd.forward(request, response);

	}
%>