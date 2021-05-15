<%--
  Created by IntelliJ IDEA.
  User: Santi
  Date: 12/05/2021
  Time: 8:07 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
    <title>Info Author</title>
</head>
<body>
<div>
  Author Info:
  <br>
  <h6 id="authorInfo">

  </h6>
</div>
<table id="tableBooks" class="table">
  <thead>
  <tr>
    <th>Book Id</th>
    <th>Title</th>
    <th>ISBN</th>
    <th>Genre</th>
    <th>Actions</th>
  </tr>
  </thead>
  <tbody>

  </tbody>
</table>

<script>
  var xhr = new XMLHttpRequest();
  function makeTable(elementId, columns, actions){
      xhr.onreadystatechange = function (){
          if(xhr.readyState == 4){
              var author = JSON.parse(xhr.responseText);
              var tableBody = document.getElementById("tableBooks").getElementsByTagName("tbody")[0];

              var h6 = document.getElementById("authorInfo");
              h6.innerHTML= "Name: " +author.name +" Country: " +author.country

            console.log(author);
            console.log(author.books);

              author.books.map(b => {
                var newRow = tableBody.insertRow();

                columns.map(c => {
                  var cell = newRow.insertCell();
                  var text = document.createTextNode(b[c]);
                  cell.appendChild(text);
                });


                if(actions.includes("createEdition")){
                  var cell = newRow.insertCell();
                  var action = document.createElement('button');
                  action.setAttribute('onclick', 'location.href="./form-edition.jsp?bookId=' +b.bookId + '";');
                  var text = document.createTextNode('Create Edition');
                  action.appendChild(text);
                  cell.appendChild(action);
                }
                if(actions.includes("modifyBook")){
                  var cell = newRow.insertCell();
                  var action = document.createElement('button');
                  action.setAttribute('onclick', 'location.href="./form-book-m.jsp?authorId='+author.authorId +'&bookId=' +b.bookId + '";');
                  var text = document.createTextNode('Modify book');
                  action.appendChild(text);
                  cell.appendChild(action);
                }
                if(actions.includes("deleteBook")){
                  var cell = newRow.insertCell();
                  var action = document.createElement('button');
                  action.setAttribute('onclick', 'location.href="./DeleteBookServlet?authorId='+author.authorId +'&bookId=' +b.bookId + '";');
                  var text = document.createTextNode('Delete book');
                  action.appendChild(text);
                  cell.appendChild(action);
                }
                if(actions.includes("showEditions")){
                  var cell = newRow.insertCell();
                  var action = document.createElement('button');
                  action.setAttribute('onclick', 'location.href="./info-book.jsp?bookId=' +b.bookId + '";');
                  var text = document.createTextNode('Show Editions');
                  action.appendChild(text);
                  cell.appendChild(action);
                }
              });
          }
      }
  }
  xhr.open('GET', '${pageContext.request.contextPath}/InfoAuthorServlet?authorId='+<%out.print(request.getParameter("authorId"));%>);
  xhr.send(null);

  makeTable('tableBooks', ['bookId', 'title', 'isbn', 'genre'], ["createEdition", "modifyBook", "deleteBook", "showEditions"]);
</script>
</body>
</html>
