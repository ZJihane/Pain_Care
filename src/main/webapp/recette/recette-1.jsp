<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="../home/head.jsp" %>

<body>

    <%@ include file="../userapp/header2.jsp" %>

    <section class="breadcrumbs">
        <div class="container">
            <ol>
                <li><a href="${contextPath}/userapp/acceuil_user.jsp?loggedInUser=${loggedInUser}" style="color:#8bcbc4;">Home</a></li>
                <li>Recette</li>
            </ol>
            <h2>Recette</h2>
        </div>
    </section>


   
<br><br>
    <section id="blog" class="blog">
        <div class="container" data-aos="fade-up">
            <div class="row justify-content-center align-items-center"> <!-- Add justify-content-center and align-items-center for both horizontal and vertical centering -->
                <div class="col-lg-8 entries">

                    <c:forEach var="recette" items="${allRecettes}">
                        <article class="entry" id="${recette.id_recette}">
                            <div class="entry-img">
                                <img src="data:image/jpeg;base64,${recette.pictureBase64}" alt="Recette Image" class="img-fluid">
                            </div>
                            <h2 class="entry-title">
                               ${recette.nom_recette}
                            </h2>
                           
                            <div class="entry-content">
                                <div class="read-more">
                                    <a href="recetteServlet?action=viewDetails&recetteId=${recette.id_recette}">Read More</a>
                                </div>
                                
                            </div>
                            
                        </article>
                    </c:forEach>
                </div>
            </div>
        </div>
    </section>
</div>


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
