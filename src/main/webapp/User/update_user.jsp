<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<%@ page import="Beans.user" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

    <div class="container mt-5">
        <h2>Update User</h2>
        <%
          user userToEdit = (user) request.getAttribute("userToEdit");
        %>
        <c:if test="${userToEdit != null}">
        
        <form action="${contextPath}/GestionUsers" method='post'>
           <input  class="form-control" name="id_user" id="id_user" value="${userToEdit.iduser}">
           
            <div class="mb-3">
                <label for="nom_user" class="form-label">Nom</label>
                <input type="text" class="form-control" id="nom_user" name="nom_user" value="${userToEdit.nomuser}" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" value="${userToEdit.email}" required>
            </div>
            
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" value="${userToEdit.password}" required>
            </div>
           
            
            <input type="hidden" class="form-control" name="role" id="role" value="${userToEdit.role}">
            
            <input type="hidden" name="action" value="update">
            
            <button type="submit" value="update" class="btn btn-primary">Update User</button>
        </form>
         </c:if>
        <br>
    <a href="${contextPath}/GestionUsers">Back to users List</a>
    </div>


    <!-- Bootstrap JS and Popper.js (for Bootstrap modal, popover, etc.) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
