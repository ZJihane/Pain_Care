package DAO.DAO_Article;

import Beans.article;
import DAO.DAOException;
import DAO.DAOFactory;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/articleServlet")
@MultipartConfig
public class articleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ArticleDAO articleDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        // Assuming you have a DAOFactory class to create DAO instances
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.articleDAO = new ArticleDAOImpl(daoFactory);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "view":
                    viewArticles(request, response);
                    break;
                case "viewDetails":
                    viewArticleWithDetails(request, response);
                    break;
                default:
                    viewArticles(request, response);
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/articleServlet?action=view");
        }
    }

    private void viewArticles(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<article> allArticles = articleDAO.getAllarticles();

            // Convert pictures to Base64
            for (article article : allArticles) {
                byte[] pictureData = article.getPicture();
                if (pictureData != null) {
                    String pictureBase64 = Base64.getEncoder().encodeToString(pictureData);
                    article.setPictureBase64(pictureBase64);
                } else {
                    article.setPictureBase64("");
                }
            }

            request.setAttribute("allArticles", allArticles);
        } catch (DAOException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("article/article-1.jsp").forward(request, response);
    }

    private void viewArticleWithDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int articleId = Integer.parseInt(request.getParameter("articleId"));
            article article = articleDAO.getArticleById(articleId);

            if (article != null) {
                String pictureBase64 = Base64.getEncoder().encodeToString(article.getPicture());
                article.setPictureBase64(pictureBase64);

                request.setAttribute("article", article);
                request.getRequestDispatcher("article/articleDetails.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/articleServlet?action=view");
            }
        } catch (DAOException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/articleServlet?action=view");
        }
    }
}
