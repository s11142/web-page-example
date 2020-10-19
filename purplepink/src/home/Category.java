package home;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CategoryBean;
import beans.GoodsBean;
import daos.CategoryDao;
import daos.DBManager;
import daos.GoodsDAO;

/**
 * Servlet implementation class Category
 */
@WebServlet("/Category")
public class Category extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String all = "all";

		//文字表示
		request.setCharacterEncoding("UTF-8");



		//値の取得
		String CategoryId = request.getParameter("CategoryId") ;

		if(CategoryId.equals(all)){

			//フォワード処理
			RequestDispatcher rd = request.getRequestDispatcher("JSP/home/home.jsp");
			rd.forward(request, response);

		}else{

			String top = "1";
			request.setAttribute("top", top);

		DBManager.getConnection();

		List<GoodsBean> gb_list  = (List<GoodsBean>)GoodsDAO.Category(Integer.parseInt(CategoryId));


		//スコープに値を保持
		request.setAttribute("CategoryList", gb_list);

		//カテゴリー名の取得
		List<CategoryBean> c = CategoryDao.findCategory();
		//スコープに値を保持
		request.setAttribute("CategoryName", c);

		//フォワード処理
		RequestDispatcher rd = request.getRequestDispatcher("JSP/home/home.jsp");
		rd.forward(request, response);
		}
	}

}
