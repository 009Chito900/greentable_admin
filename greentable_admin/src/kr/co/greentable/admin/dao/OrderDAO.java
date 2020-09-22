package kr.co.greentable.admin.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.greentable.admin.domain.OptionDomain;
import kr.co.greentable.admin.domain.OrderDomain;
import kr.co.greentable.admin.domain.ReceiverDomain;

public class OrderDAO {

	private static OrderDAO order_DAO;
	private static SqlSessionFactory ssf;
	
	private OrderDAO() {
		//org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}
	
	public static OrderDAO getInstance() {
		if(order_DAO ==null) {
			order_DAO=new OrderDAO();
		}
		return order_DAO;
	}//getInstance
	
	private SqlSessionFactory getSqlSessionFactory() throws IOException{
		if(ssf ==null) {
			//1.Stream
			String xmlConfig="kr/co/greentable/admin/dao/mybatis_config.xml";
			Reader reader=Resources.getResourceAsReader(xmlConfig);
			
			//2MyBatis Framework 
			ssf=new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}//end if
		return ssf;
	}//getSqlSessionFactory
	
	public SqlSession getSqlSession() {
		SqlSession ss=null;
		
		try {
			ss=getSqlSessionFactory().openSession();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return ss;
	}//getSqlSession
	
	public static void main(String[] args) {
		OrderDAO oDAO=OrderDAO.getInstance();
		//System.out.println("----->>>>>>>>>>>>"+oDAO.getSqlSession());
		String order_date="2020-09-10";
		String order_num="ord_22";
		//System.out.println("**********"+oDAO.selectOrderList(order_date));
		//System.out.println("**********"+oDAO.selectOptionList(order_date));
		//System.out.println("**********"+oDAO.selectReceiver(order_num));
		
	}
	
	public List<OrderDomain> selectOrderList(String order_date){
		List<OrderDomain> list=null;
		
		SqlSession ss=getSqlSession();
		list=ss.selectList("selectOrderList",order_date);
		
		ss.close();
		return list;
		
	}//selectOrderList
	
	public List<OptionDomain> selectOptionList(String order_date){
		List<OptionDomain>  list=null;
		
		SqlSession ss=getSqlSession();
		list=ss.selectList("selectOptionList",order_date);
		
		ss.close();
		return list;
		
	}//selectOptionList
	
	
	public ReceiverDomain selectReceiver(String order_num){
		ReceiverDomain rDomain=null;
		
		SqlSession ss=getSqlSession();
		rDomain=ss.selectOne("selectReceiver",order_num);
		
		ss.close();
		return rDomain;
		
	}//selectReceiver
	
	
}//class
