package kr.co.greentable.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.greentable.admin.domain.SelectAskDetailDomain;
import kr.co.greentable.admin.domain.SelectAskListDomain;
import kr.co.greentable.admin.vo.AskRangeVO;
import kr.co.greentable.admin.vo.UpdateAnswerVO;

public class AdminAskDAO {

private static AdminAskDAO aaDAO;
	
	private AdminAskDAO() {
		
	}//AdminAskDAO
//	
	public static AdminAskDAO getInstance() {
		if( aaDAO == null) {
			aaDAO=new AdminAskDAO();
		}//end if 
		return aaDAO;
	}//getInstance

	/**
	 * 전체 문의글 수를 계산하는 일.
	 * @return 총 문의글 수 
	 */
	public int selectAskCnt() {
		int cnt=0;
		
		//SQL
		SqlSession ss=AskGetMyBatisHandler.getInstance().getSqlSession();
		cnt=ss.selectOne("kr.co.greentable.admin.ask.allAskCnt");
		
		return cnt;
	}//selectAskCnt
	
	/**
	 * 전체 문의글을 조회하는 일.
	 * @return
	 */
	public List<SelectAskListDomain> selectAskList( AskRangeVO arVO ) {
		List<SelectAskListDomain> list = null;
		// MyBatisHandler 
		SqlSession ss=AskGetMyBatisHandler.getInstance().getSqlSession();
		list = ss.selectList("kr.co.greentable.admin.ask.selectAllAsk", arVO);
		ss.close();

		return list;
	}//selectAskList

	/**
	 * ask_num을 받아 상세 문의글을 조회하는 일.
	 * @param ask_num
	 * @return
	 */
	public SelectAskDetailDomain selectAskDetail( String ask_num ) { 
		SelectAskDetailDomain sadd=null;
		
		// MyBatisHandler 
		SqlSession ss=AskGetMyBatisHandler.getInstance().getSqlSession();
		sadd=ss.selectOne("kr.co.greentable.admin.ask.selectAskDetail",ask_num);
		ss.close();
		
		return sadd;
	}//selectAskDetail
	
	/**
	 * 문의글 답변을 추가/수정하는 일.
	 * @param aaVO
	 * @return
	 */
	public int updateAnswer( UpdateAnswerVO uaVO ) {
		int cnt=0;
		
		SqlSession ss=AskGetMyBatisHandler.getInstance().getSqlSession();
		cnt=ss.update("updateAnswer", uaVO);
		
		if(cnt == 1) {
			ss.commit();
		}//end if
		ss.close();
		return cnt;
	}//insertAnswer
	
	/**
	 * 문의글을 삭제하는 일
	 * @param ask_num
	 * @return
	 */
	public int removeAsk( String ask_num ) {
		int cnt=0;
		
		SqlSession ss=AskGetMyBatisHandler.getInstance().getSqlSession();
		cnt=ss.delete("deleteAsk", ask_num);
		
		if(cnt == 1) {
			ss.commit();
		}//end if
		ss.close();
		return cnt;
	}//removeAsk
//	
	
	 public static void main(String[] args) {
		System.out.println(AdminAskDAO.getInstance().selectAskCnt());
	 }//main
//	 
	
	 }// class 
