package com.SIMS.servlet;

import com.SIMS.entity.Exam;
import com.SIMS.entity.Score;
import com.SIMS.entity.Student;
import com.SIMS.entity.TeaScore;
import com.SIMS.service.ExamServiceImp;
import com.SIMS.service.ScoreServiceImp;
import com.SIMS.service.StudentServiceImp;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet_TeaGetScore", value = "/Servlet_TeaGetScore")
public class Servlet_TeaGetScore extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ScoreServiceImp scs;
    ExamServiceImp es;
    StudentServiceImp ss;
    public Servlet_TeaGetScore(){
        scs = new ScoreServiceImp();
        es =  new ExamServiceImp();
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

        ArrayList<TeaScore> ts= new ArrayList<TeaScore>();
        TeaScore ts1 = null;
        List<Score> sc = scs.GetAllScore();
        Exam e = null;
        Student s = null;

        for (Score s1:sc) {
            e = es.GetExamByEid(s1.getEid());
            s = ss.FindStuBySid(s1.getSid());
            System.out.println(e);
            System.out.println(s);
            ts1 = new TeaScore(s.getName(),s.getSid(),s.getGrade(),s.getClassNum(),e.getSub(),s1.getScore(),e.getEid(),e.getEtime(),s1.getSc_time());
            ts.add(ts1);
        }
        Gson json = new Gson();
        String res = json.toJson(ts);
        response.getWriter().write(res);
        request.setAttribute("res", ts);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
