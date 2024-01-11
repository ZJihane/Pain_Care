<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>period Form</title>
</head>
<body>
 
 
<%@ page import="Beans.period" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<h2>Create period</h2>

<form action="${contextPath}/GestionPeriods" method="post">
    <label for="first_period">first period:</label>
    <input type="text" id="first_period" name="first_period" required><br>

    <label for="cycle_length">cycle length:</label>
    <input type="text" id="cycle_length" name="cycle_length" required><br>

    <label for="period_duration">period duration:</label>
    <input type="text" id="period_duration" name="period_duration" required><br>

    <label for="nature_period">nature period:</label>
    <input type="text" id="nature_period" name="nature_period" required><br>
    
    <label for="period_pattern">period pattern:</label>
    <input type="text" id="period_pattern" name="period_pattern" required><br>
    
    <label for="id_userr">User ID:</label>
    <input type="text" id="id_user" name="id_user" required><br>

    <!-- Add a hidden input field to indicate the action -->
    <input type="hidden" name="action" value="create">

    <input type="submit" value="Create period">
</form>

</body>
</html>
