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

	@RequestMapping(value="/admin/order.do", method=GET)
	public String orderList(String orderDate, Model model) {
		
		//서비스 객체로 값 할당
		OrderService ors=new OrderService();
	
		
		//view 페이지에서 보여줄 데이터
	model.addAttribute("list_order",ors.searchOrderList(orderDate));
	model.addAttribute("list_option",ors.searchOptionList(orderDate));
		
		return "order/order";
	}
	
	@RequestMapping(value="/admin/order_detail.do", method=GET)
	public String orderDetailList(String order_num, Model model) {
		
		//서비스 객체로 값 할당
		OrderService ors=new OrderService();
		
		
		//view 페이지에서 보여줄 데이터
		model.addAttribute("receiver_detail",ors.searchReceiver(order_num));
		
		return "order/order_detail";
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
