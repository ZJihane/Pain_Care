<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>History List</title>
    <!-- Add Bootstrap CSS link -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>

<body>
   <c:set var="contextPath" value="${pageContext.request.contextPath}" />
   <h1>Gestion Histories</h1>
        
        <div class="float-left">
            <form action="${contextPath}/GestionHistory?action=add" method="post">
                <button type="submit" class="btn btn-success">Add</button>
            </form>
        </div>

<div>
    
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                <th>Endo History</th>
                <th>Birth</th>
                <th>Pregnancy Troubles</th>
                <th>User ID</th>
                <th>Sexual Abuse</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${all_history}" var="history">
                <tr>
                    <td>${history.id_history}</td>
                    <td>${history.endo_history}</td>
                    <td>${history.birth}</td>
                    <td>${history.trouble_pregnant}</td>
                    <td>${history.id_user}</td>
                    <td>${history.sexual_abuse}</td>
                    <td>
                        <form action="${contextPath}/GestionHistory" method="post">
                            <input type="hidden" name="action" value="edit">
                            <input type="hidden" name="id_history" value="${history.id_history}">
                            <button type="submit" class="btn btn-primary">Edit</button>
                        </form>
                    </td>
                    <td>
                        <form action="${contextPath}/GestionHistory" method="post">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="id_history" value="${history.id_history}">
                            <button type="submit" class="btn btn-danger">Delete</button>
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
