package DAO.DAO_Recette;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util.Base64;
import java.util.List;

import Beans.recette;

import DAO.DAOException;
import DAO.DAOFactory;

@WebServlet("/recetteServlet")
@MultipartConfig // To handle requests with files (Part)
public class recetteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RecetteDAO recetteDAO;


    @Override
    public void init() throws ServletException {
        super.init();
        // Assuming you have a DAOFactory class to create DAO instances
       
        
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.recetteDAO = new RecetteDAOImpl(daoFactory);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "view":
                    viewRecette(request, response);
                    break;
                
              
                case "viewDetails":
                    viewRecetteWithComments(request, response);
                    break;
                default:
                    viewRecette(request, response);
            }
        } else {
            // Handle the case when action is null, e.g., redirect to a default page
            response.sendRedirect(request.getContextPath() + "/recetteServlet?action=view");
        }
    }


    
	

	

	 
    
    
    private void viewRecette(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<recette> allRecettes = recetteDAO.getAllRecettes();

            // Convert pictures to Base64
            for (recette recette : allRecettes) {
                byte[] pictureData = recette.getPicture();
                if (pictureData != null) {
                    String pictureBase64 = Base64.getEncoder().encodeToString(pictureData);
                    recette.setPictureBase64(pictureBase64);
                } else {
                    recette.setPictureBase64(""); // Set an empty string or handle it according to your needs
                }
            }

            request.setAttribute("allRecettes", allRecettes);
        } catch (DAOException e) {
            e.printStackTrace();
        }
     
        request.getRequestDispatcher("recette/recette-1.jsp").forward(request, response);
    }
    
    

 
    
   


private void viewRecetteWithComments(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Récupérer l'ID du recette à partir des paramètres de la requête
            int recetteId = Integer.parseInt(request.getParameter("recetteId"));

            // Récupérer les détails du recette
            recette recette = recetteDAO.getRecetteById(recetteId);

            if (recette != null) {
                // Convertir l'image en Base64
                String pictureBase64 = Base64.getEncoder().encodeToString(recette.getPicture());
                recette.setPictureBase64(pictureBase64);


                // Définir les attributs dans la requête
                request.setAttribute("recette", recette);
               
               

                // Transférer la requête à la page JSP pour afficher la vue détaillée
                request.getRequestDispatcher("recette/recetteDetails.jsp").forward(request, response);
            } else {
                // Gérer le cas où le recette n'est pas trouvé
                response.sendRedirect(request.getContextPath() + "/recetteServlet?action=view");
            }
        } catch (DAOException e) {
            e.printStackTrace();
            // Gérer l'exception ou la journaliser
            response.sendRedirect(request.getContextPath() + "/recetteServlet?action=view");
        }
    }

    
    




   


}
