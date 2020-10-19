package home;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CategoryBean;
import beans.GoodsBean;
import beans.UserBean;
import daos.CategoryDao;
import daos.GoodsDAO;
import daos.UserDao;
/**
 * Servlet implementation class goodsChange
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//セッション準備
		HttpSession session = request.getSession(false);
		 UserBean log = (UserBean)session.getAttribute("user");

		 if (log != null){



		 //画面遷移する
		 String id = String.valueOf(log.getUser_id());
		 UserBean v01 =   UserDao.findUser(id);
		 int auth = v01.getAuthority();

		if(auth != 2){
		//グッズリストの取得

		List<GoodsBean> top10 = GoodsDAO.Goodstop10();
		request.setAttribute("CategoryList", top10);
		}else{
		//Goods全件表示
		List<GoodsBean> allfind = GoodsDAO.AllFind();
		request.setAttribute("CategoryList", allfind);
		}
		//カテゴリー名の取得
		List<CategoryBean> category = CategoryDao.findCategory();
		request.setAttribute("CategoryName", category);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/home/home.jsp");
		dispatcher.forward(request, response);
		 } else {
		List<GoodsBean> top10 = GoodsDAO.Goodstop10();
		request.setAttribute("CategoryList", top10);

		//カテゴリー名の取得
		List<CategoryBean> category = CategoryDao.findCategory();
		request.setAttribute("CategoryName", category);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/home/home.jsp");
		dispatcher.forward(request, response);

		 }
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




		//セッション準備
		HttpSession session = request.getSession(false);
		 UserBean log = (UserBean)session.getAttribute("user");

		 //画面遷移する
		 String id = String.valueOf(log.getUser_id());
		 UserBean v01 =   UserDao.findUser(id);
		 int auth = v01.getAuthority();

		if(auth != 2){
		//グッズリストの取得

		List<GoodsBean> top10 = GoodsDAO.Goodstop10();
		request.setAttribute("CategoryList", top10);
		}else{
		//Goods全件表示
		List<GoodsBean> allfind = GoodsDAO.AllFind();
		request.setAttribute("CategoryList", allfind);
		}
		//カテゴリー名の取得
		List<CategoryBean> category = CategoryDao.findCategory();
		request.setAttribute("CategoryName", category);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/home/home.jsp");
		dispatcher.forward(request, response);

	}
}





