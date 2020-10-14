package kr.co.greentable.admin.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MJ_GetMyBatisHandler {

	private static MJ_GetMyBatisHandler gmbh;
	private static SqlSessionFactory ssf;

	private MJ_GetMyBatisHandler() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}//ExamMyBatisDAO
	
	public static MJ_GetMyBatisHandler getInstance() {
		if(gmbh ==null) {
			gmbh = new MJ_GetMyBatisHandler();	
		}
		return gmbh;
	}//get insatnce
	
	public SqlSession getSqlSession() {
		
		SqlSession ss= null;
		if(ssf ==null) {
			try {
			//1.Stream을 사용하여 xml과 연결
			String xmlConfig="kr/co/greentable/admin/dao/MJ_mybatis_config.xml";
			Reader reader=Resources.getResourceAsReader(xmlConfig);
			
			//2MyBatis Framework 생성
			ssf=new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			}catch(IOException ie) {
				ie.printStackTrace();
			}//end catch
		}//end if
		ss=ssf.openSession();
		return ss;
	}//getSqlSession
	
}//class
