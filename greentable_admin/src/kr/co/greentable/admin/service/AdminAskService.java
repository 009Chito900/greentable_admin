package kr.co.greentable.admin.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import kr.co.greentable.admin.dao.AdminAskDAO;
import kr.co.greentable.admin.domain.SelectAskListDomain;
import kr.co.greentable.admin.vo.AddAnswerVO;
import kr.co.greentable.admin.vo.AskRangeVO;

public class AdminAskService {
	/**
	 * 게시판의 첫번째 번호와 끝번호를 받아서 게시판의 리스트를 조회하는 일.
	 * 
	 * @param arVO
	 * @return
	 */
	public List<SelectAskListDomain> searchAskList(AskRangeVO arVO) {
		List<SelectAskListDomain> list = null;
		
		//DAO사용
		AdminAskDAO adaskDAO=AdminAskDAO.getInstance();
		list=adaskDAO.selectAskList(arVO);

		return list;
	}// searchAskList

	/**
	 * 글번호를 받아서 DB에서 문의글 상세내용을 조회 하는 일
	 * 
	 * @param ambVO
	 * @return
	 */
	/*
	 * public selectAskDetailDomain searchAskDetail( String askNum ) {
	 * selectAskDetailDomain sadDomain=new selectAskDetailDomain();
	 * 
	 * int cnt=0;
	 * 
	 * Calendar cal=Calendar.getInstance(); int nowYear=cal.get(Calendar.YEAR);
	 * 
	 * //나이에는 태어난 해가 입력되어 있기 때문에, 나이로 연산하여 재설정한다.
	 * ambVO.setAge(nowYear-ambVO.getAge() +1 ); //DAO사용 : MyBatis ExamMyBatisDAO
	 * embDAO=ExamMyBatisDAO.getInstance(); try {
	 * cnt=embDAO.insertTestMyBatis(ambVO); } catch (SQLException e) {
	 * e.printStackTrace(); }
	 * 
	 * 
	 * return sadDomain; }//searchAskDetail
	 * 
	 *//**
		 * 추가/수정/삭제한 문의글 답변을 DB에 update하는 일.
		 * 
		 * @param ambVO
		 * @return
		 */
	/*
	 * public int addAnswer( AddAnswerVO adaVO ) { int cnt=0;
	 * 
	 * int cnt=0;
	 * 
	 * Calendar cal=Calendar.getInstance(); int nowYear=cal.get(Calendar.YEAR);
	 * 
	 * //나이에는 태어난 해가 입력되어 있기 때문에, 나이로 연산하여 재설정한다.
	 * ambVO.setAge(nowYear-ambVO.getAge() +1 ); //DAO사용 : MyBatis ExamMyBatisDAO
	 * embDAO=ExamMyBatisDAO.getInstance(); try {
	 * cnt=embDAO.insertTestMyBatis(ambVO); } catch (SQLException e) {
	 * e.printStackTrace(); }
	 * 
	 * 
	 * return cnt; }//addAnswer
	 * 
	 *//**
		 * 문의글을 DB에 delete하는 일.
		 * 
		 * @param ambVO
		 * @return
		 *//*
			 * public int removeAsk( String askNum ) { int cnt=0;
			 * 
			 * int cnt=0;
			 * 
			 * Calendar cal=Calendar.getInstance(); int nowYear=cal.get(Calendar.YEAR);
			 * 
			 * //나이에는 태어난 해가 입력되어 있기 때문에, 나이로 연산하여 재설정한다.
			 * ambVO.setAge(nowYear-ambVO.getAge() +1 ); //DAO사용 : MyBatis ExamMyBatisDAO
			 * embDAO=ExamMyBatisDAO.getInstance(); try {
			 * cnt=embDAO.insertTestMyBatis(ambVO); } catch (SQLException e) {
			 * e.printStackTrace(); }
			 * 
			 * 
			 * return cnt; }//removeAsk
			 */
}// class
