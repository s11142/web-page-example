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
 * Servlet implementation class User_UpdateComplete
 */
@WebServlet("/User_UpdateComplete")
public class User_UpdateComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//パラメータで会員登録の入力情報を受け取る
		String user_id = request.getParameter("user_id");
    	String pass = request.getParameter("pass");
    	String user_name = request.getParameter("user_name");
    	String gender = request.getParameter("gender");
    	String mail = request.getParameter("mail");
    	String address = request.getParameter("address");
    	String birthday = request.getParameter("birthday");
    	String authority = request.getParameter("authority");

    	//会員情報をインスタンス化
    	UserBean user = new UserBean();
    	user.setPass(pass);
    	user.setUser_id(Integer.parseInt(user_id));
    	user.setUser_name(user_name);
    	user.setGender(Integer.parseInt(gender));
    	user.setMail(mail);
    	user.setAddress(address);
    	user.setBirthday(birthday);
    	user.setAuthority(Integer.parseInt(authority));

       	//UserDaoの更新メソッドを呼び出す
    	UserDao.update(user);

	    // 更新完了画面に遷移
	    RequestDispatcher dispatcher = request
	            .getRequestDispatcher("/JSP/user/update_user/user_update_complete.jsp");
	    dispatcher.forward(request, response);
	}

}
