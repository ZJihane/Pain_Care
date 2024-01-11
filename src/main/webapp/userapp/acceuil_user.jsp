<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ include file="../home/head.jsp" %>
<body>
    <%@ include file="header2.jsp" %>
    
      <div class="container mt-5">
        
    <section id="values" class="values">
        <div class="container" data-aos="fade-up">
        
            <header class="section-header">
                <h1 style="color: #ff66b2; text-align: center; font-weight: bolder;">Hello , ${loggedInUser.nomuser}</h1>
            </header>

            <div class="row">
                <div class="col-lg-4" data-aos="fade-up" data-aos-delay="200">
                    <div class="box" >
                        <img src="../assets/img/infos.jpg" class="img-fluid" alt="">
                        <h3>Informations sur l'endométriose</h3>
                        <p>Restez informés sur l'endométriose </p>
                        
                         <a href="${contextPath}/articleServlet?loggedInUser=${loggedInUser}">
                               <button class="button-with-color" type="submit">
                                  <span class="icon bi bi-pen"></span>
                                        aller à
                               </button>
                           </a>
                    </div>
                </div>

                <div class="col-lg-4 mt-4 mt-lg-0" data-aos="fade-up" data-aos-delay="400">
                    <div class="box">
                        <img src="../assets/img/pain.png" class="img-fluid" alt="">
                        <h3>Évolution de la douleur</h3>
                        <p>explorez vottre parcours de douleur </p>
                        <br>
                          <a href="${contextPath}/userapp/pain_graph.jsp?loggedInUser=${loggedInUser}">
                               <button class="button-with-color" type="submit">
                                  <span class="icon bi bi-pen"></span>
                                        aller à
                               </button>
                           </a>
                    </div>
                </div>

                <div class="col-lg-4 mt-4 mt-lg-0" data-aos="fade-up" data-aos-delay="600">
                    <div class="box">
                        <img src="../assets/img/quiz.jpg" class="img-fluid" alt="">
                        <br><br>
                        <h3>Quiz</h3>
                        
                        <p>Testez vos connaissances sur l'endométriose</p>
                        <br>
                        <a href="${contextPath}/userapp/quiz.jsp?loggedInUser=${loggedInUser}">
       
       
        <button class="button-with-color" type="submit">
            <span class="icon bi bi-pen"></span>
           aller à
        </button>
    </a>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
    <%@ include file="../home/links.jsp" %>
    <%@ include file="../home/footer.jsp" %>
</body>
</html>
