package user;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserBean;
import check.Check;

/**
 * Servlet implementation class User_InsertConfirm
 */
@WebServlet("/User_InsertConfirm")
public class User_InsertConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//パラメータで会員登録の入力情報を受け取る
    	String pass = request.getParameter("pass");
    	String user_name = request.getParameter("user_name");
    	String gender = request.getParameter("gender");
    	String mail = request.getParameter("mail");
    	String address = request.getParameter("address");
    	String birthday = request.getParameter("birthday");
    	String authority = request.getParameter("authority");

    	//エラーメッセージの受け取り
    	String error0 = null;
    	String error1 = null;
    	String error2 = null;
    	String error3 = null;
    	String error4 = null;


    	error0 = Check.passcheck(pass);
    	error1 = Check.mailcheck(mail);
    	error2 = Check.namecheck(user_name);
    	error3 = Check.addresscheck(address);
    	error4 = Check.birthdaycheck(birthday);

    	String[] errorAll = {error0,error1,error2,error3,error4};

    	if ((errorAll[0] != null) || (errorAll[1] != null) || (errorAll[2] != null)
    	|| (errorAll[3] != null) || (errorAll[4] != null)){

        	request.setAttribute("errorMessage", errorAll);

    	    RequestDispatcher dispatcher = request
    	            .getRequestDispatcher("/JSP/user/insert_user/user_insert_input.jsp");
    	    dispatcher.forward(request, response);



//	     if (error1 != null) {
//			request.setAttribute("errorMessage", error1);
//
//
//
//		} else if (error2 != null) {
//			request.setAttribute("errorMessage", error2);
//
//		    RequestDispatcher dispatcher = request
//		            .getRequestDispatcher("/JSP/user/insert_user/user_insert_input.jsp");
//		    dispatcher.forward(request, response);
//		} else if (error3 != null) {
//			request.setAttribute("errorMessage", error3);
//
//		    RequestDispatcher dispatcher = request
//		            .getRequestDispatcher("/JSP/user/insert_user/user_insert_input.jsp");
//		    dispatcher.forward(request, response);
//		} else if (error4 != null) {
//			request.setAttribute("errorMessage", error4);
//
//		    RequestDispatcher dispatcher = request
//		            .getRequestDispatcher("/JSP/user/insert_user/user_insert_input.jsp");
//		    dispatcher.forward(request, response);
//		} else if (error5 != null) {
//			request.setAttribute("errorMessage", error5);
//
//		    RequestDispatcher dispatcher = request
//		            .getRequestDispatcher("/JSP/user/insert_user/user_insert_input.jsp");
//		    dispatcher.forward(request, response);
		} else {
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


	    // 登録確認画面に遷移
	    RequestDispatcher dispatcher = request
	            .getRequestDispatcher("/JSP/user/insert_user/user_insert_confirm.jsp");
	    dispatcher.forward(request, response);

	}

}

}