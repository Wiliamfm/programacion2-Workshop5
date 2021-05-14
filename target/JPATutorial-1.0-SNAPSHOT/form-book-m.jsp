<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Modify Book</title>
</head>
<body>

<form action="./ModifyBookServlet">
  Book title: <input type="text" id="title" name="title">
  <br />
  Book ISBN: <input type="text" id="isbn" name="isbn">
  <br />
  Book genre: <input type="text" id="genre" name="genre">
  <br />
  <input type="hidden" id="authorId" name="authorId" value="<%=request.getParameter("authorId")%>">
  <input type="hidden" id="bookId" name="bookId" value="<%=request.getParameter("bookId")%>">

  <input type="submit" value="Modify book!">
</form>

</body>
</html>
