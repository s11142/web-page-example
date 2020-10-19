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
 * Servlet implementation class Category_UpdateInput
 */
@WebServlet("/Category_UpdateInput")
public class Category_UpdateInput extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//パラメータ取得
		String catname = request.getParameter("catname");
		String catid = request.getParameter("catid");

		int catId = Integer.parseInt(catid);

//		String oldname = request.getParameter("oldname");

		//Beanの準備
		CategoryBean catBean = new CategoryBean();
		CategoryBean oldBean = CategoryDao.findById(catId);

		//変数catBeanにパラメータ取得した値をセットする
		catBean.setCategory_name(catname);
		catBean.setCategory_id(catId);

		request.setAttribute("newcat", catBean);
		request.setAttribute("oldBean", oldBean);


		// カテゴリー名変更画面へ画面遷移を行う
        RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/category/category_update_input.jsp");
        dispatcher.forward(request, response);

	}

}
