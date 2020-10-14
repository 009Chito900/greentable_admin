package kr.co.greentable.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.greentable.admin.service.AjaxService;

@Controller
public class AjaxController {

	@GetMapping(value="/total_order_price.do")
	public String selectProductCtg(Model model) {
		AjaxService as= new AjaxService();
		String json=as.productJson(mainCtg); 
		model.addAttribute("json",json);
		
		return "ajax/output_json";
	}
	
	@GetMapping("/select_list.do")
	public String selectListCtg(String mainCtg, Model model){
		
		AjaxService as= new AjaxService();
		String json=as.listJson(mainCtg); 
		model.addAttribute("json",json);
		return "ajax/output_json";
	}
}
