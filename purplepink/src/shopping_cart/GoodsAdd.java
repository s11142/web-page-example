package shopping_cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.GoodsBean;
import daos.GoodsDAO;

/**
 * Servlet implementation class GoodsAdd
 */
@WebServlet("/GoodsAdd")
public class GoodsAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // セッションを利用する準備
        HttpSession session = request.getSession(false);

		//商品IDを保持
		String GoodsId = request.getParameter("goodsId");

		//買い物かごセッションスコープを設定
		@SuppressWarnings("unchecked")
		List<GoodsBean>goodsList = (List<GoodsBean>) session.getAttribute("goodsList");

		//商品の詳細情報を取得
		GoodsBean goods = GoodsDAO.findGoods(GoodsId);

		//商品を買いものリストに追加
		goodsList.add(goods);


        //買い物かごに保持する商品IDのリストをセット
        session.setAttribute("goodsList",goodsList );


        //トップ画面に遷移
		RequestDispatcher rd = request.getRequestDispatcher("/HomeServlet");
			rd.forward(request, response);

	}

}
