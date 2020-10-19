package category;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Category_InsertInput
 */
@WebServlet("/Category_InsertInput")
public class Category_InsertInput extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// カテゴリー新規登録(カテゴリー情報追加)画面へ画面遷移を行う
        RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/category/category_insert_input.jsp");
        dispatcher.forward(request, response);

	}

}
