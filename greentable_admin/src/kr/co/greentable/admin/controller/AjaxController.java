package kr.co.greentable.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.greentable.admin.service.AjaxService;

@Controller
public class AjaxController {

	@GetMapping("/select_list.do")
	public String selectListCtg(String mainCtg, Model model){
		
		AjaxService as= new AjaxService();
		String json=as.listJson(mainCtg); 
		model.addAttribute("json",json);
		return "ajax/output_json";
	}
}
