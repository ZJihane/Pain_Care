package DAO.DAO_History;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.history;
import DAO.DAOException;
import DAO.DAOFactory;

public class HistoryDaoImpl implements HistoryDAO {

    private DAOFactory daoFactory;

    public HistoryDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void create(history history) throws DAOException {
        final String SQL_INSERT = "INSERT INTO history (endo_history, birth, pregnancy_troubles, id_user, sexual_abuse) VALUES (?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement(connection, SQL_INSERT,
                    history.isEndo_history(),
                    history.isBirth(),
                    history.isTrouble_pregnant(),
                    history.getId_user(),
                    history.isSexual_abuse()
            );
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeResources(preparedStatement, connection);
        }
    }

    @Override
    public history find(int id_history) throws DAOException {
        final String SQL_SELECT_BY_ID = "SELECT * FROM history WHERE id_history=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        history history = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement(connection, SQL_SELECT_BY_ID, id_history);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                history = mapResultSetToHistory(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeResources(resultSet, preparedStatement, connection);
        }

        return history;
    }

    @Override
    public List<history> getAllHistories() throws DAOException {
        final String SQL_SELECT_ALL = "SELECT * FROM history";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<history> allHistories = new ArrayList<>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement(connection, SQL_SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                history history = mapResultSetToHistory(resultSet);
                allHistories.add(history);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeResources(resultSet, preparedStatement, connection);
        }

        return allHistories;
    }

    @Override
    public void update(history history) throws DAOException {
        final String SQL_UPDATE = "UPDATE history SET endo_history=?, birth=?, pregnancy_troubles=?, id_user=?, sexual_abuse=? WHERE id_history=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement(connection, SQL_UPDATE,
                    history.isEndo_history(),
                    history.isBirth(),
                    history.isTrouble_pregnant(),
                    history.getId_user(),
                    history.isSexual_abuse(),
                    history.getId_history()
            );
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeResources(preparedStatement, connection);
        }
    }

    @Override
    public void delete(int id_history) throws DAOException {
        final String SQL_DELETE = "DELETE FROM history WHERE id_history=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement(connection, SQL_DELETE, id_history);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeResources(preparedStatement, connection);
        }
    }

    // Helper method to map ResultSet to history object
    private history mapResultSetToHistory(ResultSet resultSet) throws SQLException {
        history history = new history();
        history.setId_history(resultSet.getInt("id_history"));
        history.setEndo_history(resultSet.getBoolean("endo_history"));
        history.setBirth(resultSet.getBoolean("birth"));
        history.setTrouble_pregnant(resultSet.getBoolean("pregnancy_troubles"));
        history.setId_user(resultSet.getInt("id_user"));
        history.setSexual_abuse(resultSet.getBoolean("sexual_abuse"));
        return history;
    }


    // Helper method to initialize a PreparedStatement with parameters
    private PreparedStatement initPreparedStatement(Connection connection, String sql, Object... objects) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < objects.length; i++) {
            preparedStatement.setObject(i + 1, objects[i]);
        }
        return preparedStatement;
    }

    // Helper method to close resources (ResultSet, PreparedStatement, Connection)
    private void closeResources(AutoCloseable... resources) {
        for (AutoCloseable resource : resources) {
            if (resource != null) {
                try {
                    resource.close();
                } catch (Exception e) {
                    // Log the exception or handle it as needed
                }
            }
        }
    }
}
