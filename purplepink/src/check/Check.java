package check;

import static util.Constants.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import beans.GoodsBean;
import daos.GoodsDAO;
public class Check {

	//パスワード入力チェックメソッド
	public static String passcheck(String pass) {

		String errorMsg = null;

		if (pass.isEmpty()) {
			//パスワード未入力チェック
			errorMsg = PASSWORD_EMPTY;
		} else if (pass.length() > 15) {
			//パスワード文字数チェック
			errorMsg = PASSWORD_LENGTH_OVER;
		}
		return errorMsg;
	}

	//メールアドレス入力チェックメソッド
	public static String mailcheck(String mail) {

		String errorMsg = null;

		if (mail.isEmpty()) {
			//メールアドレス未入力チェック
			errorMsg = MAIL_EMPTY;
		} else if (mail.length() > 50) {
			//メールアドレス文字数チェック
			errorMsg = MAIL_LENGTH_OVER;
		}
		return errorMsg;
	}

	//名前入力チェックメソッド
	public static String namecheck(String name) {

		String errorMsg = null;

		if (name.isEmpty()) {
			//名前未入力チェック
			errorMsg = NAME_EMPTY;
		} else if (name.length() > 20) {
			//名前文字数チェック
			errorMsg = NAME_LENGTH_OVER;
		}
		return errorMsg;
	}

	//住所入力チェックメソッド
	public static String addresscheck(String address) {

		String errorMsg = null;

		if (address.isEmpty()) {
			//住所未入力チェック
			errorMsg = ADDRESS_EMPTY;
		} else if (address.length() > 50) {
			//住所文字数チェック
			errorMsg = ADDRESS_LENGTH_OVER;
		}
		return errorMsg;
	}

	//誕生日入力チェックメソッド
	public static String birthdaycheck(String birthday) {

		String errorMsg = null;

		Pattern pattern = Pattern.compile(BIRTHDAY_MATCH_CHECK);

		Matcher matcher = pattern.matcher(birthday);

		if (birthday.isEmpty()) {
			//誕生日未入力チェック
			errorMsg = BIRTHDAY_EMPTY;
		} else if (!matcher.find()) {
			//誕生日文字数チェック
			errorMsg = BIRTHDAY_MISSMATCH;
		}
		return errorMsg;
	}


	//購入量・在庫入力チェックメソッド
	public static String quantitycheck(int orderquantity, int goodsId) {

		String errorMsg = null;

		GoodsBean goods = GoodsDAO.findGoods(String.valueOf(goodsId));

		int stockingquantity = goods.getQuantity();

		if (orderquantity==0) {
			errorMsg = "購入したい数を入力してください。";
		} else if (orderquantity > stockingquantity) {
			//在庫数チェック
			errorMsg = QUANTITY_CHECK;
		}
		return errorMsg;
	}


	//商品名入力チェックメソッド
	public static String gnamecheck(String gname) {

		String errorMsg = null;

		if (gname.isEmpty()) {
			//商品名未入力チェック
			errorMsg = GNAME_EMPTY;
		} else if (gname.length() > 40) {
			//商品名文字数チェック
			errorMsg = GNAME_LENGTH_OVER;
		}
		return errorMsg;
	}

	//仕入れ先入力チェックメソッド
	public static String suppliercheck(String supplier) {

		String errorMsg = null;

		if (supplier.isEmpty()) {
			//仕入れ先未入力チェック
			errorMsg = SUPPLIER_EMPTY;
		} else if (supplier.length() > 50) {
			//仕入れ先文字数チェック
			errorMsg = SUPPLIER_LENGTH_OVER;
		}
		return errorMsg;
	}

	//在庫数入力チェックメソッド
	public static String stockcheck(String stock) {

		String errorMsg = null;

		if (stock.isEmpty()) {
			//在庫数未入力チェック
			errorMsg = STOCKING_DATE_EMPTY;
		} else if (stock.length() > 10) {
			//在庫数文字数チェック
			errorMsg = STOCKING_DATE_LENGTH_OVER;
		}
		return errorMsg;
	}

	//画像ファイル名チェックメソッド
	public static String savecheck(String save) {

		String errorMsg = null;

		if (save.length() > 50) {
			//画像ファイル名文字数チェック
			errorMsg = STOCKING_DATE_EMPTY;
		}
		return errorMsg;
	}

	//詳細情報チェックメソッド
	public static String detailcheck(String detail) {

		String errorMsg = null;

		if (detail.length() > 900) {
			//詳細情報文字数チェック
			errorMsg = DETAIL_LENGTH_OVER;
		}
		return errorMsg;
	}

	//価格未入力チェックメソッド
	public static String pricecheck(String price) {

		String errorMsg = null;

		if (price.length() == 0) {
			//価格未入力チェック
			errorMsg = PRICE_EMPTY;
		}
		return errorMsg;
	}

	//価格未入力チェックメソッド
	public static String catidcheck(String catid) {

		String errorMsg = null;

		if (catid.length() == 0) {
			//価格未入力チェック
			errorMsg = CATID_EMPTY;
		}
		return errorMsg;
	}

	//カテゴリー名入力チェックメソッド
	public static String catnamecheck(String cname) {

		String errorMsg = null;

		if (cname.isEmpty()) {
			//カテゴリー名未入力チェック
			errorMsg = CAT_NAME_EMPTY;
		} else if (cname.length() > 40) {
			//カテゴリー名文字数チェック
			errorMsg = CAT_NAME_LENGTH_OVER;
		}
		return errorMsg;
	}
}
