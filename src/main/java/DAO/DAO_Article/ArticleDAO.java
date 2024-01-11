package DAO.DAO_Article;


import Beans.article;
import DAO.DAOException;


import java.util.List;

public interface ArticleDAO  {

    public List<article> getAllarticles() throws DAOException ;
    public article getArticleById(int recetteId) ;

    
}
