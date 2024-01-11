<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<header id="header" class="header fixed-top">
    <div class="container-fluid container-xl d-flex align-items-center justify-content-between">
        <a href="${contextPath}/userapp/acceuil_user.jsp?loggedInUser=${loggedInUser}" class="logo d-flex align-items-center">
    <img src="${contextPath}/assets/img/logo.jpeg" alt="Logo de mon site" style="height:150px; width: 100px;">
</a>
 <nav id="navbar" class="navbar">
            <ul>
                <li><a class="nav-link active" href="${contextPath}/userapp/acceuil_user.jsp?loggedInUser=${loggedInUser}" style="color:#8bcbc3;">Home</a></li>

             <li><a class="nav-link " href="${contextPath}/diagnostic/DiagnosticForm.jsp?loggedInUser=${loggedInUser}" style="color:#8bcbc3;">Diagnostic</a></li>
              <li><a class="nav-link " href="${contextPath}/blogServlet?loggedInUser=${loggedInUser}" style="color:#8bcbc3;">Blog</a></li>
              <li><a class="nav-link " href="${contextPath}/userapp/profil.jsp?loggedInUser=${loggedInUser}" style="color:#8bcbc3;">Profil</a></li>
              <li><a class="nav-link " href="${contextPath}/recetteServlet?loggedInUser=${loggedInUser}&action=view" style="color:#8bcbc3;">Recettes</a></li>
           <li><a class="nav-link " href="${contextPath}/userapp/Calendrier.jsp?loggedInUser=${loggedInUser}" style="color:#8bcbc3;">Calendrier</a></li>
              


                <li><a class="getstarted scrollto" href="${contextPath}/LogoutServlet">Log out<i class="bi bi-box-arrow-in-right"></i></a></li>
            </ul>
            <i class="bi bi-list mobile-nav-toggle"></i>
        </nav><!-- .navbar -->
    </div>
</header>
