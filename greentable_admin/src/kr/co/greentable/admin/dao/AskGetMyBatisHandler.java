package kr.co.greentable.admin.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class AskGetMyBatisHandler {

	private static AskGetMyBatisHandler gmbhDAO;
	private static SqlSessionFactory ssf;

	private AskGetMyBatisHandler() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging(); //
	}//ExamMyBatisDAO
	
	public static AskGetMyBatisHandler getInstance() {
		if(gmbhDAO ==null) {
			gmbhDAO = new AskGetMyBatisHandler();	
		}
		return gmbhDAO;
	}//get insatnce
	
	public SqlSession getSqlSession() {
		
		SqlSession ss=null;
		
		if(ssf ==null) {
			try {
				//1.Stream
				String xmlConfig="kr/co/greentable/admin/dao/mybatis_ask_config.xml";
				Reader reader=Resources.getResourceAsReader(xmlConfig);
				
				//2MyBatis Framework
				ssf=new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			}catch(IOException ie) {
				ie.printStackTrace();
			}//end catch
		}//end if
		ss=ssf.openSession();
		return ss;
	}//getSqlSessionFactory
	
	
}//class
