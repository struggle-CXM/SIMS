package com.SIMS.servlet;

import com.SIMS.entity.Exam;
import com.SIMS.entity.Score;
import com.SIMS.entity.StuScore;
import com.SIMS.service.ExamServiceImp;
import com.SIMS.service.ScoreServiceImp;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet_GetScoreBySid", value = "/Servlet_GetScoreBySid")
public class Servlet_GetScoreBySid extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ScoreServiceImp scs;
    ExamServiceImp es;
    public Servlet_GetScoreBySid(){
        scs = new ScoreServiceImp();
        es = new ExamServiceImp();
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

        String sid = request.getParameter("sid");

        ArrayList<StuScore> st = new ArrayList<StuScore>();

        Exam e = null;
//        String sid = "grd";
        List<Score> s = scs.GetScoreBySid(sid);
        StuScore ss;
        for (Score s1:s) {

            e = es.GetExamByEid(s1.getEid());

            ss = new StuScore(e.getSub(),s1.getScore(),e.getEtime(),s1.getSc_time());
            System.out.println(ss);
            st.add(ss);
        }







        Gson json = new Gson();
        String res = json.toJson(st);
        response.getWriter().write(res);
        request.setAttribute("res", st);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
