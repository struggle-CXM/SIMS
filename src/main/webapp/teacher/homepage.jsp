<%@ page import="com.SIMS.entity.Teacher" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/12/16
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- layui的样式包 -->
    <link rel="stylesheet" href="../layui/css/layui.css" media="all"/>
    <!-- layui的js,模块化使用 -->
    <script type="text/javascript" src="../layui/layui.js"></script>
</head>
<body>
<ul class="layui-nav" lay-filter="">
    <li class="layui-nav-item">
        <a href="javascript:;">个人中心</a>
        <dl class="layui-nav-child"> <!-- 二级菜单 -->
            <dd><a href="homepage.jsp">个人信息</a></dd>
            <dd><a href="changepwd.jsp">密码修改</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item"><a href="class.jsp">班级信息</a></li>
    <li class="layui-nav-item">
        <a href="javascript:;">成绩管理</a>
        <dl class="layui-nav-child"> <!-- 二级菜单 -->
            <dd><a href="Score_entry.jsp">成绩录入</a></dd>
            <dd><a href="grade.jsp">成绩查询</a></dd>

        </dl>
    </li>

    <button id="loginout" class="layui-btn quit-btn" style="background: #FF5722;" lay-submit lay-filter="logout">退出</button>
</ul>
<% Teacher t = (Teacher) session.getAttribute("teacher");%>
<table class="layui-table">
    <colgroup>
        <col width="150">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
        <th>姓名</th>
        <th><%= t.getName()%></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>电话</td>
        <td><%=t.getTel()%></td>

    </tr>
    <tr>
        <td>工号</td>
        <td><%=t.getTid()%></td>

    </tr>

    <tr>
        <td>入职时间</td>
        <td><%=t.getT_time()%></td>

    </tr>
    </tbody>
</table>
<script src="../lib/jquery.min.js"></script>
<script>
    $('#loginout').on('click', function() {
        // $money = $("#money").text();
        window.location.href="http://localhost:8081/Servlet_LoginOut";
    });
</script>

</body>
</html>
