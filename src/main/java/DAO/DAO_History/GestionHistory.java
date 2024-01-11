package DAO.DAO_History;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import Beans.history;
import DAO.DAOException;
import DAO.DAOFactory;

@WebServlet("/GestionHistory")
public class GestionHistory extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HistoryDAO historyDAO;

    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.historyDAO = new HistoryDaoImpl(daoFactory);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<history> all_history = this.historyDAO.getAllHistories();
        request.setAttribute("all_history", all_history);
        RequestDispatcher dispatcher = request.getRequestDispatcher("history/All_history.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<history> all_history;

        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
            case "delete":
                String historyIdToDelete = request.getParameter("id_history");
                if (historyIdToDelete != null) {
                    int idHistory = Integer.parseInt(historyIdToDelete);
                    try {
                        this.historyDAO.delete(idHistory);
                        request.setAttribute("deleteSuccess", true);
                    } catch (DAOException e) {
                        e.printStackTrace();
                        request.setAttribute("deleteError", true);
                    }
                }
                // Récupérer la liste des histoires après la suppression
                all_history = this.historyDAO.getAllHistories();
                request.setAttribute("all_history", all_history);
                RequestDispatcher deleteDispatcher = request.getRequestDispatcher("history/All_history.jsp");
                deleteDispatcher.forward(request, response);
                break;


            case "add":
                RequestDispatcher addDispatcher = request.getRequestDispatcher("history/CreateHistory.jsp");
                addDispatcher.forward(request, response);
                break;


            case "update":
                String historyIdToUpdate = request.getParameter("id_history");
                if (historyIdToUpdate != null && !historyIdToUpdate.isEmpty()) {
                    int idHistory = Integer.parseInt(historyIdToUpdate);

                    // Récupérer les autres valeurs du formulaire
                    String updatedEndoHistory = request.getParameter("endo_history");
                    String updatedBirth = request.getParameter("birth");
                    String updatedPregnancyTroubles = request.getParameter("pregnancy_troubles");
                    String updatedUserId = request.getParameter("id_user");
                    String updatedSexualAbuse = request.getParameter("sexual_abuse");

                    // Vérifier que les autres paramètres ne sont pas nuls
                    if (updatedEndoHistory != null && updatedBirth != null && updatedPregnancyTroubles != null &&
                            updatedUserId != null && updatedSexualAbuse != null) {
                        // Convertir les chaînes en types appropriés (par exemple, endo_history en int, etc.)
                        // Assurez-vous de gérer les exceptions pour les conversions
                        int endoHistoryValue = Integer.parseInt(updatedEndoHistory);
                        
                        int birthValue = Integer.parseInt(updatedBirth);
                        int pregnancyTroublesValue = Integer.parseInt(updatedPregnancyTroubles);
                        int userIdValue = Integer.parseInt(updatedUserId);
                        int sexualAbuseValue = Integer.parseInt(updatedSexualAbuse);

                        // Créer un objet history avec les valeurs mises à jour
                        history updatedHistory = new history();
                        updatedHistory.setId_history(idHistory);
                        updatedHistory.setEndo_history(endoHistoryValue==1);
                        updatedHistory.setBirth(birthValue==1);
                        updatedHistory.setTrouble_pregnant(pregnancyTroublesValue==1);
                        updatedHistory.setId_user(userIdValue);
                        updatedHistory.setSexual_abuse(sexualAbuseValue==1);

                        try {
                            // Appeler la méthode update de votre DAO pour mettre à jour l'histoire
                            this.historyDAO.update(updatedHistory);
                            request.setAttribute("updateSuccess", true);
                        } catch (DAOException e) {
                            e.printStackTrace();
                            request.setAttribute("updateError", true);
                        }
                    }
                }

                // Obtenir à nouveau la liste des histoires après la mise à jour
                all_history = this.historyDAO.getAllHistories();
                request.setAttribute("all_history", all_history);
                RequestDispatcher updateDispatcher = request.getRequestDispatcher("history/All_history.jsp");
                updateDispatcher.forward(request, response);
                break;


            case "edit":
                // Gérer l'action d'édition
                String historyIdToEdit = request.getParameter("id_history");

                if (historyIdToEdit != null) {
                    int idHistory = Integer.parseInt(historyIdToEdit);
                    history historyToEdit = this.historyDAO.find(idHistory);

                    // Vérifier si l'histoire est trouvée
                    if (historyToEdit != null) {
                        // Récupérer les autres valeurs du formulaire
                        boolean updatedEndoHistory = historyToEdit.isEndo_history();
                        boolean updatedBirth = historyToEdit.isBirth();
                        boolean updatedPregnancyTroubles = historyToEdit.isTrouble_pregnant();
                        int updatedUserId = historyToEdit.getId_user();
                        boolean updatedSexualAbuse = historyToEdit.isSexual_abuse();

                        // Définir les valeurs mises à jour dans l'objet historyToEdit
                        int endoHistoryValue = updatedEndoHistory ? 1 : 0;
                        int birthValue = updatedBirth ? 1 : 0;
                        int pregnancyTroublesValue = updatedPregnancyTroubles ? 1 : 0;
                        int userIdValue = updatedUserId;
                        int sexualAbuseValue = updatedSexualAbuse ? 1 : 0;

                        // Définir les valeurs mises à jour dans l'objet historyToEdit
                        historyToEdit.setEndo_history(endoHistoryValue == 1);
                        historyToEdit.setBirth(birthValue == 1);
                        historyToEdit.setTrouble_pregnant(pregnancyTroublesValue == 1);
                        historyToEdit.setId_user(userIdValue);
                        historyToEdit.setSexual_abuse(sexualAbuseValue == 1);

                        request.setAttribute("historyToEdit", historyToEdit);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("history/update_history.jsp");
                        dispatcher.forward(request, response);
                    } else {
                        // Gérer le cas où l'histoire n'est pas trouvée
                        request.setAttribute("error", "History not found");
                        RequestDispatcher errorDispatcher = request.getRequestDispatcher("/error.jsp");
                        errorDispatcher.forward(request, response);
                    }
                }
                break;



            case "create":
                // Récupérer les paramètres du formulaire
                String endoHistoryString = request.getParameter("endo_history");
                String birthString = request.getParameter("birth");
                String pregnancyTroublesString = request.getParameter("pregnancy_troubles");
                String userIdString = request.getParameter("id_user");
                String sexualAbuseString = request.getParameter("sexual_abuse");

                // Valider et convertir les paramètres du formulaire en types appropriés
                try {
                    int endoHistory = Integer.parseInt(endoHistoryString);
                    
                    int birth = Integer.parseInt(birthString);
                    int pregnancyTroubles = Integer.parseInt(pregnancyTroublesString);
                    int userId = Integer.parseInt(userIdString);
                    int sexualAbuse = Integer.parseInt(sexualAbuseString);

                    // Créer un nouvel objet history
                    history newHistory = new history();
                    newHistory.setEndo_history(endoHistory == 1);
                    newHistory.setBirth(birth==1);
                    newHistory.setTrouble_pregnant(pregnancyTroubles==1);
                    newHistory.setId_user(userId);
                    newHistory.setSexual_abuse(sexualAbuse==1);

                    // Appeler la méthode create du DAO pour ajouter le nouvel historique
                    this.historyDAO.create(newHistory);

                    // Récupérer la liste des historiques après la création
                    all_history = this.historyDAO.getAllHistories();
                    request.setAttribute("histories", all_history);

                    // Rediriger vers la page JSP appropriée
                    RequestDispatcher createDispatcher = request.getRequestDispatcher("history/All_history.jsp");
                    createDispatcher.forward(request, response);
                } catch (NumberFormatException | DAOException e) {
                    e.printStackTrace(); // Gérer l'exception selon les besoins
                    request.setAttribute("createError", true);
                    // Vous voudrez peut-être rediriger vers une page d'erreur ou le traiter différemment
                }
                break;

            }
        }
    }
}
