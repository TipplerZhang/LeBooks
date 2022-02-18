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
    <p>

        <c:forEach items="${articles}" var="article">
            <tr>
                <td>${article.book_id}</td>
                <td>${article.book_name}article.book_name</td>
                <td>${article.book_price}article.book_price</td>
            </tr>
        </c:forEach>
    </p>
</body>
</html>
