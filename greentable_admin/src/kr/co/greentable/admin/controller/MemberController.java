package kr.co.greentable.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.greentable.admin.domain.SelectMemberDetailDomain;
import kr.co.greentable.admin.domain.SelectMemberListDomain;
import kr.co.greentable.admin.service.MemberService;
import kr.co.greentable.admin.vo.MemberRangeVO;
import kr.co.greentable.admin.vo.ModifyMemberVO;

@Controller
public class MemberController {

	/**
	 * 전체 회원 게시물을 조회하는 일
	 * @param paramPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin_member_list.do", method = {GET,POST})
	public String memberList(String paramPage, Model model ) {
		
		//서비스를 생성하고 업무처리 결과를 얻는다.
		MemberService ms = new MemberService();
		
		//전체 문의글 수 
		int totalCount = ms.totalCount();
		//한 화면에 보여줄 게시물의 수 
		int pageScale = ms.pageScale();
		//총 페이지 수
		int totalPage = ms.totalPage(totalCount, pageScale);
		//xxxController는 web parameter 처리( 유효성검증 , 파라메터 관련처리)
		if( paramPage == null){
			paramPage = "1";
		}//end if
		
		int currentPage = Integer.parseInt( paramPage );
		
		//페이지별 시작 번호(업무로직)
		int startNum = ms.startNum(currentPage, pageScale);
		
		//페이지별 끝번호(업무로직)
		int endNum = ms.endNum(startNum,pageScale);
		
		//시작번호와 끝번호 사이의 원글을 조회
		MemberRangeVO mrVO = new MemberRangeVO(startNum, endNum);
		System.out.println("시작번호" + mrVO.getStartNum() + " / 끝번호" + mrVO.getEndNum());
		
		List<SelectMemberListDomain> list = ms.selectMemberList(mrVO);
		//뷰로 전달하기 위해 Model에 추가
		model.addAttribute("list_data", list);
		model.addAttribute("total_page", totalPage);
		
		return "member/admin_member_list";
	}//memberList


	@RequestMapping(value = "/admin_member_detail.do", method = GET)
	public String memberOneList(String id, Model model ) {

		//서비스를 생성하고 업무처리 결과를 얻는다.
		MemberService ms = new MemberService();
		SelectMemberDetailDomain smdd = ms.selectMemberDetailList(id);
		//뷰로 전달하기 위해 Model에 추가
		model.addAttribute("data", smdd);

		return "member/admin_member_detail";
	}//memberOneList


	@RequestMapping(value = "/remove_member.do", method = POST)
	public String removeMember(String id, Model model) {

		MemberService ms = new MemberService();
		boolean flag = ms.removeMember(id);

		model.addAttribute("delFlag", flag); //삭제결과
		model.addAttribute("move_page", "del"); //이동한 페이지

		return "forward:admin_member_list.do";
	}//removeMember


	@RequestMapping(value = "/modify_member.do", method = POST)
	public String ModifyMember(ModifyMemberVO mmVO, Model model) throws IOException {

		MemberService ms = new MemberService();
		boolean flag = ms.modifyMember(mmVO);

		model.addAttribute("updFlag", flag);
		model.addAttribute("move_page","upd");

		return "forward:admin_member_list.do";
	}//ModifyMember


}//class
