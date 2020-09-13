<%--
  Created by IntelliJ IDEA.
  User: 曾振宇
  Date: 2020/6/17
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
    <form action="login" method="post">
        <label>用户名: <input type="text" name="username"></label>
        <label>密码: <input type="text" name="password"></label>
        <label>记住我:<input type="checkbox" name="rememberMe" value="1"></label>

        <input type="submit" value="登陆">
    </form>
<%--    ${pageContext.request.contextPath}/--%>
    </body>
</html>
