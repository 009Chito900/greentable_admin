package kr.co.greentable.admin.vo;

public class AskRangeVO {
	int startNum, endNum;
	
	public AskRangeVO() {
	}

	public AskRangeVO(int startNum, int endNum) {
		this.startNum = startNum;
		this.endNum = endNum;
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
	
}//class
