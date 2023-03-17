package com.SIMS.servlet;

import com.SIMS.entity.Student;
import com.SIMS.entity.Teacher;
import com.SIMS.service.StudentServiceImp;
import com.SIMS.service.TeacherServiceImp;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet_Tea_Login", value = "/Servlet_Tea_Login")
public class Servlet_Tea_Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
    TeacherServiceImp ts;

    public Servlet_Tea_Login(){

        ts = new TeacherServiceImp();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // TODO Auto-generated method stub
        // 允许跨域访问的域名：若有端口需写全（协议+域名+端口），若没有端口末尾不用加'/'
        response.setHeader("Access-Control-Allow-Origin", "*");

        // 允许前端带认证cookie：启用此项后，上面的域名不能为'*'，必须指定具体的域名，否则浏览器会提示
        response.setHeader("Access-Control-Allow-Credentials", "true");

        // 提示OPTIONS预检时，后端需要设置的两个常用自定义头
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,X-Requested-With");


        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");
        String password = request.getParameter("password");


        System.out.println(name + " " + password);


        Teacher t= ts.TeacherLogin(new Teacher(name,password));
//			将用户名存入session，发送到前台
        HttpSession session = request.getSession();
        session.setAttribute("teacher", t);

        Cookie cookie = new Cookie("user",name +"-"+password);

        // 响应给客户端
        response.addCookie(cookie);

            Gson json = new Gson();
            String res = json.toJson(t);
            response.getWriter().write(res);
            request.setAttribute("res", t);




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }
}
