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
    <section class="signup">
        <div class="container2">
            <div class="signup-content">
                <div class="signup-form">
                    <h2 class="form-title"><span style="color : #8bcbc3 ;">Sign</span> <span
                            style="color : #ff9999 ;">up</span></h2>
                    <form method="POST" action="${contextPath}/SignupServlet" class="register-form" id="register-form">
                        <div class="form-group">
                            <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                            <input type="text" name="nom_user" id="name" placeholder="Your Name" />
                        </div>
                        <div class="form-group">
                            <label for="email"><i class="zmdi zmdi-email"></i></label>
                            <input type="email" name="email" id="email" placeholder="Your Email" />
                        </div>
                        <div class="form-group">
                            <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                            <input type="password" name="password" id="pass" placeholder="Password" />
                        </div>
                        <div class="form-group">
                            <label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
                            <input type="password" name="re_pass" id="re_pass"
                                placeholder="Repeat your password" />
                        </div>

                        <div class="form-group form-button">
                            <input type="submit" name="action" value="create" id="signup"
                                class="form-submit" />
                        </div>
                    </form>
                </div>
                <div class="signup-image">
                    <figure><img src="../images/signup-image.jpg" alt="sing up image"></figure>
                    <a href="login.jsp" class="signup-image-link">Je suis déjà membre.</a>
                </div>
            </div>
        </div>
    </section>
    <%@ include file="footer.jsp" %>
    <%@ include file="links.jsp" %>

</body>

</html>
