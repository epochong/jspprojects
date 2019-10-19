package com.ming.service;

import com.ming.dao.UserDAO;
import com.ming.po.User;

import java.util.List;

/**
 * @author: xiao ming
 * @create:2019-08-2019/8/27 18:45
 */
public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAO();

    @Override
    public User registryLogin(User user) throws Exception {
        return userDAO.registryLogin(user);
    }

    @Override
    public User user_order() throws Exception {
        return userDAO.user_order();
    }
}
