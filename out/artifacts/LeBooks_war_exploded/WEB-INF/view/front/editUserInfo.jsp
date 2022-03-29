<%--
  Created by IntelliJ IDEA.
  User: zhangleyuan
  Date: 2022/3/20
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>租赁系统-用户个人页面</title>
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
        <div id="central" >
            <!-- 右边对应物品列表 -->
            <div style="float:left;width:1100px;text-align:center;margin-left: -60px;">

                <!-- 显示所有书籍 -->
                <div id="tabs" style="Width:1100px;background-color:white;">
                    <ul>
                        <li><a href="tabs-1">编辑个人信息</a></li>
                    </ul>
                    <div class="sales-queue" id="tabs-1" style="background-color:white;margin-top:-25px;">
                        <table width="550" align="center" style="font-size:14px;">
                            <tr align="left">
                                <td>编号：</td>
                                <td>${user.user_id}</td>
                            </tr>
                            <tr align="left">
                                <td>账号：</td>
                                <td><input type="text" name="user_account" size="50" value="${user.user_account}" ></td>
                            </tr>
                            <tr align="left">
                                <td>姓名：</td>
                                <td><input type="text" name="username" size="50" value="${user.username}" ></td>
                            </tr>
                            <tr align="left">
                                <td>性别：</td>
                                <td><input type="text" name="user_sex" size="50" value="${user.user_sex}" ></td>
                            </tr>
                            <tr align="left">
                                <td>出生日期：</td>
                                <td><input type="text" name="user_birth" size="50" value="${user.user_birth}"></td>
                            </tr>
                            <tr align="left">
                                <td>邮箱：</td>
                                <td><input type="text" name="user_email" size="50" value="${user.user_email}"></td>
                            </tr>
                            <tr align="left">
                                <td>手机号：</td>
                                <td><input type="text" name="user_phone" size="50" value="${user.user_phone}"></td>
                            </tr>
                            <tr align="left">
                                <td>地址：</td>
                                <td><input type="text" name="user_address" size="50" value="${user.user_address}"></td>
                            </tr>
                        </table>
                        <div>
                            <td><input type="submit" value="提交"/></td>
                            <td><input type="button" onclick="document.location='index.action'" value="返回"/></td>
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
