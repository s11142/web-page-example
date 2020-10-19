package goods;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.GoodsBean;
import daos.GoodsDAO;

/**
 * Servlet implementation class Allgoods
 */
@WebServlet("/Allgoods")
public class Allgoods extends HttpServlet {
	private static final long serialVersionUID = 1L;




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Goods全件の値を取得

		List<GoodsBean> all_goods =  GoodsDAO.AllFind();



		//スコープに値を保持
		request.setAttribute("Goods", all_goods);

		//フォワード処理
		RequestDispatcher rd = request.getRequestDispatcher("/JSP/goods/allGoods.jsp");
		rd.forward(request, response);

	}

}
