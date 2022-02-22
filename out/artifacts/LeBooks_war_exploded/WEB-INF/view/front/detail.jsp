<%--
  Created by IntelliJ IDEA.
  User: zhangleyuan
  Date: 2022/2/21
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>图书详情页</title>
    <link href="fkjava.ico" rel="shortcut icon" type="image/x-icon" />
    <!-- main.css是购物商城主样式 -->
    <link rel=stylesheet type="text/css" href="static/css/main.css"/>
    <!-- header.js输出头部信息 -->
    <script type="text/javascript" src="static/js/header.js"></script>
    <script type="text/javascript">
        // 加一减一事件处理函数
        var numFun = function(level){
            var buyNum = document.getElementById("buyNum");
            var num = buyNum.value;
            if (isNaN(num)){
                buyNum.value = 1;
                return;
            }
            num = parseInt(num);
            switch (level){
                case 1: // 减一
                    buyNum.value = (num <= 1) ? 1 : num - 1;
                    break;
                case 2: // 加一
                    buyNum.value = num + 1;
                    break;
            }
        };
        // 当你填写好购买数量，后失去焦点会调来这个函数
        var blurFn = function(){
            var buyNum = document.getElementById("buyNum");
            var num = buyNum.value;
            if (isNaN(num)){
                buyNum.value = 1;
                return;
            }
            buyNum.value = (num <= 1) ? 1 : num;
        };

        var buy = function(){
            document.getElementById("buyform").submit();
        };
    </script>
</head>
<body>
    <div id="container">
        <!-- header部分 -->
        <div id="shortcut">
            <script type="text/javascript">header("${session_user.name}");</script>
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
            <!-- 左边物品类型列表 -->
            <div  id="booksort" style="float:left;width:210px;height: 600px;">
                <div class="mt" >
                    <h2><strong style="LINE-HEIGHT: 45px;">图书国家分类</strong></h2>
                </div>
                <div class="mc">

                    <div class="item"><h3><b>&gt;</b><a href="index.action?book_birthplace=中国">·中国</a></h3></div>

                    <div class="item"><h3><b>&gt;</b><a href="index.action?book_birthplace=美国">·美国</a></h3></div>

                    <div class="item"><h3><b>&gt;</b><a href="index.action?book_birthplace=法国">·法国</a></h3></div>

                    <div class="item"><h3><b>&gt;</b><a href="index.action?book_birthplace=英国">·英国</a></h3></div>

                    <div class="item"><h3><b>&gt;</b><a href="index.action?book_birthplace=日本">·日本</a></h3></div>

                    <div class="item"><h3><b>&gt;</b><a href="index.action?book_birthplace=荷兰">·荷兰</a></h3></div>

                    <div class="item"><h3><b>&gt;</b><a href="index.action?book_birthplace=德国">·德国</a></h3></div>

                    <div class="item"><h3><b>&gt;</b><a href="index.action?book_birthplace=苏格兰">·苏格兰</a></h3></div>

                    <div class="item"><h3><b>&gt;</b><a href="index.action?book_birthplace=意大利">·意大利</a></h3></div>

                    <div class="item"><h3><b>&gt;</b><a href="index.action?book_birthplace=俄罗斯">·俄罗斯</a></h3></div>

                </div>
            </div>
            <!-- 右边物品明细显示 -->
            <div class="w main">
                <div class="right-extra">
                    <div id="name">
                        <h1>${article.book_name}</h1>
                    </div>
                    <div id="preview">
                        <div id="spec-n1" class="jqzoom">
                            <img src="static/images/article/${article.book_image}" title="article.book_name " height="280" width="280" />
                        </div>
                        <ul class="extra">
                            <li>
                                <span>评分：</span>
                                <div class="con" id="star10918727">
                                    <div style="float: left; margin: 2px 0 0 5px; width: 64px; height: 12px; background-image: url(static/images/icon_clubs.gif); background-repeat: no-repeat; overflow: hidden;"></div>

                                </div>
                            </li>
                            <li class="tuangou"><h1>该商品支持全国租赁</h1></li>
                        </ul>
                    </div>
                    <!--preview end-->
                    <ul id="summary">
                        <li>供应商：<strong>${article.book_press}</strong></li>
                        <li>出产地：<strong> ${article.book_birthplace}</strong></li>
                    </ul>
                    <ul id="book-price">
                        <li>定&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价：<span>￥${article.book_price}</span></li>
                        <li>月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;租：<span>￥<fmt:formatNumber value="${article.book_price*0.3}" pattern="0.00"></fmt:formatNumber></span></li>
                        <li class="sub">
                            <span class="fl">库&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;存：${article.book_reserve}</span>
                            <span>&nbsp;&nbsp;下单后立即发货</span>
                        </li>
                        <!--促销-->
                        <li style="display: list-item;" id="mfms" class="hide">
                            <table border="0" cellpadding="0" cellspacing="0">
                                <tbody>
                                <tr>
                                    <td valign="top">促销信息：</td>
                                    <td><font color="#ef0000">该商品参加限时活动，租赁图书每月只需原价3折，限时享受哦！</font></td>
                                </tr>
                                </tbody>
                            </table>
                        </li>
                    </ul>

                    <!-- 加入购物车表单 -->
                    <form action="buy.action" method="post" id="buyform">
                        <!-- 隐藏表单传递要购买的书籍id -->
                        <input type="hidden" name="id" value="1"/>
                        <div class="m" id="choose">
                            <dl class="amount">
                                <dt>我要预购：</dt>
                                <dd>
                                    <a class="reduce" onclick="numFun(1);" href="javascript:void(0);">-</a>
                                    <!-- 购买书的数量 -->
                                    <input value="1" id="buyNum" name="buyNum" onblur="blurFn();" type="text" />
                                    <a class="add" onclick="numFun(2);" href="javascript:void(0);">+</a>
                                </dd>

                            </dl>
                            <div class="btns">
                                <a id="InitCartUrl" href="javascript:void(0);" onclick="buy();" class="btn-append"
                                   style="background-image: url(static/images/btn_new.jpg)">添加到购物车</a>
                                <input id="reservation"	value="关&nbsp;注" type="submit" style="background: url(static/images/reservation.jpg) no-repeat 0 0;" οnclick="buy()" />
                            </div>
                        </div>
                    </form>

                </div>
                <!---- 下部图书简介显示 ----->
                <div id="right-bottom">
                    <p class="bookname">简介:</p>
                    <p class="introduction">${article.book_description}</p>
                </div>
                <!---- middle end----->
            </div>
        </div>
        <!---- middle end----->

        <!--bottom part-->
        <div  id="footer">
            <footer ><div >&copy; 2018-2022 <a href="index.action">LeBooks租赁平台</a></div></footer>
        </div>
    </div>
</body>
</html>
