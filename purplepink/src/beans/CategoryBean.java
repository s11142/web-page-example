package beans;

import java.io.Serializable;

public class CategoryBean implements Serializable{
	private static final long serialVersionUID = 1L;
	/** カテゴリーId */
	private int Category_id;

	/** カテゴリー名前 */
	private String Category_name;


	/** カテゴリーId */
	public int getCategory_id() {
		return Category_id;
	}

	public void setCategory_id(int category_id) {
		Category_id = category_id;
	}


	/** カテゴリー名前 */
	public String getCategory_name() {
		return Category_name;
	}

	public void setCategory_name(String ctegory_name) {
		Category_name = ctegory_name;
	}



}
