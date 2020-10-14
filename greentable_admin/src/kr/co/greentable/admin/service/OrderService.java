package kr.co.greentable.admin.service;

import java.util.List;

import kr.co.greentable.admin.dao.OrderDAO;
import kr.co.greentable.admin.domain.OptionDomain;
import kr.co.greentable.admin.domain.OrderDomain;
import kr.co.greentable.admin.domain.ReceiverDomain;

public class OrderService {
	


	OrderDAO order_DAO=OrderDAO.getInstance();

	public List<OrderDomain> searchOrderList(String order_date){
		List<OrderDomain>  orderList=null;
		
		orderList = order_DAO.selectOrderList(order_date);
		
	
		  for(int i=0; i <orderList.size()-1 ; i++) {
			
		
			  if(orderList.get(i).getOrder_num().equals( orderList.get(i+1).getOrder_num()) ) {
			 
				  String order_num=orderList.get(i+1).getOrder_num(); 
				  order_num=" "; 
			
		  	
			  } //end if
		  }//end for
		 
			/*
			 * for(int i=0; i <orderList.size()-1 ; i++) {
			 * System.out.println(i+1+"번째 :"+orderList.get(i).getOrder_num()); }
			 */
		
		return orderList;
	}//searchOrderList
	
	
	
	public List<OptionDomain> searchOptionList(String order_date){
		List<OptionDomain> optionList=null;
		optionList = order_DAO.selectOptionList(order_date);
		
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
