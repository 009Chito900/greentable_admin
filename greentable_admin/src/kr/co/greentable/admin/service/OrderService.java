package kr.co.greentable.admin.service;

import java.util.List;

import kr.co.greentable.admin.dao.OrderDAO;
import kr.co.greentable.admin.domain.OptionDomain;
import kr.co.greentable.admin.domain.OrderDomain;
import kr.co.greentable.admin.domain.ReceiverDomain;

public class OrderService {
	
	/**
	 * 총구매액을 구하는 일
	 * @param optDomain
	 */
	public void calTotalPrice(OptionDomain optDomain) {
		int totalPrice=0;
		//총구매액은 옵션가 * 옵션 수량
		totalPrice=optDomain.getOption_price()*optDomain.getQuantity();
		optDomain.setTotal_price(totalPrice);

	}//calTotalPrice


	OrderDAO order_DAO=OrderDAO.getInstance();

	public List<OrderDomain> searchOrderList(String order_date){
		List<OrderDomain>  orderList=null;
		//dao사용
		orderList = order_DAO.selectOrderList(order_date);
		
		return orderList;
	}//searchOrderList
	
//	public static void main(String[] args) {
//		OrderService os= new OrderService();
//		String order_date="2020-09-10";
//		String order_num="ord_22";
//		List<OrderDomain>list= os.searchOrderList(order_date);
//		List<OptionDomain> list1=os.searchOptionList(order_date);
//		ReceiverDomain d=os.searchReceiver(order_num);
//		//System.out.println(list);
//		System.out.println(d);
//		
//	}
	
	public List<OptionDomain> searchOptionList(String order_date){
		List<OptionDomain> optionList=null;
		//dao사용
		optionList = order_DAO.selectOptionList(order_date);
		
		return optionList;
	}//searchOrderList
	
	/**
	 * OrderDAO의 selectOrderlist 메소드 사용
	 * @param order_date
	 * @return
	 */
	public ReceiverDomain searchReceiver(String order_num){
		ReceiverDomain rDomain=null;
		//dao사용
		rDomain = order_DAO.selectReceiver(order_num);
		
		return rDomain;
	}//searchOrderDetail
	
	
	
}//class
