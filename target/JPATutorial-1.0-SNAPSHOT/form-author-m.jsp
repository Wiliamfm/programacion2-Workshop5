<%--
  Created by IntelliJ IDEA.
  User: Santi
  Date: 12/05/2021
  Time: 5:16 p. m.
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>JPA Tutorial</title>
</head>
<body>

<form action="./ModifyAuthorServlet">
  Author name: <input type="text" id="name" name="name">
  Author country: <input type="text" id="country" name="country">
  <input type="hidden" name="authorId" value="<%= request.getParameter("authorId")%>">
  <input type="submit" value="Modify author!">
</form>

</body>
</html>

