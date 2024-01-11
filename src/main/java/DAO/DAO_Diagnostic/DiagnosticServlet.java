package DAO.DAO_Diagnostic;
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Beans.period ;
import DAO.DAOFactory;
import DAO.DAO_History.HistoryDAO;
import DAO.DAO_History.HistoryDaoImpl;
import DAO.DAO_Pain.PainDAO;
import DAO.DAO_Pain.PainDaoImpl;
import DAO.DAO_Period.PeriodDAO;
import DAO.DAO_Period.PeriodDaoImpl;
import Beans.diagnostic ;
import Beans.history;
import Beans.pain;

@WebServlet("/DiagnosticServlet")
public class DiagnosticServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private PeriodDAO periodDAO;
    private DiagnosticDAO diagnosticDAO;
    private PainDAO painDAO;
    private HistoryDAO historyDAO;

    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.periodDAO = new PeriodDaoImpl(daoFactory);
        this.diagnosticDAO = new DiagnosticDaoImpl(daoFactory);
        this.painDAO = new PainDaoImpl(daoFactory);
        this.historyDAO = new HistoryDaoImpl(daoFactory);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            if (action != null) {
                switch (action) {
                    case "create":
                    	int id_user = Integer.parseInt(request.getParameter("id_user"));
                        createDiagnostic(request, response, id_user);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/diagnostic/Diagnostic_result.jsp");
                        dispatcher.forward(request, response);
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Gérer les erreurs, rediriger vers une page d'erreur, etc.
        }
    }

    private void createDiagnostic(HttpServletRequest request, HttpServletResponse response , int id_user) throws IOException {
        try {
       
            int first_period = Integer.parseInt(request.getParameter("first_period"));
            int cycle_length = Integer.parseInt(request.getParameter("cycle_length"));
            int period_duration = Integer.parseInt(request.getParameter("period_duration"));
            String nature_period = request.getParameter("nature_period");
            String period_pattern = request.getParameter("period_pattern");
            int id_user_period = id_user; // Utiliser le même ID utilisateur pour la cohérence

            // Créer un objet Period
            period period = new period();
            period.setFirst_period(first_period);
            period.setCycle_length(cycle_length);
            period.setPeriod_duration(period_duration);
            period.setNature_period(nature_period);
            period.setPeriod_pattern(period_pattern);
            period.setId_user(id_user_period);

            // Appeler la fonction pour créer la période dans la base de données
           
            periodDAO.create(period);

            // Récupérer les données du formulaire pour l'objet Pain
            String[] pain_trigger = request.getParameterValues("pain_trigger[]");
            boolean pain_rapport = "true".equals(request.getParameter("pain_rapport"));
            int severity_pain = Integer.parseInt(request.getParameter("severity_pain"));
            String other_symptom = request.getParameter("other_symptom");
            int id_user_pain = id_user; // Utiliser le même ID utilisateur pour la cohérence

            
            pain pain = new pain();
            pain.setPain_trigger(pain_trigger);
            pain.setPain_rapport(pain_rapport);
            pain.setSeverity_pain(severity_pain);
            pain.setOther_symptom(other_symptom);
            pain.setId_user(id_user_pain);

           
            painDAO.create(pain);

            // Récupérer les données du formulaire pour l'objet History
            boolean endo_history = "on".equals(request.getParameter("endo_history"));
            boolean birth = "on".equals(request.getParameter("birth"));
            boolean trouble_pregnant = "on".equals(request.getParameter("trouble_pregnant"));
            boolean sexual_abuse = "on".equals(request.getParameter("sexual_abuse"));
            int id_user_history = id_user; // Utiliser le même ID utilisateur pour la cohérence

            // Créer un objet History
            history history = new history();
            history.setEndo_history(endo_history);
            history.setBirth(birth);
            history.setTrouble_pregnant(trouble_pregnant);
            history.setSexual_abuse(sexual_abuse);
            history.setId_user(id_user_history);

            
            historyDAO.create(history);
            
            double totalScore = 0;

            // Critère 1 : Difficulté à concevoir
            if (history.isTrouble_pregnant()) {
                totalScore += 5;
            }

            // Critère 2 : Age au Premier Cycle Menstruel
            int firstPeriod = period.getFirst_period();
            if (firstPeriod < 11) {
                totalScore += 3;
            } else if (firstPeriod > 16) {
                totalScore += 2;
            }

            // Critère 3 : Intensité des douleurs abdominales
            int painSeverity = pain.getSeverity_pain();
            if (painSeverity >= 7) {
                totalScore += 4;
            } else if (painSeverity >= 5) {
                totalScore += 2;
            }

            // Critère 4 : Durée du Cycle
            int cycleLength = period.getCycle_length();
            if (cycleLength < 27) {
                totalScore += 4;
            }

            // Critère 5 : Douleur lors des Rapports Sexuels
            if (pain.isPain_rapport()) {
                totalScore += 4;
            }
            
            double weight = Double.parseDouble(request.getParameter("weight"));
            double height = Double.parseDouble(request.getParameter("height"));
            

            // Créer un objet Diagnostic
            diagnostic diagnostic = new diagnostic();
            diagnostic.setWeight(weight);
            diagnostic.setHeight(height);
            diagnostic.setId_user(id_user);
            
            diagnostic.setResultat(totalScore);
            diagnosticDAO.create(diagnostic);
 
            int lowRiskThreshold = 8;
            int moderateRiskThreshold = 15;

            String Risk ;
            if (totalScore < lowRiskThreshold) {
                Risk="LOW";
            } else if (totalScore < moderateRiskThreshold) {
                 Risk="MODERATE";
            } else {
               Risk="HIGH";
            }
            request.setAttribute("pain", pain);
            request.setAttribute("period", period);
            request.setAttribute("diagnostic", diagnostic);
            request.setAttribute("history", history);
            request.setAttribute("riskLevel", Risk);

          
            
           
        

        } catch (Exception e) {
            e.printStackTrace();
            // Gérer les erreurs, rediriger vers une page d'erreur, etc.
        }
    }
}
