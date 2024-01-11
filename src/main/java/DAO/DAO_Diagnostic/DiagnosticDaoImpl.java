package DAO.DAO_Diagnostic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.diagnostic;
import DAO.DAOException;
import DAO.DAOFactory;

public class DiagnosticDaoImpl implements DiagnosticDAO {

    private DAOFactory daoFactory;

    public  DiagnosticDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void create(diagnostic diagnostic) throws DAOException {
        final String SQL_INSERT = "INSERT INTO diagnostic (weight, height, bmi, id_user , resultat) VALUES (?, ?, ?, ?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement(connection, SQL_INSERT,
                    diagnostic.getWeight(),
                    diagnostic.getHeight(),
                    diagnostic.getBmi(),
                    diagnostic.getId_user(),
                    diagnostic.getResultat()
             
            );
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeResources(preparedStatement, connection);
        }
    }

    @Override
    public diagnostic find(int id_diagnostic) throws DAOException {
        final String SQL_SELECT_BY_ID = "SELECT * FROM diagnostic WHERE id_diagnostic=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        diagnostic diagnostic = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement(connection, SQL_SELECT_BY_ID, id_diagnostic);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                diagnostic = mapResultSetToDiagnostic(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeResources(resultSet, preparedStatement, connection);
        }

        return diagnostic;
    }

    @Override
    public List<diagnostic> getAllDiagnostics() throws DAOException {
        final String SQL_SELECT_ALL = "SELECT * FROM diagnostic";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<diagnostic> allDiagnostics = new ArrayList<>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement(connection, SQL_SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	diagnostic diagnostic = mapResultSetToDiagnostic(resultSet);
                allDiagnostics.add(diagnostic);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeResources(resultSet, preparedStatement, connection);
        }

        return allDiagnostics;
    }

    @Override
    public void update(diagnostic diagnostic) throws DAOException {
        final String SQL_UPDATE = "UPDATE diagnostic SET weight=?, height=?, bmi=?, id_user=? WHERE id_diagnostic=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement(connection, SQL_UPDATE,
            		 diagnostic.getWeight(),
                     diagnostic.getHeight(),
                     diagnostic.getBmi(),
                     diagnostic.getId_user(),
                    diagnostic.getId_diagnostic()
            );
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeResources(preparedStatement, connection);
        }
    }

    @Override
    public void delete(int idDiagnostic) throws DAOException {
        final String SQL_DELETE = "DELETE FROM diagnostic WHERE id_diagnostic=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement(connection, SQL_DELETE, idDiagnostic);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeResources(preparedStatement, connection);
        }
    }

    // Helper method to map ResultSet to diagnostic object
    private diagnostic mapResultSetToDiagnostic(ResultSet resultSet) throws SQLException {
    	diagnostic diagnostic = new diagnostic();
        diagnostic.setId_diagnostic(resultSet.getInt("id_diagnostic"));
        diagnostic.setWeight(resultSet.getDouble("weight"));
        diagnostic.setHeight(resultSet.getDouble("height"));
        diagnostic.setBmi(resultSet.getDouble("bmi"));
        diagnostic.setId_user(resultSet.getInt("id_user"));
        diagnostic.setResultat(resultSet.getDouble("resultat"));
        return diagnostic;
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
