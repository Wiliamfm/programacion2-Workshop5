<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
        <title>JSP Tutorial</title>
    </head>
    <body>

        <h1>Library Manager</h1>

        <button onclick="location.href='./form-library.jsp';">Create library</button>
        <button onclick="location.href='./form-author.jsp';">Create author</button>
        <button onclick="location.href='./form-customer.jsp';">Create customer</button>

        <h3>Libraries</h3>

        <table id="librariesTbl" class="table">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>

        <h3>Authors</h3>

        <table id="authorsTbl" class="table">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Country</th>
                <th># Books</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>

        <h3>Customers</h3>

        <table id="customersTbl" class="table">
            <thead>
            <tr>
                <th>email</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Gender</th>
                <th>Age</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>

        <script>

            function printTable(elementId, servlet, columns, actions = []) {

                var xhr = new XMLHttpRequest();
                xhr.onreadystatechange = function() {
                    if (xhr.readyState == 4) {
                        var data = JSON.parse(xhr.responseText);
                        console.log(typeof data);
                        console.log(data);

                        var tbodyRef = document.getElementById(elementId).getElementsByTagName('tbody')[0];

                        data.map(d => {

                            var newRow = tbodyRef.insertRow();

                            columns.map(c => {
                                var cell = newRow.insertCell();
                                var text = document.createTextNode(d[c]);
                                cell.appendChild(text);
                            });

                            if (actions.includes('create-book')) {
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./form-book.jsp?authorId=' + d['authorId'] + '";');
                                var text = document.createTextNode('Create book');
                                action.appendChild(text);
                                cell.appendChild(action);
                            }

                            if (actions.includes('delete-author')) {
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./delete-author?authorId=' + d['authorId'] + '";');
                                var text = document.createTextNode('Delete author');
                                action.appendChild(text);
                                cell.appendChild(action);
                            }

                            if (actions.includes('modify-author')) {
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./form-author-m.jsp?authorId=' + d['authorId'] + '";');
                                var text = document.createTextNode('Modify author');
                                action.appendChild(text);
                                cell.appendChild(action);
                            }

                            if (actions.includes('showInfo')) {
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./info-author.jsp?authorId=' + d['authorId'] + '";');
                                var text = document.createTextNode('Show Info');
                                action.appendChild(text);
                                cell.appendChild(action);
                            }

                            if (actions.includes('deleteLibrary')) {
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./DeleteLibraryServlet?libraryId=' + d['libraryId'] + '";');
                                var text = document.createTextNode('Delete Library');
                                action.appendChild(text);
                                cell.appendChild(action);
                            }

                            if (actions.includes('modifyLibrary')) {
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./form-library-m.jsp?libraryId=' + d['libraryId'] + '";');
                                var text = document.createTextNode('Modify Library');
                                action.appendChild(text);
                                cell.appendChild(action);
                            }

                            if (actions.includes('rent')) {
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./form-library-m.jsp?libraryId=' + d['libraryId'] + '";');
                                var text = document.createTextNode('Rent edition');
                                action.appendChild(text);
                                cell.appendChild(action);
                            }

                            if (actions.includes('modifyCustomer')) {
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./form-customer-m.jsp?id=' + d['email'] + '";');
                                var text = document.createTextNode('Modify Customer');
                                action.appendChild(text);
                                cell.appendChild(action);
                            }

                            if (actions.includes('deleteCustomer')) {
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./DeleteCustomerServlet?id=' + d['email'] + '";');
                                var text = document.createTextNode('Delete Customer');
                                action.appendChild(text);
                                cell.appendChild(action);
                            }

                        });

                    }
                }
                xhr.open('GET', '${pageContext.request.contextPath}/' + servlet, true);
                xhr.send(null);

            }

            // Printing libraries
            printTable(elementId = 'librariesTbl', servlet = 'list-libraries', columns = ['libraryId', 'name'], actions= ["deleteLibrary", "modifyLibrary"]);

            // Printing authors
            printTable(elementId = 'authorsTbl', servlet = 'list-authors', columns = ['authorId', 'name', 'country', 'numBooks'], actions = ['create-book', 'delete-author', 'modify-author', 'showInfo']);

            // Printing customers
            printTable(elementId = 'customersTbl', servlet = 'listCustomersServlet', columns = ['email', 'firstName', 'lastName', 'gender', 'age'], actions = ['rent', 'modifyCustomer', 'deleteCustomer']);

        </script>

    </body>
</html>