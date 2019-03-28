<%--
  Created by IntelliJ IDEA.
  User: PXY
  Date: 2019/3/11 0011
  Time: 下午 8:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/ssoLoginCheck_Domain/login" method="post">
        账号：<input name="username" type="text"><br>
        密码：<input name="password" type="password"><br>
        <input value="/ssoDemo01_Domain/demo.jsp" type="hidden" name="gotoUrl">
        <input type="submit" value="登录">
    </form>
</body>
</html>
