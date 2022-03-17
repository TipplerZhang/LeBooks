<%--
  Created by IntelliJ IDEA.
  User: zhangleyuan
  Date: 2022/3/17
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<title>租赁系统-后台管理页面</title>
<link href="fkjava.ico" rel="shortcut icon" type="image/x-icon" />
<!-- main.css是购物商城主样式 -->
<link rel=stylesheet type="text/css" href="static/css/main.css"/>
<!-- 使用jQuery-UI的样式来设置tab页 -->
<link type="text/css" href="static/css/ui-lightness/jquery-ui-1.8.20.custom.css" rel="stylesheet" />
<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="static/js/jquery-ui.js"></script>
<script type="text/javascript" src="static/js/pager.js"></script>
<!-- header.js输出头部信息 -->
<script type="text/javascript" src="static/js/adminHeader.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div id="container">
        <!-- header部分 -->
        <div id="shortcut">
            <script type="text/javascript">header("${session_admin.admin_name}");</script>
            <div class="nav">
                <div class="w960 center">
                    <ul>
                        <li><a title="首页" href="adminIndex.action">首页</a></li>

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
        <div id="central" >
            <!-- 左边物品类型列表 -->
            <div  id="booksort" style="float:left;width:210px;">
                <div class="mt" >
                    <h2><strong style="LINE-HEIGHT: 45px;">商城后台管理</strong></h2>
                </div>
                <div class="mc">

                    <div class="item"><h3><b>&gt;</b><a href="index.action?book_birthplace=中国">.用户管理</a></h3></div>

                    <div class="item"><h3><b>&gt;</b><a href="index.action?book_birthplace=美国">·图书管理</a></h3></div>

                    <div class="item"><h3><b>&gt;</b><a href="index.action?book_birthplace=法国">·订单管理</a></h3></div>

                    <div class="item"><h3><b>&gt;</b><a href="index.action?book_birthplace=英国">·类型管理</a></h3></div>

                </div>
            </div>

            <!--bottom part-->
        <div  id="footer">
            <footer ><div >&copy; 2018-2022 <a href="/">LeBooks租赁平台</a></div></footer>
        </div>
        <!--bottom end-->
    </div>
</body>
</html>
