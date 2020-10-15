package kr.co.greentable.admin.service;

import java.util.List;

import kr.co.greentable.admin.dao.MemberDAO;
import kr.co.greentable.admin.domain.SelectMemberDetailDomain;
import kr.co.greentable.admin.domain.SelectMemberListDomain;
import kr.co.greentable.admin.vo.MemberRangeVO;
import kr.co.greentable.admin.vo.ModifyMemberVO;

public class MemberService {
	
	/**
	 * 전체 회원의 수
	 * @return totalCnt: 전체 회원의 수
	 */
	public int totalCount() {
		
		int totalCnt = 0;
		
		MemberDAO mDAO = MemberDAO.getInstance();
		totalCnt = mDAO.selectMemberCnt();
		
		return totalCnt;
	}//totalCount
	
	
	/**
	 * 한 화면에 보여줄 게시물의 수: 10건
	 * @return
	 */
	public int pageScale() {
		
		int pageScale = 5;
		
		return pageScale;
	}//pageScale
	
	
	/**
	 * 총 페이지 수
	 * @param totalCount
	 * @param pageScale
	 * @return
	 */
	public int totalPage( int totalCount, int pageScale) {
		
		int totalPage = (int)Math.ceil( (double)totalCount / pageScale );
		
		return totalPage;
	}//totalPage
	
	
	/**
	 * 시작번호
	 * @param currentPage
	 * @param pageScale
	 * @return
	 */
	public int startNum( int currentPage, int pageScale) {
		
		int startNum = currentPage * pageScale - pageScale + 1;
		
		return startNum;
	}//startNum
	
	
	/**
	 * 끝번호
	 * @param startNum
	 * @param pageScale
	 * @return
	 */
	public int endNum( int startNum, int pageScale) {
		
		int endNum = startNum + pageScale - 1;
		
		return endNum;
	}//endNum
	
	
	/**
	 * 회원관리 전체 회원 리스트
	 * 페이지네이션 계산 MemberRangeVO(startNum, endNum) 
	 * @param mrVO
	 * @return
	 */
	public List<SelectMemberListDomain> selectMemberList(MemberRangeVO mrVO) {
		
		List<SelectMemberListDomain> list = null;
		
		MemberDAO mDAO = MemberDAO.getInstance();
		list = mDAO.selectMemberList(mrVO);
		
		return list;
	}//selectMemberList
	
	/**
	 * 아이디로 한 행 조회
	 * @param id
	 * @return
	 */
	public SelectMemberDetailDomain selectMemberDetailList(String id) {
		
		SelectMemberDetailDomain smdd = null;

		MemberDAO mDAO = MemberDAO.getInstance();
		smdd = mDAO.selectMemberOneList(id);
		
		return smdd;
	}//selectMemberDetailList
	
	/**
	 * 회원 삭제
	 * @param id
	 * @return
	 */
	public boolean removeMember(String id) {

		boolean flag = false;

		MemberDAO mDAO = MemberDAO.getInstance();
		flag = mDAO.deleteMember(id) == 1;

		return flag;
	}//removeMember
	
	/**
	 * 회원 수정
	 * @param mmVO
	 * @return
	 */
	public boolean modifyMember( ModifyMemberVO mmVO) {

		boolean flag = false;

		MemberDAO mDAO = MemberDAO.getInstance();
		flag = mDAO.updateMember(mmVO) == 1; //한 행이 변경되면 false 아니면 true?

		return flag;
	}//modifyMember

}//class
