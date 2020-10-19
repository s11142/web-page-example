<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" href="css/complete.css" />
<link rel="stylesheet" href="css/design.css" />
<title>商品管理システム</title>
</head>
<body class="back">

<header>
	<%@include file="/JSP/common/header.jsp"%>
	</header>
	<div class="block_a">
		<img alt="うさぎ" src="picture/rabbit2.png">
	</div>
	<div class="block_b">
      <h3>削除完了画面</h3>

        <p>商品削除処理が完了しました。</p>
       </div>

<div>
        <form action="<%=request.getContextPath()%>/Return">
        <input class="big" type="submit" value="管理者専用画面へ戻る">
        </form>
        </div>
<footer>
<div class="footer">
		<p>
			<small>&copy; purple pink</small>
		</p>
	</div>
	</footer>
</body>

</html>