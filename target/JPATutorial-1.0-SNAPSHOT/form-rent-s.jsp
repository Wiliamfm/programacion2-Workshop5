<%--
  Created by IntelliJ IDEA.
  User: Santi
  Date: 15/05/2021
  Time: 7:48 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rent Date</title>
</head>
<body>
<form action="./ListRentsServlet">
    <input type="hidden" id="libraryId" name="libraryId" value="<%=request.getParameter("libraryId")%>">
    Enter rent date(year-month-day): <input type="text" id="date" name="date">
    <input type="submit" value="search rents!">
</form>
</body>
</html>
