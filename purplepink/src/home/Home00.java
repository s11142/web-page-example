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
import daos.GoodsDAO;

/**
 * Servlet implementation class Home00
 */
@WebServlet("/Home00")
public class Home00 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//いきなりトップ画面を表示させる場合
		String top = "1";
		request.setAttribute("top", top);

		//グッズリストの取得
		List<GoodsBean> top10 = GoodsDAO.Goodstop10();
		request.setAttribute("CategoryList", top10);

		//カテゴリー名の取得
		List<CategoryBean> category = CategoryDao.findCategory();
		request.setAttribute("CategoryName", category);

		//フォワード処理
				RequestDispatcher rd = request.getRequestDispatcher("JSP/home/home.jsp");
				rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
