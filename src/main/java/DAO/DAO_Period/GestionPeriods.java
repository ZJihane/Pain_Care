package DAO.DAO_Period;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Date;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import Beans.period;
import Beans.period ;
import DAO.DAOException;
import DAO.DAOFactory; 
@WebServlet("/GestionPeriods")
public class GestionPeriods extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PeriodDAO periodDAO;

    public void init() throws ServletException {
            DAOFactory daoFactory = DAOFactory.getInstance();
            this.periodDAO = new PeriodDaoImpl(daoFactory);
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            List<period> periods = this.periodDAO.getAllPeriods();
            request.setAttribute("periods", periods);
            RequestDispatcher dispatcher2 = request.getRequestDispatcher("Period/period.jsp");
            dispatcher2.forward(request, response); 
            } 
        
   

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
            List<period> periods;

            String action = request.getParameter("action");

            if (action != null) {
                switch (action) {
                    case "delete":
                        String periodIdToDelete = request.getParameter("id_period");
                        if (periodIdToDelete != null) {
                            int idPeriod = Integer.parseInt(periodIdToDelete);
                            this.periodDAO.delete(idPeriod);
                            periods = this.periodDAO.getAllPeriods();
                            request.setAttribute("periods", periods);
                            RequestDispatcher dispatcher1 = request.getRequestDispatcher("Period/period.jsp");
                            dispatcher1.forward(request, response);
                        }
                        break;

                    case "add":
                        RequestDispatcher addDispatcher = request.getRequestDispatcher("Period/formPeriod.jsp");
                        addDispatcher.forward(request, response);
                        break;
                        
                        

                    case "update":
                        String periodIdToUpdate = request.getParameter("id_period");
                        if (periodIdToUpdate != null && !periodIdToUpdate.isEmpty()) {
                            int idPeriod = Integer.parseInt(periodIdToUpdate);

                            // Vérifiez et récupérez les autres paramètres du formulaire
                            String updatedFirstPeriod = request.getParameter("first_period");
                            String updatedCycleLength = request.getParameter("cycle_length");
                            String updatedPeriodDuration = request.getParameter("period_duration");
                            String updatedNaturePeriod = request.getParameter("nature_period");
                            String updatedPeriodPattern = request.getParameter("period_pattern");
                            String updatedUserId = request.getParameter("id_user");

                            // Vérifiez que les autres paramètres ne sont pas null
                            if (updatedFirstPeriod != null && updatedCycleLength != null && updatedPeriodDuration != null &&
                                updatedNaturePeriod != null && updatedPeriodPattern != null && updatedUserId != null) {
                                // Convertissez les chaînes en types appropriés (par exemple, cycle_length en int, etc.)
                                // Assurez-vous également de gérer les exceptions pour les conversions
                                int firstPeriodValue = Integer.parseInt(updatedFirstPeriod);
                                int cycleLengthValue = Integer.parseInt(updatedCycleLength);
                                int periodDurationValue = Integer.parseInt(updatedPeriodDuration);
                                int userIdValue = Integer.parseInt(updatedUserId);

                                // Créez un objet Period avec les valeurs mises à jour
                                period updatedPeriod = new period();
                                updatedPeriod.setId_period(idPeriod);
                                updatedPeriod.setFirst_period(firstPeriodValue);
                                updatedPeriod.setCycle_length(cycleLengthValue);
                                updatedPeriod.setPeriod_duration(periodDurationValue);
                                updatedPeriod.setNature_period(updatedNaturePeriod);
                                updatedPeriod.setPeriod_pattern(updatedPeriodPattern);
                                updatedPeriod.setId_user(userIdValue);

                                try {
                                    // Appelez votre méthode update du DAO pour mettre à jour la période
                                    this.periodDAO.update(updatedPeriod);
                                    request.setAttribute("updateSuccess", true);
                                } catch (DAOException e) {
                                    e.printStackTrace();
                                    // Gérer l'exception, par exemple en définissant un attribut d'erreur
                                    request.setAttribute("updateError", true);
                                }
                            }
                        }

                        // Récupérez à nouveau la liste des périodes après la mise à jour
                        List<period> periods2 = this.periodDAO.getAllPeriods();
                        request.setAttribute("periods", periods2);
                        RequestDispatcher updateDispatcher = request.getRequestDispatcher("Period/period.jsp");
                        updateDispatcher.forward(request, response);
                        break;

                        
                        
                        
                    case "edit":
                        // Handle the edit action
                        String periodIdToEdit = request.getParameter("id_period");

                        if (periodIdToEdit != null) {
                            int idPeriod = Integer.parseInt(periodIdToEdit);
                            period periodToEdit = this.periodDAO.find(idPeriod);

                            // Check if the period is found
                            if (periodToEdit != null) {
                                // Retrieve other form values
                            	int updatedFirst_period = periodToEdit.getFirst_period();
                            	int updatedCycle_length = periodToEdit.getCycle_length();
                            	int updatedPeriod_duration = periodToEdit.getPeriod_duration();
                            	String updatedNature_period = periodToEdit.getNature_period();
                            	String updatedPeriod_pattern = periodToEdit.getPeriod_pattern();
                            	int updatedUserId = periodToEdit.getId_user();

                                // Set updated values in the periodToEdit object
                                periodToEdit.setFirst_period(updatedFirst_period);
                                periodToEdit.setCycle_length(updatedCycle_length);
                                periodToEdit.setPeriod_duration(updatedPeriod_duration);
                                periodToEdit.setNature_period(updatedNature_period);
                                periodToEdit.setPeriod_pattern(updatedPeriod_pattern);
                                periodToEdit.setId_user(updatedUserId);

                                request.setAttribute("periodToEdit", periodToEdit);
                                RequestDispatcher dispatcher = request.getRequestDispatcher("Period/updatePeriod.jsp");
                                dispatcher.forward(request, response);
                            } else {
                                // Handle the case where the period is not found
                                request.setAttribute("error", "period not found");
                                RequestDispatcher errorDispatcher = request.getRequestDispatcher("/error.jsp");
                                errorDispatcher.forward(request, response);
                            }
                        }
                        break;


                    case "create":
                        String periodId = request.getParameter("id_period");
                        String first_period = request.getParameter("first_period");
                        int first_periodValue = 0; // Valeur par défaut
                        try {
                            first_periodValue = Integer.parseInt(first_period);
                        } catch (NumberFormatException e) {
                            // Handle conversion failure
                            request.setAttribute("error", "Invalid ");
                            RequestDispatcher errorDispatcher = request.getRequestDispatcher("/error.jsp");
                            errorDispatcher.forward(request, response);
                            return;
                        }
                            
                        String cycle_length = request.getParameter("cycle_length");
                        int cycle_lengthValue = 0; // Valeur par défaut
                        try {
                            cycle_lengthValue = Integer.parseInt(cycle_length);
                        } catch (NumberFormatException e) {
                            // Handle conversion failure
                            request.setAttribute("error", "Invalid ");
                            RequestDispatcher errorDispatcher = request.getRequestDispatcher("/error.jsp");
                            errorDispatcher.forward(request, response);
                            return;
                        }
                                
                        String period_duration = request.getParameter("period_duration");
                        int period_durationValue = 0; // Valeur par défaut
                        try {
                            period_durationValue = Integer.parseInt(period_duration);
                        } catch (NumberFormatException e) {
                            // Handle conversion failure
                            request.setAttribute("error", "Invalid ");
                            RequestDispatcher errorDispatcher = request.getRequestDispatcher("/error.jsp");
                            errorDispatcher.forward(request, response);
                            return;
                        }
                        String nature_period = request.getParameter("nature_period");
                        String period_pattern = request.getParameter("period_pattern");
                   
                        String userIdString = request.getParameter("id_user");
                        int userId = 0;
                        try {
                            userId = Integer.parseInt(userIdString);
                        } catch (NumberFormatException e) {
                            // Handle conversion failure
                            request.setAttribute("error", "Invalid user ID");
                            RequestDispatcher errorDispatcher = request.getRequestDispatcher("/error.jsp");
                            errorDispatcher.forward(request, response);
                            return;
                        }

                        period period = new period();
                        period.setFirst_period(first_periodValue);
                        period.setCycle_length(cycle_lengthValue);
                        period.setPeriod_duration(period_durationValue);
                        period.setNature_period(nature_period);
                        period.setPeriod_pattern(period_pattern);
                        period.setId_user(userId);
                      
   

                        if (periodId != null && !periodId.isEmpty()) {
                            // Update existing period
                            period.setId_period(Integer.parseInt(periodId));
                            this.periodDAO.update(period);
                        } else {
                            // Add new period
                            this.periodDAO.create(period);
                        }

                        periods = this.periodDAO.getAllPeriods();
                        request.setAttribute("periods", periods);
                        RequestDispatcher saveDispatcher = request.getRequestDispatcher("Period/period.jsp");
                        saveDispatcher.forward(request, response);
                        break;
                }
            }

        
    }
}
