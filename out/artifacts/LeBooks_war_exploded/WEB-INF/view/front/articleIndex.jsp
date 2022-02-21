<%--
  Created by IntelliJ IDEA.
  User: zhangleyuan
  Date: 2022/2/14
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>租赁系统-商品页面</title>
    <link href="fkjava.ico" rel="shortcut icon" type="image/x-icon" />
    <!-- main.css是购物商城主样式 -->
    <link rel=stylesheet type="text/css" href="static/css/main.css"/>
    <!-- 使用jQuery-UI的样式来设置tab页 -->
    <link type="text/css" href="static/css/ui-lightness/jquery-ui-1.8.20.custom.css" rel="stylesheet" />
    <script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="static/js/jquery-ui.js"></script>
    <script type="text/javascript" src="static/js/pager.js"></script>
    <!-- header.js输出头部信息 -->
    <script type="text/javascript" src="static/js/header.js"></script>
    <script type="text/javascript">
        if (window.location != parent.window.location){
            parent.window.location = window.location;
        }

        window.onload = function(){
            /** tabs标签页 */
            $('#tabs').tabs();
            /** 分页标签 */
            fkjava.pager("pager", { pageIndex : "1",
                pageSize : "8",
                pageCount : "32",
                submitUrl : '/fk_ec/index.action?pageIndex={0}&typecode=0001&keyword='});

            /** 获取所有的li为特定的li绑定事件 */
            var arrays = document.getElementsByTagName("li");
            for (var i = 0; i < arrays.length; i++){
                if (arrays[i].id != "" && arrays[i].id.indexOf('selbgc1') == 0){
                    arrays[i].onmouseover = function(){
                        this.className = "selbgc1";
                    };
                    arrays[i].onmouseout = function(){
                        this.className = "";
                    };
                }
            }
            /** 设置选的下拉列表选项 */
            var select = document.getElementById("typecode");
            for (var i = 0; i < select.options.length; i++){
                var typecode = "0001";
                if (select.options[i].value == typecode){
                    select.options[i].selected = true;
                }
            }
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
    <div id="central" >
        <!-- 左边物品类型列表 -->
        <div  id="booksort" style="float:left;width:210px;">
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

        <!---- middle end----->
        <!-- 右边对应物品列表 -->
        <div style="float:left;width:750px;text-align:center;">
            <div>
                <form action="index.action" method="get" name="search" >
                    图书查询：
                    <select name="select_type" id="typecode">
                        <option value="book_name">图书名称</option>
                        <option value="book_author">图书作者</option>
                    </select>
                    <input name="keyword" type="text" value="${keyword}" size="50"/>
                    <button type="submit">搜索</button>
                </form>
            </div>
            <!-- 显示所有书籍 -->
            <div id="tabs" style="Width:750px;background-color:white;">
                <ul>
                    <li><a href="tabs-1">全部</a></li>
                </ul>
                <div class="sales-queue" id="tabs-1" style="background-color:white;margin-top:-25px;">
                    <ul class="goods-queue3">
                        <c:forEach items="${articles}" var="article">
                            <li class="selbgc11">
                                <dl class="item-des">
                                    <dt><a href="detail.action?book_id=${article.book_id}" title="${article.book_name}" target="_self"><img src="static/images/article/${article.book_image}" width="100" height="140" /></a></dt>
                                    <dd><s>¥: ${article.book_price}</s><strong>¥: 10.00</strong></dd>
                                    <dd><h2><a href="item.action?book_id=${article.book_id}" title="${article.book_name}" target="_self">${article.book_name}</a></h2></dd>
                                </dl>
                            </li>
                        </c:forEach>

                    </ul>

                    <!-- 分页标签 -->
                    <div class="pagebottom" id="pager" style="clear:both;"></div>
                </div>
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