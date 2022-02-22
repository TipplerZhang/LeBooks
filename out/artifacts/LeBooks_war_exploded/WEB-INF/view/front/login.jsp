<%--
  Created by IntelliJ IDEA.
  User: zhangleyuan
  Date: 2022/2/22
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>租赁平台-登录页面</title>
    <link href="fkjava.ico" rel="shortcut icon" type="image/x-icon" />
    <!-- main.css是购物商城主样式 -->
    <link rel=stylesheet type="text/css" href="static/css/main.css"/>
    <!-- login.css作用于登录的CSS -->
    <link rel="stylesheet" type="text/css" href="static/css/login.css"/>
    <!-- header.js输出头部信息 -->
    <script type="text/javascript" src="static/js/header.js"></script>
    <script type="text/javascript">
        if (parent.window.location != window.location){
            parent.window.location = window.location;
        }
        window.onload = function(){
            document.loginform.loginName.focus();
            document.onkeydown = function(){
                // firefox没有window.event对象
                var event = arguments[0] ? arguments[0] : window.event;
                if (event.keyCode === 13){
                    onLogin();
                }
            };
        };
        var onLogin = function(){
            //验证用户名和密码是否输入
            var loginname = document.getElementById("loginName").value;
            if(loginname == null || loginname == "" || loginname.length == 0){
                alert("请输入用户名!");
                document.getElementById("loginName").focus;
                return false;
            }
            var password = document.getElementById("password").value;
            if(password == null || password == "" || password.length == 0){
                alert("请输入密码!");
                document.getElementById("password").focus;
                return false;
            }
            document.getElementById("loginform").submit();
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
            <form name="loginform" method="post" action="login.action" id="loginform">
                <br />
                <input type="hidden" name="step" value="1"/>
                <div class="login_main" style="background: url(static/images/login_bg.jpg) no-repeat center 0;">
                    <div class="login_panel">
                        <!--登录框开始-->
                        <div class="right_panel">
                            <div class="login_frame_border">
                                <div class="login_frame">
                                    <div class="login_title">
                                        <i></i>还不是平台用户？&nbsp;&nbsp;<a href="register.action">立即注册</a>
                                    </div>
                                    <div class="login_frist clearfix" id="user_div_name">
                                        <label>登录名</label>
                                        <span class="login_input">
                                            <input name="loginName" type="text" maxlength="40" id="loginName" class="tip"/>
                                        </span>
                                        <span class="hint" id="login_loginname_error" style="display: none"></span>
                                        <span class="hint" id="usernameMessage" style="display: black">请输入邮箱地址</span>
                                    </div>
                                    <p class="clearfix" id="password_div">
                                        <label>密&nbsp;&nbsp;码</label>
                                        <span class="login_input">
                                            <input name="password" type="password" maxlength="20" id="password"/>
                                        </span>
                                        <span class="hint" id="login_password_error" style="display: none"></span>
                                        <span class="hint" id="passwordMessage" style="display: black">请输入6-16位密码</span>
                                    </p>

                                    <div class="login_btn" id="submit_signin_div">
                                        <input id="btnSignCheck" type="button" value="登 录"
                                               onclick="onLogin();" style="width: 94px; height: 27px; float: left;
                                            background: url(static/images/login_btn.png) no-repeat -237px -46px;"/>
                                        &nbsp;&nbsp;
                                    </div>

                                    <div class="co_login">
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
    </div>
</body>
</html>
