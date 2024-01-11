package DAO.DAO_Blog;

import Beans.Blog;
import DAO.DAOException;
import DAO.DAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogDaoImpl implements BlogDAO {

    private DAOFactory daoFactory;

    // Constructor
    public BlogDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    private static Blog map(ResultSet resultSet) throws SQLException {
        Blog blog = new Blog();
        blog.setBlogId(resultSet.getInt("id_blog"));
        blog.setTitle(resultSet.getString("title"));
        blog.setDescription(resultSet.getString("description"));
        blog.setPicture(resultSet.getBytes("picture"));
        blog.setPublicationDate(resultSet.getTimestamp("publicationDate"));
        blog.setUser_id(resultSet.getInt("id_user"));
        blog.setUser_nom(resultSet.getString("nom_user"));
        return blog;
    }

    @Override
    public void addBlog(Blog blog) throws DAOException {
        // Vérifier si l'utilisateur existe et si la contrainte de clé étrangère est respectée
        final String SQL_INSERT = "INSERT INTO blog (title, description, picture, publicationDate, id_user,nom_user) VALUES (?, ?, ?, ?, ?,?)";
        try (
                Connection connection = daoFactory.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setString(1, blog.getTitle());
            preparedStatement.setString(2, blog.getDescription());
            preparedStatement.setBytes(3, blog.getPicture());

            // Check if publicationDate is not null before setting it in the PreparedStatement
            if (blog.getPublicationDate() != null) {
                preparedStatement.setTimestamp(4, new Timestamp(blog.getPublicationDate().getTime()));
            } else {
                // Set publicationDate to the current date if it's null
                preparedStatement.setTimestamp(4, new Timestamp(new Date().getTime()));
            }

            preparedStatement.setLong(5, blog.getUser_id());
            preparedStatement.setString(6, blog.getUser_nom());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating blog failed, no rows affected.");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    blog.setBlogId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating blog failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }



    @Override
    public Blog getBlogById(int blogId) throws DAOException {
    	final String SQL_SELECT_BY_ID = "SELECT * FROM blog WHERE id_blog = ?";


        try (
                Connection connection = daoFactory.getConnection();
                PreparedStatement preparedStatement = initRequestPrepare(connection, SQL_SELECT_BY_ID, blogId);
                ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            if (resultSet.next()) {
                return map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return null;
    }

   

    @Override
    public void deleteBlog(int blogId) throws DAOException {
        final String SQL_DELETE = "DELETE FROM blog WHERE id_blog = ?";

        try (
                Connection connection = daoFactory.getConnection();
                PreparedStatement preparedStatement = initRequestPrepare(connection, SQL_DELETE, blogId)
        ) {
            preparedStatement.executeUpdate();
            System.out.println("Blog deleted successfully");
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    private static PreparedStatement initRequestPrepare(Connection connection, String sql, Object... objects)
            throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < objects.length; i++) {
            preparedStatement.setObject(i + 1, objects[i]);
        }
        return preparedStatement;
    }

    @Override
    public List<Blog> getAllBlogs() throws DAOException {
        final String SQL_SELECT_ALL = "select * from blog" ;

        List<Blog> blogList = new ArrayList<>();

        try (
                Connection connection = daoFactory.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);
                ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            while (resultSet.next()) {
                Blog blog = map(resultSet);
                blogList.add(blog);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return blogList;
    }
}
