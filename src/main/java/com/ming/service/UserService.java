package com.ming.service;

import com.ming.po.User;

import java.util.List;

/**
 * @author: xiao ming
 * @create:2019-08-2019/8/27 18:44
 */
public interface UserService {

    public User registryLogin(User user) throws Exception;

    public User user_order() throws Exception;
}
