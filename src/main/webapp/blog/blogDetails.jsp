<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="../home/head.jsp" %>


    <%@ include file="../userapp/header2.jsp" %>

    <section class="breadcrumbs">
        <div class="container">
            <ol>
                <li><a href="${contextPath}/userapp/acceuil_user.jsp?loggedInUser=${loggedInUser}" style="color:#8bcbc3;">Home</a></li>
                <li>Blog</li>
                <li>${blog.title}</li>
            </ol>
            <h2>Blog</h2>
        </div>
    </section>
<body>

<div class="container mt-5 blog-container">
    <div class="blog">
        <h3 class="display-4">${blog.title}</h3>
        <div class="blog-info">
            <p class="user-info">Created by  ${blog.user_nom}</p>
        </div>
        <img src="data:image/jpeg;base64,${blog.pictureBase64}" alt="Blog Image" class="img-fluid rounded">
        <p class="lead">${blog.description}</p>
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