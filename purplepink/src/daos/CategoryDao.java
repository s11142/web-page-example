package daos;



//途中
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.CategoryBean;

public class CategoryDao {




	//カテゴリー名とカテゴリーIdの取得
	public static List<CategoryBean> findCategory (){

		Connection con = null;
		PreparedStatement ps = null;
		// 全件を格納するリストを準備しておく
		List<CategoryBean> categoryList = new ArrayList<CategoryBean>();

		try {
			// DBに接続
			con = DBManager.getConnection();

			// SQL文を準備（）
			//			String sql = "select * from goods_order ";
			String sql = "select * from category ";

			ps = con.prepareStatement(sql);


			// SQL文を実行
			ResultSet rs = ps.executeQuery();

			// 検索結果をbeanに格納する
			while (rs.next()) {
				CategoryBean categorybean = new CategoryBean();
				categorybean.setCategory_id(rs.getInt("category_id"));
				categorybean.setCategory_name(rs.getString("category_name"));
				categoryList.add(categorybean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// DB切断処理
			DBManager.close(ps, con);
		}

		return categoryList;

	}

	public static void CategoryInsert(String CategoryName){

		Connection con = null;
		PreparedStatement ps = null;

		try {
			// DBに接続
			con = DBManager.getConnection();


			String sql = "INSERT INTO category VALUES (categoryid_seq.nextval,?)";

			ps = con.prepareStatement(sql);
			ps.setString(1, CategoryName);

			// SQL文を実行
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// DB切断処理
			DBManager.close(ps, con);
		}


	}

	public static void CategoryUpdate(int OldCategoryId, String NewCategoryName){

		Connection con = null;
		PreparedStatement ps = null;


		try {
			// DBに接続
			con = DBManager.getConnection();

			String sql = "UPDATE category SET category_name = ? WHERE category_id = ? ";

			ps = con.prepareStatement(sql);

			ps.setString(1, NewCategoryName);
			ps.setInt(2, OldCategoryId);

			// SQL文を実行
			ps.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// DB切断処理
			DBManager.close(ps, con);
		}
	}




	public static CategoryBean findById(int catId){



		Connection con = null;
		PreparedStatement ps = null;

		CategoryBean categoryBean = null;

		try {
			// DBに接続
			con = DBManager.getConnection();

			// SQL文を準備（社員ID検索）
			String sql = ""
					+ "SELECT "
					+ "* "
					+ "FROM "
					+ "category "
					+ "WHERE "
					+ "  category_id = ? "
					;

			ps = con.prepareStatement(sql);

			// 社員IDを検索条件に設定
			ps.setInt(1, catId);

			// SQL文を実行
			ResultSet rs = ps.executeQuery();

			// 検索結果をbeanに格納する
			while (rs.next()) {
				categoryBean = new CategoryBean();
				categoryBean.setCategory_id(rs.getInt("category_id"));
				categoryBean.setCategory_name(rs.getString("category_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// DB切断処理
			DBManager.close(ps, con);
		}
		return categoryBean;
	}


}
