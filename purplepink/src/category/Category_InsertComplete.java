package category;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CategoryDao;

/**
 * Servlet implementation class Category_InsertComplete
 */
@WebServlet("/Category_InsertComplete")
public class Category_InsertComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//パラメータの取得
		String newcat = request.getParameter("newcat");

//		//カテゴリーを扱うBeanの準備
//		CategoryBean catBean = new CategoryBean();
//
//		//パラメータの値(カテゴリー名)をBeanにセットする
//		catBean.setCategory_name(newcat);

    	//ここでインサートする
		CategoryDao.CategoryInsert(newcat);

		// カテゴリー新規登録完了画面へ画面遷移を行う
        RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/category/category_insert_complete.jsp");
        dispatcher.forward(request, response);

	}

}
