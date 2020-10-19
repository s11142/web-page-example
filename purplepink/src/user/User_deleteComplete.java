package user;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.UserDao;

/**
 * Servlet implementation class User_deleteComplete
 */
@WebServlet("/User_deleteComplete")
public class User_deleteComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//パラメータの取得
		String user_id = request.getParameter("user_id");

		//削除メソッドを呼び出す
			UserDao.delete(user_id);


        // 削除完了画面に遷移
        RequestDispatcher dispatcher = request.getRequestDispatcher("JSP/user/delete_user/user_delete_complete.jsp");
        dispatcher.forward(request, response);
	}

}
