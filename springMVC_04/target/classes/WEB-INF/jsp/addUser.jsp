<%--
  Created by IntelliJ IDEA.
  User: 28388
  Date: 2023/4/24
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<form action="/HelloHandler/add04" method="post">
  <table>
    <tr>
      <td>编号:</td>
      <td>
          <input type="text" name="ID">
      </td>
    </tr>
    <tr>
      <td>姓名:</td>
      <td>
          <input type="text" name="name">
      </td>
    </tr>
    <tr>
      <td>地址编码:</td>
      <td>
        <input type="text" name="address.code">
      </td>
    </tr>
    <tr>
      <td>详细地址:</td>
      <td>
        <input type="text" name="address.value">
      </td>
    </tr>
    <tr>
      <td>
        <input type="submit" value="提交">
      </td>
    </tr>
  </table>
</form>
</body>
</html>
