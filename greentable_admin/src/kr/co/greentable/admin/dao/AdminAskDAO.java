package kr.co.greentable.admin.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.greentable.admin.domain.SelectAskListDomain;
import kr.co.greentable.admin.vo.AskRangeVO;

public class AdminAskDAO {

	private static AdminAskDAO amaDAO;
	private static SqlSessionFactory ssf;

	private AdminAskDAO() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging(); // �����ڿ� myBatis�� �α׸� �ҷ����� �ڵ�(log4j)
	}// AdminAskDAO

	public static AdminAskDAO getInstance() {
		if (amaDAO == null) {
			amaDAO = new AdminAskDAO();
		}
		return amaDAO;
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
	public List<SelectAskListDomain> selectAskList( AskRangeVO arVO ) {
		List<SelectAskListDomain> list = null;
		// MyBatisHandler ���
		SqlSession ss = getSqlSession();

		list = ss.selectList("selectAllAsk");
		// transaction �Ϸ�
		// MyBatis Handler ����.
		ss.close();

		return list;
	}// selectAllTestMyBatis

	/**
	 * �Էµ� �̹�����(��Ī num)���� �� ���� ��ȸ.
	 * 
	 * @param img
	 * @return
	 *//*
		 * public MyBatisDomain selectOneTestMyBatis( String img ) { MyBatisDomain
		 * mbd=null;
		 * 
		 * SqlSession ss=getSqlSession(); mbd=ss.selectOne("selectOneTest", img);
		 * ss.close(); return mbd; }//selectOneTestMyBatis
		 * 
		 * public int deleteTestMyBatis( String img ) { int cnt=0;
		 * 
		 * SqlSession ss=getSqlSession(); cnt=ss.delete("deleteTest", img); //"" �ȿ���
		 * Mapper���� ���� id�� �־� �ش�. // <delete id="deleteTest" parameterType="String">
		 * if(cnt == 1) { ss.commit(); }//end if ss.close();
		 * 
		 * return cnt; }//deleteTestMyBatis
		 * 
		 * public int updateMyBatis( ModifyMyBatisVO mmbVO ) { int cnt=0;
		 * 
		 * SqlSession ss=getSqlSession(); cnt=ss.update("updateTest", mmbVO);
		 * 
		 * if( cnt == 1 ) { ss.commit(); }//end if
		 * 
		 * ss.close();
		 * 
		 * return cnt; }//updateMyBatis
		 */
	
	/*
	 * public static void main(String[] args) {
	 * System.out.println(AdminAskDAO.getInstance().selectAskList()); }//main
	 */
	
	 }// class 
