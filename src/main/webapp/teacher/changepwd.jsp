<%@ page import="com.SIMS.entity.Teacher" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/12/17
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>密码修改</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../layui/css/layui.css">
    <style type="text/css">
        .layui-input {
            border-radius: 5px;
            width: 300px;
            height: 40px;
            font-size: 15px;
        }

        .layui-form-item {
            margin-left: -20px;
        }

        #logoid {
            margin-top: -16px;
            padding-left: 150px;
            padding-bottom: 15px;
        }

        .verity {
            width: 120px;
        }

        .font-set {
            font-size: 13px;
            text-decoration: none;
            margin-left: 120px;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
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
<form class="layui-form" lay-filter="formPersonal" action="" method="post">

    <div class="layui-form-item">
        <label class="layui-form-label">新密码</label>
        <div class="layui-input-inline">
            <input type="password" name="password" required lay-verify="required" placeholder="请输入新密码"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="edit">修改</button>
        </div>
    </div>
</form>
<%Teacher t= (Teacher) session.getAttribute("teacher");%>
<script src="../lib/jquery.min.js"></script>
<script type="text/javascript" src="../layui/layui.js"></script>
<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;
        form.verify({
            username: function(value){
                if(value.length ==0){
                    return '用户名不能为空';
                }
                if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
                    return '用户名不能有特殊字符';
                }
                if(/(^\_)|(\__)|(\_+$)/.test(value)){
                    return '用户名首尾不能出现下划线\'_\'';
                }
                if(/^\d+\d+\d$/.test(value)){
                    return '用户名不能全为数字';
                }

                //如果不想自动弹出默认提示框，可以直接返回 true，这时你可以通过其他任意方式提示（v2.5.7 新增）
                if(value === 'xxx'){
                    alert('用户名不能为敏感词');
                    return true;
                }
            }
            ,password: [
                /^[\S]{6,12}$/
                ,'密码必须6到12位，且不能出现空格'
            ]
            // ,phone:[
            //     /^[1][0-9]{10}$/
            //     ,'手机号格式不正确'
            // ]
        });

        // 日期选择器
        laydate.render({
            elem: '#birthday',
            type: 'datetime'
        });
        // 初始化表格
        form.val("formPersonal", {

            "password": null
        })

        form.on('submit(edit)', function (data) {
            var field = data.field
            console.log(field)
            $.ajax({
                url: "http://localhost:8081/Servlet_TeaChangePwd",
                method: "POST",
                dataType:"json",
                data: {
                    username: <%=t.getTid()%>,
                    password: field['password'],
                },
                success: function (res) {
                    console.log(res);
                    alert("密码修改成功，请重新登录！");
                    location.href="../login.html";
                },
                error: function (msg) {
                    alert("数据请求错误" + msg);
                },
            })

            return false;

        });
    });

    $('#loginout').on('click', function() {
        // $money = $("#money").text();
        window.location.href="http://localhost:8081/Servlet_LoginOut";
    });
</script>
</body>
</html>
