package DAO.DAO_Login;

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
import DAO.DAO_User.UserDAO;
import DAO.DAO_User.UserdaoImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserDAO userDAO;

    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.userDAO = new UserdaoImpl(daoFactory);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            List<user> users = userDAO.getAllUsers();

            for (user currentUser : users) {
                if (currentUser.getEmail().equals(email) && currentUser.getPassword().equals(password)) {
                    // Set the logged-in user in the session
                    HttpSession session = request.getSession();
                    session.setAttribute("loggedInUser", currentUser);

                    // Redirect to the user's home page
                    response.sendRedirect(request.getContextPath() + "/userapp/acceuil_user.jsp");
                    return;
                }
            }

            // Authentication failed, redirect back to the login page with an error parameter
            response.sendRedirect(request.getContextPath() + "/home/login.jsp?error=true");
        } catch (DAOException e) {
            // Handle DAOException, e.g., log the exception
            response.sendRedirect(request.getContextPath() + "/home/login.jsp?error=true");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirect to the login page for GET requests
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home/login.jsp");
        dispatcher.forward(request, response);
    }
}
