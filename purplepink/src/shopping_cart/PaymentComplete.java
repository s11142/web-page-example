package shopping_cart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.GoodsBean;
import beans.OrderBean;
import beans.UserBean;
import daos.OrderDAO;

/**
 * Servlet implementation class PaymentComplete
 */
@WebServlet("/PaymentComplete")
public class PaymentComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        @SuppressWarnings("unchecked")
		List<OrderBean> order_List = (List<OrderBean>)session.getAttribute("orderList");

		//購入者のIDを代入
		UserBean log_user = (UserBean) session.getAttribute("user");
		int user_id = log_user.getUser_id();

        OrderDAO.OrderInsert(order_List ,user_id);

        //買い物かごの情報をクリアする
        session.removeAttribute("goodsList");
        List<GoodsBean> goodsList = new ArrayList<GoodsBean>();
        session.setAttribute("goodsList", goodsList);


        //伝票リストに遷移させる
		RequestDispatcher rd = request.getRequestDispatcher("/JSP/shoppingCart/paymentComplete.jsp");
		rd.forward(request, response);

	}

}
