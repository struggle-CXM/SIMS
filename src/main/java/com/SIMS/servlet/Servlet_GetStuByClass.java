package com.SIMS.servlet;

import com.SIMS.entity.Student;
import com.SIMS.service.StudentServiceImp;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet_GetStuByClass", value = "/Servlet_GetStuByClass")
public class Servlet_GetStuByClass extends HttpServlet {
    private static final long serialVersionUID = 1L;
    StudentServiceImp ss;

    public Servlet_GetStuByClass(){
        ss = new StudentServiceImp();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 允许跨域访问的域名：若有端口需写全（协议+域名+端口），若没有端口末尾不用加'/'
        response.setHeader("Access-Control-Allow-Origin", "*");

        // 允许前端带认证cookie：启用此项后，上面的域名不能为'*'，必须指定具体的域名，否则浏览器会提示
        response.setHeader("Access-Control-Allow-Credentials", "true");

        // 提示OPTIONS预检时，后端需要设置的两个常用自定义头
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,X-Requested-With");


        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String grade = request.getParameter("grade");
        String classNum = request.getParameter("classNum");

        System.out.println(grade + "46");
        System.out.println(classNum + "55");
        List<Student> s=null;

        if(grade == ""&&classNum == ""){
            s = ss.GetAllStu();
        }
        else if(grade == null&&classNum == null){
            s = ss.GetAllStu();
        }else{
            s = ss.FindStuByClass(grade,classNum);
        }


        Gson json = new Gson();
        String res = json.toJson(s);
        response.getWriter().write(res);
        request.setAttribute("res", s);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
