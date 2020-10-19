package controller;

import static util.Constants.*;

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
import beans.UserBean;
import daos.UserDao;

/**
 * ログイン画面クラス
 *
 * @author nishikawa
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ログインページに遷移する
        RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/log/login.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            // セッションを利用する準備
            HttpSession session = request.getSession(false);


            // セッション属性に登録されているユーザー情報をクリア
            session.removeAttribute("user");

            // 会員・管理者情報を扱うBeanの準備
            UserBean Bean = new UserBean();

            // 会員・管理者IDとパスワードを受け取る
            String id = request.getParameter("ID");
            String password = request.getParameter("Pass");


            // ログインチェック
            String errorMsg = check(id, password);


            // もし、エラーメッセージがあった場合
            if (errorMsg != null) {

                // エラーメッセージをリクエスト属性に登録しておく
                request.setAttribute("errorMessage", errorMsg);

                // ログイン画面へ遷移を行う
                RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/log/login.jsp");
                dispatcher.forward(request, response);


                // もし、エラーメッセージがなかった場合
            } else {

                // 入力されたID、パスワードで検索する
                Bean = UserDao.findByIdPass(id, password);


                // 該当する会員・管理者が見つかった場合
                if (Bean != null) {

                    // セッション属性にログインした会員・管理者の情報を登録しておく
                    session.setAttribute("user", Bean);


                    // 買い物かごを利用する準備--------------------------------

                    session.removeAttribute("goodsList");

                    List<GoodsBean> goodsList = new ArrayList<GoodsBean>();

                    session.setAttribute("goodsList", goodsList);

                    //一般会員・管理者分岐処理(authority)
                    int AuthorityNo = Bean.getAuthority();

                    if (AuthorityNo == 1) {

                    	// ホーム画面へ画面遷移を行う
                        RequestDispatcher dispatcher = request.getRequestDispatcher("HomeServlet");
                        dispatcher.forward(request, response);

					} else {
						// 管理者閲覧画面へ画面遷移を行う
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/Admincrud/administrator.jsp");
                        dispatcher.forward(request, response);

					}

                } else {
                	// 該当する会員・管理者が見つからなかった場合（ログインエラー）

                    // 会員・管理者ID、またはパスワードが間違っていた場合のエラーメッセージ
                    errorMsg = MAIL_OR_PASSWORD_MISMATCH;

                    // エラーメッセージをリクエスト属性に登録しておく
                    request.setAttribute("errorMessage", errorMsg);

                    // ログイン画面へ遷移を行う
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/log/login.jsp");
                    dispatcher.forward(request, response);

                }
            }
        } catch (Exception e) {

            // エラー画面へ遷移を行う
            RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/log/error.jsp");
            dispatcher.forward(request, response);

        }
    }




/**
 * ログインチェックを行うメソッド
 *
 * @param id
 * @param pass
 * @return エラーメッセージ
*/
private static String check(String id, String pass) {


    // エラーメッセージの準備
    String errorMsg = null;

    // パスワードの未入力チェック
    if (pass.isEmpty()) {
        errorMsg = PASSWORD_EMPTY;
    }

//    // メールアドレス(ID)の桁数チェック
    if (id.length() >= 50) {
    	errorMsg = MAIL_LENGTH_OVER;
	}

    //IDの未入力チェック
    if (id.isEmpty()) {
        errorMsg = MAIL_EMPTY;
    }

    return errorMsg;
}

}
