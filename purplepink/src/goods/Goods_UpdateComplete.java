package goods;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.GoodsBean;
import daos.GoodsDAO;

/**
 * Servlet implementation class Goods_UpdateComplete
 */
@WebServlet("/Goods_UpdateComplete")
public class Goods_UpdateComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String GoodsId = request.getParameter("GoodsId");
		String GoodsName = request.getParameter("GoodsName");
		String Price = request.getParameter("Price");
		String Supplier = request.getParameter("Supplier");
		String CategoryId = request.getParameter("CategoryId");
		String Quantity = request.getParameter("Quantity");
		String StockingDate = request.getParameter("StockingDate");
		String Save = request.getParameter("Save");
		String Detail = request.getParameter("Detail");


		//新規登録内容をインスタンス化
		GoodsBean goods = new GoodsBean();
		goods.setGoodsId(Integer.parseInt(GoodsId));
		goods.setGoodsName(GoodsName);
		goods.setPrice(Integer.parseInt(Price));
		goods.setSupplier(Supplier);
		goods.setCategoryId(Integer.parseInt(CategoryId));
		goods.setStockingDate(StockingDate);
		goods.setQuantity(Integer.parseInt(Quantity));
		goods.setSave(Save);
		goods.setDetail(Detail);

		//更新メソッドを呼び出す
		GoodsDAO.update(goods);


	       // 更新情報完了画面に遷移
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/JSP/goods/update_goods/goods_update_complete.jsp");
		dispatcher.forward(request, response);

	}

}
