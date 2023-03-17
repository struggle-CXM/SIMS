<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/12/17
  Time: 20:29
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
    <title>学生成绩查询</title>
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
<div class="layui-card">
<%--    <div class="layui-card-header">卡片面板</div>--%>
    <div class="layui-card-body" style="margin-top: 80px">

    </div>
</div>
<table id="demo" lay-filter="test"></table>

<%--表格工具控件--%>
<%--<script type="text/html" id="toolbarDemo">--%>
<%--    <div class="layui-btn-container">--%>
<%--        <button lay-filter="toolbarDemo" class="layui-btn layui-btn-sm" lay-event="add">添加</button>--%>
<%--        <button lay-filter="toolbarDemo" class="layui-btn layui-btn-sm" lay-event="delete">删除</button>--%>
<%--        <button lay-filter="toolbarDemo" class="layui-btn layui-btn-sm" lay-event="update">编辑</button>--%>
<%--    </div>--%>
<%--</script>--%>
<script src="../lib/jquery.min.js"></script>
<script>
    layui.use(['table','laypage'], function () {
        var table = layui.table;
        var laypage = layui.laypage;

        //执行一个laypage实例
        // laypage.render({
        //     elem: 'demo' //注意，这里的 test1 是 ID，不用加 # 号
        //     ,count: 50 //数据总数，从服务端得到
        // });
        //第一个实例
        table.render({
            elem: '#demo'
            , height: 600
            , url: 'http://localhost:8081/Servlet_TeaGetScore' //数据接口
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

            // , page: true //开启分页
            , limit: 5


            , cols: [[ //表头
                {field: 'aa',type:'numbers'}

                ,{field: 'name', title: '姓名', width: 160}
                , {field: 'sid', title: '学号', width: 160,sort:true}
                , {field: 'grade', title: '年级', width: 160,sort:true}
                , {field: 'classNum', title: '班级', width: 160,sort:true}
                , {field: 'sub', title: '课程名称', width: 160}
                , {field: 'score', title: '分数', width: 160,sort:true}
                , {field: 'eid', title: '考试号', width: 160}
                , {field: 'etime', title: '考试时间', width: 160,sort:true}
                , {field: 'sctime', title: '赋分时间', width: 160}


            ]]
        });
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'add':

                    layer.msg('添加');
                    break;
                case 'delete':
                    layer.msg('删除');
                    break;
                case 'update':
                    layer.msg('编辑');
                    break;
            };
        });

    });
    $('#loginout').on('click', function() {
        // $money = $("#money").text();
        window.location.href="http://localhost:8081/Servlet_LoginOut";
    });
</script>

</body>
</html>
