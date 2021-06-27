package com.jishou.service;

import com.jishou.dao.UserDao;
import com.jishou.dao.UserDaoImpl;
import com.jishou.pojo.Menu;
import com.jishou.pojo.Transport;
import com.jishou.pojo.User;

import java.util.List;

public class UserServiceImpl  implements UserService {

    private UserDao userDao=new UserDaoImpl();

    @Override
    public User login(User user) {
        return userDao.queryOneUser(user);
    }

    @Override
    public boolean register(User user) {
        int row = userDao.insertUser(user);
        if(row>0){
            return true;
        }
        return false;
    }

    @Override
    public User queryOneUserByUsername(String username) {
        return userDao.queryUserByUsername(username);
    }

    @Override
    public boolean updateUser(User user) {
        int row = userDao.updateUser(user);
        if(row>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Menu> queryMenusByRoleId(int roleId) {
        return userDao.queryMenusByRoleId(roleId);
    }

    @Override
    public List<User> queryAllUser() {
        return userDao.queryAllUser();
    }

    @Override
    public boolean deleteUserByUsername(String username) {
        int row = userDao.deleteUserByUsername(username);
        if(row>0){
            return true;
        }

        return false;
    }
    @Override
    public boolean updateUserRoot(User user) {
        int row = userDao.updateUserRoot(user);
        if(row>0){
            return true;
        }

        return false;
    }
}