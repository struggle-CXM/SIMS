<%@ page import="com.SIMS.entity.Admin" %><%--
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
        <a href="">个人中心</a>
        <dl class="layui-nav-child">
            <dd><a href="homepage.jsp">个人信息</a></dd>
            <dd><a href="adminchangepwd.jsp">修改密码</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item">
        <a href="">人员管理</a>
        <dl class="layui-nav-child">
            <dd><a href="tea-man.jsp">教师管理</a></dd>
            <dd><a href="stu-man.jsp">学生管理</a></dd>
        </dl>
    </li>

    <button id="loginout" class="layui-btn quit-btn" style="background: #FF5722;" lay-submit lay-filter="logout">退出</button>
</ul>
<%Admin a = (Admin) session.getAttribute("admin");%>
<table class="layui-table">
    <colgroup>
        <col width="150">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
        <th>姓名</th>
        <th><%= a.getName()%></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>电话</td>
        <td><%=a.getTel()%></td>

    </tr>
    <tr>
        <td>工号</td>
        <td><%=a.getAid()%></td>

    </tr>
    <tr>
        <td>职位</td>
        <td><%=a.getPosition()%></td>

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
