package kr.co.greentable.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.greentable.admin.domain.OptionDomain;
import kr.co.greentable.admin.domain.OrderDomain;
import kr.co.greentable.admin.domain.ReceiverDomain;
import kr.co.greentable.admin.vo.OrderRangeVO;

public class OrderDAO {
	
	private static OrderDAO oDAO;
	
	private OrderDAO() {
	}
	
	public static OrderDAO getInstance() {
		if(oDAO == null) {
			oDAO=new OrderDAO();
		}
		return oDAO;
	}//getInstance
	
	public int selectOrderCnt(String date) {
		int cnt=0;
		SqlSession ss=MJ_GetMyBatisHandler.getInstance().getSqlSession();
		cnt=ss.selectOne("allOrderCnt",date);
		return cnt;
	}
	
	public List<OrderDomain> selectOrderList(OrderRangeVO orVO){
		List<OrderDomain> list=null;
		
		SqlSession ss=MJ_GetMyBatisHandler.getInstance().getSqlSession();
		list=ss.selectList("selectOrder",orVO);
		
		ss.close();
		return list;
		
	}//selectOrderList
	
	public List<OptionDomain> selectOptionList(OrderRangeVO orVO){
		List<OptionDomain>  list=null;
		
		SqlSession ss=MJ_GetMyBatisHandler.getInstance().getSqlSession();
		list=ss.selectList("selectOption",orVO);
		
		ss.close();
		return list;
		
	}//selectOptionList
	
	
	public List<OrderDomain> selectDetailOrderList(String order_num){
		List<OrderDomain> list=null;
		
		SqlSession ss=MJ_GetMyBatisHandler.getInstance().getSqlSession();
		list=ss.selectList("selectDetailOrder",order_num);
		
		ss.close();
		return list;
		
	}//selectOrderListof
	
	public List<OptionDomain> selectDetailOptionList(String order_num){
		List<OptionDomain>  list=null;
		
		SqlSession ss=MJ_GetMyBatisHandler.getInstance().getSqlSession();
		list=ss.selectList("selectDetailOption",order_num);
		
		ss.close();
		return list;
		
	}//selectOptionList
	
	
	public ReceiverDomain selectReceiver(String order_num){
		ReceiverDomain rDomain=null;
		
		
		SqlSession ss=MJ_GetMyBatisHandler.getInstance().getSqlSession();
		rDomain=ss.selectOne("selectReceiver", order_num);
		
		ss.close();
		
		return rDomain;
		
	}//selectReceiver

	public int deleteOrdernum(String order_num) {
		SqlSession ss=MJ_GetMyBatisHandler.getInstance().getSqlSession();
		int cnt=ss.delete("deleteOrder",order_num);
		ss.commit();
		ss.close();
		
		return cnt;
	}//deleteOrdernum
	
public static void main(String[] args) {
	OrderRangeVO orVO=new OrderRangeVO("2020-09-10", 1, 10);
	System.out.println("!!!!!!!!!!!!!!!!!"+OrderDAO.getInstance().selectOrderList(orVO));
	System.out.println("@@@@"+OrderDAO.getInstance().selectOptionList(orVO));
	
//	System.out.println(OrderDAO.getInstance().selectReceiver("ord_22"));
//	System.out.println(OrderDAO.getInstance().selectDetailOptionList("ord_22"));
//	System.out.println(OrderDAO.getInstance().selectDetailOrderList("ord_22"));
	
}
	
	
}//class
