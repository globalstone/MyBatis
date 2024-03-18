package mybatis.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mybatis.service.domain.Search;
import mybatis.service.domain.User;
import mybatis.service.user.UserDao;
import mybatis.service.user.UserService;

@Service("userServiceImpl14")
public class UserServiceImpl14 implements UserService {

	///Field
	@Autowired
	@Qualifier("userDaoImpl14")
	UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		System.out.println("::" +getClass()+"setUserDao Call.....");
		this.userDao = userDao;
	}

	///Constructor
	public UserServiceImpl14() {
		System.out.println("::"+getClass()+" default Constructor Call....");
	}
	@Override
	public int addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		System.out.println(">>>>>>>Frist Insert =======================");
		result = userDao.addUser(user);
		System.out.println(">>>>>>>> 첫번째 insert 결과 : "+result);
		System.out.println(">>>>>>>>>>>>> 2 Insert =========================");
//		result = userDao.addUser(user);
//		System.out.println(">>>>>>>> 두번째 insert 결과 : "+result);
//		System.out.println(">>>>>>>>>>>>>> 결과는 ??????? =====================");
		
		
		return 0;
	}

	@Override
	public User getUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getUser(userId);
	}

	@Override
	public int updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	@Override
	public int removeUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return userDao.removeUser(userId);
	}

	@Override
	public List<User> getUserList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getUserList(search);
	}
	
	
}