<%--
  Created by IntelliJ IDEA.
  User: Santi
  Date: 15/05/2021
  Time: 10:13 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
    <title>Info Edition</title>
</head>
<body>
<div>
    Edition Info:
    <br>
    <h6 id="infoEdition">
    </h6>
</div>
<table id="tableLibraries" class="table">
    <thead>
    <tr>
        <th>library Id</th>
        <th>Name</th>
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
                var xhrEdition=new XMLHttpRequest()
                var editionId;

                xhrEdition.open('GET', '${pageContext.request.contextPath}/InfoEditionServlet?id=<%=request.getParameter("editionId")%>');
                xhrEdition.send(null);
                xhrEdition.onreadystatechange=function (){
                    if(xhrEdition.readyState==4){
                        var edition = JSON.parse(xhrEdition.responseText);
                        editionId= edition.editionId;
                        console.log(edition);

                        var h6 = document.getElementById("infoEdition");
                        h6.innerHTML= "Description: " +edition["description"] +" Release Year: " +edition.releaseYear;


                        var library = JSON.parse(xhr.responseText);
                        var tableBody = document.getElementById("tableLibraries").getElementsByTagName("tbody")[0];

                        var h6 = document.getElementById("infoEdition");
                        h6.innerHTML= "Description: " +library["description"] +" Release Year: " +library.releaseYear;

                        console.log(library);

                        library.map(b => {
                            var newRow = tableBody.insertRow();

                            columns.map(c => {
                                var cell = newRow.insertCell();
                                var text = document.createTextNode(b[c]);
                                cell.appendChild(text);
                            });
                            if(actions.includes("linkLibrary")){
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./AddLibraryServlet?libraryId=' +b.libraryId + '&editionId=' +editionId + '&case=link' +'";');
                                var text = document.createTextNode('link Library');
                                action.appendChild(text);
                                cell.appendChild(action);
                            }
                            if(actions.includes("unlinkLibrary")){
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./AddLibraryServlet?libraryId=' +b.libraryId + '&editionId=' +editionId + '&case=unlink' +'";');
                                var text = document.createTextNode('unlink library');
                                action.appendChild(text);
                                cell.appendChild(action);
                            }
                        });
                    }
                }
            }
        }
    }
    xhr.open('GET', '${pageContext.request.contextPath}/list-libraries');
    xhr.send(null);

    makeTable('tableBooks', ['libraryId', 'name'], ["linkLibrary", "unlinkLibrary"]);
</script>

</body>
</html>
