<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update pain</title>
    <!-- Add Bootstrap CSS link -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<%@ page import="Beans.pain" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="container mt-5">
    <h2>Update pain</h2>

    <c:if test="${painToEdit != null}">
        <form action="${contextPath}/GestionPains" method="post">
            <div class="mb-3">
                <label for="pain_trigger" class="form-label">pain_trigger:</label>
                <input type="text" class="form-control" id="pain_trigger" name="pain_trigger" value="${painToEdit.pain_trigger}" required>
            </div>

            <div class="mb-3">
                <label for="severity_pain" class="form-label">severity_pain:</label>
                <input type="text" class="form-control" id="severity_pain" name="severity_pain" value="${painToEdit.severity_pain}" required>
            </div>

            <div class="mb-3">
                <label for="other_symptom" class="form-label">other_symptom:</label>
                <input type="text" class="form-control" id="other_symptom" name="other_symptom" value="${painToEdit.other_symptom}" required>
            </div>

            <div class="mb-3">
                <label for="id_user" class="form-label">User ID:</label>
                <input type="text" class="form-control" id="id_user" name="id_user" value="${painToEdit.id_user}" required>
            </div>

            <!-- Add hidden input fields to indicate the action and pain ID -->
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="id_pain" value="${painToEdit.id_pain}">

            <button type="submit" class="btn btn-primary">Update pain</button>
        </form>
        <br>
        <a href="${contextPath}/GestionPains">Back to pain List</a>
    </c:if>
</div>

<!-- Add Bootstrap JS and Popper.js scripts (optional) -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>
