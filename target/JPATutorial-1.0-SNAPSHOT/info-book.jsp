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
    <title>Info Book</title>
</head>
<body>
<div>
    Book Info:
    <br>
    <h6 id="bookInfo">

    </h6>
</div>
<table id="tableEditions" class="table">
    <thead>
    <tr>
        <th>Edition Id</th>
        <th>Description</th>
        <th>Release Year</th>
        <th>Book Id</th>
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
                var book = JSON.parse(xhr.responseText);
                var tableBody = document.getElementById("tableEditions").getElementsByTagName("tbody")[0];

                var h6 = document.getElementById("bookInfo");
                h6.innerHTML= "Title: " +book.title +" isbn: " +book.isbn +" genre: " +book.genre

                console.log(book);
                console.log(book.editionPOJOList);

                book.editionPOJOList.map(b => {
                    var newRow = tableBody.insertRow();

                    columns.map(c => {
                        var cell = newRow.insertCell();
                        var text = document.createTextNode(b[c]);
                        cell.appendChild(text);
                    });
                    if(actions.includes("modifyEdition")){
                        var cell = newRow.insertCell();
                        var action = document.createElement('button');
                        action.setAttribute('onclick', 'location.href="./form-edition-m.jsp?bookId=' +b.bookId + '&editionId=' +b.editionId +  '";');
                        var text = document.createTextNode('Modify Edition');
                        action.appendChild(text);
                        cell.appendChild(action);
                    }
                    if(actions.includes("deleteEdition")){
                        var cell = newRow.insertCell();
                        var action = document.createElement('button');
                        action.setAttribute('onclick', 'location.href="./DeleteEditionServlet?bookId=' +b.bookId + '&editionId=' +b.editionId + '";');
                        var text = document.createTextNode('Delete Edition');
                        action.appendChild(text);
                        cell.appendChild(action);
                    }
                    if(actions.includes("showEditions")){
                        var cell = newRow.insertCell();
                        var action = document.createElement('button');
                        action.setAttribute('onclick', 'location.href="./InfoEditionServlet?bookId=' +b.bookId + '";');
                        var text = document.createTextNode('Show Editions');
                        action.appendChild(text);
                        cell.appendChild(action);
                    }
                });
            }
        }
    }
    xhr.open('GET', '${pageContext.request.contextPath}/InfoEditionServlet?bookId='+<%out.print(request.getParameter("bookId"));%>);
    xhr.send(null);

    makeTable('tableBooks', ['editionId', 'description', 'releaseYear', 'bookId'], ["modifyEdition", "deleteEdition", "showEditions"]);
</script>
</body>
</html>

