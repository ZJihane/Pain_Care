<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>History Form</title>
</head>
<body>
 
<%@ page import="Beans.history" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<h2>Create History</h2>

<form action="${contextPath}/GestionHistory" method="post">
    <label for="endo_history">Endo History:</label>
    <input type="text" id="endo_history" name="endo_history" required><br>

    <label for="birth">Birth:</label>
    <input type="text" id="birth" name="birth" required><br>

    <label for="pregnancy_troubles">Pregnancy Troubles:</label>
    <input type="text" id="pregnancy_troubles" name="pregnancy_troubles" required><br>

    <label for="id_user">User ID:</label>
    <input type="text" id="id_user" name="id_user" required><br>

    <label for="sexual_abuse">Sexual Abuse:</label>
    <input type="text" id="sexual_abuse" name="sexual_abuse" required><br>

    <!-- Add a hidden input field to indicate the action -->
    <input type="hidden" name="action" value="create">

    <input type="submit" value="Create History">
</form>

</body>
</html>
