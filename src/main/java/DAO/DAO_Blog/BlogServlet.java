package DAO.DAO_Blog;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

import Beans.Blog;
import Beans.user;
import DAO.DAOException;
import DAO.DAOFactory;
import DAO.DAO_User.UserDAO;
import DAO.DAO_User.UserdaoImpl;

@WebServlet("/blogServlet")
@MultipartConfig // To handle requests with files (Part)
public class BlogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BlogDAO blogDAO;
	private UserdaoImpl userDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        // Assuming you have a DAOFactory class to create DAO instances
       
        
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.blogDAO = new BlogDaoImpl(daoFactory);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "view":
                    viewBlog(request, response);
                    break;
                case "create":
                    showCreateForm(request, response);
                    break;
                case "delete":
                    deleteBlog(request, response);
                    break;
                case "viewDetails":
                    viewBlogWithComments(request, response);
                    break;
                default:
                    viewBlog(request, response);
            }
        } else {
            // Handle the case when action is null, e.g., redirect to a default page
            response.sendRedirect(request.getContextPath() + "/blogServlet?action=view");
        }
    }


    
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
       
        String action = request.getParameter("action");

      
           if ("create".equals(action)) {
            createBlog(request, response);
        }else if ("delete".equals(action)) {
        	deleteBlog(request, response );
        }
}

	private void createBlog(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    String title = request.getParameter("title");
	    String description = request.getParameter("description");
	    Part picturePart = request.getPart("picture");
	    String id_user = request.getParameter("id_user");
	    int user_id = (id_user != null) ? Integer.parseInt(id_user) : 5;

	    DAOFactory daoFactory = DAOFactory.getInstance();
        this.userDAO = new UserdaoImpl(daoFactory);
        
		List<user> users = userDAO.getAllUsers();
	    String nom_user = ""; // Initialize nom_user

	    for (user user_data : users) {
	        if (user_id == user_data.getIduser()) {
	            nom_user = user_data.getNomuser();
	            break; // Break out of the loop once the user is found
	        }
	    }

	    // Check if nom_user is not empty before creating the new blog
	    if (!nom_user.isEmpty()) {
	        Blog newBlog = new Blog();
	        newBlog.setTitle(title);
	        newBlog.setDescription(description);
	        newBlog.setUser_id(user_id);
	        newBlog.setUser_nom(nom_user);

	        if (picturePart != null && picturePart.getSize() > 0) {
	            byte[] pictureBytes = new byte[(int) picturePart.getSize()];
	            picturePart.getInputStream().read(pictureBytes);
	            newBlog.setPicture(pictureBytes);
	        }

	        blogDAO.addBlog(newBlog);

	        response.sendRedirect(request.getContextPath() + "/blogServlet?action=viewAll");
	    } else {
	        // Handle the case where the user is not found
	        // You can redirect to an error page or handle it based on your requirements
	        response.sendRedirect(request.getContextPath() + "/errorPage.jsp");
	    }
	}

    
    
    private void viewBlog(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Blog> allBlogs = blogDAO.getAllBlogs();

            // Convert pictures to Base64
            for (Blog blog : allBlogs) {
                byte[] pictureData = blog.getPicture();
                if (pictureData != null) {
                    String pictureBase64 = Base64.getEncoder().encodeToString(pictureData);
                    blog.setPictureBase64(pictureBase64);
                } else {
                    blog.setPictureBase64(""); // Set an empty string or handle it according to your needs
                }
            }

            request.setAttribute("allBlogs", allBlogs);
        } catch (DAOException e) {
            e.printStackTrace();
        }
     
        request.getRequestDispatcher("blog/blog-1.jsp").forward(request, response);
    }
    
    

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("blog/create_blog.jsp").forward(request, response);
}

    private void deleteBlog(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Inside deleteBlog method");

        String blogIdParameter = request.getParameter("blogId");
        System.out.println("blogIdParameter: " + blogIdParameter);

        if (blogIdParameter != null && !blogIdParameter.isEmpty()) {
            int blogId = Integer.parseInt(blogIdParameter);
            System.out.println("Deleting blog with ID: " + blogId);

            try {
                // Supprimer le blog directement
                blogDAO.deleteBlog(blogId);
                System.out.println("Blog deleted successfully");
            } catch (DAOException e) {
                e.printStackTrace();
                System.out.println("Exception occurred");
                // Handle exception or log it
            }
        } else {
            System.out.println("blogId is null or empty");
        }

   

        response.sendRedirect(request.getContextPath() + "/blogServlet?action=view");
    }
    
   


private void viewBlogWithComments(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Récupérer l'ID du blog à partir des paramètres de la requête
            int blogId = Integer.parseInt(request.getParameter("blogId"));

            // Récupérer les détails du blog
            Blog blog = blogDAO.getBlogById(blogId);

            if (blog != null) {
                // Convertir l'image en Base64
                String pictureBase64 = Base64.getEncoder().encodeToString(blog.getPicture());
                blog.setPictureBase64(pictureBase64);


                // Définir les attributs dans la requête
                request.setAttribute("blog", blog);
               
               

                // Transférer la requête à la page JSP pour afficher la vue détaillée
                request.getRequestDispatcher("blog/blogDetails.jsp").forward(request, response);
            } else {
                // Gérer le cas où le blog n'est pas trouvé
                response.sendRedirect(request.getContextPath() + "/blogServlet?action=view");
            }
        } catch (DAOException e) {
            e.printStackTrace();
            // Gérer l'exception ou la journaliser
            response.sendRedirect(request.getContextPath() + "/blogServlet?action=view");
        }
    }

    
    




   


}
