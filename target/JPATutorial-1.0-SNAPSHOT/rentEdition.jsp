<%--
  Created by IntelliJ IDEA.
  User: Santi
  Date: 15/05/2021
  Time: 3:16 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rent Edition</title>
</head>
<body>
<form action="./RentEditionServlet">
  Customer email: <input type="email" id="email" name="email">
  <input type="hidden" id="editionId" name="editionId" value="<%=request.getParameter("editionId")%>">
  <input type="submit" value="Rent edition!">
</form>
</body>
</html>
