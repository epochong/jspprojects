package com.ming.dao;

import com.ming.po.Order;
import com.ming.po.User;
import com.ming.tools.ConfigPath;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author: xiao ming
 * @create:2019-08-2019/8/27 18:45
 */
public class UserDAO {

    public User registryLogin(User user) {
        try {
            ConfigPath configPath = new ConfigPath();
            String strSql = "select t_username,t_userpass from t_user where t_username='"+user.getUserName()+"' and t_userpass='"+user.getUserPass()+"'";
            ResultSet rs = configPath.executeQueryOper(strSql);
            User user1 = null;
            if(rs.next()){
                user1 = new User();
                user1.setUserName(rs.getString("t_username"));
                user1.setUserPass(rs.getString("t_userpass"));
                return user1;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }


    public User user_order() {
        try {
            ConfigPath configPath = new ConfigPath();
            String strSql = "select t_username,t_orderNum from t_user inner join t_order where t_userid = t_order.t_userNo";
            ResultSet rs = configPath.executeQueryOper(strSql);
            List<Order> orderList = new ArrayList<>();
            User user = new User();
            while(rs.next()){
                Order order = new Order();
                user.setUserName(rs.getString("t_username"));
                order.setOrderNum(rs.getInt("t_orderNum"));
                orderList.add(order);
                user.setOrderList(orderList);
            }
           return user;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

}
