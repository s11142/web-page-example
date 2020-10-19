package shopping_cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.GoodsBean;
import beans.UserBean;

/**
 * Servlet implementation class ShoppingCart
 */
@WebServlet("/ShoppingCart")
public class ShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
		@SuppressWarnings("unchecked")
		List<GoodsBean>goodsList = (List<GoodsBean>) session.getAttribute("goodsList");

		//未ログインの場合は買い物かごに遷移させない
		UserBean log = (UserBean)session.getAttribute("user");
		if(log==null){

			 RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/home/home.jsp");
			    dispatcher.forward(request, response);

		}else{


			 session.setAttribute("goodsList", goodsList);

			//買い物かごリストに遷移する
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/shoppingCart/cart_list.jsp");
		    dispatcher.forward(request, response);

	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
