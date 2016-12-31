<%--
  Created by IntelliJ IDEA.
  User: rantianhua
  Date: 16/12/25
  Time: 下午5:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>文件上传示例</h1>
<form action="upload" method="post" enctype="multipart/form-data">

    <input type="file" name="file">
    <br><br>
    <input type="submit" value="submit">

</form>

</body>
</html>
