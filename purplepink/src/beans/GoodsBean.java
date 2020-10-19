package beans;

import java.io.Serializable;
/**
 * 商品テーブル用bean
 *
 * @author Kazuki Ito
 *
 */
public class GoodsBean implements Serializable{
	private static final long serialVersionUID = 1L;

	/** 商品Id*/
	private int GoodsId;
	/** 商品の名前*/
	private String GoodsName;
	/** 商品の値段*/
	private int Price;
	/** 仕入れ先*/
	private String Supplier;
	/** 仕入れ時期*/
	private String  StockingDate;
	/**カテゴリーId*/
	private int CategoryId;
	/** カテゴリーの名前*/
	private String CategoryName;
	/** 在庫 */
	private int Quantity;
	/** 画像の名称保存先 */
	private String Save;
	/** 詳細情報 */
	private String Detail;
	/** 論理フラッグ */
	private int flag;



    //以下各フィールドのgetter及びsetterの記述である。

	/** 商品Id*/
	public int getGoodsId() {
		return GoodsId;
	}
	public void setGoodsId(int goodsId) {
		GoodsId = goodsId;
	}


	/** 商品の名前*/
	public String getGoodsName() {
		return GoodsName;
	}
	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;
	}


	/** 商品の値段*/
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}


	/** 仕入れ先*/
	public String getSupplier() {
		return Supplier;
	}
	public void setSupplier(String supplier) {
		Supplier = supplier;
	}


	/** 仕入れ時期*/
	public String getStockingDate() {
		return StockingDate;
	}
	public void setStockingDate(String stockingDate) {
		StockingDate = stockingDate;
	}


	/**カテゴリーId*/
	public int getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}


	/** カテゴリーの名前*/
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	/** 在庫 */
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}


	/** 画像の名称保存先 */
	public String getSave() {
		return Save;
	}
	public void setSave(String save) {
		Save = save;
	}

	/** 詳細情報 */
	public String getDetail() {
		return Detail;
	}
	public void setDetail(String detail) {
		Detail = detail;
	}


	/** 論理フラッグ */
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}

}
