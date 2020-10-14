package kr.co.greentable.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.greentable.admin.domain.SelectAskDetailDomain;
import kr.co.greentable.admin.domain.SelectAskListDomain;
import kr.co.greentable.admin.service.AdminAskService;
import kr.co.greentable.admin.vo.AskRangeVO;
import kr.co.greentable.admin.vo.UpdateAnswerVO;

@Controller
public class AdminAskController {
	/**
	 * 전체 문의글을 조회하는 일  
	 * @param currentPage : 현재 페이지 model : 전체 문의글
	 * @return 
	 */
	@RequestMapping(value="/ask/askList.do", method = GET)
	public String askList( String paramPage, HttpSession session, Model model ) {
		
			String url="ask/adAskList";
			//로그인 체크 
			String id=(String)session.getAttribute("user_id");
			
			if(id == null) {
				url="redirect:/admin/loginForm.do"; //
			}
		
			//Service
			AdminAskService aas=new AdminAskService();
			//전체 문의글 수 
			int totalCount=aas.totalCount();
			//한 화면에 보여줄 게시물의 수 
			int pageScale=aas.pageScale();
			//총 페이지 수
			int totalPage=aas.totalPage(totalCount, pageScale);
			//xxxController는 web parameter 처리( 유효성검증 , 파라메터 관련처리)
			if( paramPage == null){
				paramPage="1";
			}//end if
			
			int currentPage=Integer.parseInt( paramPage );
			
			//페이지별 시작 번호(업무로직)
			int startNum=aas.startNum(currentPage, pageScale);
			
			//페이지별 끝번호(업무로직)
			int endNum=aas.endNum(startNum,pageScale);
			
			//시작번호와 끝번호 사이의 원글을 조회
			AskRangeVO arVO=new AskRangeVO(startNum, endNum);
			
			List<SelectAskListDomain> list=aas.searchAskList(arVO);
			//model
			model.addAttribute("list_data", list);
			model.addAttribute("total_page", totalPage);
			
			return url;
		}//askList
	
	/**
	 * 선택한 문의글의 상세 내용을 보는 일 
	 * @param ask_num : 문의글 번호 model : 문의글 상세 내용
	 * @return 
	 */
	@RequestMapping(value="/ask/askListDetail.do", method = GET)
	public String askListDetail( String ask_num, HttpSession session, Model model ) {
		
		String url="ask/adAskDetail";
		//로그인 체크 
		String id=(String)session.getAttribute("user_id");
		
		if(id == null) {
			url="redirect:/admin/loginForm.do"; //
		}
		
		
		SelectAskDetailDomain sadd=null;
		AdminAskService aas=new AdminAskService();
		sadd=aas.searchAskDetail(ask_num);
		//model
		model.addAttribute("ask_detail", sadd);
		
		return url;
	}//askListDetail
	
	/**
	 * 추가/수정된 문의글 답변을 가지고 update하는 일.
	 * @param AddAnswerVO : ask_num, ask_answer
	 * @return  
	 */
	@RequestMapping(value="/ask/updateAnswer.do", method = POST)
	public String addAnswer( UpdateAnswerVO uaVO, Model model ) {
				
		int cnt=0;
		AdminAskService aas=new AdminAskService();
		cnt=aas.updateAnswer(uaVO);
		//model
		model.addAttribute("update_answer", cnt);
		
		return "ask/redirect";
	}//addAnswer
	
	/**
	 * 문의글을 삭제하는 일.
	 * @param String : ask_num model : cnt
	 * @return 
	 */
	@RequestMapping(value="/ask/removeAnswer.do", method = GET)
	public String removeAnswer( String ask_num, Model model ) {
		int cnt=0;
		AdminAskService aas=new AdminAskService();
		cnt=aas.removeAsk(ask_num);
		//model
		model.addAttribute("delete_ask", cnt);
		
		return "ask/redirect_del";
	}//removeAnswer
	
	
}
