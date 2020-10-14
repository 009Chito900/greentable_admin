package kr.co.greentable.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.greentable.admin.domain.SalesDomain;
import kr.co.greentable.admin.domain.SalesGraphDomain;
import kr.co.greentable.admin.vo.SalesRangeVO;

public class SalesDAO {
	
	private static SalesDAO sDAO;
	
	private SalesDAO() {
	}
	
	public static SalesDAO getInstance() {
		if(sDAO == null) {
			sDAO=new SalesDAO();
		}
		return sDAO;
	}//getInstance

	
/**전체 판매 수 
 * @param date
 * @return
 */
	public int selectSalesCnt(String date) {
		int cnt=0;
		SqlSession ss=MJ_GetMyBatisHandler.getInstance().getSqlSession();
		cnt=ss.selectOne("allSalesCnt", date);
		return cnt;
	}//selectSalesCnt


	
	public List<SalesDomain> selectSales(SalesRangeVO srVO){
		
		
		SqlSession ss=MJ_GetMyBatisHandler.getInstance().getSqlSession();
		List<SalesDomain> list=ss.selectList("sales",srVO);
		
		ss.close();
		return list;
	}//selectSales
	
	public List<SalesGraphDomain> selectSalesGraph(String order_date){
		
		
		SqlSession ss=MJ_GetMyBatisHandler.getInstance().getSqlSession();
		List<SalesGraphDomain> list=ss.selectList("salesGraph",order_date);
		
		ss.close();
		return list;
	}//selectSales
	
	
	
	public static void main(String[] args) {
		SalesDAO.getInstance().selectSalesGraph("2020-09-10");
		
	}
	
	
}//class
