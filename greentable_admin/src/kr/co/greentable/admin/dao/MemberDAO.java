package kr.co.greentable.admin.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.greentable.admin.domain.SelectMemberListDomain;

/**
 * 관리자 회원관리 DAO
 * @author sist27
 *
 */
public class MemberDAO {
	
	private static MemberDAO mDAO;
	private static SqlSessionFactory ssf;
	
	private MemberDAO() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging(); //log 찍는거
		
	}//MemberDAO
	
	public static MemberDAO getInstance() {
		
		if( mDAO == null ) {
			mDAO = new MemberDAO();
		}//end if
		
		return mDAO;
		
	}//getInstance
	
	
	private SqlSessionFactory getSqlSessionFactory() throws IOException {
		
		if( ssf == null ) {
			
			//1. 환경설정 XML을 Stream을 사용하여 xml과 연결
			String xmlConfig = "kr/co/greentable/admin/dao/mybatis_config.xml";
			Reader reader = Resources.getResourceAsReader(xmlConfig);//입력된 경로의 파일과 스트림을 연결
			
			//2. SqlSessionFactoryBuilder 생성  : MyBatisFramework 생성
			//  DB 연결 유지, XML Parsing, 쿼리문을 실행 
			ssf = new SqlSessionFactoryBuilder().build(reader);
			
			reader.close(); //xml을 읽어들인 스트림을 끊는다.
		}//end if
		
		return ssf;
	}//getSqlSessionFactory
	
	
	/**
	 * SqlSession 얻기(MyBatis handler 얻기): 개발자가 사용하여 조작 
	 * - autocommit을 지원하지 않는다. commit()을 별도로 수행, 사용이 종료되면 닫는다. 
	 * @return
	 */
	public SqlSession getSqlSession() {
		
		SqlSession ss = null;
		
		try {
			ss = getSqlSessionFactory().openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		return ss;
	}//getSqlSession
	
	public List<SelectMemberListDomain> selectMemberList(String id) {
		
		List<SelectMemberListDomain> list = null;
		
		//MyBatis Handler 얻기
		SqlSession ss = getSqlSession();
		
		list = ss.selectList("selectMemberList", id); //Mapper에서 찾아 파싱하여 실행해야 될 id, 값
		
		ss.close();
		
		return list;
		
	}//selectMemberList

}//class
