package kr.co.greentable.admin.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.greentable.admin.domain.MainCategoryDomain;
import kr.co.greentable.admin.domain.ProductDomain;
import kr.co.greentable.admin.domain.ProductOptionDomain;
import kr.co.greentable.admin.vo.ProductOptionVO;
import kr.co.greentable.admin.vo.ProductVO;
import kr.co.greentable.admin.vo.UpdateProductVO;

public class ProductDAO {

	private static ProductDAO pdDAO;
	private static SqlSessionFactory ssf;

	private ProductDAO() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging(); // �����ڿ� myBatis�� �α׸� �ҷ����� �ڵ�(log4j)
	}// AdminAskDAO

	public static ProductDAO getInstance() {
		if (pdDAO == null) {
			pdDAO = new ProductDAO();
		}
		return pdDAO;
	}// get insatnce

	private SqlSessionFactory getSqlSessionFactory() throws IOException {
		if (ssf == null) {
			// 1.Stream�� ����Ͽ� xml�� ����
			String xmlConfig = "kr/co/greentable/admin/dao/mybatis_config.xml";
			Reader reader = Resources.getResourceAsReader(xmlConfig);

			// 2MyBatis Framework ����
			ssf = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} // end if
		return ssf;
	}// getSqlSessionFactory

	public SqlSession getSqlSession() {
		SqlSession ss = null;
		try {
			ss = getSqlSessionFactory().openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ss;
	}// getSqlSession

	
	public int insertProduct(ProductVO pdVO) {
		int cnt = 0;
		SqlSession ss = getSqlSession();

		cnt = ss.insert("kr.co.greentable.product.insertProduct", pdVO);
		ss.commit();
		
		ss.close();

		return cnt;
	}// selectAllTestMyBatis

	public int insertProductOption(ProductOptionVO pdoVO) {
		int cnt = 0;
		SqlSession ss = getSqlSession();

		cnt = ss.insert("kr.co.greentable.product.insertProductOption", pdoVO);
		ss.commit();
		
		ss.close();

		return cnt;
	}
	public String selectProductNum(ProductVO pdVO) {
		String product_num = "";
		SqlSession ss = getSqlSession();
		System.out.println(pdVO.getProductName());
		System.out.println(pdVO.getProductTooltip());
		product_num = ss.selectOne("kr.co.greentable.product.selectProductNum", pdVO);
		
		ss.close();
		
		return product_num;
	}
	
	public List<ProductDomain> selectProductList() {
		List<ProductDomain> list = null;
		SqlSession ss = getSqlSession();
		list = ss.selectList("kr.co.greentable.product.selectProductList");
		
		ss.close();
		return list;
	}
	
	public List<ProductOptionDomain> selectProductOptionList(String productNum){
		List<ProductOptionDomain> list =null;
		
		SqlSession ss = getSqlSession();
		list = ss.selectList("kr.co.greentable.product.selectProductOptionList",productNum.trim());
		
		ss.close();
		
		return list;
	}
	
	public List<MainCategoryDomain> selectMainCategoryList(){
		List<MainCategoryDomain> list = null;
		
		SqlSession ss = getSqlSession();
		list = ss.selectList("kr.co.greentable.product.selectMainCtg");
		
		ss.close();
		return list;
	}
	
	public int deleteProduct(String productNum) {
		int cnt = 0;
		
		SqlSession ss = getSqlSession();
		cnt = ss.delete("kr.co.greentable.product.delProduct",productNum.trim());
		ss.commit();
		
		return cnt;
	}

	public int deleteOptionProduct(String productNum) {
		int cnt = 0;
		
		SqlSession ss = getSqlSession();
		cnt = ss.delete("kr.co.greentable.product.delOptionProduct",productNum.trim());
		ss.commit();
		
		return cnt;
	}
	public int updateProduct(UpdateProductVO udpdVO) {
		int cnt = 0;
		SqlSession ss = getSqlSession();
		cnt = ss.update("kr.co.greentable.product.productUpdate", udpdVO);
		ss.commit();
		
		return cnt;
	}
	
public static void main(String[] args) {
	ProductDAO pdd = ProductDAO.getInstance();
	UpdateProductVO udpdVO = new UpdateProductVO();
	udpdVO.setProductNum("pro_30");
	udpdVO.setProductName(" ");
	udpdVO.setProductTooltip(" ");
	udpdVO.setProImgInfoName(" ");
	udpdVO.setProImgThumbName(" ");
	udpdVO.setProTextInfo(" ");
	udpdVO.setOnSale("Y");
	udpdVO.setSubCtg(" ");
	pdd.updateProduct(udpdVO);
	pdd.deleteOptionProduct("pro_40");
}
	 }// class 
