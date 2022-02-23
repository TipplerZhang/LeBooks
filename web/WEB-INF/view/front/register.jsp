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
            <form action="register.action" method="post" name="registerform" >
                <h3>用户注册：</h3>
                <hr>
                <p>用户昵称：<span class="a1" ><input type="text" required placeholder autofocus></span> <hr></p>
                <p>用户姓名：<span class="a1" ><input type="text" required placeholder autofocus></span> <hr></p>
                <p>密码： <span class="a2" ><input type="password" required placeholder></span><hr></p>
                <p>注册邮箱：<span class="a1" ><input type="email" required placeholder="javin@example.com"></span><hr></p>
                <p>性别：<span class="a2">男<input type="radio" name="1" checked>女 <input type="radio" name="1"> </span><hr></p>
                <button type=submit>立即注册</button>
            </form>
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
