<%--
  Created by IntelliJ IDEA.
  User: Santi
  Date: 15/05/2021
  Time: 1:45 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Modify Customer form</title>
</head>
<body>

<form action="./ModifyCustomerServlet">
    Client first name: <input type="text" id="fName" name="fName">
    Client last name: <input type="text" id="lName" name="lName">
    Client gender: <input type="text" id="gender" name="gender">
    Client age: <input type="text" id="age" name="age">
    <input type="hidden" id="email" name="id" value="<%=request.getParameter("id")%>">
    <input type="submit" value="Modify customer!">
</form>

</body>
</html>
