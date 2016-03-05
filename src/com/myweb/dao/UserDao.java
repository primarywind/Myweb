package com.myweb.dao;

import com.myweb.entity.User;

import java.util.List;

public interface UserDao {
    public Integer save(User user);

    public User findById(int id);

    public void update(User user);

    public User findByNameAndPassowrd(String name, String md5PassWord);

    public User findByName(String name);

    public List<User> findHotUser(int hotUserSize);

}
