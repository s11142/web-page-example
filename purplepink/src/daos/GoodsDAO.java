package daos;

/**
 * SQL文
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.GoodsBean;



public class GoodsDAO {

	private static GoodsBean categorybean;





	//カテゴリー検索
	public static List<GoodsBean> Category (int GoodsId){

		Connection con = null;
		PreparedStatement ps = null;
		// 全件を格納するリストを準備しておく
		List<GoodsBean> goodsList = new ArrayList<GoodsBean>();

		try {
			// DBに接続
			con = DBManager.getConnection();

			// SQL文を準備（）
			String sql = "select * from goods_order "
					+ "where category_id = ? AND flag = 1 ";

			ps = con.prepareStatement(sql);

			// 商品IDを検索条件に設定
			ps.setInt(1, GoodsId);

			// SQL文を実行
			ResultSet rs = ps.executeQuery();

			// 検索結果をbeanに格納する
			while (rs.next()) {
				categorybean = new GoodsBean();
				categorybean.setGoodsId(rs.getInt("goods_id"));
				categorybean.setGoodsName(rs.getString("goods_name"));
				categorybean.setPrice(rs.getInt("price"));
				categorybean.setSupplier(rs.getString("supplier"));
				categorybean.setStockingDate(rs.getString("stocking_date"));
				categorybean.setCategoryId(rs.getInt("category_id"));
				categorybean.setCategoryName(rs.getString("category_name"));
				categorybean.setQuantity(rs.getInt("quantity"));
				goodsList.add(categorybean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// DB切断処理
			DBManager.close(ps, con);
		}
		return goodsList;

	}

	//価格別検索
	public static List<GoodsBean> Price (int priceno){

		Connection con = null;
		PreparedStatement ps = null;
		// 全件を格納するリストを準備しておく
		List<GoodsBean> goodsList = new ArrayList<GoodsBean>();

		try {
			// DBに接続
			con = DBManager.getConnection();

			// SQL文を準備（）
			String sql = "select * from goods_order "
					+ "where price between ? and ? AND flag = 1 ";

			ps = con.prepareStatement(sql);

			// 商品IDを検索条件に設定
			if(priceno==1){
				ps.setInt(1, 100);
				ps.setInt(2, 1000);
			}else if(priceno==2){
				ps.setInt(1, 1000);
				ps.setInt(2, 1100);
			}else if(priceno==3){
				ps.setInt(1, 1100);
				ps.setInt(2, 2000);
			}else if(priceno==4){
				ps.setInt(1, 2000);
				ps.setInt(2, 4000);
			}

			// SQL文を実行
			ResultSet rs = ps.executeQuery();

			// 検索結果をbeanに格納する
			while (rs.next()) {
				categorybean = new GoodsBean();
				categorybean.setGoodsId(rs.getInt("goods_id"));
				categorybean.setGoodsName(rs.getString("goods_name"));
				categorybean.setPrice(rs.getInt("price"));
				categorybean.setSupplier(rs.getString("supplier"));
				categorybean.setStockingDate(rs.getString("stocking_date"));
				categorybean.setCategoryId(rs.getInt("category_id"));
				categorybean.setCategoryName(rs.getString("category_name"));
				categorybean.setQuantity(rs.getInt("quantity"));
				goodsList.add(categorybean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// DB切断処理
			DBManager.close(ps, con);
		}
		return goodsList;

	}


	//新着順表示検索
	public static List<GoodsBean> Goodstop10 (){

		Connection con = null;
		PreparedStatement ps = null;
		// 全件を格納するリストを準備しておく
		List<GoodsBean> goodsList = new ArrayList<GoodsBean>();

		GoodsBean gb = null;

		try {
			// DBに接続
			con = DBManager.getConnection();

			// SQL文を準備（）
			String sql = "select * from goods_order10 WHERE flag = 1  ";

			ps = con.prepareStatement(sql);


			// SQL文を実行
			ResultSet rs = ps.executeQuery();

			// 検索結果をbeanに格納する
			while (rs.next()) {
				gb = new GoodsBean();
				gb.setGoodsId(rs.getInt("goods_id"));
				gb.setGoodsName(rs.getString("goods_name"));
				gb.setPrice(rs.getInt("price"));
				gb.setSupplier(rs.getString("supplier"));
				gb.setStockingDate(rs.getString("stocking_date"));
				gb.setCategoryId(rs.getInt("category_id"));
				gb.setCategoryName(rs.getString("category_name"));
				gb.setQuantity(rs.getInt("quantity"));
				//				gb.setSave(rs.getString("save"));
				//				gb.setDetail(rs.getString("detail"));
				goodsList.add(gb);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// DB切断処理
			DBManager.close(ps, con);
		}
		return goodsList;

	}

	//Goodsの全件表示
		public static List<GoodsBean> AllFind(){
			Connection con = null;
			PreparedStatement ps = null;
			// 全件を格納するリストを準備しておく
			List<GoodsBean> goodsList = new ArrayList<GoodsBean>();
//			GoodsBean categorybean = null;

			try {
				// DBに接続
				con = DBManager.getConnection();
				// SQL文を準備（）
				String sql = "select * from goods_order WHERE flag = 1 ";
				ps = con.prepareStatement(sql);
				// SQL文を実行
				ResultSet rs = ps.executeQuery();
				// 検索結果をbeanに格納する
				while (rs.next()) {
					categorybean = new GoodsBean();
					categorybean.setGoodsId(rs.getInt("goods_id"));
					categorybean.setGoodsName(rs.getString("goods_name"));
					categorybean.setPrice(rs.getInt("price"));
					categorybean.setSupplier(rs.getString("supplier"));
					categorybean.setStockingDate(rs.getString("stocking_date"));
					categorybean.setCategoryId(rs.getInt("category_id"));
					categorybean.setCategoryName(rs.getString("category_name"));
					categorybean.setQuantity(rs.getInt("quantity"));
					categorybean.setSave(rs.getString("save"));
					categorybean.setDetail(rs.getString("detail"));
					goodsList.add(categorybean);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				// DB切断処理
				DBManager.close(ps, con);
			}
			return goodsList;
		}



	/**
	 * 商品IDによる1件検索メソッド
	 *
	 * @param GoodsId
	 *            商品ID
	 * @return 商品テーブルのbean
	 */

	public static GoodsBean findGoods(String GoodsId) {
		Connection con = null;
		PreparedStatement ps = null;
		GoodsBean goods = null;


		try {
			// DBに接続
			con = DBManager.getConnection();

			// SQL文を準備（社員ID検索）
			String sql = "SELECT * "
					+ " FROM goods "
					+ " WHERE goods_id = ? "
					+ " AND flag = 1 ";

			ps = con.prepareStatement(sql);

			// 社員IDを検索条件に設定
			ps.setString(1, GoodsId);


			// SQL文を実行
			ResultSet rs = ps.executeQuery();


			// 検索結果をbeanに格納する
			while( rs.next()){

				goods = new GoodsBean();
				goods.setGoodsId(rs.getInt("goods_id"));
				goods.setGoodsName(rs.getString("goods_name"));
				goods.setCategoryId(rs.getInt("category_id"));
				goods.setPrice(rs.getInt("price"));
				goods.setSupplier(rs.getString("supplier"));
				goods.setStockingDate(rs.getString("stocking_date"));
				goods.setQuantity(rs.getInt("quantity"));
				goods.setSave(rs.getString("save"));
				goods.setDetail(rs.getString("detail"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// DB切断処理
			DBManager.close(ps, con);
		}

		return goods;
	}


	/**
	 * 商品情報新規登録メソッド
	 *
	 * @param GoodsBean
	 *            登録する商品のbean
	 */
	public static void insert(GoodsBean goods) {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			// DBに接続
			con = DBManager.getConnection();

			// SQL文を準備（INSERT文）
			String sql = "INSERT INTO goods " +
					"( goods_id ,"
					+ " goods_name ,"
					+ " category_id ,"
					+ " price ,"
					+ " supplier ,"
					+ " stocking_date ,"
					+ " quantity ,"
					+ " save ,"
					+ " detail ,"
					+ " flag"
					+ " ) "

            		+ " VALUES ( goodsid_seq .nextval , ? , ? , ? , ? , ? , ? , ? , ? , ? )";


			ps = con.prepareStatement(sql);

			ps.setString(1, goods.getGoodsName());
			ps.setInt(2,goods.getCategoryId() );
			ps.setInt(3, goods.getPrice());
			ps.setString(4,goods.getSupplier());
			ps.setString(5, goods.getStockingDate());
			ps.setInt(6, goods.getQuantity());
			ps.setString(7, goods.getSave());
			ps.setString(8, goods.getDetail());
			ps.setInt(9,1);

			// SQLを実行
			ps.executeUpdate();



		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}
		return;
	}


	/**
	 * 商品情報更新メソッド
	 *
	 * @param GoodsBean
	 *            更新する商品のbean
	 */
	public static void update(GoodsBean goods) {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			// DBに接続
			con = DBManager.getConnection();

			// SQL文を準備（UPDATE文）
			String sql = " UPDATE goods "+
					" SET "
					+ " goods_name  = ? ,"
					+ " price   = ? ,"
					+ " supplier  = ? ,"
					+ " stocking_date  = ? ,"
					+ " quantity  = ? , "
					+ " save  = ? , "
					+ " detail  = ? "
					+ " WHERE "
					+ " goods_id = ? ";

			ps = con.prepareStatement(sql);

			ps.setString(1, goods.getGoodsName());
			ps.setInt(2, goods.getPrice());
			ps.setString(3,goods.getSupplier());
			ps.setString(4, goods.getStockingDate());
			ps.setInt(5, goods.getQuantity());
			ps.setString(6, goods.getSave());
			ps.setString(7, goods.getDetail());
			ps.setInt(8,goods.getGoodsId() );


			// SQLを実行
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}
		return;
	}

	/**
	 * 商品情報削除メソッド
	 *
	 * @param goods_id
	 *            削除する商品のID
	 */
	public static void delete(String goods_id) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			// DBに接続
			con = DBManager.getConnection();

			// SQL文を準備（論理削除文、社員ID指定）
			String sql =  " UPDATE goods "+
					" SET "
					+ " flag = 0"
					+ " WHERE "
					+ " goods_id = ? ";

			ps = con.prepareStatement(sql);



			// 削除する社員のIDを設定
			ps.setString(1, goods_id);

			// SQLを実行
			ps.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}
		return;
	}


}