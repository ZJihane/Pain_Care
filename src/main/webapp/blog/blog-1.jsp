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
            </ol>
            <h2>Blog</h2>
        </div>
    </section>
    
<div class="container mt-5 text-center">
    <a href="${contextPath}/blog/create_blog.jsp?loggedInUser=${loggedInUser}">
       
       
        <button class="button-with-color" type="submit">
            <span class="icon bi bi-pen"></span>
            Créer un Nouveau Blog
        </button>
    </a>
</div>

   
<br><br>
    <section id="blog" class="blog">
        <div class="container" data-aos="fade-up">
            <div class="row justify-content-center align-items-center"> <!-- Add justify-content-center and align-items-center for both horizontal and vertical centering -->
                <div class="col-lg-8 entries">

                    <c:forEach var="blog" items="${allBlogs}">
                        <article class="entry" id="${blog.blogId}">
                            <div class="entry-img">
                                <img src="data:image/jpeg;base64,${blog.pictureBase64}" alt="Blog Image" class="img-fluid">
                            </div>
                            <h2 class="entry-title">
                                <a>${blog.title}</a>
                            </h2>
                            <div class="entry-meta">
                                <ul>
                                    <li class="d-flex align-items-center"><i class="bi bi-person"></i> <a>${blog.user_nom}</a></li>
                                    <li class="d-flex align-items-center"><i class="bi bi-clock"></i> <a><time datetime="2020-01-01">${blog.publicationDate}</time></a></li>
                                </ul>
                            </div>
                            <div class="entry-content">
                                <p id="blogDescription_${blog.blogId}">
                                    ${blog.description}
                                </p>
                                <div class="read-more">
                                    <a href="blogServlet?action=viewDetails&blogId=${blog.blogId}">Read More</a>
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
