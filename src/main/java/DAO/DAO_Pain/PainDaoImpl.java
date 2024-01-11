package DAO.DAO_Pain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Beans.pain;
import DAO.DAOException;
import DAO.DAOFactory;

public class PainDaoImpl implements PainDAO {

    private DAOFactory daoFactory;

    public PainDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void create(pain pain) throws DAOException {
        final String SQL_INSERT = "INSERT INTO pain (pain_trigger, severity_pain, other_symptom, id_user, pain_rapport) VALUES (?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement(connection, SQL_INSERT,
                    String.join(",", pain.getPain_trigger()),
                    pain.getSeverity_pain(),
                    pain.getOther_symptom(),
                    pain.getId_user(),
                    pain.isPain_rapport()
            );
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeResources(preparedStatement, connection);
        }
    }

    @Override
    public pain find(int id_pain) throws DAOException {
        final String SQL_SELECT_BY_ID = "SELECT * FROM pain WHERE id_pain=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        pain pain = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement(connection, SQL_SELECT_BY_ID, id_pain);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                pain = mapResultSetToPain(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeResources(resultSet, preparedStatement, connection);
        }

        return pain;
    }

    @Override
    public List<pain> getAllPains() throws DAOException {
        final String SQL_SELECT_ALL = "SELECT * FROM pain";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<pain> allPains = new ArrayList<>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement(connection, SQL_SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                pain pain = mapResultSetToPain(resultSet);
                allPains.add(pain);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeResources(resultSet, preparedStatement, connection);
        }

        return allPains;
    }

    @Override
    public void update(pain pain) throws DAOException {
        final String SQL_UPDATE = "UPDATE pain SET pain_trigger=?, severity_pain=?, other_symptom=?, id_user=? WHERE id_pain=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement(connection, SQL_UPDATE,
                    String.join(",", pain.getPain_trigger()),
                    pain.getSeverity_pain(),
                    pain.getOther_symptom(),
                    pain.getId_user(),
                    pain.getId_pain()
            );
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeResources(preparedStatement, connection);
        }
    }

    @Override
    public void delete(int idPain) throws DAOException {
        final String SQL_DELETE = "DELETE FROM pain WHERE id_pain=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement(connection, SQL_DELETE, idPain);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeResources(preparedStatement, connection);
        }
    }

    // Helper method to map ResultSet to Pain object
    private pain mapResultSetToPain(ResultSet resultSet) throws SQLException {
        pain pain = new pain();
        pain.setId_pain(resultSet.getInt("id_pain"));
        pain.setPain_trigger(resultSet.getString("pain_trigger").split(","));
        pain.setSeverity_pain(resultSet.getInt("severity_pain"));
        pain.setOther_symptom(resultSet.getString("other_symptom"));
        pain.setId_user(resultSet.getInt("id_user"));
        pain.setPain_rapport(resultSet.getBoolean("pain_rapport"));
        return pain;
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
