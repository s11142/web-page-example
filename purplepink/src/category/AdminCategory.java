package category;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CategoryBean;
import daos.CategoryDao;

/**
 * カテゴリー一覧の表示
 * Servlet implementation class AdminCategory
 */
@WebServlet("/AdminCategory")
public class AdminCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Beanの準備
//		CategoryBean categorybean = new CategoryBean();

		//カテゴリーテーブルを検索し、全項目(カテゴリーIDとカテゴリー名)を取得する
		List<CategoryBean> categoryList = CategoryDao.findCategory();

		// 検索結果の入ったリストをリクエスト属性に登録しておく
        request.setAttribute("categoryList", categoryList);


		// カテゴリー変更画面へ画面遷移を行う
        RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/category/categorylist.jsp");
        dispatcher.forward(request, response);


	}

}
