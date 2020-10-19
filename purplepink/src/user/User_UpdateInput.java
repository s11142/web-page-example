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
 * Servlet implementation class User_UpdateInput
 */
@WebServlet("/User_UpdateInput")
public class User_UpdateInput extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub//
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
    	String res = request.getParameter("res");

		if(res==null){
			res="2";
		}

	   	if(Integer.parseInt(res)==1){
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

	    	//リクエストに情報を保持
	       	request.setAttribute("user", user);

	        // 更新情報確認画面に遷移
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/user/update_user/user_update_input.jsp");
	        dispatcher.forward(request, response);
	   	}else{


    	//会員IDから全件検索
	   	UserBean user = UserDao.findUser(user_id);


    	request.setAttribute("user", user);

        // 更新情報確認画面に遷移
        RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/user/update_user/user_update_input.jsp");
        dispatcher.forward(request, response);
	   	}
	}

}
