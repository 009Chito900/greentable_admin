package kr.co.greentable.admin.service;

import java.util.List;

import kr.co.greentable.admin.dao.AdminAskDAO;
import kr.co.greentable.admin.domain.SelectAskDetailDomain;
import kr.co.greentable.admin.domain.SelectAskListDomain;
import kr.co.greentable.admin.vo.AskRangeVO;
import kr.co.greentable.admin.vo.UpdateAnswerVO;

public class AdminAskService {
	
	/**
	 * 전체 문의글의 수 : DB사용
	 * @return totalCnt : 전체 문의글 수 
	 */
	public int totalCount() {
		int totalCnt=0;
		
		AdminAskDAO adaskDAO=AdminAskDAO.getInstance();
		totalCnt=adaskDAO.selectAskCnt();
		
		return totalCnt;
	}//totalCount
	
	/**
	 * 한 화면에 보여줄 게시물의 수. 10건
	 * @return
	 */
	public int pageScale() {
		int pageScale=10;
		
		return pageScale;
	}//pageScale
	
	/**
	 * 총 페이지수 
	 * @param totalCount
	 * @param pageScale
	 * @return
	 */
	public int totalPage( int totalCount, int pageScale) {
		
		int totalPage=(int)Math.ceil( (double)totalCount /pageScale);
		
		return totalPage;
	}//totalPage
	
	/**
	 * 시작번호. 
	 * @return
	 */
	public int startNum( int currentPage, int pageScale ) {
		int startNum= currentPage*pageScale-pageScale+1 ;
		return startNum;
	}//startNum
	
	/**
	 *  끝 번호. 
	 * @return
	 */
	public int  endNum( int startNum, int pageScale ) {
		int endNum=startNum+pageScale-1;
		return endNum;
	}//endNum
	
	/**
	 * 전체 문의글 조회
	 * 
	 * @param arVO : startNum, endNum
	 * @return
	 */
	public List<SelectAskListDomain> searchAskList( AskRangeVO arVO ) {
		//DAO
		AdminAskDAO adaskDAO=AdminAskDAO.getInstance();
		
	
		List<SelectAskListDomain> list = null;
		
		list=adaskDAO.selectAskList( arVO );

		return list;
	}// searchAskList

	/**
	 * ask_num을 받아서 문의글 상세 내용을 조회하는 일.
	 * 
	 * @param ask_num 문의글 번호
	 * @return 문의글 상세 내용
	 */
	 public SelectAskDetailDomain searchAskDetail( String ask_num ) {
		 AdminAskDAO adaskDAO=AdminAskDAO.getInstance();
		 
		 SelectAskDetailDomain sadd=null;
		 sadd=adaskDAO.selectAskDetail(ask_num);
		 
		 return sadd;
	 }//searchAskDetail
		 

	 public int updateAnswer( UpdateAnswerVO uaVO ) { 
		 AdminAskDAO adaskDAO=AdminAskDAO.getInstance();
		 
		 int cnt=0;
		 cnt=adaskDAO.updateAnswer(uaVO);
	
		 return cnt; 
	 }//updateAnswer
	 
	 public int removeAsk( String ask_num ) {
		 AdminAskDAO adaskDAO=AdminAskDAO.getInstance();
		 
		 int cnt=0;
		 cnt=adaskDAO.removeAsk(ask_num);
	
		 return cnt; 
	 }//removeAsk
	 
}// class
