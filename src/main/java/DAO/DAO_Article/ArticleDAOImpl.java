package DAO.DAO_Article;

import Beans.article;
import DAO.DAOException;
import DAO.DAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAOImpl implements ArticleDAO {

    private DAOFactory daoFactory;

    // Constructeur
    public ArticleDAOImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public List<article> getAllarticles() throws DAOException {
        final String SQL_SELECT_ALL = "SELECT id_article, titre, description, picture FROM article";

        List<article> articleList = new ArrayList<>();

        try (
                Connection connection = daoFactory.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);
                ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            while (resultSet.next()) {
                article article = map(resultSet);
                articleList.add(article);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur lors de la récupération des articles", e);
        }

        return articleList;
    }

    @Override
    public article getArticleById(int articleId) throws DAOException {
        final String SQL_SELECT_BY_ID = "SELECT id_article, titre, description, picture FROM article WHERE id_article = ?";

        try ( 
        		Connection connection = daoFactory.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID)
        ) {
            preparedStatement.setInt(1, articleId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return map(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur lors de la récupération de l'article par ID", e);
        }

        return null; // Retourne null si aucun article correspondant n'est trouvé
    }

    private static article map(ResultSet resultSet) throws SQLException {
        article article = new article();
        article.setId_article(resultSet.getInt("id_article"));
        article.setNom(resultSet.getString("titre"));
        article.setDescription(resultSet.getString("description"));
        article.setPicture(resultSet.getBytes("picture"));
        
        return article;
    }
}
