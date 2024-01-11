<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<%@ include file="../home/head.jsp" %>
<%@ include file="../userapp/header2.jsp" %>
<head>
<style>
    body {
        background-color: #ebcad1;
    }

    .container3 {
        background-color: #ffffff;
        padding: 20px;
        border-radius: 10px;
        width: 60%;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        margin: auto;
        margin-top: 50px;
    }

    h2 {
        color: #8bcbc3;
        margin-bottom: 30px;
    }

    form {
        margin-top: 20px;
    }

    .form-group {
        margin-bottom: 20px;
    }

    label {
        color: #8bcbc3;
        font-weight: bold;
    }

    input[type="text"], input[type="number"], select, textarea {
        width: 100%;
        padding: 10px;
        margin-top: 5px;
        margin-bottom: 15px;
        border: 1px solid #8bcbc3;
        border-radius: 4px;
        box-sizing: border-box;
    }

   input[type="radio"] + label, input[type="checkbox"] + label {
    color: black;
}

    button {
        background-color: #8bcbc3;
        color: #ffffff;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
    }
</style></head>
<body class="text-center">
    <br><br><br><br><br>
    <div class="container3">
        <h2>Résultat du Diagnostic</h2>
         <c:set var="contextPath" value="${pageContext.request.contextPath}" />
        <form action="${contextPath}/DownloadResultsServlet" method="post">
            <c:if test="${not empty diagnostic}">
                <p><strong>Attributs du Diagnostic :</strong></p>
                <p>Poids : <input type="text" name="weight" value="${diagnostic.weight}" readonly="readonly"></p>
                <p>Hauteur : <input type="text" name="height" value="${diagnostic.height}" readonly="readonly"></p>
            </c:if>

            <c:if test="${not empty period}">
                <p><strong>Attributs de la Période :</strong></p>
                <p>Premier Cycle Menstruel : <input type="text" name="first_period" value="${period.first_period}" readonly="readonly"></p>
                <p>Longueur du Cycle Menstruel : <input type="text" name="cycle_length" value="${period.cycle_length}" readonly="readonly"></p>
                <p>Durée des Règles : <input type="text" name="period_duration" value="${period.period_duration}" readonly="readonly"></p>
                <p>Nature des Règles : <input type="text" name="nature_period" value="${period.nature_period}" readonly="readonly"></p>
                <p>Pattern des Règles : <input type="text" name="period_pattern" value="${period.period_pattern}" readonly="readonly"></p>
            </c:if>

            <c:if test="${not empty pain}">
                <p><strong>Attributs de la Douleur :</strong></p>
                <p>Déclencheurs de la Douleur :</p>
                <ul>
                    <c:forEach var="trigger" items="${pain.pain_trigger}">
                        <li><input type="text" name="pain_trigger" value="${trigger}" readonly="readonly"></li>
                    </c:forEach>
                </ul>
                <p>Douleur lors des Rapports Sexuels : <input type="text" name="pain_rapport" value="${pain.pain_rapport}" readonly="readonly"></p>
                <p>Intensité de la Douleur : <input type="text" name="severity_pain" value="${pain.severity_pain}" readonly="readonly"></p>
                <p>Autres Symptômes : <input type="text" name="other_symptom" value="${pain.other_symptom}" readonly="readonly"></p>
            </c:if>

            <c:if test="${not empty history}">
                <p><strong>Attributs de l'Histoire Médicale :</strong></p>
                <p>Antécédents d'Endométriose : <input type="text" name="endo_history" value="${history.endo_history}" readonly="readonly"></p>
                <p>Histoire des Accouchements : <input type="text" name="birth" value="${history.birth}" readonly="readonly"></p>
                <p>Difficultés à Tomber Enceinte : <input type="text" name="trouble_pregnant" value="${history.trouble_pregnant}" readonly="readonly"></p>
                <p>Antécédents d'Agressions Sexuelles : <input type="text" name="sexual_abuse" value="${history.sexual_abuse}" readonly="readonly"></p>
            </c:if>

            <p>Résultat du Risque : <input type="text" name="riskLevel" value="${riskLevel}" readonly="readonly"></p>
            <div class="text-center">
           <button type="submit" >download</button>
           </div>

            
        </form>
    </div>

    <br><br><br>
    
    <%@ include file="/home/footer.jsp" %>
</body>
</html>

