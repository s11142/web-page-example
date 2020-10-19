package daos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * DB接続処理用クラス
 *
 * @author System Shared
 *
 */
public class DBManager {

    /** ドライバクラス名 クラス変数 定数 */
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    /** 接続するDBのURL */
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    /** DB接続するためのユーザー名
     *  データベースに作成したユーザーを指定する */
    private static final String USER_NAME = "team09";
    /** DB接続するためのパスワード
     * データベースに作成したパスワードを指定する */
    private static final String PASSWORD = "team09sss";

    /**
     * DB接続メソッド
     *
     * @return 接続情報
     */
    public static Connection getConnection() {

        try {
            // JDBCドライバクラスをJVMに登録
            Class.forName(DRIVER);

            // DBへ接続
            Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            return con;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * @param ps
     *            preparedStatement
     * @param con
     *            接続情報
     */
    public static void close(PreparedStatement ps, Connection con) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}