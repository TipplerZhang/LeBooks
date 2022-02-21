<%--
  Created by IntelliJ IDEA.
  User: zhangleyuan
  Date: 2022/2/21
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <!-- 左边物品类型列表 -->
            <div  id="booksort" style="float:left;width:210px;height: 600px;">
                <div class="mt" >
                    <h2><strong style="LINE-HEIGHT: 45px;">图书国家分类</strong></h2>
                </div>
                <div class="mc">

                    <div class="item"><h3><b>&gt;</b><a href="/fk_ec/index.action?typecode=0001">·中国</a></h3></div>

                    <div class="item"><h3><b>&gt;</b><a href="/fk_ec/index.action?typecode=0002">·美国</a></h3></div>

                    <div class="item"><h3><b>&gt;</b><a href="/fk_ec/index.action?typecode=0003">·法国</a></h3></div>

                    <div class="item"><h3><b>&gt;</b><a href="/fk_ec/index.action?typecode=0004">·英国</a></h3></div>

                    <div class="item"><h3><b>&gt;</b><a href="/fk_ec/index.action?typecode=0005">·日本</a></h3></div>

                    <div class="item"><h3><b>&gt;</b><a href="/fk_ec/index.action?typecode=0006">·荷兰</a></h3></div>

                    <div class="item"><h3><b>&gt;</b><a href="/fk_ec/index.action?typecode=0006">·德国</a></h3></div>

                    <div class="item"><h3><b>&gt;</b><a href="/fk_ec/index.action?typecode=0006">·印度</a></h3></div>

                    <div class="item"><h3><b>&gt;</b><a href="/fk_ec/index.action?typecode=0006">·意大利</a></h3></div>

                    <div class="item"><h3><b>&gt;</b><a href="/fk_ec/index.action?typecode=0006">·俄罗斯</a></h3></div>

                </div>
            </div>
            <!-- 右边物品明细显示 -->
            <div class="w main">
                <div class="right-extra">
                    <div id="name">
                        <h1>小王子</h1>
                    </div>
                    <div id="preview">
                        <div id="spec-n1" class="jqzoom">
                            <img src="images/article/20130331_1_1.jpg" title="小王子 " height="280" width="280" />
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
                        <li>供应商：<strong> Reynal & Hitchcock</strong></li>
                        <li>出产地：<strong> 法国</strong></li>
                    </ul>
                    <ul id="book-price">
                        <li>定&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价：<span>￥108.0</span></li>
                        <li class="sub">
                            <span class="fl">库&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;存：100</span>
                            <span>&nbsp;&nbsp;下单后立即发货</span>
                        </li>
                        <!--促销-->
                        <li style="display: list-item;" id="mfms" class="hide">
                            <table border="0" cellpadding="0" cellspacing="0">
                                <tbody>
                                <tr>
                                    <td valign="top">促销信息：</td>
                                    <td><font color="#ef0000">该商品参加满减活动，购买活动商品每满300元，可减100元现金</font></td>
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
                                <input id="reservation"	value="关&nbsp;注" type="submit" style="background: url(static/images/reservation.jpg) no-repeat 0 0;" οnclick="#" />
                            </div>
                        </div>
                    </form>

                </div>
                <!---- 下部图书简介显示 ----->
                <div id="right-bottom">
                    <p class="bookname">简介:</p>
                    <p class="introduction">一位先生回忆起自己小时候，在与大人交流中一直找不到一个能够阐述自己的价值观的人，因为大人们都太讲实际了。
                        先生长大后，成为一名飞行员，不过因飞机故障而迫降在撒哈拉沙漠，途中遇见小王子。 小王子告诉飞行员自己来自另一颗名为B612的星球，
                        而小王子也告诉他为什么离开自己的星球，在抵达地球之前，途中又到访了其他星球，他访问了国王、爱虚荣的人、酒鬼、商人、点灯人、
                        地理学家、蛇、三枚花瓣的沙漠花、玫瑰园、扳道工、商贩、狐狸以及这位飞行员。 飞行员和小王子在沙漠中共同拥有过一段极为珍贵的友谊。
                        当小王子要离开地球时，飞行员非常的悲伤。他一直非常怀念他们共度的时光。 此后，他为了纪念小王子所以写了这部小说。</p>
                </div>
                <!---- middle end----->
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
