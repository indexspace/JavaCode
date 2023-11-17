<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>visit</title>
</head>
<body>
    <%
        Integer visit = (Integer) application.getAttribute("visit");
        if(visit == null) visit = new Integer(0);
        application.setAttribute("visit", ++visit);
    %>
    <h2>访问量: 你是第<%=visit%>位访问本网站的用户</h2>
</body>
</html>
