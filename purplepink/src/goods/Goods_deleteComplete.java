package goods;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.GoodsDAO;

/**
 * Servlet implementation class Goods_deleteConplete
 */
@WebServlet("/Goods_deleteComplete")
public class Goods_deleteComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String GoodsId = request.getParameter("GoodsId");

		//削除メソッドを呼び出す
		GoodsDAO.delete(GoodsId);

	       // 削除完了画面に遷移
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/JSP/goods/delete_goods/goods_delete_complete.jsp");
		dispatcher.forward(request, response);

	}

}
