<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>pain Form</title>
</head>
<body>
 
 
<%@ page import="Beans.pain" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<h2>Create pain</h2>

<form action="${contextPath}/GestionPains" method="post">
    <label for="pain_trigger">pain_trigger:</label>
    <input type="text" id="pain_trigger" name="pain_trigger" required><br>

    <label for="severity_pain">severity_pain:</label>
    <input type="text" id="severity_pain" name="severity_pain" required><br>

    <label for="other_symptom">other_symptom:</label>
    <input type="text" id="other_symptom" name="other_symptom" required><br>

    <label for="id_userr">User ID:</label>
    <input type="text" id="id_user" name="id_user" required><br>

    <!-- Add a hidden input field to indicate the action -->
    <input type="hidden" name="action" value="create">

    <input type="submit" value="Create pain">
</form>

</body>
</html>
