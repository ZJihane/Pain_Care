<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<%@ include file="head.jsp" %>

<link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
<link rel="stylesheet" href="../css2/style.css">
<script src="../vendor2/jquery/jquery.min.js"></script>
<script src="../js2/main.js"></script>

<body>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <%@ include file="header1.jsp" %>

    <br><br><br>
    <section class="sign-in">
        <div class="container2">
            <div class="signin-content">
                <div class="signin-image">
                    <figure><img src="<c:url value='/images/signin-image.jpg'/>" alt="sing up image"></figure>
                    <a href="signup.jsp" class="signup-image-link">Créer un compte</a>
                </div>

                <div class="signin-form">
                    <h2 class="form-title"><span style="color : #8bcbc3 ;">Sign</span> <span
                            style="color : #ff9999 ;">in</span></h2>

                    <!-- Display error message if 'error' parameter is present in the URL -->
                    <c:if test="${param.error == 'true'}">
                        <div style="color: red; font-weight: bold;">"Adresse e-mail ou mot de passe incorrect. Veuillez réessayer."</div>
                    </c:if>

                    <form method="POST" action="${contextPath}/LoginServlet" class="register-form" id="login-form">
                        <div class="form-group">
                            <label for="email"><i class="zmdi zmdi-account material-icons-name"></i></label>
                            <input type="text" name="email" id="email" placeholder="Your Email" />
                        </div>
                        <div class="form-group">
                            <label for="password"><i class="zmdi zmdi-lock"></i></label>
                            <input type="password" name="password" id="password" placeholder="Password" />
                        </div>
                        
                        <div class="form-group form-button">
                            <input type="submit" name="signin" id="signin" class="form-submit" value="Log in" />
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </section>
    <%@ include file="footer.jsp" %>
    <%@ include file="links.jsp" %>

</body>

</html>
