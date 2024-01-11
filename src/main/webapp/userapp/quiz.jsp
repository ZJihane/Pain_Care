<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ include file="../home/head.jsp" %>
<body>
    <%@ include file="header2.jsp" %>
    
    <!DOCTYPE html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Endometriosis Quiz</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      line-height: 1.6;
      margin: 0;
      padding: 20px;
    }

    h1 {
      text-align: center;
      color: #7accc4;
    }

    #quizContainer {
      max-width: 600px;
      margin: 0 auto;
      background-color: #d4f5f2;
      border-radius: 8px;
      padding: 20px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    .question {
      display: none;
    }

    button {
      padding: 8px 16px;
      margin-top: 10px;
      cursor: pointer;
      border: none;
      border-radius: 4px;
      background-color: #FD6C9E;
      color: white;
    }

    button:hover {
      background-color: #FD6C9E;
    }

    /* Styles pour les boutons radio */
input[type="radio"] {
  /* Masquer les boutons radio par défaut */
  appearance: none;
  -webkit-appearance: none;
  -moz-appearance: none;
  /* Ajouter un style de remplacement pour les boutons radio */
  width: 15px;
  height: 15px;
  border: 2px solid #7accc4;
  border-radius: 50%;
  outline: none;
  cursor: pointer;
  /* Ajouter une marge ou un espacement */
  margin-right: 5px; /* Par exemple */
}

/* Styles pour les boutons radio lorsqu'ils sont cochés */
input[type="radio"]:checked {
  background-color: #7accc4; /* Couleur de fond lorsque sélectionné */
}


    p {
      margin-bottom: 10px;
    }

    .explanation {
      display: none;
      margin-top: 10px;
    }
    .correct {
      color: green;
      font-weight: bold;
    }

    .incorrect {
      color: red;
      font-weight: bold;
    }
     /* Ajout d'une classe "question-container" pour contrôler la visibilité des questions */
     .question-container {
      display: none;
    }

    /* Affichage initial de la première question */
    #question1 {
      display: block;
    }
    
  </style>
</head>
<br><br><br><br>
<body>

<h1>Endometriosis Quiz</h1>
<div id="quizContainer">
 <!-- Question 1 -->

 <div id="question1" class="question" style="display: block;">
   <h2>Question 1: What is endometriosis?</h2>

    <form id="quizForm1">
       <p>What is endometriosis?</p>

       <input type="radio" id="option1_1" name="answer1" value="option1_1">
       <label for="option1_1">A condition where the uterus is enlarged.</label><br>

       <input type="radio" id="option1_2" name="answer1" value="option1_2">
       <label for="option1_2">A condition where the uterine lining sheds more frequently.</label><br>

       <input type="radio" id="option1_3" name="answer1" value="option1_3">
       <label for="option1_3">A condition where the uterine lining grows outside the uterus.</label><br>

       <input type="radio" id="option1_4" name="answer1" value="option1_4">
       <label for="option1_4">A condition where the uterus is tilted backward.</label><br>

       <button type="button" onclick="checkAnswer1()">Submit Answer</button>
       <button id="nextButton1" style="display: none;" onclick="nextQuestion1()">Next</button>
       <p id="feedback"></p>
       <p id="explanation" style="display: none;"></p>
      </form>
  </div>


 <!-- Question 2 -->
 <div id="question2" class="question" style="display: block;">
    <h2>Question 2: What are some common symptoms of endometriosis?</h2>
  
    <form id="quizForm2">
      <p>What are some common symptoms of endometriosis?</p>
  
      <input type="radio" id="option2_1" name="answer2" value="option2_1">
      <label for="option2_1">Pelvic pain.</label><br>
  
      <input type="radio" id="option2_2" name="answer2" value="option2_2">
      <label for="option2_2">Heavy menstrual bleeding.</label><br>
  
      <input type="radio" id="option2_3" name="answer2" value="option2_3">
      <label for="option2_3">Painful intercourse.</label><br>
  
      <input type="radio" id="option2_4" name="answer2" value="option2_4">
      <label for="option2_4">All of the above.</label><br>
  
      <button type="button" onclick="checkAnswer2()">Submit Answer</button>
      <button id="nextButton2" style="display: none;" onclick="nextQuestion2()">Next</button>
     <p id="feedback2"></p>
     <p id="explanation2" style="display: none;"></p>

    </form>
  
    
  </div>

  <!-- Question 3 -->
 <div id="question3" class="question" style="display: block;">
    <h2>Question 3: What is the main cause of endometriosis?</h2>
  
    <form id="quizForm3">
      <p>What is the main cause of endometriosis?</p>
  
      <input type="radio" id="option3_1" name="answer3" value="option3_1">
      <label for="option3_1">Hormonal imbalances.</label><br>
  
      <input type="radio" id="option3_2" name="answer3" value="option3_2">
      <label for="option3_2">Genetic factors.</label><br>
  
      <input type="radio" id="option3_3" name="answer3" value="option3_3">
      <label for="option3_3">Inflammation.</label><br>
  
      <input type="radio" id="option3_4" name="answer3" value="option3_4">
      <label for="option3_4">Unknown.</label><br>
  
      <button type="button" onclick="checkAnswer3()">Submit Answer</button>
      <button id="nextButton3" style="display: none;" onclick="nextQuestion3()">Next</button>
      <p id="feedback3"></p>
      <p id="explanation3" style="display: none;"></p>
    </form>
  </div>

  <!-- Question 4 -->
 <div id="question4" class="question" style="display: block;">
    <h2>Question 4: How is endometriosis diagnosed?</h2>
  
    <form id="quizForm4">
      <p>How is endometriosis diagnosed?</p>
  
      <input type="radio" id="option4_1" name="answer4" value="option4_1">
      <label for="option4_1">Through a physical examination.</label><br>
  
      <input type="radio" id="option4_2" name="answer4" value="option4_2">
      <label for="option4_2">Through blood tests.</label><br>
  
      <input type="radio" id="option4_3" name="answer4" value="option4_3">
      <label for="option4_3">Through imaging tests like ultrasound.</label><br>
  
      <input type="radio" id="option4_4" name="answer4" value="option4_4">
      <label for="option4_4">Through laparoscopy.</label><br>
  
      <button type="button" onclick="checkAnswer4()">Submit Answer</button>
      <button id="nextButton4" style="display: none;" onclick="nextQuestion4()">Next</button>
      <p id="feedback4"></p>
      <p id="explanation4" style="display: none;"></p>
    </form>
  </div>

 <!-- Question 5 -->
 <div id="question5" class="question" style="display: block;">
    <h2>Question 5: What is the primary treatment for endometriosis?</h2>
  
    <form id="quizForm5">
      <p>What is the primary treatment for endometriosis?</p>
  
      <input type="radio" id="option5_1" name="answer5" value="option5_1">
      <label for="option5_1">Pain medication.</label><br>
  
      <input type="radio" id="option5_2" name="answer5" value="option5_2">
      <label for="option5_2">Hormonal therapy.</label><br>
  
      <input type="radio" id="option5_3" name="answer5" value="option5_3">
      <label for="option5_3">Surgery.</label><br>
  
      <input type="radio" id="option5_4" name="answer5" value="option5_4">
      <label for="option5_4">Lifestyle changes.</label><br>
  
      <button type="button" onclick="checkAnswer5()">Submit Answer</button>
     <button id="nextButton5" style="display: none;" onclick="nextQuestion5()">Next</button>
      <p id="feedback5"></p>
      <p id="explanation5" style="display: none;"></p>
    </form>
  </div>

 <!-- Question 6 -->
 <div id="question6" class="question" style="display: block;">
    <h2>Question 6: Can endometriosis cause infertility?</h2>
  
    <form id="quizForm6">
      <p>Can endometriosis cause infertility?</p>
  
      <input type="radio" id="option6_1" name="answer6" value="option6_1">
      <label for="option6_1">Yes, it can affect fertility.</label><br>
  
      <input type="radio" id="option6_2" name="answer6" value="option6_2">
      <label for="option6_2">No, it does not impact fertility.</label><br>
  
      <input type="radio" id="option6_3" name="answer6" value="option6_3">
      <label for="option6_3">It depends on the severity of the condition.</label><br>
  
      <input type="radio" id="option6_4" name="answer6" value="option6_4">
      <label for="option6_4">Endometriosis only affects menstruation.</label><br>
  
      <button type="button" onclick="checkAnswer6()">Submit Answer</button>
     <button id="nextButton6" style="display: none;" onclick="nextQuestion6()">Next</button>
     <p id="feedback6"></p>
      <p id="explanation6" style="display: none;"></p>
    </form>
  </div>

 <!-- Question 7 -->
 <div id="question7" class="question" style="display: block;">
    <h2>Question 7: What are some risk factors for developing endometriosis?</h2>
  
    <form id="quizForm7">
      <p>What are some risk factors for developing endometriosis?</p>
  
      <input type="radio" id="option7_1" name="answer7" value="option7_1">
      <label for="option7_1">Early menarche (onset of menstruation).</label><br>
  
      <input type="radio" id="option7_2" name="answer7" value="option7_2">
      <label for="option7_2">Late menopause.</label><br>
  
      <input type="radio" id="option7_3" name="answer7" value="option7_3">
      <label for="option7_3">Family history of endometriosis.</label><br>
  
      <input type="radio" id="option7_4" name="answer7" value="option7_4">
      <label for="option7_4">All of the above.</label><br>
  
      <button type="button" onclick="checkAnswer7()">Submit Answer</button>
      <button id="nextButton7" style="display: none;" onclick="nextQuestion7()">Next</button>
      <p id="feedback7"></p>
      <p id="explanation7" style="display: none;"></p>
    </form>
  </div>
 <!-- Question 8 -->
 <div id="question8" class="question" style="display: block;">
    <h2>Question 8: Is there a cure for endometriosis?</h2>
  
    <form id="quizForm8">
      <p>Is there a cure for endometriosis?</p>
  
      <input type="radio" id="option8_1" name="answer8" value="option8_1">
      <label for="option8_1">Yes, it can be completely cured.</label><br>
  
      <input type="radio" id="option8_2" name="answer8" value="option8_2">
      <label for="option8_2">No, there is no known cure.</label><br>
  
      <input type="radio" id="option8_3" name="answer8" value="option8_3">
      <label for="option8_3">Surgery can provide a permanent cure.</label><br>
  
      <input type="radio" id="option8_4" name="answer8" value="option8_4">
      <label for="option8_4">Endometriosis resolves on its own over time.</label><br>
  
      <button type="button" onclick="checkAnswer8()">Submit Answer</button>
     <button id="nextButton8" style="display: none;" onclick="nextQuestion8()">Next</button>
      <p id="feedback8"></p>
      <p id="explanation8" style="display: none;"></p>
    </form>   
  </div>

 <!-- Question 9 -->
 <div id="question9" class="question" style="display: block;">
    <h2>Question 9: What is the endometrium?</h2>
  
    <form id="quizForm9">
      <p>What is the endometrium?</p>
  
      <input type="radio" id="option9_1" name="answer9" value="option9_1">
      <label for="option9_1">The outer layer of the uterus.</label><br>
  
      <input type="radio" id="option9_2" name="answer9" value="option9_2">
      <label for="option9_2">The inner lining of the uterus.</label><br>
  
      <input type="radio" id="option9_3" name="answer9" value="option9_3">
      <label for="option9_3">A structure within the ovaries.</label><br>
  
      <input type="radio" id="option9_4" name="answer9" value="option9_4">
      <label for="option9_4">The fallopian tubes.</label><br>
  
      <button type="button" onclick="checkAnswer9()">Submit Answer</button>
    
     <button id="nextButton9" style="display: none;" onclick="nextQuestion9()">Next</button>
      <p id="feedback9"></p>
      <p id="explanation9" style="display: none;"></p>
    </form>
  </div>

 <!-- Question 10 -->
 <div id="question10" class="question" style="display: block;">
    <h2>Question 10: Can endometriosis be managed through lifestyle changes?</h2>
  
    <form id="quizForm10">
      <p>Can endometriosis be managed through lifestyle changes?</p>
  
      <input type="radio" id="option10_1" name="answer10" value="option10_1">
      <label for="option10_1">Yes, diet and exercise can help alleviate symptoms.</label><br>
  
      <input type="radio" id="option10_2" name="answer10" value="option10_2">
      <label for="option10_2">No, lifestyle changes have no impact on endometriosis.</label><br>
  
      <input type="radio" id="option10_3" name="answer10" value="option10_3">
      <label for="option10_3">Only medication can manage endometriosis.</label><br>
  
      <input type="radio" id="option10_4" name="answer10" value="option10_4">
      <label for="option10_4">Lifestyle changes worsen endometriosis.</label><br>
  
      <button type="button" onclick="checkAnswer10()">Submit Answer</button>
      <p id="feedback10"></p>
      <p id="explanation10" style="display: none;"></p>
    </form>
   
  </div>
  
</div>
<!-- ... Ajoutez ici les autres questions similaires jusqu'à la question 10 -->

<script>
  function checkAnswer1() {
    var selectedAnswer = document.querySelector('input[name="answer1"]:checked');
    var feedback = document.getElementById("feedback");
    var explanation = document.getElementById("explanation");

    if (selectedAnswer) {
      var userAnswer = selectedAnswer.value;
      var correctAnswer = "option1_3"; // Remplacez cette valeur par la réponse correcte

      if (userAnswer === correctAnswer) {
        // Réponse correcte
        feedback.classList.add("correct");
        feedback.innerHTML = "Correct!";
        explanation.innerHTML = "<strong> Explanation: </strong> <br> Endometriosis is characterized by the abnormal growth of tissue resembling the uterine lining outside the uterus.";
      } else {
        // Réponse incorrecte
        feedback.classList.add("incorrect");
        feedback.innerHTML = "Incorrect!";
        explanation.innerHTML = "The correct answer is 'A condition where the uterine lining grows outside the uterus'. <br> <strong> Explanation: </strong> <br>  Endometriosis is characterized by the abnormal growth of tissue resembling the uterine lining outside the uterus.";
      }
      explanation.style.display = "block";
    } else {
      // Aucune réponse sélectionnée
      feedback.innerHTML = "Please select an answer.";
      explanation.style.display = "none";
    }
  }

  function checkAnswer2() {
    var selectedAnswer = document.querySelector('input[name="answer2"]:checked');
    var feedback = document.getElementById("feedback2");
    var explanation = document.getElementById("explanation2");

    if (selectedAnswer) {
      var userAnswer = selectedAnswer.value;
      var correctAnswer = "option2_4"; // Remplacez cette valeur par la réponse correcte

      if (userAnswer === correctAnswer) {
        // Réponse correcte
        feedback.classList.add("correct");
        feedback.innerHTML = "Correct!";
        explanation.innerHTML = "<strong> Explanation: </strong> <br> Individuals with endometriosis often experience a combination of symptoms, including pelvic pain, heavy menstrual bleeding, and painful intercourse. The presence of these symptoms can vary based on the extent and location of the abnormal tissue growth.";
      } else {
        // Réponse incorrecte
        feedback.classList.add("incorrect");
        feedback.innerHTML = "Incorrect!";
        explanation.innerHTML = "The correct answer is 'All of the above.'<br> <strong> <strong> Explanation: Individuals with endometriosis often experience a combination of symptoms, including pelvic pain, heavy menstrual bleeding, and painful intercourse. The presence of these symptoms can vary based on the extent and location of the abnormal tissue growth. </strong> <br> ";
      }
      explanation.style.display = "block";
    } else {
      // Aucune réponse sélectionnée
      feedback.innerHTML = "Please select an answer.";
      explanation.style.display = "none";
    }
  }

  function checkAnswer3() {
    var selectedAnswer = document.querySelector('input[name="answer3"]:checked');
    var feedback = document.getElementById("feedback3");
    var explanation = document.getElementById("explanation3");

    if (selectedAnswer) {
      var userAnswer = selectedAnswer.value;
      var correctAnswer = "option3_4"; // Remplacez cette valeur par la réponse correcte

      if (userAnswer === correctAnswer) {
        // Réponse correcte
        feedback.classList.add("correct");
        feedback.innerHTML = "Correct!";
        explanation.innerHTML = "<strong> Explanation: </strong> <br> Although hormonal imbalances, genetic predisposition, and inflammation are theorized contributors, the exact root cause of endometriosis remains uncertain. Researchers continue to investigate the complex interplay of factors that may trigger its development.";
      } else {
        // Réponse incorrecte
        feedback.classList.add("incorrect");
        feedback.innerHTML = "Incorrect!";
        explanation.innerHTML = "The correct answer is 'Unknown'<br> <strong> <strong> Explanation: </strong> <br> Although hormonal imbalances, genetic predisposition, and inflammation are theorized contributors, the exact root cause of endometriosis remains uncertain. Researchers continue to investigate the complex interplay of factors that may trigger its development.";
      }
      explanation.style.display = "block";
    } else {
      // Aucune réponse sélectionnée
      feedback.innerHTML = "Please select an answer.";
      explanation.style.display = "none";
    }
  }

  function checkAnswer4() {
    var selectedAnswer = document.querySelector('input[name="answer4"]:checked');
    var feedback = document.getElementById("feedback4");
    var explanation = document.getElementById("explanation4");

    if (selectedAnswer) {
      var userAnswer = selectedAnswer.value;
      var correctAnswer = "option4_4"; // Remplacez cette valeur par la réponse correcte

      if (userAnswer === correctAnswer) {
        // Réponse correcte
        feedback.classList.add("correct");
        feedback.innerHTML = "Correct!";
        explanation.innerHTML = "<strong> Explanation: </strong> <br> Laparoscopy, a minimally invasive surgical procedure, is the preferred method for diagnosing endometriosis. It allows direct visualization of pelvic organs, identification of abnormal tissue growth, and often enables simultaneous treatment during the procedure.";
      } else {
        // Réponse incorrecte
        feedback.classList.add("incorrect");
        feedback.innerHTML = "Incorrect!";
        explanation.innerHTML = "The correct answer is 'Through laparoscopy'. <br> <strong> Explanation: </strong> <br>  Laparoscopy, a minimally invasive surgical procedure, is the preferred method for diagnosing endometriosis. It allows direct visualization of pelvic organs, identification of abnormal tissue growth, and often enables simultaneous treatment during the procedure.'";
      }
      explanation.style.display = "block";
    } else {
      // Aucune réponse sélectionnée
      feedback.innerHTML = "Please select an answer.";
      explanation.style.display = "none";
    }
  }

  function checkAnswer5() {
    var selectedAnswer = document.querySelector('input[name="answer5"]:checked');
    var feedback = document.getElementById("feedback5");
    var explanation = document.getElementById("explanation5");

    if (selectedAnswer) {
      var userAnswer = selectedAnswer.value;
      var correctAnswer = "option5_2"; // Remplacez cette valeur par la réponse correcte

      if (userAnswer === correctAnswer) {
        // Réponse correcte
        feedback.classList.add("correct");
        feedback.innerHTML = "Correct!";
        explanation.innerHTML = "<strong> Explanation: </strong> <br> Hormonal therapy, such as birth control pills or GnRH agonists, is commonly chosen as the primary treatment for endometriosis. These therapies aim to regulate hormone levels and create an environment less conducive to the growth of endometrial tissue outside the uterus.";
      } else {
        // Réponse incorrecte
        feedback.classList.add("incorrect");
        feedback.innerHTML = "Incorrect!";
        explanation.innerHTML = "The correct answer is 'Hormonal therapy.' <br> <strong> Explanation: </strong> <br>Hormonal therapy, such as birth control pills or GnRH agonists, is commonly chosen as the primary treatment for endometriosis. These therapies aim to regulate hormone levels and create an environment less conducive to the growth of endometrial tissue outside the uterus.";
      }
      explanation.style.display = "block";
    } else {
      // Aucune réponse sélectionnée
      feedback.innerHTML = "Please select an answer.";
      explanation.style.display = "none";
    }
  }

  function checkAnswer6() {
    var selectedAnswer = document.querySelector('input[name="answer6"]:checked');
    var feedback = document.getElementById("feedback6");
    var explanation = document.getElementById("explanation6");

    if (selectedAnswer) {
      var userAnswer = selectedAnswer.value;
      var correctAnswer = "option6_1"; // Remplacez cette valeur par la réponse correcte

      if (userAnswer === correctAnswer) {
        // Réponse correcte
        feedback.classList.add("correct");
        feedback.innerHTML = "Correct!";
        explanation.innerHTML = "<strong> Explanation: </strong> <br> Endometriosis can lead to fertility challenges due to its potential to cause structural damage, adhesions, and inflammation in the pelvic region. These factors can hinder the normal function of reproductive organs and decrease the chances of successful conception.";
      } else {
        // Réponse incorrecte
        feedback.classList.add("incorrect");
        feedback.innerHTML = "Incorrect!";
        explanation.innerHTML = "The correct answer is 'Yes, it can affect fertility.' <br> <strong> Explanation: </strong> <br> Endometriosis can lead to fertility challenges due to its potential to cause structural damage, adhesions, and inflammation in the pelvic region. These factors can hinder the normal function of reproductive organs and decrease the chances of successful conception.";
      }
      explanation.style.display = "block";
    } else {
      // Aucune réponse sélectionnée
      feedback.innerHTML = "Please select an answer.";
      explanation.style.display = "none";
    }
  }

  function checkAnswer7() {
    var selectedAnswer = document.querySelector('input[name="answer7"]:checked');
    var feedback = document.getElementById("feedback7");
    var explanation = document.getElementById("explanation7");

    if (selectedAnswer) {
      var userAnswer = selectedAnswer.value;
      var correctAnswer = "option7_4"; // Remplacez cette valeur par la réponse correcte

      if (userAnswer === correctAnswer) {
        // Réponse correcte
        feedback.classList.add("correct");
        feedback.innerHTML = "Correct!";
        explanation.innerHTML = "<strong> Explanation: </strong> <br> Early menarche, late menopause, and a family history of endometriosis are established risk factors. These factors influence hormonal exposure and genetic susceptibility, increasing the likelihood of developing the condition.";
      } else {
        // Réponse incorrecte
        feedback.classList.add("incorrect");
        feedback.innerHTML = "Incorrect!";
        explanation.innerHTML = "The correct answer is 'All of the above.' <br> <strong> Explanation: </strong> <br> Early menarche, late menopause, and a family history of endometriosis are established risk factors. These factors influence hormonal exposure and genetic susceptibility, increasing the likelihood of developing the condition. ";
      }
      explanation.style.display = "block";
    } else {
      // Aucune réponse sélectionnée
      feedback.innerHTML = "Please select an answer.";
      explanation.style.display = "none";
    }
  }

  function checkAnswer8() {
    var selectedAnswer = document.querySelector('input[name="answer8"]:checked');
    var feedback = document.getElementById("feedback8");
    var explanation = document.getElementById("explanation8");

    if (selectedAnswer) {
      var userAnswer = selectedAnswer.value;
      var correctAnswer = "option8_2"; // Remplacez cette valeur par la réponse correcte

      if (userAnswer === correctAnswer) {
        // Réponse correcte
        feedback.classList.add("correct");
        feedback.innerHTML = "Correct!";
        explanation.innerHTML = "<strong> Explanation: </strong> <br> Despite various treatment approaches, a definitive cure for endometriosis is currently unavailable. While symptoms can be managed and quality of life improved, the underlying condition itself persists.";
      } else {
        // Réponse incorrecte
        feedback.classList.add("incorrect");
        feedback.innerHTML = "Incorrect!";
        explanation.innerHTML = "The correct answer is 'No, there is no known cure.'<br> <strong> Explanation: </strong> <br> Despite various treatment approaches, a definitive cure for endometriosis is currently unavailable. While symptoms can be managed and quality of life improved, the underlying condition itself persists.";
      }
      explanation.style.display = "block";
    } else {
      // Aucune réponse sélectionnée
      feedback.innerHTML = "Please select an answer.";
      explanation.style.display = "none";
    }
  }

  function checkAnswer9() {
    var selectedAnswer = document.querySelector('input[name="answer9"]:checked');
    var feedback = document.getElementById("feedback9");
    var explanation = document.getElementById("explanation9");

    if (selectedAnswer) {
      var userAnswer = selectedAnswer.value;
      var correctAnswer = "option9_2"; // Remplacez cette valeur par la réponse correcte

      if (userAnswer === correctAnswer) {
        // Réponse correcte
        feedback.classList.add("correct");
        feedback.innerHTML = "Correct!";
        explanation.innerHTML = "<strong> Explanation: </strong> <br> The endometrium is the innermost layer of the uterus that thickens and sheds cyclically in response to hormonal changes. This process is central to the menstrual cycle and plays a role in pregnancy.";
      } else {
        // Réponse incorrecte
        feedback.classList.add("incorrect");
        feedback.innerHTML = "Incorrect!";
        explanation.innerHTML = "The correct answer is 'The inner lining of the uterus.' <br> <strong> Explanation: </strong> <br> The endometrium is the innermost layer of the uterus that thickens and sheds cyclically in response to hormonal changes. This process is central to the menstrual cycle and plays a role in pregnancy.";
      }
      explanation.style.display = "block";
    } else {
      // Aucune réponse sélectionnée
      feedback.innerHTML = "Please select an answer.";
      explanation.style.display = "none";
    }
  }

  function checkAnswer10() {
    var selectedAnswer = document.querySelector('input[name="answer10"]:checked');
    var feedback = document.getElementById("feedback10");
    var explanation = document.getElementById("explanation10");

    if (selectedAnswer) {
      var userAnswer = selectedAnswer.value;
      var correctAnswer = "option10_1"; // Remplacez cette valeur par la réponse correcte

      if (userAnswer === correctAnswer) {
        // Réponse correcte
        feedback.classList.add("correct");
        feedback.innerHTML = "Correct!";
        explanation.innerHTML = "<strong> Explanation: </strong> <br> While medical interventions are crucial, adopting a healthy lifestyle including a balanced diet and regular exercise can contribute positively. These practices can potentially reduce inflammation, manage pain, and enhance overall well-being for individuals living with endometriosis.";
      } else {
        // Réponse incorrecte
        feedback.classList.add("incorrect");
        feedback.innerHTML = "Incorrect!";
        explanation.innerHTML = "The correct answer is 'Yes, diet and exercise can help alleviate symptoms.'<br> <strong> Explanation: </strong> <br> While medical interventions are crucial, adopting a healthy lifestyle including a balanced diet and regular exercise can contribute positively. These practices can potentially reduce inflammation, manage pain, and enhance overall well-being for individuals living with endometriosis.";
      }
      explanation.style.display = "block";
    } else {
      // Aucune réponse sélectionnée
      feedback.innerHTML = "Please select an answer.";
      explanation.style.display = "none";
    }

  }
  let currentQuestion = 1;
  const totalQuestions = 10;

  function showQuestion(questionNumber) {
    for (let i = 1; i <= totalQuestions; i++) {
      const question = document.getElementById(`question${i}`);
      if (i === questionNumber) {
        question.style.display = "block";
      } else {
        question.style.display = "none";
      }
    }

    if (questionNumber === 1) {
      document.getElementById("prevButton").style.display = "none";
    } else {
      document.getElementById("prevButton").style.display = "block";
    }

    if (questionNumber === totalQuestions) {
      document.getElementById("nextButton").innerText = "Finish";
    } else {
      document.getElementById("nextButton").innerText = "Next";
    }
  }

  function nextQuestion() {
    if (currentQuestion < totalQuestions) {
      currentQuestion++;
      showQuestion(currentQuestion);
    } else {
      // L'utilisateur a terminé le quiz
      alert("You have completed the quiz!");
      // Vous pouvez rediriger l'utilisateur vers une autre page ou effectuer une autre action ici
    }
  }

  function previousQuestion() {
    if (currentQuestion > 1) {
      currentQuestion--;
      showQuestion(currentQuestion);
    }
  }

  // Affichage initial de la première question
  showQuestion(currentQuestion);

  

</script>

<!-- ... Ajoutez ici les divs pour les autres questions (question 2 à question 10) -->
<%@ include file="../home/links.jsp" %>
 <%@ include file="../home/footer.jsp" %>
</body>
</html>
    
    
      
