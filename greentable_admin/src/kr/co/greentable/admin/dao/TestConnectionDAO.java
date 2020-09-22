package kr.co.greentable.admin.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestConnectionDAO {

	private static TestConnectionDAO tcDAO;
	private static SqlSessionFactory ssf;

	private TestConnectionDAO() {

	}//ExamMyBatisDAO
	public static TestConnectionDAO getInstance() {
		if(tcDAO ==null) {
			tcDAO= new TestConnectionDAO();	
		}
		return tcDAO;
	}//get insatnce
	
	private SqlSessionFactory getSqlSessionFactory() throws IOException {
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
		SqlSession ss= null;
		try {
			ss=getSqlSessionFactory().openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ss;
	}//getSqlSession
	
	public static void main(String[] args) {
		TestConnectionDAO e=TestConnectionDAO.getInstance();
				System.out.println(e.getSqlSession());
		
	}//main
	
}//class
