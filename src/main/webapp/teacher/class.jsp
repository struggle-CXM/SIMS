<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/12/17
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>班级信息</title>
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

<form class="layui-form" action="" style="margin-top: 20px">
    <div class="layui-form-item layui-inline">
        <label class="layui-form-label">年级</label>
        <div class="layui-input-block">
            <input style="width: 300px" type="text" name="grade" required  lay-verify="" placeholder="请输入年级" autocomplete="off" class="layui-input">
        </div>

    </div>
    <div class="layui-form-item layui-inline">

        <label class="layui-form-label">班级</label>
        <div class="layui-input-block">
            <input style="width: 300px" type="text" name="classNum" required  lay-verify="" placeholder="请输入班级" autocomplete="off" class="layui-input">
        </div>

    </div>
    <div class="layui-form-item layui-inline">

        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">查询</button>
            <button type="reset" class="layui-btn layui-btn-primary">清空</button>
        </div>
    </div>

</form>

<table id="demo" lay-filter="test"></table>
<script src="../lib/jquery.min.js"></script>
<script>
    layui.use(['table','form'], function () {
        var table = layui.table;
        var form = layui.form;
        //第一个实例
        table.render({
            elem: '#demo'
            ,id: 'idTest'
            , height: 600
            , url: 'http://localhost:8081/Servlet_GetStuByClass' //数据接口
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
            // ,layout:['prev','page','next','limit']
            // , page: true //开启分页
            // , limit: 10
            // , limits: [5, 10, 20, 50, 100]
            ,loading:true
            , cols: [[ //表头
                {field: 'sid', title: '学号', width: 160,  fixed: 'left',sort:true}

                , {field: 'name', title: '姓名', width: 160, }
                , {field: 'tel', title: '电话', width: 160, }
                , {field: 'grade', title: '年级', width: 160,sort:true}
                , {field: 'classNum', title: '班级', width: 160,sort:true}
                , {field: 'birth', title: '出生日期', width: 160}
                , {field: 'id', title: '身份证号', width: 160}
                , {field: 'stime', title: '入学时间', width: 160}


            ]]
        });


        //   表单提交
        form.on('submit(formDemo)', function(data){

            console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}

            table.reload('idTest', {
                where: { //设定异步数据接口的额外参数，任意设
                    grade:data.field.grade,
                    classNum: data.field.classNum
                }
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
            return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
        });



    });

    $('#loginout').on('click', function() {
        // $money = $("#money").text();
        window.location.href="http://localhost:8081/Servlet_LoginOut";
    });
</script>
</body>
</html>
