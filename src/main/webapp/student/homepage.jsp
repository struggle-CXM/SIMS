<%@ page import="com.SIMS.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/12/16
  Time: 16:14
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
  <li class="layui-nav-item"><a href="homepage.jsp">个人信息</a></li>
  <li class="layui-nav-item"><a href="grade.jsp">成绩查询</a></li>
  <li class="layui-nav-item"><a href="personal.jsp">密码修改</a></li>
  <button id="loginout" class="layui-btn quit-btn" style="background: #FF5722;" lay-submit lay-filter="logout">退出</button>
</ul>
<% Student s = (Student) session.getAttribute("student");%>
<table class="layui-table">
  <colgroup>
    <col width="150">
    <col width="200">
    <col>
  </colgroup>
  <thead>
  <tr>
    <th>姓名</th>
    <th><%= s.getName()%></th>
  </tr>
  </thead>
  <tbody>
  <tr>
    <td>电话</td>
    <td><%=s.getTel()%></td>
  </tr>
  <tr>
    <td>学号</td>
    <td><%=s.getSid()%></td>
  </tr>
  <tr>
    <td>年级</td>
    <td><%=s.getGrade()%></td>
  </tr>
  <tr>
    <td>班级</td>
    <td><%=s.getClassNum()%></td>
  </tr>
  <tr>
    <td>出生日期</td>
    <td><%=s.getBirth()%></td>

  </tr>
  <tr>
    <td>身份证号</td>
    <td><%=s.getId()%></td>

  </tr>
  <tr>
    <td>入学时间</td>
    <td><%=s.getStime()%></td>

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
