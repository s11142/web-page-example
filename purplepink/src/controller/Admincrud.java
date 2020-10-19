package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserBean;
import daos.UserDao;

/**
 * Servlet implementation class Admincrud
 */
@WebServlet("/Admincrud")
public class Admincrud extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 社員テーブルを検索し、全項目を取得する
        List<UserBean> userList = UserDao.findAll();

        // 検索結果の入ったリストをリクエスト属性に登録しておく
        request.setAttribute("userList", userList);

        // 管理者用一覧表示画面へ画面遷移を行う
        RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/Admincrud/admincrud.jsp");
        dispatcher.forward(request, response);

	}

}
