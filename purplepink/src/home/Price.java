package home;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/Price")
public class Price extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String top = "1";
		request.setAttribute("top", top);


		//文字表示
		request.setCharacterEncoding("UTF-8");

		//値の取得
		int priceno = Integer.parseInt( request.getParameter("price")) ;

		List<GoodsBean> gb = new ArrayList<GoodsBean>();

		if(priceno!=5){
			gb =GoodsDAO.Price(priceno);



		}else{
//		DBManager.getConnection();
		gb = GoodsDAO.Goodstop10();	}

		//スコープに値を保持
		request.setAttribute("CategoryList", gb);

		//カテゴリー名の取得
		List<CategoryBean> c = CategoryDao.findCategory();

		//スコープに値を保持
		request.setAttribute("CategoryName", c);

		//フォワード処理
		RequestDispatcher rd = request.getRequestDispatcher("JSP/home/home.jsp");
		rd.forward(request, response);



	}

}
