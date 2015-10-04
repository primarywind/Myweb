package demo.service;

import java.sql.Timestamp;

import demo.dao.IUserDao;
import demo.entity.User;
import demo.entity.UserInfo;

public class UserServiceImpl implements IUserService {
	private IUserDao userDao;

	public void reg(UserInfo tuser) {
		User user = new User();
		user.setGender(1);
		user.setLevel(1);
		user.setNationality("中国");
		Timestamp time1 = new Timestamp(System.currentTimeMillis());
		user.setRegTime(time1);
		user.setUserName("胡磊");
		this.userDao.save(user);
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
}
