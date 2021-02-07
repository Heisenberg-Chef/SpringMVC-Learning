<%--
  Created by IntelliJ IDEA.
  User: qilei
  Date: 2021/2/5
  Time: 4:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>上传文件</title>
  </head>
  <body>
  <h1>上传文件</h1>
  <form action="/upload" enctype="multipart/form-data" method="post">
    <input type="file" name="file">
    <input type="submit" name="upload">
  </form>
  <br>
  <h1>文件上传实例 - 菜鸟教程</h1>
  <form method="post" action="/UploadServlet" enctype="multipart/form-data">
    选择一个文件:
    <input type="file" name="uploadFile" />
    <br/><br/>
    <input type="submit" value="上传" />
  </form>
  <br/><br/>
  <br/><br/>
  <br/><br/>
  <br/><br/>
  ${message}
  </body>
</html>
