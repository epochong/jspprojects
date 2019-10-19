package com.ming.po;

import java.util.List;

/**
 * @author: xiao ming
 * @create:2019-08-2019/8/27 15:45
 */
public class User {

    private String userId;

    private String userName;

    private String userPass;

    private List<Order> orderList;

    public User(){

    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
}
