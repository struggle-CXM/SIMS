<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/12/17
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成绩录入</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- layui的样式包 -->
    <link rel="stylesheet" href="../layui/css/layui.css" media="all"/>
    <!-- layui的js,模块化使用 -->
    <script type="text/javascript" src="../layui/layui.js"></script><title>Title</title>
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

<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">考试号</label>
        <div class="layui-input-block">
            <input style="width: 300px" type="text" name="eid" required  lay-verify="eid" placeholder="请输入考试号" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">学号</label>
        <div class="layui-input-block">
            <input style="width: 300px" type="text" name="sid" required  lay-verify="sid" placeholder="请输入学号" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">分数</label>
        <div class="layui-input-block">
            <input style="width: 300px" type="text" name="score" required  lay-verify="number" placeholder="请输入分数" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">清空</button>
        </div>
    </div>
</form>
<script src="../lib/jquery.min.js"></script>
<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;
        form.verify({
            sid: function(value){
                if(value.length ==0){
                    return '学号不能为空';
                }
                if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
                    return '学号不能有特殊字符';
                }
                if(/(^\_)|(\__)|(\_+$)/.test(value)){
                    return '学号首尾不能出现下划线\'_\'';
                }
                // if(/^\d+\d+\d$/.test(value)){
                // 	return '用户名不能全为数字';
                // }

                //如果不想自动弹出默认提示框，可以直接返回 true，这时你可以通过其他任意方式提示（v2.5.7 新增）
                // if(value === 'xxx'){
                //     alert('用户名不能为敏感词');
                //     return true;
                // }
            }
            // ,password: [
            //     /^[\S]{6,12}$/
            //     ,'密码必须6到12位，且不能出现空格'
            // ]
            // ,phone:[
            //     /^[1][0-9]{10}$/
            //     ,'手机号格式不正确'
            // ]
        });
        //提交
        form.on('submit(formDemo)', function(data){
            // layer.msg(JSON.stringify(data.field));


            var field = data.field;
            console.log(field);
            $.ajax({
                url: "http://localhost:8081/Servlet_ScoreEntry",
                method: "POST",
                dataType:"json",
                data: {
                    eid: field['eid'],
                    sid: field['sid'],
                    score:field['score']
                },
                success: function (res) {
                    console.log("ajax返回结果：" + res);
                    alert("录入成功");


                },
                error: function (msg) {
                    alert("数据请求错误" + msg);
                },
            });
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
