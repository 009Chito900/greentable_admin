package kr.co.greentable.admin.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.greentable.admin.domain.ProductDomain;
import kr.co.greentable.admin.domain.SelectAskListDomain;
import kr.co.greentable.admin.domain.SubCategoryDomain;
import kr.co.greentable.admin.vo.AskRangeVO;

public class AjaxDAO {

	private static AjaxDAO ajDAO;
	private static SqlSessionFactory ssf;

	private AjaxDAO() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging(); // �����ڿ� myBatis�� �α׸� �ҷ����� �ڵ�(log4j)
	}// AdminAskDAO

	public static AjaxDAO getInstance() {
		if (ajDAO == null) {
			ajDAO = new AjaxDAO();
		}
		return ajDAO;
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

	/**
	 * ��� ���Ǳ� ��ȸ�ϴ� �� 
	 * @return
	 */
	public List<SubCategoryDomain> selectSubCtgList(String mainCtg) {
		List<SubCategoryDomain> list = null;
		// MyBatisHandler ���
		SqlSession ss = getSqlSession();

		list = ss.selectList("kr.co.greentable.product.selectSubCtg",mainCtg);
		
		ss.close();

		return list;
	}// selectAllTestMyBatis
	
	public List<ProductDomain> selectMainProductList(String mainCtg){
		List<ProductDomain> list = null;
		
		SqlSession ss = getSqlSession();
		
		list = ss.selectList("kr.co.greentable.product.selectMainProduct", mainCtg.trim());
		
		return list;
	}

	 }// class 
