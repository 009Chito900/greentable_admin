package kr.co.greentable.admin.vo;

/**
 * ������ ȸ������ Pagination
 * ���۹�ȣ, ����ȣ
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
