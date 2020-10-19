package category;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CategoryBean;
import daos.CategoryDao;

/**
 * Servlet implementation class Category_UpdateComplete
 */
@WebServlet("/Category_UpdateComplete")
public class Category_UpdateComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	//パラメータ取得
		String newcatname = request.getParameter("newcatname");
		String oldcatid = request.getParameter("oldcatid");

		int oldcatno = Integer.parseInt(oldcatid);
		//カテゴリーを扱うBeanの準備
		CategoryBean catBean = new CategoryBean();

		//パラメータの値(カテゴリー名)をBeanにセットする
		catBean.setCategory_name(newcatname);
		catBean.setCategory_id(oldcatno);

    	//ここでupdateする
        CategoryDao.CategoryUpdate(oldcatno , newcatname);


		// カテゴリー名変更完了画面へ画面遷移を行う
        RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/category/category_update_complete.jsp");
        dispatcher.forward(request, response);

	}

}
