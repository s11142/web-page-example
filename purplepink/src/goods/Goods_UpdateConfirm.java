package goods;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.GoodsBean;
import check.Check;

/**
 * Servlet implementation class Goods_UpdateConfirm
 */
@WebServlet("/Goods_UpdateConfirm")
public class Goods_UpdateConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String GoodsId = request.getParameter("GoodsId");
		String GoodsName = request.getParameter("GoodsName");
		String Price = request.getParameter("Price");
		String Supplier = request.getParameter("Supplier");
		String CategoryId = request.getParameter("CategoryId");
		String StockingDate = request.getParameter("StockingDate");
		String Quantity = request.getParameter("Quantity");
		String Save = request.getParameter("Save");
		String Detail = request.getParameter("Detail");

		//エラーメッセージの受け取り
		String error0 = null;
		String error1 = null;
		String error2 = null;
		String error3 = null;
		String error4 = null;
		String error5 = null;
		String error6 = null;


		error0 = Check.gnamecheck(GoodsName);
		error1 = Check.pricecheck(Price);
		error2 = Check.suppliercheck(Supplier);
		error3 = Check.catidcheck(CategoryId);
		error4 = Check.stockcheck(Quantity);
		error5 = Check.savecheck(Save);
		error6 = Check.detailcheck(Detail);

		String[] errorAll = {error0,error1,error2,error3,error4,error5,error6};


		if ((errorAll[0] != null) || (errorAll[1] != null) || (errorAll[2] != null)
				|| (errorAll[3] != null) || (errorAll[4] != null) || (errorAll[5] != null) || (errorAll[6] != null)){

			request.setAttribute("errorMessage", errorAll);

			GoodsBean goods = new GoodsBean();
			goods.setGoodsId(Integer.parseInt(GoodsId));
			goods.setGoodsName(GoodsName);
			if(Price.length() == 0){
				goods.setPrice(0);
			}else{
				goods.setPrice(Integer.parseInt(Price));
				}
			goods.setSupplier(Supplier);
			if(CategoryId.length() == 0){
				goods.setPrice(0);
			}else{
				goods.setCategoryId(Integer.parseInt(CategoryId));
				}
			goods.setStockingDate(StockingDate);

			if(Quantity.length() == 0){
				goods.setPrice(0);
			}else{
				goods.setCategoryId(Integer.parseInt(Quantity));
				}

			goods.setSave(Save);
			goods.setDetail(Detail);

			request.setAttribute("goods", goods);

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/JSP/goods/update_goods/goods_update_input.jsp");
			dispatcher.forward(request, response);


		} else {

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

			request.setAttribute("goods", goods);

			// 情報確認画面に遷移
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/JSP/goods/update_goods/goods_update_confirm.jsp");
			dispatcher.forward(request, response);
		}

	}

}

