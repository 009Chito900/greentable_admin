package kr.co.greentable.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.greentable.admin.service.AdminAskService;
import kr.co.greentable.admin.vo.AddAnswerVO;
import kr.co.greentable.admin.vo.AskRangeVO;

@Controller
public class AdminAskController {
	/**
	 * ���Ǳ��� ������ ��ȸ�Ͽ�, ����Ʈ�� adAskList.jsp�� �ѷ��ִ� ��.
	 * @param currentPage : ���� ������ model : �Խñ��� ����
	 * @return 
	 */
	@RequestMapping(value="/admin/askList.do", method = GET)
	public String askList( String currentPage, Model model ) {
			
			AskRangeVO arVO=null;
			arVO.setStartNum(1);
			arVO.setEndNum(10); //���Ƿ� ���� ����
		
			if( currentPage == null ) {
				currentPage="1";
			}//end if
			
			//���񽺸� �����ϰ� ����ó�� ����� ��´�.
			AdminAskService aas=new AdminAskService();
			//����ó�� ����� �𵨿� ���� 
			model.addAttribute("list_data", aas.searchAskList(arVO));
			
			return "admin/adAskList";
		}//askList
	
	/**
	 * ���õ� ���Ǳ۹�ȣ�� ������ ���Ǳ� �� ������ �����ִ� �� 
	 * @param askNum : ���Ǳ� ��ȣ model : �Խñ��� �� ����
	 * @return 
	 */
	@RequestMapping(value="/admin/askListDetail.do", method = GET)
	public String askListDetail( String askNum, Model model ) {
		
		
		
		return "admin/adAddAnswer";
	}//askListDetail
	
	/**
	 * ���Ǳ��� �亯�� �߰�/����/�����ϴ� �� 
	 * @param AddAnswerVO : �۹�ȣ, �亯���� model : �߰�/����/���� Ȯ�� 
	 * @return 
	 */
	@RequestMapping(value="/admin/addAnswer.do", method = GET)
	public String addAnswer( AddAnswerVO adaVO, Model model ) {
		
		
		
		return "admin/adAskList";
	}//addAnswer
	
	/**
	 * ���Ǳ��� �����ϴ� �� 
	 * @param String : �۹�ȣ model : ���� Ȯ�� 
	 * @return 
	 */
	@RequestMapping(value="/admin/removeAnswer.do", method = GET)
	public String removeAnswer( String askNum, Model model ) {
		
		
		
		return "admin/adAskList";
	}//removeAnswer
	
	
}
