package user;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserBean;

/**
 * Servlet implementation class User_InsertInput
 */
@WebServlet("/User_InsertInput")
public class User_InsertInput extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // 登録情報入力画面に遷移
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/JSP/user/insert_user/user_insert_input.jsp");
        dispatcher.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//パラメータで会員登録の入力情報を受け取る
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
    	user.setUser_name(user_name);
    	user.setGender(Integer.parseInt(gender));
    	user.setMail(mail);
    	user.setAddress(address);
    	user.setBirthday(birthday);
    	user.setAuthority(Integer.parseInt(authority));

    	//リクエストに情報を保持
       	request.setAttribute("user", user);

	       // 登録情報入力画面に遷移
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/JSP/user/insert_user/user_insert_input.jsp");
        dispatcher.forward(request, response);

	}

}
