package kr.co.greentable.admin.service;

import java.util.List;

import kr.co.greentable.admin.dao.AjaxDAO;
import kr.co.greentable.admin.dao.ProductDAO;
import kr.co.greentable.admin.domain.MainCategoryDomain;
import kr.co.greentable.admin.domain.ProductDomain;
import kr.co.greentable.admin.domain.ProductOptionDomain;
import kr.co.greentable.admin.domain.SubCategoryDomain;
import kr.co.greentable.admin.vo.ProductOptionVO;
import kr.co.greentable.admin.vo.ProductVO;
import kr.co.greentable.admin.vo.UpdateProductVO;

public class ProductService {

	public Boolean insertAll(ProductVO pdVO) {
		Boolean flag = false;
		ProductDAO pdDAO = ProductDAO.getInstance();
		String productNum = "";
		int cnt = pdDAO.insertProduct(pdVO) ;
		if( cnt != 1) {
			return flag;
		}
		productNum =  pdDAO.selectProductNum(pdVO).trim();
		System.out.println("."+productNum+".");
		ProductOptionVO pdoVO = new ProductOptionVO();
		cnt = 0;
		for(int i=0;i<pdVO.getProductOption().length;i++) {
			pdoVO.setProductNum(productNum);
			pdoVO.setProductOption(pdVO.getProductOption()[i]);;
			System.out.println(pdoVO.getProductOption());
			pdoVO.setProductPrice(Integer.parseInt(pdVO.getProductPrice()[i]));
			System.out.println(pdoVO.getProductPrice());
			pdDAO.insertProductOption(pdoVO);
			cnt++;
		}
		return pdVO.getProductOption().length == cnt;
	}
	
	public Boolean updateAll(UpdateProductVO udpdVO) {
		Boolean flag = false;
		ProductDAO pdDAO = ProductDAO.getInstance();
		String productNum = "";
		int cnt = pdDAO.updateProduct(udpdVO);
		if( cnt != 1) {
			return flag;
		}
		ProductOptionVO pdoVO = new ProductOptionVO();
		pdDAO.deleteOptionProduct(udpdVO.getProductNum());
		cnt = 0;
		for(int i=0;i<udpdVO.getProductOption().length;i++) {
			pdoVO.setProductNum(udpdVO.getProductNum());
			pdoVO.setProductOption(udpdVO.getProductOption()[i]);;
			pdoVO.setProductPrice(Integer.parseInt(udpdVO.getProductPrice()[i]));
			pdDAO.insertProductOption(pdoVO);
			cnt++;
		}
		return udpdVO.getProductOption().length == cnt;
	}
	
	public Boolean deleteProduct(String productNum) {
		ProductDAO pdDAO = ProductDAO.getInstance();
		int cnt = 0;
		
		cnt = pdDAO.deleteProduct(productNum);
		
		return cnt != 0;
	}
	public List<ProductDomain> allList() {
		ProductDAO pdDAO = ProductDAO.getInstance();
		List<ProductDomain> pdList = pdDAO.selectProductList();
		for(ProductDomain pd : pdList) {
			List<ProductOptionDomain> podList = pdDAO.selectProductOptionList(pd.getProduct_num()); 
			pd.setPodList(podList);
		}
		return pdList;
	}
	
	public List<MainCategoryDomain> mainCategory(){
		ProductDAO pdDAO = ProductDAO.getInstance();
		List<MainCategoryDomain> mcdList = pdDAO.selectMainCategoryList();
		
		return mcdList;
	}
	
	public List<SubCategoryDomain> subCategory(String mainCtg){
		List<SubCategoryDomain> list = AjaxDAO.getInstance().selectSubCtgList(mainCtg);
		
		return list;
	}
	
	public static void main(String[] args) {
		List<ProductDomain> list = new ProductService().allList();
		
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<list.get(i).getPodList().size();j++) {
				System.out.println(list.get(i).getPodList().get(j));
			}
		}
	}
}
