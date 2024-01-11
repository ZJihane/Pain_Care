package DAO.DAO_User;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;


import Beans.user;
import DAO.DAOException;
import DAO.DAOFactory;


@WebServlet("/GestionUsers")
public class GestionUsers extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserdaoImpl userDAO;

    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.userDAO = new UserdaoImpl(daoFactory);
    }

    public GestionUsers() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer tous les utilisateurs
        List<user> users = this.userDAO.getAllUsers();
        request.setAttribute("users", users);

        // Afficher la page de gestion des utilisateurs
        RequestDispatcher dispatcher = request.getRequestDispatcher("User/All_Users.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer tous les utilisateurs
        List<user> users = this.userDAO.getAllUsers();
        request.setAttribute("users", users);
        HttpSession session = request.getSession();

        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "delete":
                    // Supprimer un utilisateur
                    String userIdToDelete = request.getParameter("id_user");
                    if (userIdToDelete != null) {
                        int idUser = Integer.parseInt(userIdToDelete);
                        this.userDAO.delete(idUser);
                        users = this.userDAO.getAllUsers();
                        request.setAttribute("users", users);
                        RequestDispatcher dispatcher1 = request.getRequestDispatcher("User/All_Users.jsp");
                        dispatcher1.forward(request, response);
                    }
                    
                    break;

               


                case "add":
                    // Afficher la page d'ajout d'un nouvel utilisateur
                    RequestDispatcher addDispatcher = request.getRequestDispatcher("/User/CreateUser.jsp");
                    addDispatcher.forward(request, response);
                    break;

                case "create":
                    // Récupérer les données du formulaire
                    String nomUser = request.getParameter("nom_user");
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    int role = 1;

                    // Créer un nouvel objet utilisateur avec les données du formulaire
                    user newUser = new user();
                    newUser.setNomuser(nomUser);
                    newUser.setEmail(email);
                    newUser.setPassword(password);
                    newUser.setRole(role);

                    // Créer le nouvel utilisateur dans la base de données
                    try {
                        this.userDAO.create(newUser);

                        // Récupérer à nouveau la liste des utilisateurs après la création
                        List<user> users2 = this.userDAO.getAllUsers();
                        request.setAttribute("users", users2);

                        // Trouver le nouvel utilisateur créé
                        user createdUser = users2.stream()
                                .filter(u -> u.getEmail().equals(email))
                                .findFirst()
                                .orElse(null);

                        if (createdUser != null) {
                            // Définir un attribut pour le nouvel utilisateur créé
                            request.setAttribute("createdUser", createdUser);

                            // Rediriger vers la page appropriée, par exemple la page de l'utilisateur créé
                            RequestDispatcher createDispatcher = request.getRequestDispatcher("userapp/acceuil_user.jsp");
                            createDispatcher.forward(request, response);
                        } else {
                            // Gérer le cas où le nouvel utilisateur n'est pas trouvé
                            response.sendRedirect("error.jsp");
                        }
                    } catch (DAOException e) {
                        e.printStackTrace();
                        // Gérer l'exception, par exemple en définissant un attribut d'erreur
                        request.setAttribute("createError", true);

                        // Rediriger vers la page appropriée, par exemple la page d'erreur
                        RequestDispatcher createErrorDispatcher = request.getRequestDispatcher("error.jsp");
                        createErrorDispatcher.forward(request, response);
                    }
                    break;
                   

                case "update":
                    String updatedUserId = request.getParameter("id_user");
                    int idUser = Integer.parseInt(updatedUserId);
                    String updatedNomUser = request.getParameter("nom_user");
                    String updatedEmail = request.getParameter("email");
                    user updatedUser = new user();
                    updatedUser.setIduser(idUser);
                    updatedUser.setNomuser(updatedNomUser);
                    updatedUser.setEmail(updatedEmail);
                    this.userDAO.update(updatedUser);
                    request.setAttribute("loggedInUser",updatedUser);
                    
                    response.sendRedirect(request.getContextPath() + "/userapp/acceuil_user.jsp");
                    
                    break;
                       }
                    }
                   
              

                    

            
        
    }
}
