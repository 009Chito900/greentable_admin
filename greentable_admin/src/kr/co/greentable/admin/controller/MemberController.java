package kr.co.greentable.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.greentable.admin.domain.SelectMemberListDomain;
import kr.co.greentable.admin.service.MemberService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

/**
 * 관리자 회원관리 Controller
 * @author sist27
 *
 */
@Controller
public class MemberController {
	
	@RequestMapping(value = "/admin_member_list.do", method = GET)
	public String memberList(String currentPage, String id, Model model ) {// 현재페이지번호, 검색아이디, 검색결과룰 저장할 객체
		
		//서비스를 생성하고 업무처리 결과를 얻는다.
		MemberService ms = new MemberService();
		List<SelectMemberListDomain> list = ms.selectMemberList(currentPage, id);
		//업무처리 결과를 모델에 저장
		model.addAttribute("member_list", list);
		
		return "member/admin_member_list";
	}//memberList
	
}//class
