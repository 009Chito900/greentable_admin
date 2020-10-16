package kr.co.greentable.admin.service;

import java.util.List;

import kr.co.greentable.admin.dao.OrderDAO;
import kr.co.greentable.admin.domain.OptionDomain;
import kr.co.greentable.admin.domain.OrderDomain;
import kr.co.greentable.admin.domain.ReceiverDomain;
import kr.co.greentable.admin.vo.OrderRangeVO;

public class OrderService {

	OrderDAO order_DAO=OrderDAO.getInstance();
	
//전체 order 수
	public int serachOrderCount(String date) {
		int cnt=0;
		cnt=order_DAO.selectOrderCnt(date);
		return cnt;
	}
	
	//한 화면 보여줄 수
		public int pageScale() {
			int pageScale=15;
			return pageScale;
		}
		//총 페이지 수
		public int totalPage(int totalCount,int pageScale) {
			int totalPage=(int)Math.ceil((double)totalCount/pageScale);
			
			return totalPage;
		}
		
		//시작 번호
		public int startNum(int currentPage,int pageScale) {
			int startNum=currentPage*pageScale-pageScale+1;
			return startNum;
		}
		//끝 번호
		public int endNum(int startNum,int pageScale) {
			int endNum=startNum+pageScale-1;
			return endNum;
		}
		
	
	
	

	public List<OrderDomain> searchOrderList(OrderRangeVO orVO){
		List<OrderDomain>  orderList=null;
		
		orderList = order_DAO.selectOrderList(orVO);
		
	
		return orderList;
	}//searchOrderList
	
	
	
	public List<OptionDomain> searchOptionList(OrderRangeVO orVO){
		List<OptionDomain> optionList=null;
		optionList = order_DAO.selectOptionList(orVO);
		
		return optionList;
	}//searchOrderList
	
	public List<OrderDomain> searchOrderDetailList(String order_date){
		List<OrderDomain>  orderList=null;
		orderList = order_DAO.selectDetailOrderList(order_date);
		
		return orderList;
	}//searchOrderList
	
	
	
	public List<OptionDomain> searchOptionDetailList(String order_date){
		List<OptionDomain> optionList=null;
		optionList = order_DAO.selectDetailOptionList(order_date);
		
		return optionList;
	}//searchOrderList
	
	
	
	
	public ReceiverDomain searchReceiver(String order_num){
		ReceiverDomain rDomain=null;
		
		rDomain = order_DAO.selectReceiver(order_num);
		
		return rDomain;
	}//searchOrderDetail
	
	

	public boolean removeOrderNum(String order_num) {
	
		boolean flag=false;
		
		flag=order_DAO.deleteOrdernum(order_num)==1;//삭제가 되면 1
		
		return flag;
		
	}//removeOrderNum
	
	
	
	
}//class
