package util;

/**
 * 定数をまとめたクラス
 *
 * @author System Shared
 *
 */
public class Constants {

    /** 一般会員の権限を表す */
    public static final int NORMAL_MEMBER = 1;

    /** 運用管理者の権限を表す */
    public static final int GENERAL_MANAGER = 2;

    /** システム管理者の権限を表す */
    public static final int SYSTEM_MANAGER = 3;

    /** 男性を表す */
    public static final int MAN = 1;

    /** 女性を表す */
    public static final int WOMAN = 2;

    /** メールアドレス(会員・管理者ID)、またはパスワードが間違っていた場合のエラーメッセージ */
    public static final String MAIL_OR_PASSWORD_MISMATCH = "メールアドレス、またはパスワードが間違っています。";

    /** メールアドレス(会員・管理者ID)の桁数が50桁を超えた場合のチェックエラーメッセージ */
    public static final String MAIL_LENGTH_OVER = "メールアドレスは50桁以内で入力してください。";

    /** メールアドレス(会員・管理者ID)が未入力のエラーメッセージ */
    public static final String MAIL_EMPTY = "メールアドレスを入力してください。";

    /** パスワードが未入力のエラーメッセージ */
    public static final String PASSWORD_EMPTY = "パスワードを入力してください。";

    /** パスワードの入力文字が15文字以上の場合のエラーメッセージ */
    public static final String PASSWORD_LENGTH_OVER = "パスワードは16文字以内で入力してください。";

    /** 名前が未入力のエラーメッセージ */
    public static final String NAME_EMPTY = "ユーザー名を入力してください。";

    /** 名前の入力文字が20文字を超えた場合のエラーメッセージ */
    public static final String NAME_LENGTH_OVER = "会員名は20文字以内で入力してください。";

    /** 性別が未選択のエラーメッセージ */
    public static final String GENDER_EMPTY = "性別が未選択です";

    /** 性別の値が予期しない値時のエラーメッセージ */
    public static final String GENDER_MISSMATCH = "性別の値が不正です";

    /** 住所が未入力のエラーメッセージ */
    public static final String ADDRESS_EMPTY = "住所を入力してください。";

    /** 住所の入力文字が50文字を超えた場合のエラーメッセージ */
    public static final String ADDRESS_LENGTH_OVER = "住所は50文字以内で入力してください。";

    /** 生年月日が未入力のエラーメッセージ */
    public static final String BIRTHDAY_EMPTY = "生年月日を入力してください。";

    /** 生年月日の値が予期しない値時のエラーメッセージ */
    public static final String BIRTHDAY_MISSMATCH = "正しい日付を入力してください。";

    /** 権限が未選択のエラーメッセージ */
    public static final String AUTHORITY_EMPTY = "権限が未選択です";

    /** 権限の値が予期しない値時のエラーメッセージ */
    public static final String AUTHORITY_MISSMATCH = "権限の値が不正です";

    /** 生年月日の入力値をチェックする正規表現 */
    public static final String BIRTHDAY_MATCH_CHECK = "^(\\d{4})/(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])$";

    /** 在庫数のエラーメッセージ */
    public static final String QUANTITY_CHECK = "在庫数に限りがございます";

    /** 購入数が未入力の際のエラーメッセージ */
    public static final String QUANTITY_OF_PURCHASE_EMPTY = "購入数を入力してください";

    /** 商品名が未入力のエラーメッセージ */
    public static final String GNAME_EMPTY = "商品名を入力してください。";

    /** 商品名の入力文字が40文字を超えた場合のエラーメッセージ */
    public static final String GNAME_LENGTH_OVER = "商品名は40文字以内で入力してください。";

    /** 仕入れ先が未入力のエラーメッセージ */
    public static final String SUPPLIER_EMPTY = "仕入れ先を入力してください。";

    /** 仕入れ先の入力文字が50文字を超えた場合のエラーメッセージ */
    public static final String SUPPLIER_LENGTH_OVER = "仕入れ先は50文字以内で入力してください。";

    /** 在庫数が未入力のエラーメッセージ */
    public static final String STOCKING_DATE_EMPTY = "在庫数を入力してください。";

    /** 在庫数の入力文字が10桁を超えた場合のエラーメッセージ */
    public static final String STOCKING_DATE_LENGTH_OVER = "在庫数は10桁以内で入力してください。";

    /** 画像ファイル名の入力文字が50文字を超えた場合のエラーメッセージ */
    public static final String SAVE_LENGTH_OVER = "画像ファイル名は50文字以内で入力してください。";

    /** 詳細情報の入力文字が900文字を超えた場合のエラーメッセージ */
    public static final String DETAIL_LENGTH_OVER = "詳細情報は900文字以内で入力してください。";

    /** 価格が未入力のエラーメッセージ */
    public static final String PRICE_EMPTY = "価格を入力してください。";

    /** カテゴリーIDが未入力のエラーメッセージ */
    public static final String CATID_EMPTY = "カテゴリーIDを入力してください。";

    /** カテゴリー名が未入力のエラーメッセージ */
    public static final String CAT_NAME_EMPTY = "カテゴリー名を入力してください。";

    /** カテゴリー名の入力文字が30文字を超えた場合のエラーメッセージ */
    public static final String CAT_NAME_LENGTH_OVER = "カテゴリー名は30文字以内で入力してください。";

}