<%-- 
    Document   : empsByDept
    Created on : Dec 25, 2020, 12:35:29 AM
    Author     : leila
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="style.css">
        <title>Employés</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="./Controller?action=Departements">Départements</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./Controller?action=Employes">Employés</a>
                    </li>
                </ul>
            </div>
        </nav>
        <h1 class="test">Liste des employés du département : ${NomDept}</h1>

        <table>
            <tr>
                <th scope="col">Code</th>
                <th scope="col">Nom</th>
                <th scope="col">Salaire</th>
                <th scope="col">Modifier</th>
                <th scope="col">Supprimer</th>
            </tr>
            <c:forEach items="${list}" var="emp">
                <tr>
                    <td>${emp.idEmp}</td>
                    <td>${emp.nom}</td>
                    <td>${emp.salaire}</td>
                    <td><a class="glyphicon glyphicon-edit" href="./Controller?action=editEmp&idEmp=${emp.idEmp}"/></td>
                    <td><a class="glyphicon glyphicon-trash" href="./Controller?action=deleteEmp&idEmp=${emp.idEmp}""/></td>
                </tr>
            </c:forEach>              
        </table>     
    </body>
</html>
