package user;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserBean;
import daos.UserDao;



/**
 * Servlet implementation class User_deleteConfirm
 */
@WebServlet("/User_deleteConfirm")
public class User_deleteConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//パラメータの取得
	   	String user_id = request.getParameter("user_id");

    	//社員IDから全件検索
	   	UserBean user = UserDao.findUser(user_id);

    	request.setAttribute("user", user);

        // 削除情報確認画面に遷移
        RequestDispatcher dispatcher = request.getRequestDispatcher("JSP/user/delete_user/user_delete_confirm.jsp");
        dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
