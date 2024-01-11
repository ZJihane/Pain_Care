<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="../home/head.jsp" %>


    <%@ include file="../userapp/header2.jsp" %>

    <section class="breadcrumbs">
        <div class="container">
            <ol>
                <li><a href="${contextPath}/userapp/acceuil_user.jsp?loggedInUser=${loggedInUser}" style="color:#8bcbc3;">Home</a></li>
                <li>Recette</li>
                <li>${recette.nom_recette}</li>
            </ol>
            <h2>Recette</h2>
        </div>
    </section>
<body>

<div class="container mt-5 recette-container">
    <div class="recette">
        <h3 class="display-4">${recette.nom_recette}</h3>
       
        <img src="data:image/jpeg;base64,${recette.pictureBase64}" alt="Recette Image" class="img-fluid rounded">
        <p class="lead">${recette.description}</p>
    </div>
     
</div>
<br><br>

<br><br><br>
   <script src="${contextPath}/assets/vendor/purecounter/purecounter_vanilla.js"></script>
    <script src="${contextPath}/assets/vendor/aos/aos.js"></script>
    <script src="${contextPath}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="${contextPath}/assets/vendor/glightbox/js/glightbox.min.js"></script>
    <script src="${contextPath}/assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
    <script src="${contextPath}/assets/vendor/swiper/swiper-bundle.min.js"></script>
    <script src="${contextPath}/assets/vendor/php-email-form/validate.js"></script>
    <script src="${contextPath}/assets/js/main.js"></script>
    <%@ include file="/home/footer.jsp" %>
</body>

</html>