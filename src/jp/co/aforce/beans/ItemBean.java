package jp.co.aforce.beans;

import java.io.Serializable;

public class ItemBean implements Serializable {

	private ProductBean productbean;
	private int count;
	private int total;

	public ProductBean getProductbean() {
		return productbean;
	}

	public void setProductbean(ProductBean productbean) {
		this.productbean = productbean;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
