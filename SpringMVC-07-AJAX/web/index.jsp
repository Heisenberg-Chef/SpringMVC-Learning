<%--
  Created by IntelliJ IDEA.
  User: qilei
  Date: 2021/2/3
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>jQuery测试</title>
    <script src="${pageContext.request.contextPath}/static/jquery-3.5.1.js" type="text/javascript"></script>
    <script type="text/javascript">
      function a(){
        $.post({
            url:"${pageContext.request.contextPath}/a1",
            // 这里的键值对返回的就是我们Controller要接受的参数的名称,需要跟参数名字相同才可以接收到
            data:{"name":$("#username").val()},
            success:function (data){
              alert(data);
            }
      })}
    </script>
  </head>
  <body>
<%--  失去焦点的时候,发起一个请求到后台--%>
  用户名 : <input type="text" id="username" onblur="a()">
  </body>
</html>
