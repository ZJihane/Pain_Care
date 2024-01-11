<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="../home/head.jsp" %>

<body>

    <%@ include file="../userapp/header2.jsp" %>

    <section class="breadcrumbs">
        <div class="container">
            <ol>
                <li><a href="${contextPath}/userapp/acceuil_user.jsp?loggedInUser=${loggedInUser}" style="color:#8bcbc3;">Home</a></li>
                <li>Blog</li>
                <li>Ajouter un nouveau Blog</li>
            </ol>
            <h2>Blog</h2>
        </div>
    </section>

<div class="container mt-5">
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <h2 class="mb-4">Ajouter un nouveau Blog</h2>
    
    <form action="${contextPath}/blogServlet" method="post" enctype="multipart/form-data">
        <input type="hidden" name="action" value="create">

        <div class="mb-3">
            <label for="title" class="form-label">Title</label>
            <input type="text" class="form-control" id="title" name="title" required>
        </div>

        <div class="mb-3">
            <label for="description" class="form-label">Description</label>
            <textarea class="form-control" id="description" name="description" rows="4" required></textarea>
        </div>

        <div class="mb-3">
            <label for="picture" class="form-label">Picture</label>
            <input type="file" class="form-control" id="picture" name="picture" accept="image/*">
        </div>
        
         <input type="text" class="form-control" id="id_user" name="id_user" value="${loggedInUser.iduser}" hidden required>
        
        

        <button type="submit" class="btn btn-primary">Create Blog</button>
    </form>

    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger mt-3" role="alert">
            ${errorMessage}
        </div>
    </c:if>
    
  
   
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
