package kr.co.greentable.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.greentable.admin.domain.OptionDomain;
import kr.co.greentable.admin.service.OrderService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;

@Controller
public class OrderController {

	@RequestMapping(value="/order.do", method=GET)
	public String orderMain() {
	
		return "order/order_main";
	}
	
	@RequestMapping(value="/order_pocess.do", method=GET)
	public String orderList(String orderDate, Model model) {
		
		OrderService ors=new OrderService();
		
		
		model.addAttribute("list_order",ors.searchOrderList(orderDate));
		model.addAttribute("list_option",ors.searchOptionList(orderDate));
		model.addAttribute("orderDate",orderDate );
		
		return "order/order_process";
	}
	
	@RequestMapping(value="/order_detail.do", method=GET)
	public String orderDetailList(String order_num, Model model) {
		
		OrderService ors=new OrderService();
		
		model.addAttribute("list_order",ors.searchOrderDetailList(order_num));
		model.addAttribute("list_option",ors.searchOptionDetailList(order_num));
		
		model.addAttribute("receiver_detail",ors.searchReceiver(order_num));
		
		return "order/order_detail";
	}
	
	
	@RequestMapping(value="/order_delete.do", method=GET)
	public String removeOrderNum(String orderDate, String chosen_order_num, Model model) {
		
		OrderService ors=new OrderService();
		
		boolean flag=ors.removeOrderNum(chosen_order_num);
		
		model.addAttribute("orderDate",orderDate);
		model.addAttribute("delFlag",flag);
		model.addAttribute("move_page","del");
		
		return "forward:order.do";
	}

	
	@ExceptionHandler(IOException.class)
	public ModelAndView uploadErr(IOException ie) {
		ModelAndView mav= new ModelAndView();
		mav.setViewName("order/order_err");
		mav.addObject("errMsg",ie);
		
		ie.printStackTrace();
		
		return mav;
	}
	
}
