package com.SIMS.servlet;

import com.SIMS.entity.Student;
import com.SIMS.service.StudentServiceImp;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet_AddStu", value = "/Servlet_AddStu")
public class Servlet_AddStu extends HttpServlet {
    private static final long serialVersionUID = 1L;

    StudentServiceImp ss;

    public Servlet_AddStu() {
        ss = new StudentServiceImp();
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

        String sid = request.getParameter("sid");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        String grade = request.getParameter("grade");
        String classNum = request.getParameter("classNum");
        String birth = request.getParameter("birth");
        String id = request.getParameter("id");
        String stime = request.getParameter("stime");
        Student s = new Student(sid, password, name, tel, grade, classNum, birth, id, stime);
        System.out.println(s);
        int i = ss.AddStudent(s);
        Gson json = new Gson();
        String res = json.toJson(i);
        response.getWriter().write(res);
        request.setAttribute("res", i);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
