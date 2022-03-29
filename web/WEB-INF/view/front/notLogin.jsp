<%--
  Created by IntelliJ IDEA.
  User: zhangleyuan
  Date: 2022/3/20
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>租赁平台-未登录页面</title>
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
            <script type="text/javascript">header("${session_user.username}");</script>
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
            <div class="shoppingcart_wrapper" id="shoppingcart">
                <p ><span id="shoppingcart_dd" >当前位置&nbsp;&gt;&gt;&nbsp;未登录 </span></p>

                <!-- 购物车为空的话 -->

                <table align="center">
                    <tr>
                        <td><img alt="" src="static/images/cart_icon.gif"/></td>
                        <td>
                                            <span style="font-size:14px;font-weight:bold;">
                                                当前未登录，<a href="login.action">点击返回登录页面&gt;&gt;</a>
                                            </span>
                        </td>
                    </tr>
                </table>

            </div>
        </div>
        <!---- middle end----->

        <!--bottom part-->
        <div  id="footer">
            <footer ><div >&copy; 2018-2022 <a href="/">LeBooks租赁平台</a></div></footer>
        </div>
    </div>
</body>
</html>
