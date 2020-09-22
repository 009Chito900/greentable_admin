package kr.co.greentable.admin.service;

import java.util.List;

import kr.co.greentable.admin.dao.MemberDAO;
import kr.co.greentable.admin.domain.SelectMemberListDomain;

/**
 * ������ ȸ������ Service
 * @author sist27
 *
 */
public class MemberService {
	
	public List<SelectMemberListDomain> selectMemberList(String currentPage, String id) {
		
		List<SelectMemberListDomain> list = null;
		
		//DAO ���
		MemberDAO mDAO = MemberDAO.getInstance();
		
		//RangeVO�� ����Ͽ� ����� ���۹�ȣ ����ȣ�� ������ , ���̵� ����
		//��ȸ�ϴ� ��� ������ ���ļ� �־���� �Ѵ�.
		list = mDAO.selectMemberList(id);
		
		return list;
	}//selectMemberList
	
}//class
