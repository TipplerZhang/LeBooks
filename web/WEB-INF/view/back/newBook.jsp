<%--
  Created by IntelliJ IDEA.
  User: zhangleyuan
  Date: 2022/3/19
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>租赁系统-图书添加页面</title>
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
        function submitFn(){
            document.getElementById("newBookInfo").submit();
        }
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
                        <li><a href="tabs-1">图书添加</a></li>
                        <div id="newBook"><a href="newBook.action?flag=true">increase</a></div>
                    </ul>
                    <div class="sales-queue" id="tabs-1" style="background-color:white;margin-top:-25px;">
                        <form name="newBookInfo" id="newBookInfo" action="newBook.action?flag=false" method="get" enctype="multipart/form-data">
                            <table width="450" align="center" style="font-size:14px;">
                                <tr align="left">
                                    <td>名称：</td>
                                    <td><input type="text" name="book_name" size="50" value="" ></td>
                                </tr>
                                <tr align="left">
                                    <td>价格：</td>
                                    <td><input type="text" name="book_price" size="50" value=""></td>
                                </tr>
                                <tr align="left">
                                    <td>作者：</td>
                                    <td><input type="text"name="book_author" size="50" value=""></td>
                                </tr>
                                <tr align="left">
                                    <td>类型：</td>
                                    <td><input type="text" name="book_type" size="50" value=""></td>
                                </tr>
                                <tr align="left">
                                    <td>库存：</td>
                                    <td><input type="text" name="book_reserve" size="50" value=""></td>
                                </tr>
                                <tr align="left">
                                    <td>出版社：</td>
                                    <td><input type="text" name="book_press"  size="50" value=""></td>
                                </tr>
                                <tr align="left">
                                    <td>出版地：</td>
                                    <td><input type="text" name="book_birthplace"  size="50" value=""></td>
                                </tr>
                                <tr align="left">
                                    <td>图书封面：</td>
                                    <td><input type="file" name="book_image" size="40" value=""></td>
                                </tr>
                                <tr align="left">
                                    <td>书面描述：</td>
                                    <td>
                                        <textarea rows="5" cols="40" name="book_description" ></textarea>
                                    </td>
                                </tr>
                            </table>
                            <div>
                                <td><input onclick="submitFn();" type="button" value="提交"/></td>
                                <td><input type="button" onclick="document.location='bookManage.action'" value="返回"/></td>
                            </div>
                        </form>
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
