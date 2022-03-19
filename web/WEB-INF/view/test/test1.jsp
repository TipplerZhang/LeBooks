<%--
  Created by IntelliJ IDEA.
  User: zhangleyuan
  Date: 2022/2/18
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="editBookform" action="editBook.action"
      method="post" enctype="multipart/form-data">
    <table width="450" align="center" style="font-size:14px;">
        <tr align="left">
            <td>图书编号：</td>
            <td>${article.book_id}</td>
        </tr>
        <tr align="left">
            <td>名称：</td>
            <td><input type=text name="book_name" size="50" value="${article.book_name}"></td>
        </tr>
        <tr align="left">
            <td>价格：</td>
            <td><input type=text name="book_price" size="50" value="${article.book_price}"></td>
        </tr>
        <tr align="left">
            <td>作者：</td>
            <td><input type=text name="book_author" size="50" value="${article.book_author}"></td>
        </tr>
        <tr align="left">
            <td>类型：</td>
            <td><input type=text name="book_type" size="50" value="${article.book_type}"></td>
        </tr>
        <tr align="left">
            <td>库存：</td>
            <td><input type=text name="book_reserve" size="50" value="${article.book_reserve}"></td>
        </tr>
        <tr align="left">
            <td>出版社：</td>
            <td><input type=text name="book_press"  size="50" value="${article.book_press}"></td>
        </tr>
        <tr align="left">
            <td>出版地：</td>
            <td><input type=text name="book_birthplace"  size="50" value="${article.book_birthplace}"></td>
        </tr>
        <tr align="left">
            <td>图书封面：</td>
            <td><input type="file" name="book_image" size="40" value="${article.book_image}"></td>
        </tr>
        <tr align="left">
            <td>书面描述：</td>
            <td>
                <textarea rows="5" cols="40" name="book_description" value="${article.book_description}"></textarea>
            </td>
        </tr>
    </table>
    <table>
        <tr>
            <td><input type="submit" value="提交"/></td>
            <td><input type="button" onclick="document.location='bookManager.action'" value="返回"/></td>
        </tr>
    </table>
</form>
</body>
</html>
