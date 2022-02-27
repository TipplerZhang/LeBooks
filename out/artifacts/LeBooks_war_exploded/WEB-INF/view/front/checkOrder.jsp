<%--
  Created by IntelliJ IDEA.
  User: zhangleyuan
  Date: 2022/2/27
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>租赁平台-确定订单</title>
    <link href="fkjava.ico" rel="shortcut icon" type="image/x-icon" />
    <!-- main.css是购物商城主样式 -->
    <link rel=stylesheet type="text/css" href="static/css/main.css"/>
    <!-- header.js输出头部信息 -->
    <script type="text/javascript" src="static/js/header.js"></script>
    <script type="text/javascript">
        function submitFn(){
            document.getElementById("orderform").submit();
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

    <!--header end-->
    <div class="Wrap_cart">
        <div class="List_cart marginb10">
            <h2><strong>填写核对订单信息</strong></h2>
            <div class="cart_table">
                <!--收货人地址开始-->
                <div id="part_consignee">
                    <div class="o_write">
                        <h1>收货人信息&nbsp;
                            <span style="display: none"><a href="javascript:void(0);" style="color: rgb(255, 102, 0);">[创建一个新地址]</a></span>
                        </h1>
                        <div class="middle">
                            <div id="consignee_addr">
                                <table border="0" cellspacing="0" width="100%">
                                    <tbody>
                                    <tr>
                                        <td align="right" valign="middle" width="85">
                                            <font color="red">*</font>姓名：</td>
                                        <td align="left" valign="middle"><input
                                                id="consignee_addressName" class="txt" maxlength="20"
                                                type="text" value="${session_user.username}">&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td align="right" valign="middle"><font color="red">*</font>地址：</td>
                                        <td align="left" valign="middle"><span
                                                id="consigneeShow_addressName"></span>
                                            <input id="consignee_address" class="txt" maxlength="50"
                                                   type="text" value="${session_user.user_address}"
                                                   style="margin-left: 2px; width: 327px;">&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="right" valign="middle"><font color="red">*</font>电话号：</td>
                                        <td align="left" valign="middle"><input
                                                id="consignee_message" class="txt" type="text" value="${session_user.user_phone}">
                                            &nbsp; &nbsp;<font color="#000000">用于接收发货通知短信及送货前确认</font>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="right" valign="middle">电子邮件：</td>
                                        <td align="left" valign="middle"><input
                                                id="consignee_email" class="txt" type="text" value="${session_user.user_email}"> &nbsp;
                                            <font color="#000000">用来接收订单提醒邮件，便于您及时了解订单状态</font></td>
                                    </tr>

                                    </tbody>
                                </table>
                            </div>
                        </div>

                        <div class="footer">
                            <input class="btn" value="确认" type="button">
                        </div>
                    </div>
                </div>
                <!--收货人地址结束,支付方式及配送方式开始-->
                <div id="part_payTypeAndShipType">
                    <div class="o_show">
                        <h1>支付及配送方式&nbsp;</h1>
                        <div id="updateInfo_payType"></div>
                        <div class="middle">
                            <table style="width: 100%;">
                                <tbody>
                                <tr>
                                    <td style="text-align: right; width: 80px;">支付方式：</td>
                                    <td>在线支付</td>
                                </tr>
                                <tr style="">
                                    <td style="text-align: right;">配送方式：</td>
                                    <td>快递运输</td>
                                </tr>
                                <tr style="">
                                    <td style="text-align: right;">运 费：</td>
                                    <td>0.00元<span style="color: red">(免运费)</span></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="footer"></div>
                    </div>
                </div>
                <!--支付方式及配送方式结束-->
                <!--Cart信息开始-->
                <div id="part_cart">
                    <div class="o_show">
                        <h1>
                            <span style="margin-right: 700px;">商品清单</span>
                            <a href="showCar.action" style="color: rgb(0, 112, 215);">返回修改购物车</a>
                        </h1>
                        <div class="middle">
                            <table class="Table" cellpadding="3" cellspacing="0" width="100%">
                                <tbody>
                                <tr class="align_Center Thead">
                                    <td>商品id</td>
                                    <td width="10%">图书名称</td>
                                    <td width="8%">数量</td>
                                    <td width="8%">小计(元)</td>
                                    <td width="9%">操作</td>
                                </tr>
                                <!-- 迭代购物车中的书 -->


                                <c:forEach items="${carts}" var="cart">
                                    <tr class="align_Center_Order">
                                        <td class="align_Left" width="15%">${cart.cart_book_id} </td>
                                        <td width="35%"><span class="price">${cart.cart_book_name}</span></td>
                                        <td width="15%">${cart.cart_book_amount}</td>
                                        <td width="20%">${cart.cart_book_price}</td>
                                        <td width="15%"><button onclick="deleteShopCart(${cart.cart_id})">删除</button></td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>
                        <div class="footer"></div>
                    </div>
                </div>
                <!--Cart信息结束-->
                <div id="ware_info">
                    <div style="background: #fff; font-size: 14px; font-weight: bold; padding-left: 2px;">结算信息</div>
                    <h1></h1>
                    <div class="middle">
                        <!--订单信息-->
                        <ul id="part_info">
                            <li class="info1" style="padding-bottom: 5px">商品金额：${orderMoney} +
                                运费：0.00元 - 优惠券：<span id="price_coupon">0.00</span>元 - 礼品卡： <span
                                        id="price_coupon">0.00</span>元 - 返现：0.00元 <input
                                        id="txtIsUseMoney" value="0" type="hidden"> <br>
                            </li>
                            <li class="info2" style="width: 100%; overflow: hidden;">
                                <table style="width: 100%;" cellpadding="0" cellspacing="0">
                                    <tbody>
                                    <tr>
                                        <td></td>
                                        <td style="text-align: right; font-size: 15px;"><b>应付总额：<font
                                                color="red">${orderMoney}</font> 元
                                        </b>
                                            <div id="paypassword_panel"></div></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </li>
                        </ul>
                    </div>
                </div>
                <!--提交-->
                <div class="o_show submit">
                    <div id="submit_btn">
                        <table cellpadding="0" cellspacing="0" width="100%">
                            <tbody>
                            <tr>
                                <td style="padding: 0pt; text-align: left; vertical-align: top;">
                                    <div style="width: 600px; padding-left: 10px;" id="part_remark">
                                        <font id="showForm_remark"> </font>
                                    </div>
                                </td>
                                <td style="width: 100px; padding: 0pt;">
                                    <!-- 确定订单 -->
                                    <form action="saveOrder.action" method="post" id="orderform">
                                        <input type="hidden" name="countMoney" value="41.76"/>
                                        <input onclick="submitFn();" style="margin-top: 2px; border: medium none; cursor: pointer; width: 160px; height: 53px; background: url(static/images/submit.jpg) repeat scroll 0% 0% transparent;" type="button"/>
                                    </form>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <!--提交结束-->
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
