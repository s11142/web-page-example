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
import check.Check;
import daos.GoodsDAO;

/**
 * Servlet implementation class PaymentConfirm
 */
@WebServlet("/PaymentConfirm")
public class PaymentConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // セッションを利用する準備
        HttpSession session = request.getSession(false);

        //買い物かごリストを取得
		@SuppressWarnings("unchecked")
		List<GoodsBean> list = (List<GoodsBean>)session.getAttribute("goodsList");


		//伝票のリストを作成
		List<OrderBean> orderList =  new ArrayList<OrderBean>();
		OrderBean order = null;

	String [] error = new String [list.size()];
		int i = 0;
		//各伝票オブジェクトに値を代入する
		for ( GoodsBean goods : list) {
	//エラーメッセージの受け取り
	    	error [i] = null;

			order = new OrderBean();

			//商品番号を代入
			order.setGoodsId(goods.getGoodsId());

			//商品名を代入
			GoodsBean syo_hin = GoodsDAO.findGoods(String.valueOf(goods.getGoodsId()));
			String syo_name = syo_hin.getGoodsName();
			order.setGoodsName(syo_name);

			//商品の個数を代入
			String order_quantity = request.getParameter(String.valueOf(goods.getGoodsId()));
			//未入力の時
			if(order_quantity.length() == 0) {

				error[i]= "購入数を入力してください";

				order.setOrder_quantity(0);
				//購入者のIDを代入
				UserBean log_user = (UserBean) session.getAttribute("user");
				int user_id = log_user.getUser_id();
				order.setUser_id(user_id);

				//入力されたとき
			}else{
			order.setOrder_quantity(Integer.parseInt(order_quantity));

			//購入者のIDを代入
			UserBean log_user = (UserBean) session.getAttribute("user");
			int user_id = log_user.getUser_id();
			order.setUser_id(user_id);

	error[i] = Check.quantitycheck(Integer.parseInt(order_quantity),goods.getGoodsId());
			}
	    	i++;
			//伝票オブジェクトを伝票リストに追加
			orderList.add(order);
		}

		int count = 0;
		for (int j = 0; j < error.length; j++) {
			if(error[j] != null){
				count++;
			}
		}



    	if (count != 0){

        	request.setAttribute("errorMessage", error);

    	    RequestDispatcher dispatcher = request
    	            .getRequestDispatcher("/JSP/shoppingCart/cart_list.jsp");
    	    dispatcher.forward(request, response);


		}

        //決済画面に保持する伝票のリストをセット
		session.setAttribute("orderList", orderList);


        //伝票リストに遷移させる
		RequestDispatcher rd = request.getRequestDispatcher("/JSP/shoppingCart/paymentConfirm.jsp");
		rd.forward(request, response);



	}

}
