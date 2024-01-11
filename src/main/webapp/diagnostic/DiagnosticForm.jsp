<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<%@ include file="../home/head.jsp" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<body>
 <%@ include file="../userapp/header2.jsp" %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Test de diagnostic</title>
    <!-- Ajout de Bootstrap -->
    

    <script>
        function calculateBMI() {
            var poids = document.getElementById("poids").value;
            var tailleCm = document.getElementById("taille").value;

            // Convertir la taille de centimètres en mètres
            var tailleMetres = tailleCm / 100;

            if (poids && tailleMetres) {
                var bmi = (poids / (tailleMetres * tailleMetres)).toFixed(2);
                document.getElementById("bmi").value = bmi;
            }
        }
    </script>
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
    font-weight: normal;
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
</style>
    
</head>

<body>
<br><br><br><br>
    <div class="container3">
        <h2>Formulaire de Diagnostic</h2>
        <form action="${contextPath}/DiagnosticServlet?action=create" method="post">

            <!-- Fieldset pour les questions sur la période -->
            <fieldset>
                <legend> Période</legend>

                <div class="form-group">
                    <label for="first_period">Âge au Premier Cycle Menstruel :</label>
                    <input type="number" class="form-control" name="first_period" required>
                </div>

                <div class="form-group">
                    <label for="cycle_length">Longueur du Cycle Menstruel (jours) :</label>
                    <input type="number" class="form-control" name="cycle_length" required>
                </div>

                <div class="form-group">
                    <label for="period_duration">Durée des Règles (jours) :</label>
                    <input type="number" class="form-control" name="period_duration" required>
                </div>

                <div class="form-group">
                    <label for="nature_period">Nature des Règles :</label>
                    <select class="form-control" name="nature_period">
                        <option value="abondantes">Abondantes</option>
                        <option value="pas_abondantes">Pas Abondantes</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="period_pattern">Pattern des Règles :</label>
                    <select class="form-control" name="period_pattern">
                        <option value="reguliere">Régulière</option>
                        <option value="non_reguliere">Non Régulière</option>
                    </select>
                </div>

            </fieldset>

      
<fieldset>
    <legend>Histoire Médicale</legend>

    <div class="form-group">
        <label>Histoire des Accouchements :</label><br>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="birth" value="true">
            <label class="form-check-label">Oui</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="birth" value="false">
            <label class="form-check-label">Non</label>
        </div>
    </div>

    <div class="form-group">
        <label>Difficultés à Tomber Enceinte :</label><br>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="trouble_pregnant" value="true">
            <label class="form-check-label">Oui</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="trouble_pregnant" value="false">
            <label class="form-check-label">Non</label>
        </div>
    </div>

    <div class="form-group">
        <label>Antécédents d'Agressions Sexuelles :</label><br>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="sexual_abuse" value="true">
            <label class="form-check-label">Oui</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="sexual_abuse" value="false">
            <label class="form-check-label">Non</label>
        </div>
    </div>
</fieldset>


            <!-- Fieldset pour les questions sur la douleur -->
<fieldset>
    <legend>Informations sur la Douleur</legend>

    

    <div class="form-group">
        <label for="pain_trigger">Déclencheurs de la Douleur :</label><br>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" name="pain_trigger[]" value="Mvt_Intestinaux">
            <label class="form-check-label">Mouvement Intestinaux</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" name="pain_trigger[]" value="Vessie">
            <label class="form-check-label">La vessie pleine</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" name="pain_trigger[]" value="Orgasme">
            <label class="form-check-label">L'orgasme</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" name="pain_trigger[]" value="Miction">
            <label class="form-check-label">La miction (uriner)</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" name="pain_trigger[]" value="Aucune">
            <label class="form-check-label">Aucune des réponses</label>
        </div>
    </div>

    <div class="form-group">
        <label for="pain_rapport">Douleur lors des Rapports Sexuels :</label><br>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="pain_rapport" value="true">
            <label class="form-check-label">Oui</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="pain_rapport" value="false">
            <label class="form-check-label">Non</label>
        </div>
    </div>

    <div class="form-group">
        <label for="severity_pain">Intensité de la Douleur :</label>
        <input type="number" name="severity_pain" required class="form-control">
    </div>

    <div class="form-group">
        <label for="other_symptom">Autres Symptômes :</label>
        <textarea name="other_symptom" class="form-control"></textarea>
    </div>
</fieldset>

            <div class="form-group">
                <label for="weight">Poids (kg) :</label>
                <input type="number" step="0.01" class="form-control" name="weight" required oninput="calculateBMI()">
            </div>

            <div class="form-group">
                <label for="height">Taille (m) :</label>
                <input type="number" step="0.01" class="form-control" name="height" required oninput="calculateBMI()">
            </div>

            <div class="form-group">
                
                <input type="number" step="0.01" class="form-control" name="bmi" hidden>
            </div>

            <input type="number" name="id_user" value="${loggedInUser.iduser}" hidden><br>

            <div class="text-center">
             <button type="submit">Résultat</button>
            </div>
        </form>
    </div>
<br><br><br>
   <script src="${contextPath}/assets/vendor/purecounter/purecounter_vanilla.js"></script>
    <script src="${contextPath}/assets/vendor/aos/aos.js"></script>
    <script src="${contextPath}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="${contextPath}/assets/vendor/glightbox/js/glightbox.min.js"></script>
    <script src="${contextPath}/assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
    <script src="${contextPath}/assets/vendor/swiper/swiper-bundle.min.js"></script>
    <script src="${contextPath}/assets/vendor/php-email-form/validate.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="${contextPath}/assets/js/main.js"></script>
    <%@ include file="/home/footer.jsp" %>
</body>

</html>
  