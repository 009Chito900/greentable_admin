package kr.co.greentable.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.greentable.admin.service.OrderService;
import kr.co.greentable.admin.vo.OrderRangeVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.io.IOException;


@Controller
public class OrderController {

	@RequestMapping(value="/order.do", method=GET)
	public String orderMain() {

		return "order/order_main";
		
	}
	
	@RequestMapping(value="/order_process.do", method=GET)
	public String orderList(String paramPage, String order_date, Model model) {
		
		OrderService ors=new OrderService();
		
		//전체 order 수
				int totalCount=ors.serachOrderCount(order_date);
				//한 화면에 보여줄 order 수
				int pageScale=ors.pageScale();
				//총 페이지 수
				int totalPage=ors.totalPage(totalCount, pageScale);
				//
				if(paramPage ==null) {
					paramPage="1";
				}
				//현재 페이지
				int currentPage=Integer.parseInt(paramPage);
				
				//페이지 별 시작번호
				int startNum=ors.startNum(currentPage, pageScale);
				//페이지별 끝 번호
				int endNum=ors.endNum(startNum, pageScale);
		
				//시작번호와 끝 번호 사이의 글 조회
				OrderRangeVO orVO=new OrderRangeVO(order_date, startNum,endNum);
				
		model.addAttribute("total_page",totalPage);
		model.addAttribute("list_order",ors.searchOrderList(orVO));
		model.addAttribute("list_option",ors.searchOptionList(orVO));
		model.addAttribute("orderDate",order_date );
		
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
