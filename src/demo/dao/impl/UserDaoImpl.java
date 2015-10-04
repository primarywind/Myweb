package demo.dao.impl;

import demo.dao.UserDao;
import demo.entity.User;

public class UserDaoImpl extends CommonDao implements UserDao {

    public void save(User user) {
        super.save(user);
    }
}
