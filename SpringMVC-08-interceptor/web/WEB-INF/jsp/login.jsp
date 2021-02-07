<%--
  Created by IntelliJ IDEA.
  User: qilei
  Date: 2021/2/5
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆界面</title>
</head>
<%--web-inf下的所有页面都不能直接访问--%>
<body>
    <h1>登陆页面</h1>

    <form action="${pageContext.request.contextPath}/user/login" method="post">
        用户名：<input type="text" name="username"> <br>
        密码：<input type="password" name="pwd"> <br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
