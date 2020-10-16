package kr.co.greentable.admin.service;

import java.text.DecimalFormat;
import java.util.List;

import kr.co.greentable.admin.dao.SalesDAO;
import kr.co.greentable.admin.domain.SalesDomain;
import kr.co.greentable.admin.domain.SalesGraphDomain;
import kr.co.greentable.admin.vo.SalesRangeVO;

public class SalesService {

	SalesDAO sDAO=SalesDAO.getInstance();
	//전체 sales 수
	public int searchSalesCount(String date) {
		int cnt=0;
		cnt=sDAO.selectSalesCnt(date);
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
	

	/////////
	public List<SalesDomain> searchSalesList(SalesRangeVO srVO){
		List<SalesDomain>list=null;
		 list=sDAO.selectSales(srVO);
		return list;
	}//searchSalesList
	
	
	public List<SalesGraphDomain> searchSalesGraph(String order_date){
		List<SalesGraphDomain>list=null;
		list=sDAO.selectSalesGraph(order_date);
		return list;
	}//searchSalesGraph
	

	public int[] ctgSeperateSum( List<SalesGraphDomain> list) {
		

		 
		int ctg1Sum=0; int ctg2Sum=0; int ctg3Sum=0;
		for(SalesGraphDomain sd: list) {			
		
			if( "과수원".equals(sd.getMain_ctg_name())) {
				ctg1Sum=ctg1Sum+sd.getTotal_price();	
			}
			if( "쌀 잡곡".equals(sd.getMain_ctg_name())) {
				ctg2Sum=ctg2Sum+sd.getTotal_price();	
			}
			if("바다와 강".equals(sd.getMain_ctg_name())) {
				ctg3Sum=ctg3Sum+sd.getTotal_price();	
			}
		}//end for
		
		int[] sum=new int[3];
		sum[0]=ctg1Sum;
		sum[1]=ctg2Sum;
		sum[2]=ctg3Sum;
		
		return sum;
	}
	
}//class
