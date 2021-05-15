<%--
  Created by IntelliJ IDEA.
  User: Santi
  Date: 15/05/2021
  Time: 10:03 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Modify Library</title>
</head>
<body>

<form action="./ModifyLibraryServlet">
  <input type="hidden" id="libraryId" name="libraryId" value="<%=request.getParameter("libraryId")%>">
  Library name: <input type="text" id="name" name="name">
  <input type="submit" value="Modify library!">
</form>

</body>
</html>
