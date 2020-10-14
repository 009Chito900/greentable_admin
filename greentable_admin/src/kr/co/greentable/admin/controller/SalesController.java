package kr.co.greentable.admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.greentable.admin.domain.SalesDomain;
import kr.co.greentable.admin.domain.SalesGraphDomain;
import kr.co.greentable.admin.service.SalesService;
import kr.co.greentable.admin.vo.SalesRangeVO;

@Controller
public class SalesController {

	SalesService ss=new SalesService();
	

	@GetMapping(value="/sales.do")
	public String salesMain(String order_date) { 

		return"sales/sales_main";
	}//salesList

	@RequestMapping(value="/sales_process.do")
	public String salesList(String paramPage, String order_date, Model model) {
	
		//전체 sales 수
		int totalCount=ss.searchSalesCount(order_date);
		//한 화면에 보여줄 sales 수
		int pageScale=ss.pageScale();
		//총 페이지 수
		int totalPage=ss.totalPage(totalCount, pageScale);
		//
		if(paramPage ==null) {
			paramPage="1";
		}
		//현재 페이지
		int currentPage=Integer.parseInt(paramPage);
		
		//페이지 별 시작번호
		int startNum=ss.startNum(currentPage, pageScale);
		//페이지별 끝 번호
		int endNum=ss.endNum(startNum, pageScale);
		
		//시작번호와 끝 번호 사이의 글 조회
		
		System.out.println("!!============>paramPage:"+paramPage+"startnum:"+startNum+"endNum"+endNum);
		
		SalesRangeVO srVO=new SalesRangeVO(order_date, startNum,endNum);
		
		List<SalesDomain> list=ss.searchSalesList(srVO); 
		model.addAttribute("total_page",totalPage);
		
		
		//원래 있던 거
		List<SalesGraphDomain> graphList=ss.searchSalesGraph(order_date);
		int[]sum=ss.ctgSeperateSum(graphList);
		
		
		model.addAttribute("sales_list",list );
		model.addAttribute("order_date",order_date );
		model.addAttribute("ctgSum",sum);
		
		
		return"sales/sales_result";
	}//salesList
	
}//class
