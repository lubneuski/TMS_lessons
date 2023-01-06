<%@ page import="java.util.List" %>
<%@ page import="alex.lu.CarStorage" %>
<%@ page import="alex.lu.Cars" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="static alex.lu.CarStorage.getCars" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    if (request.getAttribute("cars")!=null) {
        Map<String, Cars> car = (Map<String, Cars>) request.getAttribute("cars");
        for (Map.Entry<String, Cars> entry : getCars().entrySet()) {
            out.println("Id: "+entry +"<br>");
        }
    }
%>

</body>
</html>