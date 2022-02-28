<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhangleyuan
  Date: 2022/2/28
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>租赁平台-我的订单</title>
    <link href="fkjava.ico" rel="shortcut icon" type="image/x-icon" />
    <!-- main.css是购物商城主样式 -->
    <link rel=stylesheet type="text/css" href="static/css/main.css"/>
    <!-- 使用jQuery-UI的样式来设置tab页 -->
    <link type="text/css" href="static/css/ui-lightness/jquery-ui-1.8.20.custom.css" rel="stylesheet" />
    <script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="static/js/jquery-ui.js"></script>
    <!-- header.js输出头部信息 -->
    <script type="text/javascript" src="static/js/header.js"></script>
    <script type="text/javascript">
        function showDetails(id){
            $("#detail_" + id).toggle();
        }
    </script>
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
            <div>
                <p style="text-align:left;">
                        <span id="shoppingcart_dd" >
                        当前位置&nbsp;&gt;&gt;&nbsp;我的订单
                        </span>
                </p>
                <h1 id="myorderName" ><font color="red">${session_user.username}</font>：您好,您当前共有个订单：</h1>
                <div  class="orderShow" >

                    <table >
                        <thead>
                        <tr class="order_disc" >
                            <th class="order_row1">订单号</th>
                            <th class="order_row2">图书名称</th>
                            <th class="order_row3">下单时间</th>
                            <th class="order_row4">数量</th>
                            <th class="order_row5">状态</th>
                            <th class="order_row6">总金额</th>
                        </tr>
                        </thead>
                        <tbody >
                            <c:forEach items="${orders}" var="order">
                                <tr class="order_info">
                                    <td class="order_row11">${order.order_id}</td>
                                    <td class="order_row11">${order.order_name}</td>
                                    <td class="order_row11">${order.order_time}</td>
                                    <td class="order_row11">${order.order_amount}</td>
                                    <td class="order_row11">${order.order_status}</td>
                                    <td class="order_row11">${order.order_price}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
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
