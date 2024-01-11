package DAO.DAO_User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.user;
import DAO.DAOException;
import DAO.DAOFactory;
import jakarta.servlet.http.HttpServletRequest;

public class UserdaoImpl implements UserDAO {

    private DAOFactory daoFactory;

    public UserdaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public List<user> getAllUsers() {
        final String SQL_SELECT_ALL = "SELECT id_user, nom_user, role, email, password FROM user";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        user user = null;
        List<user> allUsers = new ArrayList<user>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initRequestPrepare(connection, SQL_SELECT_ALL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = map(resultSet);
                allUsers.add(user);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            // ClosingAll(resultSet, preparedStatement, connection);
        }

        return allUsers;
    }


    private static user map(ResultSet resultSet) throws SQLException {
        user user = new user();
        user.setIduser(resultSet.getInt("id_user"));
        user.setNomuser(resultSet.getString("nom_user"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setRole(resultSet.getInt("role"));
        return user;
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
	public void create(user user) {
		  final String SQL_INSERT = "INSERT INTO user (nom_user,email,password,role) VALUES (?, ?, ?, ?)";
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            connection = daoFactory.getConnection();
	            preparedStatement = initRequestPrepare(connection, SQL_INSERT,
	            		user.getNomuser(),
	                    user.getEmail(),
	                    user.getPassword(),
	                    user.getRole()
	                   
	            );
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            throw new DAOException(e);
	        } finally {
	            // ClosingAll(preparedStatement, connection);
	        }
		
	}
    @Override
    public void delete(int idUser) throws DAOException {
        final String SQL_DELETE = "DELETE FROM user WHERE id_user=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initRequestPrepare(connection, SQL_DELETE, idUser);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            // ClosingAll(preparedStatement, connection);
        }
    }
    
    @Override
    public void update(user user) throws DAOException {
        final String SQL_UPDATE = "UPDATE user SET nom_user=?, email=? WHERE id_user=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initRequestPrepare(connection, SQL_UPDATE,
                user.getNomuser(),
                user.getEmail(),
                user.getIduser()  // Ajoutez cette ligne pour fournir la valeur pour id_user
            );
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeResources(preparedStatement, connection);
        }
    }

    @Override
    public user edit(int idUser) throws DAOException {
        final String SQL_SELECT_PAR_ID = "SELECT id_user, nom_user, email, password, role FROM user WHERE id_user=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        user user = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initRequestPrepare(connection, SQL_SELECT_PAR_ID, idUser);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            // ClosingAll(resultSet, preparedStatement, connection);
        }

        return user;
    }

    @Override
    public user find(int idUser) throws DAOException {
        final String SQL_SELECT_PAR_ID = "SELECT id_user, nom_user, email, password, role FROM user WHERE id_user=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        user user = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initRequestPrepare(connection, SQL_SELECT_PAR_ID, idUser);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            // Gérer la fermeture des ressources ici si nécessaire
        }

        return user;
    }
    private void closeResources(AutoCloseable... resources) {
        for (AutoCloseable resource : resources) {
            if (resource != null) {
                try {
                    resource.close();
                } catch (Exception e) {
                    // Vous pouvez ajuster la gestion de l'exception en fonction de vos besoins.
                    // Par exemple, vous pouvez journaliser l'exception ou la propager.
                    e.printStackTrace();
                }
            }
        }
    }

	
   


    

}
