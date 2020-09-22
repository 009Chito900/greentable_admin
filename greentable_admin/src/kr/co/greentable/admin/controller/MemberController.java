package kr.co.greentable.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.greentable.admin.domain.SelectMemberListDomain;
import kr.co.greentable.admin.service.MemberService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

/**
 * ������ ȸ������ Controller
 * @author sist27
 *
 */
@Controller
public class MemberController {
	
	@RequestMapping(value = "/admin_member_list.do", method = GET)
	public String memberList(String currentPage, String id, Model model ) {// ������������ȣ, �˻����̵�, �˻������ ������ ��ü
		
		//���񽺸� �����ϰ� ����ó�� ����� ��´�.
		MemberService ms = new MemberService();
		List<SelectMemberListDomain> list = ms.selectMemberList(currentPage, id);
		//����ó�� ����� �𵨿� ����
		model.addAttribute("member_list", list);
		
		return "member/admin_member_list";
	}//memberList
	
}//class
