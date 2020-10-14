package kr.co.greentable.admin.vo;

public class SalesRangeVO {

	String order_date;
	int startNum,endNum;
	
	
	public SalesRangeVO(String order_date, int startNum, int endNum) {
		super();
		this.order_date = order_date;
		this.startNum = startNum;
		this.endNum = endNum;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getEndNum() {
		return endNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	
}
