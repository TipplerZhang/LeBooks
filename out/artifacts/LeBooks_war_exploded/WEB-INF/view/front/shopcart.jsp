<%--
  Created by IntelliJ IDEA.
  User: zhangleyuan
  Date: 2022/2/25
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>租赁平台-购物车</title>
    <link href="fkjava.ico" rel="shortcut icon" type="image/x-icon" />
    <!-- main.css是购物商城主样式 -->
    <link rel=stylesheet type="text/css" href="static/css/main.css"/>
    <!-- header.js输出头部信息 -->
    <script type="text/javascript" src="static/js/header.js"></script>
    <script type="text/javascript">
        // 从购物车中删除物品
        var deleteFn = function(id){
            window.location.href = "deleteCar.action?id=" + id;
        };
        /** id: 物品的ID, num: 购买的数量 , type : 是加一还是减一*/
        var addFun = function(id, num, type){
            // 购买的数量
            var buyNum = parseInt(num);
            if (buyNum == 1 && type == 2){
                return;
            }
            switch (type){
                case 1: // 增加一个
                    window.location.href = "updateCar.action?id=" + id + "&buyNum=" + (buyNum+1);
                    break;
                case 2: // 减少一个
                    window.location.href = "updateCar.action?id=" + id + "&buyNum=" + (buyNum-1);
                    break;
            }
        };
        var blurFn = function(obj, id, num){
            if (isNaN(obj.value)){
                obj.value = num;
            }else if (obj.value < 1){
                obj.value = num;
            }else if (obj.value != num){
                window.location.href = "updateCar.action?id=" + id + "&buyNum=" + obj.value;
            }
        };
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
            <div class="shoppingcart_wrapper" id="shoppingcart">
                <p ><span id="shoppingcart_dd" >当前位置&nbsp;&gt;&gt;&nbsp;我的购物车 </span></p>
                <ul class="shoppingcart_subject" id="ui_shoppingcart_title">
                    <li class="row1">图书ID</li>
                    <li class="row2">图书名称</li>
                    <li class="row5">数量</li>
                    <li class="row4"><span title="在疯狂价基础上再优惠">&nbsp;&nbsp;&nbsp;小计&nbsp;&nbsp;&nbsp;</span></li>
                    <li class="row6">操作</li>
                </ul>

                <!-- 购物车不为空 -->

                <!-- 购物车为空的话 -->

                <table align="center">
                    <tr>
                        <td><img alt="" src="static/images/cart_icon.gif"/></td>
                        <td>
                                        <span style="font-size:14px;font-weight:bold;">
                                            购物车为空，<a href="index.action">我要去看看&gt;&gt;</a>
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
