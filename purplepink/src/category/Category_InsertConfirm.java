package category;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import check.Check;
/**
 * Servlet implementation class Category_InsertConfirm
 */
@WebServlet("/Category_InsertConfirm")
public class Category_InsertConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//パラメータ取得
		String newcat = request.getParameter("newcat");

	//エラーメッセージの受け取り
    	String errorMsg1 = null;

    	errorMsg1 = Check.catnamecheck(newcat);

       	if (errorMsg1 != null){

            request.setAttribute("errorMessage", errorMsg1);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/category/category_insert_input.jsp");
            dispatcher.forward(request, response);

       	} else {
//		//カテゴリーを扱うBeanの準備
//		CategoryBean catBean = new CategoryBean();
//
//		//パラメータの値(カテゴリー名)をBeanにセットする
//		catBean.setCategory_name(newcat);

		//入力した値を保持したBeanをリクエスト属性に登録
		request.setAttribute("newcat", newcat);

		// カテゴリー新規登録確認画面へ画面遷移を行う
        RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/category/category_insert_confirm.jsp");
        dispatcher.forward(request, response);

	}

}
}