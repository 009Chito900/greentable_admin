package kr.co.greentable.admin.domain;

import java.util.List;


public class OrderDomain {
	String order_num,id,name,product_name;
	List<OptionDomain> optionList;
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public List<OptionDomain> getOptionList() {
		return optionList;
	}
	public void setOptionList(List<OptionDomain> optionList) {
		this.optionList = optionList;
	}
	
}
