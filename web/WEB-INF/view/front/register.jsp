<%--
  Created by IntelliJ IDEA.
  User: zhangleyuan
  Date: 2022/2/23
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>租赁平台-注册页面</title>
    <link href="fkjava.ico" rel="shortcut icon" type="image/x-icon" />
    <!-- main.css是购物商城主样式 -->
    <link rel=stylesheet type="text/css" href="static/css/main.css"/>
    <!-- header.js输出头部信息 -->
    <script type="text/javascript" src="static/js/header.js"></script>
    <script type="text/javascript">
        if (parent.window.location != window.location){
            parent.window.location = window.location;
        }
        window.onload = function(){
            document.registerform.registerEmail.focus();
            document.onkeydown = function(){
                // firefox没有window.event对象
                var event = arguments[0] ? arguments[0] : window.event;
                if (event.keyCode === 13){
                    onRegister();
                }

            };
        };
        var onRegister = function(){
            //验证用户名和密码是否输入
            var registerEmail = document.getElementById("registerEmail").value;
            if(registerEmail == null || registerEmail == "" || registerEmail.length == 0){
                alert("请输入邮箱地址!");
                document.getElementById("registerEmail").focus;
                return false;
            }
            var username = document.getElementById("username").value;
            if(username == null || username == "" || username.length == 0){
                alert("请输入姓名!");
                document.getElementById("username").focus;
                return false;
            }
            var password = document.getElementById("password").value;
            if(password == null || password == "" || password.length == 0){
                alert("请输入密码!");
                document.getElementById("password").focus;
                return false;
            }
            document.getElementById("registerform").submit();
        };
    </script>
</head>
<body>
    <div id="container">
        <!-- header部分 -->
        <div id="shortcut">
            <script type="text/javascript">header("");</script>
            <div class="nav">
                <div class="w960 center">
                    <ul>
                        <li><a title="首页" href="index.action">首页</a></li>

                        <li><a title="小说" href="index.action?book_type=小说">小说</a></li>

                        <li><a title="文学" href="index.action?book_type=文学">文学</a></li>

                        <li><a title="历史" href="index.action?book_type=历史">历史</a></li>

                        <li><a title="地理" href="index.action?book_type=战争">战争</a></li>

                        <li><a title="政治" href="index.action?book_type=政治">政治</a></li>

                        <li><a title="经济" href="index.action?book_type=经济">经济</a></li>

                        <li><a title="哲学" href="index.action?book_type=哲学">哲学</a></li>

                        <li><a title="心理" href="index.action?book_type=心理">心理</a></li>

                        <li><a title="童书" href="index.action?book_type=儿童">儿童</a></li>

                        <li><a title="冒险" href="index.action?book_type=冒险">冒险</a></li>

                        <li><a title="科技" href="index.action?book_type=科幻">科幻</a></li>

                        <li><a title="宗教" href="index.action?book_type=宗教">宗教</a></li>

                        <li><a title="艺术" href="index.action?book_type=推理">推理</a></li>

                        <li><a title="法律" href="index.action?book_type=爱情">爱情</a></li>

                        <li><a title="奇幻" href="index.action?book_type=奇幻">奇幻</a></li>

                    </ul>
                </div>
            </div>
        </div>
        <!--header end-->
        <!-- middle part -->
        <div id="central">
            <form name="registerform" method="post" action="register.action" id="registerform">
                <br />
                <input type="hidden" name="step" value="1"/>
                <div class="register_main" style="background: url(static/images/login_bg.jpg) no-repeat center 0;">
                    <div class="register_panel">
                        <!--注册框开始-->
                        <div class="right_panel">
                            <div class="register_frame_border">
                                <div class="register_frame">
                                    <div class="register_title">
                                        <i></i>已是平台用户？&nbsp;&nbsp;<a href="login.action">立即登录</a>
                                    </div>
                                    <div class="register_frist clearfix" id="user_div_name">
                                        <label>邮&nbsp;&nbsp;箱</label>
                                        <span class="register_input">
                                            <input name="registerEmail" type="text" maxlength="40" id="registerEmail" class="tip" placeholder="请输入注册邮箱地址"/>
                                        </span>

                                    </div>
                                    <p class="clearfix" id="username_div">
                                        <label>姓&nbsp;&nbsp;名</label>
                                        <span class="register_input">
                                            <input name="username" type="text" maxlength="20" id="username" placeholder="请输入注册姓名"/>
                                        </span>
                                    </p>
                                    <p class="clearfix" id="password_div">
                                        <label>密&nbsp;&nbsp;码</label>
                                        <span class="register_input">
                                            <input name="password" type="password" maxlength="20" id="password" placeholder="请输入注册姓名"/>
                                        </span>
                                    </p>


                                    <div class="register_btn" id="submit_signin_div">
                                        <input id="btnSignCheck" type="submit" value="注 册"
                                               onclick="onRegister();" style="width: 94px; height: 27px; float: left;
                                            background: url(static/images/register.jpg) no-repeat ;"/>
                                        &nbsp;&nbsp;
                                    </div>

                                    <div class="co_register">
                                        <span>理想的书籍，是智慧的钥匙。——列夫·托尔斯泰</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <!--登录框结束-->
        </div>
        <!-- middle end -->
        <!--bottom part-->
        <div  id="footer">
            <footer ><div >&copy; 2018-2022 <a href="index.action">LeBooks租赁平台</a></div></footer>
        </div>
        <!--bottom end-->
    </div>
</body>
</html>
