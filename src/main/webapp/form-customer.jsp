<%--
  Created by IntelliJ IDEA.
  User: Santi
  Date: 15/05/2021
  Time: 12:44 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Customer form</title>
</head>
<body>

<form action="./CreateCustomerServlet">
  Client email: <input type="email" id="email" name="email">
  Client first name: <input type="text" id="fName" name="fName">
  Client last name: <input type="text" id="lName" name="lName">
  Client gender: <input type="text" id="gender" name="gender">
  Client age: <input type="text" id="age" name="age">
  <input type="submit" value="Create customer!">
</form>

</body>
</html>
