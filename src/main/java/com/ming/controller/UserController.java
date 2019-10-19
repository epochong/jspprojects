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
 * @create:2019-08-2019/8/27 15:53
 */

@WebServlet(urlPatterns = "/userController")
public class UserController extends HttpServlet {

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

        String name = request.getParameter("username");
        String pass = request.getParameter("userpass");

        User user = new User();
        user.setUserName(name);
        user.setUserPass(pass);


        try {
            User user1 = userService.registryLogin(user);
            if(user1.getUserName().equals("arvin") && user1.getUserPass().equals("123")){
                request.setAttribute("userkey",user1);
                request.getRequestDispatcher("orderController").forward(request,response);
            }else{
                request.getRequestDispatcher("false.jsp").forward(request,response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
