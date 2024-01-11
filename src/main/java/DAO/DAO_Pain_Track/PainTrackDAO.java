package DAO.DAO_Pain_Track;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.PainTrack;
import DAO.DAOException;
import DAO.DAOFactory;

public class PainTrackDAO {

    private DAOFactory daoFactory;

    public PainTrackDAO(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public void create(PainTrack painTrack) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            String query = "INSERT INTO pain_track (pain_severity, pain_locations, symptomes, pain_worsen, feelings ,id_user ,date) VALUES (?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, painTrack.getPainSeverity());
          
            preparedStatement.setString(2, String.join(",", painTrack.getPainLocations()));
            preparedStatement.setString(3, String.join(",", painTrack.getSymptomes()));
            preparedStatement.setString(4, String.join(",", painTrack.getPainWorsen()));
            preparedStatement.setString(5, String.join(",", painTrack.getFeelings()));


            preparedStatement.setInt(6, painTrack.getId_user());
            java.sql.Date sqlDate = new java.sql.Date(painTrack.getDate().getTime());
            preparedStatement.setDate(7, sqlDate);

           
            

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur lors de la création de la douleur", e);
        } 
    }

   

    public List<PainTrack> getAllPainTrack(int id_user) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<PainTrack> painTracks = new ArrayList<>();

        try {
            connection = daoFactory.getConnection();
            String query = "SELECT * FROM pain_track WHERE id_user = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id_user);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                PainTrack painTrack = mapResultSetToTrack(resultSet);
                painTracks.add(painTrack);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur lors de la récupération des douleurs", e);
        } finally {
            closeResources(resultSet, preparedStatement, connection);
        }

        return painTracks;
    }

    private PainTrack mapResultSetToTrack(ResultSet resultSet) throws SQLException {
        PainTrack painTrack = new PainTrack();
        painTrack.setIdPainTrack(resultSet.getInt("id_pain_track"));
        painTrack.setPainSeverity(resultSet.getInt("pain_severity"));
        painTrack.setPainLocations(resultSet.getString("pain_locations").split(","));
        painTrack.setSymptomes(resultSet.getString("symptomes").split(","));
        painTrack.setPainWorsen(resultSet.getString("pain_worsen").split(","));
        painTrack.setFeelings(resultSet.getString("feelings").split(","));
        painTrack.setDate(resultSet.getDate("date"));
        painTrack.setId_user(resultSet.getInt("id_user"));

        return painTrack;
    }

    // Add this method to close the resources
    private void closeResources(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            // Handle or log the exception if needed
            e.printStackTrace();
        }
    }
    
   


}
