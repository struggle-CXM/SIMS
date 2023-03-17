<%@ page import="com.SIMS.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/12/16
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- layui的样式包 -->
    <link rel="stylesheet" href="../layui/css/layui.css" media="all"/>
    <!-- layui的js,模块化使用 -->
    <script type="text/javascript" src="../layui/layui.js"></script>
    <title>个人成绩查询</title>
</head>
<body class="layui-layout-body">
<ul class="layui-nav" lay-filter="">
    <li class="layui-nav-item"><a href="homepage.jsp">个人信息</a></li>
    <li class="layui-nav-item"><a href="grade.jsp">成绩查询</a></li>
    <li class="layui-nav-item"><a href="personal.html">密码修改</a></li>
    <button id="loginout" class="layui-btn quit-btn" style="background: #FF5722;" lay-submit lay-filter="logout">退出</button>
</ul>
<% Student s = (Student) session.getAttribute("student");%>
<table id="demo" lay-filter="test"></table>
<script src="../lib/jquery.min.js"></script>
<script>
    layui.use('table', function () {
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#demo'
            , height: 315
            , url: 'http://localhost:8081/Servlet_GetScoreBySid?sid=<%=s.getSid()%>' //数据接口
            ,parseData: function(res){ //res 即为原始返回的数据
                console.log(res)
                return {
                    "code": 0, //解析接口状态
                    "msg": res.message, //解析提示文本
                    "count": res.length, //解析数据长度
                    "data": res //解析数据列表
                };
            }
            , toolbar: '#toolbarDemo'
            ,layout:['prev','page','next','limit']
            , page: true //开启分页
            , limit: 10
            , limits: [5, 10, 20, 50, 100]
            ,loading:true
            , cols: [[ //表头
                {field: 'sub', title: '课程名称', width: 160,  fixed: 'left'}
                , {field: 'score', title: '分数', width: 160}
                , {field: 'etime', title: '考试时间', width: 160, sort: true}
                , {field: 'sctime', title: '赋分时间', width: 160,sort:true}


            ]]
        });

    });
    $('#loginout').on('click', function() {
        // $money = $("#money").text();
        window.location.href="http://localhost:8081/Servlet_LoginOut";
    });
</script>
</body>
</html>
