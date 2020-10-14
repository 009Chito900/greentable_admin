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
	 * 문의글의 내용을 조회하여, 리스트로 adAskList.jsp에 뿌려주는 일.
	 * @param currentPage : 현재 페이지 model : 게시글의 내용
	 * @return 
	 */
	@RequestMapping(value="/admin/askList.do", method = GET)
	public String askList( String currentPage, Model model ) {
			
			AskRangeVO arVO=null;
			arVO.setStartNum(1);
			arVO.setEndNum(10); //임의로 구간 설정
		
			if( currentPage == null ) {
				currentPage="1";
			}//end if
			
			//서비스를 생성하고 업무처리 결과를 얻는다.
			AdminAskService aas=new AdminAskService();
			//업무처리 결과를 모델에 저장 
			model.addAttribute("list_data", aas.searchAskList(arVO));
			
			return "admin/adAskList";
		}//askList
	
	/**
	 * 선택된 문의글번호를 가지고 문의글 상세 정보를 보여주는 일 
	 * @param askNum : 문의글 번호 model : 게시글의 상세 내용
	 * @return 
	 */
	@RequestMapping(value="/admin/askListDetail.do", method = GET)
	public String askListDetail( String askNum, Model model ) {
		
		
		
		return "admin/adAddAnswer";
	}//askListDetail
	
	/**
	 * 문의글의 답변을 추가/수정/삭제하는 일 
	 * @param AddAnswerVO : 글번호, 답변내용 model : 추가/수정/삭제 확인 
	 * @return 
	 */
	@RequestMapping(value="/admin/addAnswer.do", method = GET)
	public String addAnswer( AddAnswerVO adaVO, Model model ) {
		
		
		
		return "admin/adAskList";
	}//addAnswer
	
	/**
	 * 문의글을 삭제하는 일 
	 * @param String : 글번호 model : 삭제 확인 
	 * @return 
	 */
	@RequestMapping(value="/admin/removeAnswer.do", method = GET)
	public String removeAnswer( String askNum, Model model ) {
		
		
		
		return "admin/adAskList";
	}//removeAnswer
	
	
}
