
package kr.co.greentable.admin.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.greentable.admin.service.LoginService;
import kr.co.greentable.admin.vo.LoginVO;



@SessionAttributes({"user_id"})
@Controller
public class LoginController {

	@RequestMapping(value="/logout.do")
	public String logout(SessionStatus sessionStatus) {
		
		  sessionStatus.setComplete();

		return "login/login_frm";
	}
	
	
	@RequestMapping(value="/login_frm.do")
	public String loginForm() {
		
		return "login/login_frm";
	}//loginForm
	
	@RequestMapping(value="/login_process.do", method=RequestMethod.POST)
	public String loginProcess(LoginVO lVO, Model model) {
		
		LoginService ls=new LoginService();
		String id=ls.searchId(lVO);
		
		model.addAttribute("user_id",id);
		
		return "login/login_process";
	}//loginForm
	
}//class
