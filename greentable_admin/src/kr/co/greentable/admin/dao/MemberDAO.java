package kr.co.greentable.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.greentable.admin.domain.SelectMemberDetailDomain;
import kr.co.greentable.admin.domain.SelectMemberListDomain;
import kr.co.greentable.admin.vo.MemberRangeVO;
import kr.co.greentable.admin.vo.ModifyMemberVO;

public class MemberDAO {

	private static MemberDAO mDAO;

	private MemberDAO() {
	}//MemberDAO

	public static MemberDAO getInstance() {
		if( mDAO == null ) {
			mDAO = new MemberDAO();
		}//end if

		return mDAO;
	}//getInstance


	public int selectMemberCnt() {

		int cnt = 0;

		//MyBatis Handler 얻기
		SqlSession ss = GetMyBatisHandler_jh.getInstance().getSqlSession();
		cnt = ss.selectOne("kr.co.greentable.member.allMemberCnt");
		ss.close();

		return cnt;
	}//selectMemberCnt


	/**
	 * 회원관리 리스트 조회 (아이디, 이름, 이메일, 가입일)
	 * 페이지네이션 MemberRangeVO(startNum, endNum)
	 * @param mrVO
	 * @return
	 */
	public List<SelectMemberListDomain> selectMemberList( MemberRangeVO mrVO) {

		List<SelectMemberListDomain> list = null;

		//MyBatis Handler 얻기
		SqlSession ss = GetMyBatisHandler_jh.getInstance().getSqlSession();
		list = ss.selectList("selectMemberList", mrVO); 
		ss.close();

		return list;
	}//selectMemberList


	/**
	 * id로 한 행을 조회
	 * @param id
	 * @return
	 */
	public SelectMemberDetailDomain selectMemberOneList( String id) {

		SelectMemberDetailDomain smdd = null;

		//MyBatis Handler 얻기
		SqlSession ss = GetMyBatisHandler_jh.getInstance().getSqlSession();
		smdd = ss.selectOne("selectMemberDetailList", id);
		ss.close();

		return smdd;
	}//selectMemberOneList


	public int deleteMember( String id) {

		int cnt = 0;

		SqlSession ss = GetMyBatisHandler_jh.getInstance().getSqlSession();
		cnt = ss.delete("deleteMember", id);

		if( cnt == 1 ) {
			ss.commit();
		}//end if

		ss.close();

		return cnt;
	}//deleteMember


	public int updateMember( ModifyMemberVO mmVO) {

		int cnt = 0;

		SqlSession ss = GetMyBatisHandler_jh.getInstance().getSqlSession();
		cnt = ss.update("updateMember", mmVO);

		if( cnt == 1 ) {
			ss.commit();
			System.out.println("수정완료");
		}//end if

		ss.close();

		return cnt;
	}//updateMyBatis


	public static void main(String[] args) {
		//단위 테스트
		//		MemberRangeVO mrVO = new MemberRangeVO();
		//		mrVO.setStartNum(1);
		//		mrVO.setEndNum(10);

		ModifyMemberVO mmVO = new ModifyMemberVO();
		//		mmVO.setId("park9396");
		mmVO.setId("kim1");
		mmVO.setEmail("park3@daum.net");
		mmVO.setAddr1("서울시 마포구 셔교동");
		mmVO.setAddr2("푸르지오2차 아파트 101호");
		mmVO.setZipcode("00421");
		mmVO.setPhone("01031314646");

		System.out.println(MemberDAO.getInstance().updateMember(mmVO) );
	}

}//class
