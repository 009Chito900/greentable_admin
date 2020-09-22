package kr.co.greentable.admin.service;

import java.util.List;

import kr.co.greentable.admin.dao.MemberDAO;
import kr.co.greentable.admin.domain.SelectMemberListDomain;

/**
 * 관리자 회원관리 Service
 * @author sist27
 *
 */
public class MemberService {
	
	public List<SelectMemberListDomain> selectMemberList(String currentPage, String id) {
		
		List<SelectMemberListDomain> list = null;
		
		//DAO 사용
		MemberDAO mDAO = MemberDAO.getInstance();
		
		//RangeVO를 사용하여 연산된 시작번호 끝번호를 가지고 , 아이디를 저장
		//조회하는 모든 값들을 합쳐서 넣어줘야 한다.
		list = mDAO.selectMemberList(id);
		
		return list;
	}//selectMemberList
	
}//class
