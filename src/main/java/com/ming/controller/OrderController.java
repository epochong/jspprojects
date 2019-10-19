package com.ming.controller;

import com.ming.po.User;
import com.ming.service.UserService;
import com.ming.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author: xiao ming
 * @create:2019-08-2019/8/27 20:12
 */

@WebServlet(urlPatterns = "/orderController")
public class OrderController  extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //User user  = (User) request.getAttribute("userkey");

        try {
            User user1  =  userService.user_order();
            request.setAttribute("userInfo",user1);
            request.getRequestDispatcher("success.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
