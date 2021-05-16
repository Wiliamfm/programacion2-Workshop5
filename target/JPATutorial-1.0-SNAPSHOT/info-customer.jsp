<%--
  Created by IntelliJ IDEA.
  User: Santi
  Date: 15/05/2021
  Time: 3:38 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
  <title>Info Customer</title>
</head>
<body>
<div>
  Customer Info:
  <br>
  <h6 id="infoCustomer">
  </h6>
</div>
<div>
  <form id="form" >
    <input type="hidden" id="customerId" name="customerId" value="<%=request.getParameter("customerId")+"\";"%>">
    Enter rent date(year-month-day): <input type="text" id="date" name="date">
    <input type="submit" value="search rents!">
  </form>
</div>
<table id="tableRents" class="table">
  <thead>
  <tr>
    <th>Rent Id</th>
    <th>Renting date</th>
    <th>Email</th>
    <th>Edition Id</th>
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
        console.log(xhr);
        var rents = JSON.parse(xhr.responseText);
        var tableBody = document.getElementById("tableRents").getElementsByTagName("tbody")[0];

        var h6 = document.getElementById("infoCustomer");
        //h6.innerHTML= "Name: " +author.name +" Country: " +author.country

        console.log(rents);

        rents.map(b => {
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
        });
      }
    }
  }

  xhr.open('GET', '${pageContext.request.contextPath}/ListRentsServlet?customerId=<%=request.getParameter("customerId")%>&date=<%=request.getParameter("date")%>');
  xhr.send(null);

  makeTable('tableBooks', ['id', 'email', 'editionId', 'rentingDate'], []);
</script>

</body>
</html>
