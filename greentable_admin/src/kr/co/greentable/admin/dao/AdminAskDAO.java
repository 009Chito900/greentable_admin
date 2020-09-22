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
		org.apache.ibatis.logging.LogFactory.useLog4JLogging(); // 생성자에 myBatis의 로그를 불러오는 코드(log4j)
	}// AdminAskDAO

	public static AdminAskDAO getInstance() {
		if (amaDAO == null) {
			amaDAO = new AdminAskDAO();
		}
		return amaDAO;
	}// get insatnce

	private SqlSessionFactory getSqlSessionFactory() throws IOException {
		if (ssf == null) {
			// 1.Stream을 사용하여 xml과 연결
			String xmlConfig = "kr/co/greentable/admin/dao/mybatis_config.xml";
			Reader reader = Resources.getResourceAsReader(xmlConfig);

			// 2MyBatis Framework 생성
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
	 * 모든 문의글 조회하는 일 
	 * @return
	 */
	public List<SelectAskListDomain> selectAskList( AskRangeVO arVO ) {
		List<SelectAskListDomain> list = null;
		// MyBatisHandler 얻기
		SqlSession ss = getSqlSession();

		list = ss.selectList("selectAllAsk");
		// transaction 완료
		// MyBatis Handler 종료.
		ss.close();

		return list;
	}// selectAllTestMyBatis

	/**
	 * 입력된 이미지명(가칭 num)으로 한 행을 조회.
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
		 * SqlSession ss=getSqlSession(); cnt=ss.delete("deleteTest", img); //"" 안에는
		 * Mapper에서 만든 id를 넣어 준다. // <delete id="deleteTest" parameterType="String">
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
