package daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import beans.OrderBean;
public class OrderDAO {

	int userId;
	int goodsId;
	int orderQuantity;
	String orderDate;


	public static void OrderInsert (List<OrderBean> order_List, int userId ){


		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		PreparedStatement ps4 = null;
		PreparedStatement ps5 = null;

		//現在日時の取得
		Date day = new Date();
		SimpleDateFormat v01 = new SimpleDateFormat("yyyy/MM/dd");
		//現在の日時を購入時間に代入する
		String orderDate = v01.format(day);

		try {

				// DBに接続
				con = DBManager.getConnection();

				con.setAutoCommit(false);

				//自動採番された、orderIdを持ってくる。
				int orderId = 0;
				String sql1 =
						"SELECT order_id FROM order_detail WHERE ROWNUM <= 1 ORDER BY order_id DESC ";
				ps1 = con.prepareStatement(sql1);

				ResultSet rs = ps1.executeQuery();
				while (rs.next()) {
					orderId = rs.getInt("order_id");
					orderId = orderId + 1;
				}



				for ( OrderBean ob : order_List) {

					int Quantity = 0;
					int goodsId = ob.getGoodsId();
					int orderQuantity = ob.getOrder_quantity();



				//伝票番号と購入商品の情報を伝票詳細テーブルにセット
				// SQL文を準備（）
				String sql = "INSERT INTO order_detail "
						+ "VALUES(?,?,?) ";
				ps2 = con.prepareStatement(sql);
				ps2.setInt(1,orderId);
				ps2.setInt(2,goodsId);
				ps2.setInt(3,orderQuantity);
				ps2.executeUpdate();



				//商品テーブルから購入商品のデータを取得
				// SQL文を準備（）
				String sql2 = "SELECT * FROM goods WHERE goods_id = ? ";
				ps3 = con.prepareStatement(sql2);
				ps3.setInt(1, goodsId);
				// SQL文を実行
				ResultSet rs2 = ps3.executeQuery();
				// 検索結果をbeanに格納する
				while (rs2.next()) {
					Quantity = rs2.getInt("quantity") ;
				}

				int new_quantity = Quantity - orderQuantity;

				//商品テーブルに購入数を引いた数を上書き保存
				String sql3 = "UPDATE goods SET quantity = ? WHERE goods_id = ? ";
				ps4 = con.prepareStatement(sql3);
				ps4.setInt(1, new_quantity);
				ps4.setInt(2, goodsId);

				ps4.executeUpdate();

				}

				//伝票番号と購入者の情報を伝票テーブルにセット
				// SQL文を準備（）
				String sql4 = "INSERT INTO orders "
						+ "VALUES(?,?,?) ";
				ps5 = con.prepareStatement(sql4);
				ps5.setInt(1,orderId);
				ps5.setInt(2,userId);
				ps5.setString(3,orderDate);
				ps5.executeUpdate();


				con.commit();

			} catch (SQLException e) {

				//途中エラー発生した場合のトランザクション処理
				try {
					con.rollback();
					con.commit();
				} catch (SQLException e1) {}
				e.printStackTrace();

			} finally {
				// DB切断処理
				DBManager.close(ps, con);
			}

	}

}



