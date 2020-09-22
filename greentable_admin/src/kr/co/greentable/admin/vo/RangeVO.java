package kr.co.greentable.admin.vo;

/**
 * 관리자 회원관리 Pagination
 * 시작번호, 끝번호
 * @author sist27
 *
 */
public class RangeVO {
	
	String id, startNum, endNum;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStartNum() {
		return startNum;
	}

	public void setStartNum(String startNum) {
		this.startNum = startNum;
	}

	public String getEndNum() {
		return endNum;
	}

	public void setEndNum(String endNum) {
		this.endNum = endNum;
	}

}
