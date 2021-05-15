<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Modify Edition Form</title>
</head>
<body>

<form action="./ModifyEditionServlet">
    <input type="hidden" id="bookId" name="bookId" value ="<%= request.getParameter("bookId") %>">
    <input type="hidden" id="editionId" name="editionId" value ="<%= request.getParameter("editionId") %>">
    Edition Description: <input type="text" id="description" name="description">
    <br />
    <input type="submit" value="Modify Edition!">
</form>

</body>
</html>
