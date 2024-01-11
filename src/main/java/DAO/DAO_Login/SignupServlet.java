package DAO.DAO_Login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import Beans.user;
import DAO.DAOException;
import DAO.DAOFactory;
import DAO.DAO_User.*;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserdaoImpl userDAO;

    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.userDAO = new UserdaoImpl(daoFactory);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nomUser = request.getParameter("nom_user");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int role = 1;

        // Create a new user object with the form data
        user newUser = new user();
        newUser.setNomuser(nomUser);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setRole(role);

        try {
            // Create the new user in the database
            this.userDAO.create(newUser);

            // Get the list of users after creation
            List<user> users = this.userDAO.getAllUsers();
            request.setAttribute("users", users);

            // Find the newly created user
            user createdUser = users.stream()
                    .filter(u -> u.getEmail().equals(email))
                    .findFirst()
                    .orElse(null);

            if (createdUser != null) {
                // Set an attribute for the newly created user
                request.setAttribute("createdUser", createdUser);

                // Redirect to the appropriate page, e.g., the created user's page
                response.sendRedirect(request.getContextPath() + "/home/login.jsp");
            } else {
                // Handle the case where the newly created user is not found
                response.sendRedirect("error.jsp");
            }
        } catch (DAOException e) {
            e.printStackTrace();
            // Handle the exception, e.g., set an error attribute

            // Redirect to the appropriate page, e.g., the error page
            RequestDispatcher createErrorDispatcher = request.getRequestDispatcher("error.jsp");
            createErrorDispatcher.forward(request, response);
        }
    }
}
