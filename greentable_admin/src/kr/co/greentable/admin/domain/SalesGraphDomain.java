package kr.co.greentable.admin.domain;

public class SalesGraphDomain {

	private String main_ctg_name, product_name, option_name;
	private int option_price,quantity,total_price;
	public String getMain_ctg_name() {
		return main_ctg_name;
	}
	public void setMain_ctg_name(String main_ctg_name) {
		this.main_ctg_name = main_ctg_name;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getOption_name() {
		return option_name;
	}
	public void setOption_name(String option_name) {
		this.option_name = option_name;
	}
	public int getOption_price() {
		return option_price;
	}
	public void setOption_price(int option_price) {
		this.option_price = option_price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

}
