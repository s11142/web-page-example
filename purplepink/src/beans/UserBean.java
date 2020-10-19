package beans;
import java.io.Serializable;

/**
 * 会員(従業員)テーブル用bean
 *
 * @author Kazuki Ito
 *
 */
public class UserBean implements Serializable {



	/** 会員(従業員)ID */
    private int user_id;

    /** 会員(従業員)名 */
    private String user_name;

	/** パスワード */
    private String pass;

	/** 生年月日 */
    private String birthday;

    /** 住所 */
    private String Address;

    /** 性別 */
    private int gender;

    /** メールアドレス */
    private String Mail;

    /** 権限 */
    private int authority;

    /** 論理フラッグ */
    private int flag;

    //以下各フィールドのgetter及びsetterの記述である。


    /** 論理フラッグ */
    public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}

	/** 会員(従業員)ID */
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

    /** 会員(従業員)名 */
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/** パスワード */
    public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	/** 生年月日 */
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

    /** 住所 */
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}

    /** 性別 */
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}

	/** メールアドレス */
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}

	/** 権限 */
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}



}
