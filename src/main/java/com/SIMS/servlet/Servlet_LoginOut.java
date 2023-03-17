package com.SIMS.servlet;

import com.SIMS.entity.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet_LoginOut", value = "/Servlet_LoginOut")
public class Servlet_LoginOut extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 允许跨域访问的域名：若有端口需写全（协议+域名+端口），若没有端口末尾不用加'/'
        response.setHeader("Access-Control-Allow-Origin", "*");

        // 允许前端带认证cookie：启用此项后，上面的域名不能为'*'，必须指定具体的域名，否则浏览器会提示
        response.setHeader("Access-Control-Allow-Credentials", "true");

        // 提示OPTIONS预检时，后端需要设置的两个常用自定义头
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,X-Requested-With");


        // 1. 销毁Session对象
        request.getSession().invalidate();
        // 2. 删除Cookie对象
        Cookie cookie = new Cookie("user", null);
        cookie.setMaxAge(0); // 设置0，表示删除cookie
        response.addCookie(cookie);

        // 3. 重定向跳转到登录页面
        response.sendRedirect("index.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
