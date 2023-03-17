package com.SIMS.servlet;

import com.SIMS.entity.Score;
import com.SIMS.service.ScoreServiceImp;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

@WebServlet(name = "Servlet_ScoreEntry", value = "/Servlet_ScoreEntry")
public class Servlet_ScoreEntry extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ScoreServiceImp scs;
    public Servlet_ScoreEntry(){
        scs = new ScoreServiceImp();
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
        Calendar now = Calendar.getInstance();


        String eid = request.getParameter("eid");
        String sid = request.getParameter("sid");
        int score = Integer.parseInt(request.getParameter("score"));
        System.out.println(score);
        String scid = eid + sid;
        String sctime = now.get(Calendar.YEAR) + "-" +  (String.valueOf(now.get(Calendar.MONTH)+1).length()==1?("0"+ (now.get(Calendar.MONTH) + 1)):String.valueOf(now.get(Calendar.MONTH)+1))
                + "-" + (String.valueOf(now.get(Calendar.DAY_OF_MONTH)).length()==1?("0"+ now.get(Calendar.DAY_OF_MONTH)):String.valueOf(now.get(Calendar.DAY_OF_MONTH)));
//                + (String.valueOf(now.get(Calendar.HOUR_OF_DAY)).length()==1?("0"+String.valueOf(now.get(Calendar.HOUR_OF_DAY))):String.valueOf(now.get(Calendar.HOUR_OF_DAY)))
//                + (String.valueOf(now.get(Calendar.MINUTE)).length()==1?("0"+String.valueOf(now.get(Calendar.MINUTE))):String.valueOf(now.get(Calendar.MINUTE)))
//                + (String.valueOf(now.get(Calendar.SECOND)).length()==1?("0"+String.valueOf(now.get(Calendar.SECOND))):String.valueOf(now.get(Calendar.SECOND)));
        int i = scs.AddScore(new Score(scid,eid,sid,score,sctime));
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
