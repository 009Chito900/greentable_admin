package kr.co.greentable.admin.domain;

public class ReceiverDomain {

	String /* order_date, */ receiver_name, receiver_phone, receiver_addr1, receiver_addr2, receiver_zipcode;

	/*
	 * public String getOrder_date() { return order_date; }
	 * 
	 * public void setOrder_date(String order_date) { this.order_date = order_date;
	 * }
	 */

	public String getReceiver_name() {
		return receiver_name;
	}

	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}

	public String getReceiver_phone() {
		return receiver_phone;
	}

	public void setReceiver_phone(String receiver_phone) {
		this.receiver_phone = receiver_phone;
	}

	public String getReceiver_addr1() {
		return receiver_addr1;
	}

	public void setReceiver_addr1(String receiver_addr1) {
		this.receiver_addr1 = receiver_addr1;
	}

	public String getReceiver_addr2() {
		return receiver_addr2;
	}

	public void setReceiver_addr2(String receiver_addr2) {
		this.receiver_addr2 = receiver_addr2;
	}

	public String getReceiver_zipcode() {
		return receiver_zipcode;
	}

	public void setReceiver_zipcode(String receiver_zipcode) {
		this.receiver_zipcode = receiver_zipcode;
	}

	@Override
	public String toString() {
		return "ReceiverDomain [receiver_name=" + receiver_name + ", receiver_phone=" + receiver_phone
				+ ", receiver_addr1=" + receiver_addr1 + ", receiver_addr2=" + receiver_addr2 + ", receiver_zipcode="
				+ receiver_zipcode + "]";
	}

}
