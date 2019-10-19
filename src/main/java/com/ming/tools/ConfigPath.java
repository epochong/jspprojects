package com.ming.tools;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;


/**
 * @author: xiao ming
 * @create:2019-08-2019/8/27 18:51
 */
public class ConfigPath {

    private Connection conn;
    private Statement state;
    private ResultSet rs;

    private  String DRIVER_CLASS; // 数据库驱动
    private  String DB_URL; // 数据库连接地址
    private  String DB_USER; // 数据库用户名称
    private  String DB_PASSWORD; // 数据库用户密码


    public ConfigPath(){
        try {
            // 创建Properties类对象
            Properties properties = new Properties();
            // 读取properties属性文件到输入流中
            InputStream is = ConfigPath.class.getResourceAsStream("/db.properties");
            // 从输入流中加载属性列表
            properties.load(is);
            // 获取数据库连接属性值
            DRIVER_CLASS = properties.getProperty("DRIVER_CLASS");
            DB_URL = properties.getProperty("DB_URL");
            DB_USER = properties.getProperty("DB_USER");
            DB_PASSWORD = properties.getProperty("DB_PASSWORD");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Connection getConnection(){
        try {
            // 加载数据库驱动类
            Class.forName(DRIVER_CLASS);
            System.out.println("数据库驱动加载成功");

            // 获取数据库连接对象
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("数据库连接成功");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public ResultSet executeQueryOper(String strSql){
        try {
            conn = this.getConnection();
            state = conn.createStatement();
            rs = state.executeQuery(strSql);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }


}
