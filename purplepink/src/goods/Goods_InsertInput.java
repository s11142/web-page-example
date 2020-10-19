package goods;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Goods_InsertInput
 */
@WebServlet("/Goods_InsertInput")
public class Goods_InsertInput extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	       // 登録情報入力画面に遷移
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/JSP/goods/insert_goods/goods_insert_input.jsp");
        dispatcher.forward(request, response);

	}




}
