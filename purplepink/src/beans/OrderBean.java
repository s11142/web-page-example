package beans;
import java.io.Serializable;
/**
 * 商品テーブル用bean
 *
 * @author Kazuki Ito
 *
 */
public class OrderBean implements Serializable{

	/** 伝票番号*/
	private int order_id ;
	/** 購入商品Id*/
	private int GoodsId;
	/** 購入商品名*/
	private String GoodsName;
	/** 購入者ID */
    private int user_id;
	/** 購入数*/
	private int order_quantity ;
	/** 購入日*/
	private String order_date  ;

    //以下各フィールドのgetter及びsetterの記述である。

	/** 伝票番号*/
	public int getOrder_id() {
		return order_id;}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;}


	/** 購入商品Id*/
	public int getGoodsId() {
		return GoodsId;}
	public void setGoodsId(int goodsId) {
		GoodsId = goodsId;}


	/** 商品の名前*/
	public String getGoodsName() {
		return GoodsName;}
	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;}


	/** 購入者ID */
	public int getUser_id() {
		return user_id;}
	public void setUser_id(int user_id) {
		this.user_id = user_id;}


	/** 購入数*/
	public int getOrder_quantity() {
		return order_quantity;}
	public void setOrder_quantity(int order_quantity) {
		this.order_quantity = order_quantity;}


	/** 購入日*/
	public String getOrder_date() {
		return order_date;}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;}

}
