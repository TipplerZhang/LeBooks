<%--
  Created by IntelliJ IDEA.
  User: zhangleyuan
  Date: 2022/3/19
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>租赁系统-订单管理页面</title>
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
    <script type="text/javascript">
        if (window.location != parent.window.location){
            parent.window.location = window.location;
        }

        window.onload = function(){
            /** tabs标签页 */
            $('#tabs').tabs();
            /** 分页标签 */
            fkjava.pager("pager", { pageIndex : "${pagerModel.pageIndex}",
                pageSize : "${pagerModel.pageSize}",
                pageCount : "${pagerModel.totalNum}",
                submitUrl : 'orderManage.action?pageIndex={0}'});

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
            <script type="text/javascript">header("${session_admin.admin_name}");</script>
            <div class="adminNav">
                <div class="w960 center">
                    <ul>

                        <li class="list"><a title="用户" href="userManage.action?manage_type=tab_user">用户管理</a></li>

                        <li class="list"><a title="图书" href="bookManage.action?manage_type=tab_books">图书管理</a></li>

                        <li class="list"><a title="订单" href="orderManage.action?manage_type=tab_order">订单管理</a></li>

                        <li class="list"><a title="管理员" href="adminManage.action?manage_type=tab_admin">管理员管理</a></li>

                    </ul>
                </div>
            </div>
        </div>
        <!--header end-->
        <div id="central" >
            <!-- 右边对应物品列表 -->
            <div style="float:left;width:1100px;text-align:center;margin-left: -60px;">

                <!-- 显示所有书籍 -->
                <div id="tabs" style="Width:1100px;background-color:white;">
                    <ul>
                        <li><a href="tabs-1">订单管理</a></li>
                        <li style="margin-left: 250px;">
                            <form action="orderManage.action" method="get" name="search">
                                订单查询：
                                <select name="select_type" id="typecode" style="height: 23px;">
                                    <option value="order_id">订单编号</option>
                                    <option value="order_status">订单状态</option>
                                </select>
                                <input name="keyword" type="text" value="${keyword}" size="30" style="height: 23px;"/>
                                <button type="submit">搜索</button>
                            </form>
                        </li>
                    </ul>

                    <div class="sales-queue" id="tabs-1" style="background-color:white;margin-top:-25px;">
                        <div  class="userShow" >

                            <table >
                                <thead>
                                <tr class="user_disc" >
                                    <th class="user_row1">订单号</th>
                                    <th class="user_row2">订单名称</th>
                                    <th class="user_row3">下单时间</th>
                                    <th class="user_row4">收款人ID</th>
                                    <th class="user_row5">数量</th>
                                    <th class="user_row6">总金额</th>
                                    <th class="user_row7">收款地址</th>
                                    <th class="user_row8">状态</th>
                                </tr>
                                </thead>
                                <tbody >
                                <c:forEach items="${orders}" var="order">
                                    <tr class="user_info">
                                        <td class="user_row11">${order.order_id}</td>
                                        <td class="user_row11">${order.order_name}</td>
                                        <td class="user_row11">${order.order_time}</td>
                                        <td class="user_row11">${order.order_receiver_id}</td>
                                        <td class="user_row11">${order.order_amount}</td>
                                        <td class="user_row11">${order.order_price}</td>
                                        <td class="user_row11">${order.order_address}</td>
                                        <td class="user_row11">${order.order_status}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <!-- 分页标签 -->
                            <div class="pagebottom" id="pager" style="clear:both;"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--bottom part-->
        <div  id="footer" style="">
            <footer ><div >&copy; 2018-2022 <a href="/">LeBooks租赁平台</a></div></footer>
        </div>
        <!--bottom end-->
    </div>
</body>
</html>
