package kr.co.greentable.admin.domain;

public class SelectAskListDomain {
	String ask_num, id, ask_category, ask_subject, ask_date, answer_date; //chkAnswer가 컬럼에 없음. 왜 없는? 

	public String getAsk_num() {
		return ask_num;
	}

	public void setAsk_num(String ask_num) {
		this.ask_num = ask_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAsk_category() {
		return ask_category;
	}

	public void setAsk_category(String ask_category) {
		this.ask_category = ask_category;
	}

	public String getAsk_subject() {
		return ask_subject;
	}

	public void setAsk_subject(String ask_subject) {
		this.ask_subject = ask_subject;
	}

	public String getAsk_date() {
		return ask_date;
	}

	public void setAsk_date(String ask_date) {
		this.ask_date = ask_date;
	}

	public String getAnswer_date() {
		return answer_date;
	}

	public void setAnswer_date(String answer_date) {
		this.answer_date = answer_date;
	}
	
}//class 
