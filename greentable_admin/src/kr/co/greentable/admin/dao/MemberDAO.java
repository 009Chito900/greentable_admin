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
 * ������ ȸ������ DAO
 * @author sist27
 *
 */
public class MemberDAO {
	
	private static MemberDAO mDAO;
	private static SqlSessionFactory ssf;
	
	private MemberDAO() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging(); //log ��°�
		
	}//MemberDAO
	
	public static MemberDAO getInstance() {
		
		if( mDAO == null ) {
			mDAO = new MemberDAO();
		}//end if
		
		return mDAO;
		
	}//getInstance
	
	
	private SqlSessionFactory getSqlSessionFactory() throws IOException {
		
		if( ssf == null ) {
			
			//1. ȯ�漳�� XML�� Stream�� ����Ͽ� xml�� ����
			String xmlConfig = "kr/co/greentable/admin/dao/mybatis_config.xml";
			Reader reader = Resources.getResourceAsReader(xmlConfig);//�Էµ� ����� ���ϰ� ��Ʈ���� ����
			
			//2. SqlSessionFactoryBuilder ����  : MyBatisFramework ����
			//  DB ���� ����, XML Parsing, �������� ���� 
			ssf = new SqlSessionFactoryBuilder().build(reader);
			
			reader.close(); //xml�� �о���� ��Ʈ���� ���´�.
		}//end if
		
		return ssf;
	}//getSqlSessionFactory
	
	
	/**
	 * SqlSession ���(MyBatis handler ���): �����ڰ� ����Ͽ� ���� 
	 * - autocommit�� �������� �ʴ´�. commit()�� ������ ����, ����� ����Ǹ� �ݴ´�. 
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
		
		//MyBatis Handler ���
		SqlSession ss = getSqlSession();
		
		list = ss.selectList("selectMemberList", id); //Mapper���� ã�� �Ľ��Ͽ� �����ؾ� �� id, ��
		
		ss.close();
		
		return list;
		
	}//selectMemberList

}//class
