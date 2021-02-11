<%-- 
    Document   : add_dept
    Created on : Dec 25, 2020, 2:14:23 AM
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
        <title>Départements</title>
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
        <h1 class="test">Ajouter un département</h1>
        <form action="./Controller?action=saveDept" method="POST">
            <table>
                <tr>
                    <th>Code:</th>
                    <td><input type="text" name="idDept" /></td>
                </tr>
                <tr>
                    <th>Nom:</th>
                    <td><input type="text" name="nom" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Ajouter"/>
                        <a href="./Controller?action=Departements"><input type="button" value="Revenir"/></a>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
