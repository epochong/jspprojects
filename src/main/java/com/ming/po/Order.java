package com.ming.po;

/**
 * @author: xiao ming
 * @create:2019-08-2019/8/27 20:30
 */
public class Order {

    private int orderId;

    private int orderNum;

    private int userNum;

    public Order(){

    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }
}
