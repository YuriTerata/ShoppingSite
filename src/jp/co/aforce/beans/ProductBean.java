package jp.co.aforce.beans;

import java.io.Serializable;

public class ProductBean implements Serializable {

	private int product_num;
	private String product_name;
	private int product_price;
	private String description;
	private String product_gr;

	public int getProduct_num() {
		return product_num;
	}

	public void setProduct_num(int product_num) {
		this.product_num = product_num;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProduct_gr() {
		return product_gr;
	}

	public void setProduct_gr(String product_gr) {
		this.product_gr = product_gr;
	}

}
