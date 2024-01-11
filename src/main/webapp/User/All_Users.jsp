<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User List</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
    
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />

    <!-- Move the "Add" button to the left -->
    <h1>Gestion Utilisateurs</h1>
    
    <div style="float: left;">
        <form action="${contextPath}/GestionUsers?action=add" method="post">
            <button type="submit" class="btn btn-primary">Add</button>
        </form>
    </div>

    <!-- Center the table horizontally -->
    <div class="container mt-4">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Email</th>
                    <th>Role</th>
                    <th>Delete</th>
                    <th>Edit</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user" varStatus="boucle">
                    <tr>
                        <td>${user.iduser}</td>
                        <td>${user.nomuser}</td>
                        <td>${user.email}</td>
                        <td>${user.role}</td>

                        <td>
                            <form action="${contextPath}/GestionUsers?id_user=${user.iduser}&action=delete" method="post">
                                <button type="submit" class="btn btn-danger">Delete</button>
                            </form>
                        </td>
                        <td>
                            <form action="${contextPath}/GestionUsers?id_user=${user.iduser}&action=edit" method="post">
                                <button type="submit" class="btn btn-primary">Edit</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Add Bootstrap JS and Popper.js scripts (optional) -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
