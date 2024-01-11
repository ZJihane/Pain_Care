<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<%@ include file="../home/head.jsp" %>
<link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
<link rel="stylesheet" href="${contextPath}/css2/style.css">
<script src="${contextPath}/vendor2/jquery/jquery.min.js"></script>
<script src="${contextPath}/js2/main.js"></script>

<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
     <%@ include file="header2.jsp" %>
    <br><br><br>
    <section class="signup">
    <div class="container2">
        <div class="signup-content">
            <div class="signup-form">
                <h2 class="form-title"><span style="color: #8bcbc3;">Modifier</span> <span
                        style="color: #ff9999;">Profil</span></h2>
                <form method="POST" action="${contextPath}/GestionUsers?action=update" class="register-form"
                    id="register-form">
                    <div class="form-group">
                       
                        <input type="text" name="nom_user" id="name" value="${loggedInUser.nomuser}" />
                    </div>
                    <div class="form-group">
                       
                        <input type="email" name="email" id="email" value="${loggedInUser.email}"  />
                    </div>
                    <input type="number" name="id_user" id="id_user" value="${loggedInUser.iduser}" hidden />

                    <div class="form-group form-button">
                        <input type="submit"  value="update" class="form-submit" />
                    </div>
                </form>
            </div>
            <div class="signup-image">
                <figure><img src="${contextPath}/images/logo_form.png" alt="sing up image"></figure>
            </div>
        </div>
    </div>
</section>

    <%@ include file="../home/links.jsp" %>
    <%@ include file="../home/footer.jsp" %>

</body>

</html>
