<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Edition Form</title>
</head>
<body>

<form action="./CreateEditionServlet">
  <input type="hidden" id="bookId" name="bookId" value ="<%= request.getParameter("bookId") %>">
  Edition Description: <input type="text" id="description" name="description">
  <br />
  <input type="submit" value="Create Edition!">
</form>

</body>
</html>
