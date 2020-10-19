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

import beans.UserBean;

public class UserDao {


	  /**
     * 会員・管理者ID(メールアドレス)とパスワードによる1件検索メソッド
     *
     * @param empId
     *            社員ID
     * @param empPass
     *            パスワード
     * @return 社員テーブルのbean
     */
    public static UserBean findByIdPass(String Id, String Pass) {

        Connection con = null;
        PreparedStatement ps = null;
        UserBean uBean = null;

        try {
        	// DBに接続
            con = DBManager.getConnection();

            // SQL文を準備（ID／PASS検索）
            String sql = ""
            		+ "SELECT * "
            		+ "FROM "
            		+ "  user_information "
            		+ "WHERE "
            		+ "  mail_address = ? AND flag = 1 "
            		+ "AND "
            		+ "  password = ?"
            ;

            ps = con.prepareStatement(sql);

            // 会員・管理者IDを検索条件に設定
            ps.setString(1, Id);

            // パスワードを検索条件に設定
            ps.setString(2, Pass);

            // SQLを実行
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                uBean = new UserBean();
                uBean.setUser_id(rs.getInt("user_id"));
                uBean.setAddress(rs.getString("mail_address"));
                uBean.setUser_name(rs.getString("user_name"));
                uBean.setAuthority(rs.getInt("authority"));
                uBean.setFlag(rs.getInt("flag"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(ps, con);
        }
        return uBean;
    }


    /**
     * 会員IDによる1件検索メソッド
     *
     * @param user_id
     *            会員ID
     * @return 社員テーブルのbean
     */

	public static UserBean findUser(String user_id) {
		 Connection con = null;
	     PreparedStatement ps = null;
	     	UserBean user = null;


	        try {
	            // DBに接続
	            con = DBManager.getConnection();

	            // SQL文を準備（社員ID検索）
	            String sql = " SELECT * "
	            		+ " FROM user_information WHERE user_id = ? AND flag = 1 ";

	            ps = con.prepareStatement(sql);

	            // 社員IDを検索条件に設定
	            ps.setString(1, user_id);


	            // SQL文を実行
	            ResultSet rs = ps.executeQuery();


	            // 検索結果をbeanに格納する
	            while( rs.next()){

	             user = new UserBean();
	            	user.setUser_id(rs.getInt("user_id"));
	            	user.setUser_name(rs.getString("user_name"));
	            	user.setBirthday(rs.getString("birthday"));
	            	user.setGender(rs.getInt("gender"));
	            	user.setMail(rs.getString("mail_address"));
	            	user.setAddress(rs.getString("address"));
	            	user.setAuthority(rs.getInt("authority"));
	            	user.setPass(rs.getString("password"));
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {


	            // DB切断処理
	            DBManager.close(ps, con);
	        }

			return user;
	}


    /**
     * 管理者情報テーブル全件検索メソッド
     *
     * @return 管理者情報テーブル全件のリスト
     * 西川作成
     */
    public static List<UserBean> findAll() {

        Connection con = null;
        PreparedStatement ps = null;

        // 全件を格納するリストを準備しておく
        List<UserBean> userList = new ArrayList<UserBean>();

        try {
        	// DBに接続
            con = DBManager.getConnection();

            // SQL文を準備（全件検索）
            String sql = ""
            		+ "SELECT "
            		+ "  user_id, "
            		+ "  user_name, "
            		+ "  birthday, "
            		+ "  gender, "
            		+ "  mail_address, "
            		+ "  address, "
            		+ "  authority, "
            		+ "  password "
            		+ "FROM "
            		+ "  user_information "
            		+ "WHERE "
            		+ " flag = 1 "
            		+ "AND authority = 2 "
            		+ "OR "
            		+ "  authority = 3 "
            		;

            ps = con.prepareStatement(sql);


            // SQLを実行
            ResultSet rs = ps.executeQuery();

            // 検索結果をbeanに格納し、そのbeanをリストに詰める
            while (rs.next()) {
                UserBean uBean = new UserBean();
                uBean.setUser_id(rs.getInt("user_id"));
                uBean.setPass(rs.getString("password"));
                uBean.setUser_name(rs.getString("user_name"));
                uBean.setGender(rs.getInt("gender"));
                uBean.setAddress(rs.getString("address"));
                uBean.setBirthday(rs.getString("birthday"));
                uBean.setAuthority(rs.getInt("authority"));
                uBean.setMail(rs.getString("mail_address"));
                userList.add(uBean);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(ps, con);
        }
        return userList;
    }




    /**
     * 会員情報新規登録メソッド
     *
     * @param UserBean
     *            登録する会員のbean
     */
    public static void insert(UserBean user) {

        Connection con = null;
        PreparedStatement ps = null;

        try {
        	// DBに接続
            con = DBManager.getConnection();

            // SQL文を準備（INSERT文）
            String sql = "INSERT INTO user_information "+
            		"(user_id ,user_name ,birthday ,gender ,mail_address ,address ,authority ,password ,flag ) "
            		+ " VALUES ( userid_seq.nextval , ? , ? , ? , ? , ? , ? , ? ,? )";




            ps = con.prepareStatement(sql);

            ps.setString(1, user.getUser_name());
            ps.setString(2, user.getBirthday());
            ps.setInt(3, user.getGender());
            ps.setString(4,user.getMail());
            ps.setString(5, user.getAddress());
            ps.setInt(6, user.getAuthority());
            ps.setString(7, user.getPass());
            ps.setInt(8, user.getFlag());

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
     * 会員情報更新メソッド
     *
     * @param UserBean
     *            更新する会員のbean
     */
    public static void update(UserBean user) {

        Connection con = null;
        PreparedStatement ps = null;

        try {
        	// DBに接続
            con = DBManager.getConnection();

            // SQL文を準備（UPDATE文）
            String sql = " UPDATE user_information "+
            		" SET "
            		+ " user_name = ? ,"
            		+ " birthday = ? ,"
            		+ " gender  =? ,"
            		+ " mail_address = ? ,"
            		+ " address = ? ,"
            		+ " authority = ? ,"
            		+ " password = ? "
            		+ " WHERE "
            		+ " user_id = ? ";

            ps = con.prepareStatement(sql);

            ps.setString(1, user.getUser_name());
            ps.setString(2, user.getBirthday());
            ps.setInt(3, user.getGender());
            ps.setString(4,user.getMail());
            ps.setString(5, user.getAddress());
            ps.setInt(6, user.getAuthority());
            ps.setString(7, user.getPass());
            ps.setInt(8, user.getUser_id());

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
     * 会員情報削除メソッド
     *
     * @param user_id
     *            削除する会員のID
     */
    public static void delete(String user_id) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
        	// DBに接続
            con = DBManager.getConnection();

            // SQL文を準備（論理削除文、社員ID指定）
            String sql = " UPDATE user_information "+
            		" SET "
            		+ " flag = 0 "
            		+ " WHERE "
            		+ " user_id = ? ";


            ps = con.prepareStatement(sql);

            // 削除する社員のIDを設定
            ps.setString(1, user_id);

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


