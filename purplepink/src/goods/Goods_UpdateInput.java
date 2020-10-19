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
 * Servlet implementation class Goods_UpdateInput
 */
@WebServlet("/Goods_UpdateInput")
public class Goods_UpdateInput extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	   	String GoodsId = request.getParameter("GoodsId");

	  //商品IDから全件検索
	   GoodsBean goods = GoodsDAO.findGoods(GoodsId);

    	request.setAttribute("goods", goods);

        // 更新情報入力画面に遷移
        RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/goods/update_goods/goods_update_input.jsp");
        dispatcher.forward(request, response);
	}

}
