<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/12/18
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- layui的样式包 -->
    <link rel="stylesheet" href="../layui/css/layui.css" media="all"/>
    <!-- layui的js,模块化使用 -->
    <script type="text/javascript" src="../layui/layui.js"></script>
    <style type="text/css">
        .container{
            width: 420px;
            height: 220px;
            min-height: 220px;
            max-height: 320px;
            position: absolute;
            top: 0;
            left: 0;
            bottom: 0;
            right: 0;
            margin: auto;
            padding: 20px;
            z-index: 130;
            border-radius: 8px;
            background-color: #fff;
            box-shadow: 0 3px 18px rgba(100, 0, 0, .5);
            font-size: 16px;
        }
        .close{
            background-color: white;
            border: none;
            font-size: 18px;
            margin-left: 410px;
            margin-top: -10px;
        }

        /*.layui-input{*/
        /*    border-radius: 5px;*/
        /*    width: 300px;*/
        /*    height: 40px;*/
        /*    font-size: 15px;*/
        /*}*/
        .layui-form-item{
            margin-left: -20px;
        }
        #logoid{
            margin-top: -16px;
            padding-left:150px;
            padding-bottom: 15px;
        }
        /*.layui-btn{*/
        /*    margin-left: -50px;*/
        /*    border-radius: 5px;*/
        /*    width: 350px;*/
        /*    height: 40px;*/
        /*    font-size: 15px;*/
        /*}*/
        .verity{
            width: 120px;
        }
        .font-set{
            font-size: 13px;
            text-decoration: none;
            margin-left: 120px;
        }
        /*a:hover{*/
        /*    text-decoration: underline;*/
        /*}*/
    </style>
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


<form  class="layui-form layui-inline" action="">
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
            <button class="layui-btn" lay-submit lay-filter="stu_get">查询</button>
            <button type="reset" class="layui-btn layui-btn-primary">清空</button>

        </div>
    </div>

</form>
<button style="margin-left: 10px"  class="layui-btn layui-btn-primary" id="addbtn" >新增</button>
<table id="demo" lay-filter="test"></table>

<script type="text/html" id="barDemo">
<%--    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="update">编辑</a>--%>
    <a style="background: #FF5722;color: white" class="layui-btn layui-btn-primary layui-btn-xs" lay-event="delete">删除</a>
</script>
<script src="../lib/jquery.min.js"></script>

<script>
    layui.use(['table','form','laydate','layer'], function () {
        var table = layui.table;
        var form = layui.form;
        var laydate = layui.laydate;
        let layer = layui.layer

        //执行一个laydate实例
        laydate.render({
            elem: '#test1' //指定元素
        });
        laydate.render({
            elem: '#test2' //指定元素
        });

        //第一个实例
        table.render({
            elem: '#demo'
            ,id: 'idTest'
            ,toolbar: '#barDemo'
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
                {field: 'sid', title: '学号', width: 160,sort:true}

                , {field: 'name', title: '姓名', width: 160 }
                , {field: 'tel', title: '电话', width: 160, }
                , {field: 'grade', title: '年级', width: 160,sort:true}
                , {field: 'classNum', title: '班级', width: 160,sort:true}
                , {field: 'birth', title: '出生日期', width: 160}
                , {field: 'id', title: '身份证号', width: 160}
                , {field: 'stime', title: '入学时间', width: 160}
                ,{fixed: 'right', title: '操作', width: 150, align:'center', toolbar: '#barDemo'}


            ]]
        });

        //表格按钮事件
        table.on('tool(test)', function(obj){
            console.log(obj.data)
            switch(obj.event){
                case 'update':
                    layer.msg('编辑');
                    break;
                case 'delete':
                    layer.confirm('确认删除该学生', {
                        btn: ['确定', '取消'] //可以无限个按
                    }, function(index, layero){
                        //确定按钮的回调   发送删除请求
                        console.log(obj.data.sid)
                        console.log(index)
                        $.ajax({
                            url: "http://localhost:8081/Servlet_DelStu",
                            method: "POST",
                            dataType:"json",
                            data: {
                                sid:obj.data.sid

                            },
                            success: function (res) {
                                console.log("ajax返回结果：" + res);
                                alert("删除成功");
                                table.reload('idTest', {
                                    where: { //设定异步数据接口的额外参数，任意设

                                    }

                                });

                            },
                            error: function (msg) {
                                alert("数据请求错误" + msg);
                            },
                        });
                        layer.msg('删除成功');

                        layer.close(index)   //这个是关闭弹窗 不用管

                    }, function(index){
                        console.log(index)
                        //按钮【按钮二】的回调
                    });
                    break;
            };
        });



        //   表单提交
        form.on('submit(stu_get)', function(data){

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

        form.on('submit(stu_man)', function(data){
            // layer.msg(JSON.stringify(data.field));


            var field = data.field;
            console.log(field);
            // $.ajax({
            //     url: "http://localhost:8081/Servlet_ScoreEntry",
            //     method: "POST",
            //     dataType:"json",
            //     data: {
            //         eid: field['eid'],
            //         sid: field['sid'],
            //         score:field['score']
            //     },
            //     success: function (res) {
            //         console.log("ajax返回结果：" + res);
            //         alert("录入成功");
            //
            //
            //     },
            //     error: function (msg) {
            //         alert("数据请求错误" + msg);
            //     },
            // });
            return false;
        });


        //新增数据
        $('#addbtn').click(function (){
            console.log(1)
            let  index = layer.open({
                area: ['500px','600px'],
                shadeClose: true,
                anim: 2,
                type: 2,
                content: 'add_student.html',
            });
        })
    });

    $('#loginout').on('click', function() {
        // $money = $("#money").text();
        window.location.href="http://localhost:8081/Servlet_LoginOut";
    });

</script>
</body>
</html>
