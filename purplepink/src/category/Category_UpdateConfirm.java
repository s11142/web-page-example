package category;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CategoryBean;
import check.Check;
import daos.CategoryDao;

/**
 * Servlet implementation class Category_UpdateConfilm
 */
@WebServlet("/Category_UpdateConfirm")
public class Category_UpdateConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String newcatname = request.getParameter("newcatname");
		String oldcatid = request.getParameter("oldcatid");

	String errorMsg1 = null;


		errorMsg1 = Check.catnamecheck(newcatname);

		//ぬるぽの原因箇所？(== null->nullではなかった)
		if (errorMsg1 != null){


    		CategoryBean catBean = new CategoryBean();
    		CategoryBean oldBean = CategoryDao.findById(Integer.parseInt(oldcatid));

    		request.setAttribute("newcat", catBean);
    		request.setAttribute("oldBean", oldBean);

            request.setAttribute("errorMessage", errorMsg1);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/category/category_update_input.jsp");
            dispatcher.forward(request, response);


       	} else {


		//カテゴリーを扱うBeanの準備
		CategoryBean catBean = new CategoryBean();
	CategoryBean oldBean = CategoryDao.findById(Integer.parseInt(oldcatid));


		//パラメータの値(カテゴリー名)をBeanにセットする
		catBean.setCategory_name(newcatname);
		catBean.setCategory_id( Integer.parseInt(oldcatid));


		//入力した値を保持したBeanをリクエスト属性に登録
		request.setAttribute("newcat", catBean);
		request.setAttribute("oldBean", oldBean);


		// カテゴリー名変更確認画面へ画面遷移を行う
        RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/category/category_update_confirm.jsp");
        dispatcher.forward(request, response);

	}

	}
	}
