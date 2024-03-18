package ibatis.services.user.test;


import java.io.Reader;
import java.util.List;

import mybatis.service.domain.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * FileName : MyBatisTestApp01.java
  * �� JBDCTestApp.java �� �� ����.
  * �� MyBatis Framework ���� �����ϴ� API�� ��� users table �� ���� SELECT   
 */
public class MyBatisTestApp01 {
	
	///main method
	public static void main(String[] args) throws Exception{
		
		//==> mybatis-config.xml : MyBatis Framework �� �ٽ� MetaData
		//==> UserMapper.xml : SQL �� ���� MetaData 
		
		//==> 1. xml metadata �д� Stream ����
		Reader reader = Resources.getResourceAsReader("sql/mybatis-config01.xml");
		
		//==> 2. Reader ��ü�� �̿� xml metadata �� ������ ���� ������ ����, ��밡���� 
		//==>     SqlSession�� �����ϴ� SqlSessionFactory  instance ����
		SqlSessionFactory sqlSessionFactory 
											= new SqlSessionFactoryBuilder().build(reader);
		
		//==> 3.SqlSessionFactory �� ���� autoCommit true �� sqlSession instance ����
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		System.out.println("\n");
		
		//==> 3. xml �� ��ϵ� query ���� �� ������ ���(?) ��ü�� ���� List ��ü �ޱ� 
		System.out.println(":: 0.all User(SELECT)");
		List<User> list01 = sqlSession.selectList("UserMapper01.getUserList");
		for(int i = 0; i < list01.size(); i++) {
			System.out.println("<"+(i+1)+"��° ȸ��.."+list01.get(i).toString());
		}
		System.out.println("\n");
		
		//1.getUser Ư�� userId ����
		User user = (User)sqlSession.selectOne("UserMapper01.getUser", "user01");
		System.out.println(":: 1.get(SELECT) ? "+user.toString());
		System.out.println("\n");
		
		//2.findUserId :: Ư�� userId/ password ����
		user.setUserId("user03");
		user.setPassword("user03");
		String name = (String)sqlSession.selectOne("UserMapper01.findUserId",user);
		System.out.println(":: 2.get(SELECT) ? "+name);
		System.out.println("\n");
		
		//3.findUserId :: Ư�� age ����
		System.out.println(":: 3. Ư������ User(SELECT) ? ");
		List<String> list02
			= sqlSession.selectList("UserMapper01.getUserListAge",new Integer(20));
		for(int i = 0; i < list02.size(); i++) {
			System.out.println("<"+ (i + 1)+">��° ȸ��...." +list02.get(i).toString());
		}
		System.out.println("\n");
		
		//End :: SqlSession close
		System.out.println(":: END :: SqlSession �ݱ�");
		sqlSession.close();
	}
}