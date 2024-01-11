package DAO.DAO_Period;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.period;
import DAO.DAOException;
import DAO.DAOFactory;

public class PeriodDaoImpl implements PeriodDAO {

    private DAOFactory daoFactory;

    public  PeriodDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void create(period period) throws DAOException {
        final String SQL_INSERT = "INSERT INTO period (first_period, cycle_length, period_duration, nature_period , period_pattern , id_user) VALUES (?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement(connection, SQL_INSERT,
                    period.getFirst_period(),
                    period.getCycle_length(),
                    period.getPeriod_duration(),
                    period.getNature_period(),
                    period.getPeriod_pattern(),
                    period.getId_user()
             
            );
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeResources(preparedStatement, connection);
        }
    }

    @Override
    public period find(int id_period) throws DAOException {
        final String SQL_SELECT_BY_ID = "SELECT * FROM period WHERE id_period=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        period period = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement(connection, SQL_SELECT_BY_ID, id_period);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                period = mapResultSetToPeriod(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeResources(resultSet, preparedStatement, connection);
        }

        return period;
    }

    @Override
    public List<period> getAllPeriods() throws DAOException {
        final String SQL_SELECT_ALL = "SELECT * FROM period";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<period> allPeriods = new ArrayList<>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement(connection, SQL_SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	period period = mapResultSetToPeriod(resultSet);
                allPeriods.add(period);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeResources(resultSet, preparedStatement, connection);
        }

        return allPeriods;
    }

    @Override
    public void update(period period) throws DAOException {
        final String SQL_UPDATE = "UPDATE period SET first_period=?, cycle_length=?, period_duration=?, nature_period=?, period_pattern=?, id_user=? WHERE id_period=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement(connection, SQL_UPDATE,
                    period.getFirst_period(),
                    period.getCycle_length(),
                    period.getPeriod_duration(),
                    period.getNature_period(),
                    period.getPeriod_pattern(),
                    period.getId_user(),
                    period.getId_period()
            );
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeResources(preparedStatement, connection);
        }
    }


    @Override
    public void delete(int idPeriod) throws DAOException {
        final String SQL_DELETE = "DELETE FROM period WHERE id_period=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement(connection, SQL_DELETE, idPeriod);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeResources(preparedStatement, connection);
        }
    }

    // Helper method to map ResultSet to period object
    private period mapResultSetToPeriod(ResultSet resultSet) throws SQLException {
    	period period = new period();
        period.setId_period(resultSet.getInt("id_period"));
        period.setFirst_period(resultSet.getInt("first_period"));
        period.setCycle_length(resultSet.getInt("cycle_length"));
        period.setPeriod_duration(resultSet.getInt("period_duration"));
        period.setNature_period(resultSet.getString("nature_period"));
        period.setPeriod_pattern(resultSet.getString("period_pattern"));
        period.setId_user(resultSet.getInt("id_user"));
        return period;
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
