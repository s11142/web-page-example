package goods;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.GoodsBean;
import daos.GoodsDAO;

/**
 * Servlet implementation class Goods_InsertComplete
 */
@WebServlet("/Goods_InsertComplete")
public class Goods_InsertComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String GoodsName = request.getParameter("GoodsName");
		String Price = request.getParameter("Price");
		String Supplier = request.getParameter("Supplier");
		String CategoryId = request.getParameter("CategoryId");
		String Quantity = request.getParameter("Quantity");
		String Save = request.getParameter("Save");
		String Detail = request.getParameter("Detail");


		//現在日時の取得
		Date day = new Date();
		SimpleDateFormat v02 = new SimpleDateFormat("yyyy/MM/dd");
		//現在の日時を仕入れ時間に代入する
		String StockingDate = v02.format(day);


		//新規登録内容をインスタンス化
		GoodsBean goods = new GoodsBean();
		goods.setGoodsName(GoodsName);
		goods.setPrice(Integer.parseInt(Price));
		goods.setSupplier(Supplier);
		goods.setCategoryId(Integer.parseInt(CategoryId));
		goods.setStockingDate(StockingDate);
		goods.setQuantity(Integer.parseInt(Quantity));
		goods.setSave(Save);
		goods.setDetail(Detail);


		//商品新規登録メソッドを呼び出す
		GoodsDAO.insert(goods);

       // 登録完了画面に遷移
  RequestDispatcher dispatcher = request
          .getRequestDispatcher("/JSP/goods/insert_goods/goods_insert_complete.jsp");
  dispatcher.forward(request, response);

	}

}
