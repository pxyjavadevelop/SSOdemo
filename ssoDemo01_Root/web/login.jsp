<%--
  Created by IntelliJ IDEA.
  User: PXY
  Date: 2019/3/13 0013
  Time: 下午 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="http://login.wkcto.com:8080/ssoLoginCheck_Root/login" method="post">
        user:<input type="text" name="username"><br>
        pass:<input type="password" name="password"><br>
        <input type="hidden" value="http://demo01.wkcto.com:8080/ssoDemo01_Root/demo.jsp" name="gotoUrl">
        <input type="submit" value="login">
    </form>
</body>
</html>
