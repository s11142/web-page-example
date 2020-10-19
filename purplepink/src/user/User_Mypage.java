package user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserBean;
import daos.UserDao;

/**
 * Servlet implementation class User_Mypage
 */
@WebServlet("/User_Mypage")
public class User_Mypage extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		UserBean log= (UserBean) session.getAttribute("user");
		int userId = log.getUser_id();
//		String user_id = request.getParameter("user_id");

    	//会員IDから全件検索
	   	UserBean user = (UserBean)UserDao.findUser(String.valueOf(userId));

    	request.setAttribute("user", user);

        // 自身の情報確認画面に遷移
        RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/user/user_page.jsp");
        dispatcher.forward(request, response);


	}

}
