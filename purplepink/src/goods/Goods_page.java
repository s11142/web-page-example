package goods;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CategoryBean;
import beans.GoodsBean;
import daos.CategoryDao;
import daos.GoodsDAO;

/**
 * Servlet implementation class Goods_page
 */
@WebServlet("/Goods_page")
public class Goods_page extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//商品IDを保持(繋がるまで「1」で固定)
		String GoodsId = request.getParameter("goodsId");

		//商品の詳細情報を取得・リクエストスコープに挿入
		GoodsBean goods = GoodsDAO.findGoods(GoodsId);

		CategoryBean cb = CategoryDao.findById(goods.getCategoryId());

		request.setAttribute("categoryname", cb);

		request.setAttribute("goods", goods);


	      //商品詳細ページに遷移
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/JSP/goods/goods_page.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
