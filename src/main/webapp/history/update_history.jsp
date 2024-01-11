<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update History</title>
    <!-- Add Bootstrap CSS link -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<%@ page import="Beans.history" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="container mt-5">
    <h2>Update History</h2>

    <c:if test="${historyToEdit != null}">
        <form action="${contextPath}/GestionHistory" method="post">
            <div class="mb-3">
                <label for="endo_history" class="form-label">Endo History:</label>
                <input type="text" class="form-control" id="endo_history" name="endo_history" value="${historyToEdit.endo_history}" required>
            </div>

            <div class="mb-3">
                <label for="birth" class="form-label">Birth:</label>
                <input type="text" class="form-control" id="birth" name="birth" value="${historyToEdit.birth}" required>
            </div>

            <div class="mb-3">
                <label for="pregnancy_troubles" class="form-label">Pregnancy Troubles:</label>
                <input type="text" class="form-control" id="pregnancy_troubles" name="pregnancy_troubles" value="${historyToEdit.trouble_pregnant}" required>
            </div>

            <div class="mb-3">
                <label for="id_user" class="form-label">User ID:</label>
                <input type="text" class="form-control" id="id_user" name="id_user" value="${historyToEdit.id_user}" required>
            </div>

            <div class="mb-3">
                <label for="sexual_abuse" class="form-label">Sexual Abuse:</label>
                <input type="text" class="form-control" id="sexual_abuse" name="sexual_abuse" value="${historyToEdit.sexual_abuse}" required>
            </div>

            <!-- Add hidden input fields to indicate the action and history ID -->
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="id_history" value="${historyToEdit.id_history}">

            <button type="submit" class="btn btn-primary">Update History</button>
        </form>
        <br>
        <a href="${contextPath}/GestionHistory">Back to History List</a>
    </c:if>
</div>

<!-- Add Bootstrap JS and Popper.js scripts (optional) -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>
