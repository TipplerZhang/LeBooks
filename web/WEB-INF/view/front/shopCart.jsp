<%--
  Created by IntelliJ IDEA.
  User: zhangleyuan
  Date: 2022/2/25
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        var deleteShopCart = function (cart_id){
            if(window.confirm("是否确认删除")){
                window.location = "deleteShopCart.action?cart_id="+cart_id;
            }
        }
        // 进行全选操作
        var checkAll = function (obj){
            // 获取所有的子checkBox
            var boxes =document.getElementsByName("box");
            for(var i=0; i<boxes.length;i++){
                boxes[i].checked = obj.checked;
            }
            // 操作提交数量
            document.getElementById("orderNum").innerText = obj.checked ? boxes.length : 0;
            // 计算提交订单的总金额
            var totalPrice = 0.00;
            var prices = document.getElementsByName("price");
            for(var i=0; i<prices.length; i++){
                totalPrice += parseFloat(prices[i].innerText);
            }
            document.getElementById("totalMoney").innerHTML = obj.checked ? totalPrice : "0";
            document.getElementById("totalAmount").value = obj.checked ? totalPrice : "0";
            // 调用函数用于计算选中的图书名称、租赁数量、租赁价格
            getCheckArticleInfo();
        }

        var checkOne = function (obj,price){
            // 获取历史下单的数量
            var num = document.getElementById("orderNum").innerText;
            // 获取历史下单的总金额
            var totalPrice = document.getElementById("totalMoney").innerHTML;
            if (obj.checked){
                // 当前checkbox是选中状态
                document.getElementById("orderNum").innerText = parseInt(num)+1;
                document.getElementById("totalMoney").innerHTML = (parseFloat(totalPrice)+parseFloat(price)).toFixed(2);
                document.getElementById("totalAmount").value = (parseFloat(totalPrice)+parseFloat(price)).toFixed(2);
            }else{
                document.getElementById("orderNum").innerText = parseInt(num)-1;
                document.getElementById("totalMoney").innerHTML = (parseFloat(totalPrice)-parseFloat(price)).toFixed(2);
                document.getElementById("totalAmount").value = (parseFloat(totalPrice)-parseFloat(price)).toFixed(2);
            }
            // 调用函数用于计算选中的图书名称、租赁数量、租赁价格
            getCheckArticleInfo();
        }
        var getCheckArticleInfo = function (){
            var info = "";
            // 获取所有的子checkBox
            var boxes =document.getElementsByName("box");
            for(var i=0; i<boxes.length;i++){
               if (boxes[i].checked){
                   // 当前checkbox是选中的，则选中checkbox的value值
                   info = "#"+boxes[i].value+info;
               }
            }
            document.getElementById("articleInfo").value = info;
        }
        // 提交订单
        var Submit = function (){
            var len = 0;
            var boxes = document.getElementsByName("box");
            for(var i=0; i<boxes.length; i++){
                if(boxes[i].checked){
                    len++;
                }
            }
            if(len == 0){
                alert("请选择需要租赁的商品信息！")
            }else{
                // 提交表单
                document.getElementById("commit_order").submit();
            }

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
            <div class="shoppingcart_wrapper" id="shoppingcart">
                <p ><span id="shoppingcart_dd" >当前位置&nbsp;&gt;&gt;&nbsp;我的购物车 </span></p>
                <ul class="shoppingcart_subject" id="ui_shoppingcart_title">
                    <li class="row0">全选<input type="checkbox" id="checkAll" onclick="checkAll(this)"></li>
                    <li class="row1">图书ID</li>
                    <li class="row2">图书名称</li>
                    <li class="row3">数量</li>
                    <li class="row4"><span title="在疯狂价基础上再优惠">&nbsp;&nbsp;&nbsp;小计&nbsp;&nbsp;&nbsp;</span></li>
                    <li class="row5">操作</li>
                </ul>

                <!-- 购物车不为空 -->
                <table class="showingcart_list">

                    <c:forEach items="${carts}" var="cart">
                        <tr>
                            <td class="row00"><input type="checkbox" name="box" value="${cart.cart_id}" class="checkOne" onclick="checkOne(this,'${cart.cart_book_price}')"></td>
                            <td class="row11">${cart.cart_book_id}</td>
                            <td class="row22">${cart.cart_book_name}</td>
                            <td class="row33">${cart.cart_book_amount}</td>
                            <td class="row44" name="price">${cart.cart_book_price}</td>
                            <td class="row55"><button onclick="deleteShopCart(${cart.cart_id})">删除</button></td>
                        </tr>
                    </c:forEach>
                </table>
                <form action="saveOrder.action" method="get" id="commit_order" name="commit_order">
                    <!--存放商品总金额 -->
                    <input type="hidden" name="totalAmount" id="totalAmount">
                    <!-- 存放商品名称、租赁价格及租赁数量-->
                    <input type="hidden" name="articleInfo" id="articleInfo">
                    <div align="right">
                        总金额：<span id="totalMoney" style="color: red">0</span>元
                        <button id="submitOrder" type="button" onclick="Submit()">提交订单<span class="badge" id="orderNum">0</span></button>
                    </div>
                </form>
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
