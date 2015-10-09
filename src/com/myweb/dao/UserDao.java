package com.myweb.dao;

import com.myweb.entity.User;

public interface UserDao {
    public Integer save(User user);

    public User findById(int id);
}
