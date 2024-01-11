<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="Beans.PainTrack" %>
<!DOCTYPE html>
<html>
<%@ include file="../home/head.jsp" %>
<body>
 <%@ include file="header2.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Pain track</title>
  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
  <style>
    body {
      
      font-family: "DM Sans", sans-serif;
      margin: 0;
	 line-height: 1.5;
	 background-color: #f1f3fb;
	 padding: 0 2rem;
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
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      padding: 40px; /* Ajoute un espace de 20px à l'intérieur du formulaire */
      }

    /* Style du bouton Submit */
.button {
  padding: 10px 20px; /* Espacement interne */
  border: none; /* Supprime la bordure par défaut */
  border-radius: 4px; /* Coins arrondis */
  background-color: #FD6C9E; /* Couleur de fond */
  color: white; /* Couleur du texte */
  font-size: 16px; /* Taille de la police */
  cursor: pointer; /* Curseur pointer */
  transition: background-color 0.3s ease; /* Transition en douceur */
  margin-top: 20px;
}

/* Conteneur du bouton Submit */
.submitBtnContainer {
  text-align: center; /* Centre le contenu horizontalement */
  margin-top: 20px; /* Espacement en haut du bouton */
}

/* Changement de couleur au survol */
.button:hover {
  background-color: #FF88BB; /* Nouvelle couleur de fond au survol */
}



    p {
      margin-bottom: 10px;
    }

    /* Affichage initial de la première question */
    #question1 {
      display: block;
    }

    input[type=range] {
  -webkit-appearance: none; /* Masque l'apparence native */
  width: 250px; /* Largeur de la barre de défilement */
  height: 10px; /* Hauteur de la barre de défilement */
  border-radius: 5px; /* Coins arrondis */
  background: #f7c1d3; /* Couleur de fond de la barre de défilement */
  outline: none; /* Supprime le contour */
   }

   input[type=range]::-webkit-slider-thumb {
  -webkit-appearance: none; /* Masque l'apparence native */
  width: 20px; /* Largeur du curseur */
  height: 20px; /* Hauteur du curseur */
  border-radius: 50%; /* Forme du curseur en cercle */
  background: #e96492; /* Couleur du curseur */
  cursor: pointer; /* Curseur personnalisé */
   }

   /* Style des cases à cocher */
input[type="checkbox"] {
  /* Masque les cases à cocher par défaut */
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
  /* Utilise une taille personnalisée pour la case à cocher */
  width: 20px;
  height: 20px;
  /* Style de base de la case à cocher */
  border: 2px solid #ccc; /* Bordure */
  border-radius: 4px; /* Coins arrondis */
  outline: none; /* Supprime le contour */
  cursor: pointer; /* Curseur pointer */
  /* Ajoute de l'espace entre la case à cocher et le label */
  margin-right: 8px;
  vertical-align: middle;
}

/* Style des cases cochées */
input[type="checkbox"]:checked {
  background-color: #FD6C9E; /* Couleur de fond lorsque cochée */
  border-color: #FD6C9E; /* Couleur de la bordure lorsque cochée */
}

/* Style du curseur de la case cochée */
input[type="checkbox"]:checked::before {
  content: "\2713"; /* Symbole de coche Unicode */
  font-size: 14px;
  color: white; /* Couleur de la coche */
  text-align: center;
  line-height: 18px;
}

   /* Couleurs pour les niveaux de douleur */
.level-text.blue-text {
  color: black;
}

.level-text.yellow-text {
  color: rgb(215, 215, 0);
}

.level-text.orange-text {
  color: rgb(255, 167, 3);
}

.level-text.red-text {
  color: red;
}

.level-text.dark-red-text {
  color: rgb(232, 0, 0);
}

.center-elements {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  text-align: center;
}


    
  </style>
</head>
<body>
<br><br><br><br>
<h1>Pain Track</h1>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<div id="quizContainer">
<form  action="${contextPath}/PainTrackServlet?action=create" method="post" >    

        <div>
    <label for="painLevel"><strong>Pain Severity:</strong></label>
    
        <input type="number" min="1" max="10"  id="painLevel" name="painLevel">
        
  
</div>
        <div>
          <label for="painLocations"><br><strong>Pain Locations:</strong></label><br>
          <input type="checkbox" id="abdomen" name="painLocations" value="Abdomen">
          <label for="abdomen">Abdomen</label><br>
          <!-- Ajoutez les autres cases à cocher pour les emplacements de douleur ici -->
          <input type="checkbox" id="back" name="painLocations" value="Back">
          <label for="back">Back</label><br>
          <input type="checkbox" id="chest" name="painLocations" value="Chest">
          <label for="chest">Chest</label><br>
          <input type="checkbox" id="head" name="painLocations" value="Head">
          <label for="head">Head</label><br>
          <input type="checkbox" id="neck" name="painLocations" value="Neck">
          <label for="neck">Neck</label><br>
          <input type="checkbox" id="hips" name="painLocations" value="Hips">
          <label for="hips">Hips</label><br>
        </div>
        <div>
        
          <label for="symptoms"><br><strong>Symptoms:</strong></label><br>
          <!-- Ajoutez des cases à cocher pour les symptômes ici -->
          <input type="checkbox" id="cramps" name="symptoms" value="Cramps">
          <label for="cramps">Cramps</label><br>
          <input type="checkbox" id="tenderBreasts" name="symptoms" value="Tender Breasts">
          <label for="tenderBreasts">Tender Breasts</label><br>
         
          <input type="checkbox" id="headache" name="symptoms" value="Headache">
          <label for="headache">Headache</label><br>
          <input type="checkbox" id="acne" name="symptoms" value="Acne">
          <label for="acne">Acne</label><br>
          <input type="checkbox" id="fatigue" name="symptoms" value="Fatigue">
          <label for="fatigue">Fatigue</label><br>
          <input type="checkbox" id="bloating" name="symptoms" value="Bloating">
          <label for="bloating">Bloating</label><br>
          <input type="checkbox" id="craving" name="symptoms" value="Craving">
          <label for="craving">Craving</label><br>
        </div>
        <div>
          <label for="painWorsen"><br><strong>What Makes Pain Worse?</strong></label><br>
          <!-- Ajoutez des cases à cocher pour ce qui aggrave la douleur ici -->
          <input type="checkbox" id="lackOfSleep" name="painWorsen" value="Lack of Sleep">
          <label for="lackOfSleep">Lack of Sleep</label><br>
          <!-- Ajoutez les autres cases à cocher pour ce qui aggrave la douleur ici -->
          <input type="checkbox" id="sitting" name="painWorsen" value="Sitting">
          <label for="sitting">Sitting</label><br>
          <input type="checkbox" id="standing" name="painWorsen" value="Standing">
          <label for="standing">Standing</label><br>
          <input type="checkbox" id="stress" name="painWorsen" value="Stress">
          <label for="stress">Stress</label><br>
          <input type="checkbox" id="walking" name="painWorsen" value="Walking">
          <label for="walking">Walking</label><br>
          <input type="checkbox" id="exercise" name="painWorsen" value="Exercise">
          <label for="exercise">Exercise</label><br>
          <input type="checkbox" id="urination" name="painWorsen" value="Urination">
          <label for="urination">Urination</label><br>
        </div>
        <div>
          <label for="feelings"><br><strong>Feelings:</strong></label><br>
          <!-- Ajoutez des cases à cocher pour les sentiments ici -->
          <input type="checkbox" id="anxious" name="feelings" value="Anxious">
          <label for="anxious">Anxious</label><br>
          <!-- Ajoutez les autres cases à cocher pour les sentiments ici -->
          <input type="checkbox" id="depressed" name="feelings" value="Depressed">
          <label for="depressed">Depressed</label><br>
          <input type="checkbox" id="dizzy" name="feelings" value="Dizzy">
          <label for="dizzy">Dizzy</label><br>
          <input type="checkbox" id="vomiting" name="feelings" value="Vomiting">
          <label for="vomiting">Vomiting</label><br>
          <input type="checkbox" id="diarrhea" name="feelings" value="Diarrhea">
          <label for="diarrhea">Diarrhea</label><br>
        </div>
        <input type="hidden" id="id_user" name="id_user" value="${loggedInUser.iduser}">
        <input type="hidden" id="date" name="date" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()) %>">
        <div class="submitBtnContainer">
         <input type="submit" class="button" value="Submit">
        </div>
    </form>
    <canvas id="painChart" width="800" height="400"></canvas>
    </div>
  <script>
var ctx = document.getElementById('painChart').getContext('2d');
var myChart;

// Initialize data arrays
var dates = [];
var painLevels = [];

<%
// Iterate through the painTrackList and populate JavaScript arrays
List<Beans.PainTrack> painTrackList = (List<Beans.PainTrack>) request.getAttribute("painTrackList");
if (painTrackList != null) {
    for (Beans.PainTrack painTrack : painTrackList) {
%>
    dates.push('<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(painTrack.getDate()) %>');
    painLevels.push(<%= painTrack.getPainSeverity() %>);
<%
    }
}
%>

// Log the arrays to the console for debugging
console.log("Dates:", dates);
console.log("Pain Levels:", painLevels);

// Create the chart
myChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: dates,
        datasets: [{
            label: 'Pain Evolution',
            data: painLevels,
            borderColor: 'rgba(75, 192, 192, 1)',
            borderWidth: 2,
            fill: false
        }]
    },
    options: {
        responsive: true,
        scales: {
            y: {
                suggestedMin: 0,
                suggestedMax: 10
            }
        }
    }
});
myChart2 = new Chart(ctx2, {
	  type: 'pie',
	  data: {
	    labels: ['Pain Worsen', 'Other'],
	    datasets: [{
	      data: pain_worsen,
	      backgroundColor: [
	        'rgba(255, 99, 132, 0.7)',
	        'rgba(54, 162, 235, 0.7)',
	        // Ajoutez plus de couleurs au besoin
	      ],
	      borderColor: [
	        'rgba(255, 99, 132, 1)',
	        'rgba(54, 162, 235, 1)',
	        // Ajoutez plus de couleurs au besoin
	      ],
	      borderWidth: 1
	    }]
	  }
	});

	myChart3 = new Chart(ctx3, {
	  type: 'pie',
	  data: {
	    labels: ['Pain Locations', 'Other'],
	    datasets: [{
	      data: pain_locations,
	      backgroundColor: [
	        'rgba(255, 99, 132, 0.7)',
	        'rgba(54, 162, 235, 0.7)',
	        // Ajoutez plus de couleurs au besoin
	      ],
	      borderColor: [
	        'rgba(255, 99, 132, 1)',
	        'rgba(54, 162, 235, 1)',
	        // Ajoutez plus de couleurs au besoin
	      ],
	      borderWidth: 1
	    }]
	  }
	});

</script>

<br><br><br><br><br><br><br><br>
<%@ include file="../home/links.jsp" %>
 <%@ include file="../home/footer.jsp" %>
</body>
</html>
