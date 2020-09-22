package kr.co.greentable.admin.domain;

/**
 * 관리자 회원관리 리스트 Domain
 * ( 첫 페이지 )
 * @author sist27
 *
 */
public class SelectMemberListDomain {
	
	String id, name, email, join_date;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJoin_date() {
		return join_date;
	}

	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}
	
}
