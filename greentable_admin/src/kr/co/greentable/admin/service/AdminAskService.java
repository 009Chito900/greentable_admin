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
	 * �Խ����� ù��° ��ȣ�� ����ȣ�� �޾Ƽ� �Խ����� ����Ʈ�� ��ȸ�ϴ� ��.
	 * 
	 * @param arVO
	 * @return
	 */
	public List<SelectAskListDomain> searchAskList(AskRangeVO arVO) {
		List<SelectAskListDomain> list = null;
		
		//DAO���
		AdminAskDAO adaskDAO=AdminAskDAO.getInstance();
		list=adaskDAO.selectAskList(arVO);

		return list;
	}// searchAskList

	/**
	 * �۹�ȣ�� �޾Ƽ� DB���� ���Ǳ� �󼼳����� ��ȸ �ϴ� ��
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
	 * //���̿��� �¾ �ذ� �ԷµǾ� �ֱ� ������, ���̷� �����Ͽ� �缳���Ѵ�.
	 * ambVO.setAge(nowYear-ambVO.getAge() +1 ); //DAO��� : MyBatis ExamMyBatisDAO
	 * embDAO=ExamMyBatisDAO.getInstance(); try {
	 * cnt=embDAO.insertTestMyBatis(ambVO); } catch (SQLException e) {
	 * e.printStackTrace(); }
	 * 
	 * 
	 * return sadDomain; }//searchAskDetail
	 * 
	 *//**
		 * �߰�/����/������ ���Ǳ� �亯�� DB�� update�ϴ� ��.
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
	 * //���̿��� �¾ �ذ� �ԷµǾ� �ֱ� ������, ���̷� �����Ͽ� �缳���Ѵ�.
	 * ambVO.setAge(nowYear-ambVO.getAge() +1 ); //DAO��� : MyBatis ExamMyBatisDAO
	 * embDAO=ExamMyBatisDAO.getInstance(); try {
	 * cnt=embDAO.insertTestMyBatis(ambVO); } catch (SQLException e) {
	 * e.printStackTrace(); }
	 * 
	 * 
	 * return cnt; }//addAnswer
	 * 
	 *//**
		 * ���Ǳ��� DB�� delete�ϴ� ��.
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
			 * //���̿��� �¾ �ذ� �ԷµǾ� �ֱ� ������, ���̷� �����Ͽ� �缳���Ѵ�.
			 * ambVO.setAge(nowYear-ambVO.getAge() +1 ); //DAO��� : MyBatis ExamMyBatisDAO
			 * embDAO=ExamMyBatisDAO.getInstance(); try {
			 * cnt=embDAO.insertTestMyBatis(ambVO); } catch (SQLException e) {
			 * e.printStackTrace(); }
			 * 
			 * 
			 * return cnt; }//removeAsk
			 */
}// class
