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
 * Servlet implementation class User_InsertComplete
 */
@WebServlet("/User_InsertComplete")
public class User_InsertComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//パラメータで会員登録の入力情報を受け取る
    	String pass = request.getParameter("pass");
    	String user_name = request.getParameter("user_name");
    	String gender = request.getParameter("gender");
    	String mail = request.getParameter("mail");
    	String address = request.getParameter("address");
    	String birthday = request.getParameter("birthday");
    	String authority = request.getParameter("authority");
    	int flag = 1;

       	//会員情報をインスタンス化
    	UserBean user = new UserBean();
    	user.setPass(pass);
    	user.setUser_name(user_name);
    	user.setGender(Integer.parseInt(gender));
    	user.setMail(mail);
    	user.setAddress(address);
    	user.setBirthday(birthday);
    	user.setAuthority(Integer.parseInt(authority));
    	user.setFlag(flag);

    	//UserDaoの新規登録メソッドを呼び出す
    	UserDao.insert(user);

		// 登録完了画面に遷移
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/JSP/user/insert_user/user_insert_complete.jsp");
		dispatcher.forward(request, response);

	}

}
