<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update period</title>
    <!-- Add Bootstrap CSS link -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<%@ page import="Beans.period" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="conterioder mt-5">
    <h2>Update period</h2>

    <c:if test="${periodToEdit != null}">
        <form action="${contextPath}/GestionPeriods" method="post">
            <div class="mb-3">
                <label for="first_period" class="form-label">first period:</label>
                <input type="text" class="form-control" id="first_period" name="first_period" value="${periodToEdit.first_period}" required>
            </div>

            <div class="mb-3">
                <label for="cycle_length" class="form-label">cycle length:</label>
                <input type="text" class="form-control" id="cycle_length" name="cycle_length" value="${periodToEdit.cycle_length}" required>
            </div>

            <div class="mb-3">
                <label for="period_duration" class="form-label">period duration:</label>
                <input type="text" class="form-control" id="period_duration" name="period_duration" value="${periodToEdit.period_duration}" required>
            </div>
            
            <div class="mb-3">
                <label for="nature_period" class="form-label">nature period:</label>
                <input type="text" class="form-control" id="nature_period" name="nature_period" value="${periodToEdit.nature_period}" required>
            </div>
            
            <div class="mb-3">
                <label for="period_pattern" class="form-label">period pattern:</label>
                <input type="text" class="form-control" id="period_pattern" name="period_pattern" value="${periodToEdit.period_pattern}" required>
            </div>

            <div class="mb-3">
                <label for="id_user" class="form-label">User ID:</label>
                <input type="text" class="form-control" id="id_user" name="id_user" value="${periodToEdit.id_user}" required>
            </div>

            <!-- Add hidden input fields to indicate the action and period ID -->
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="id_period" value="${periodToEdit.id_period}">

            <button type="submit" class="btn btn-primary">Update period</button>
        </form>
        <br>
        <a href="${contextPath}/GestionPeriods">Back to period List</a>
    </c:if>
</div>

<!-- Add Bootstrap JS and Popper.js scripts (optional) -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>
