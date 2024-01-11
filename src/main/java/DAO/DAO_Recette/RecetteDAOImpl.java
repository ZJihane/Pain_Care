package DAO.DAO_Recette;

import Beans.recette;
import DAO.DAOException;
import DAO.DAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecetteDAOImpl implements RecetteDAO {


    private DAOFactory daoFactory;

    // Constructor
    public RecetteDAOImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }


 
    @Override
    public List<recette> getAllRecettes() throws DAOException {
        final String SQL_SELECT_ALL = "SELECT id_recette, nom_recette, description, picture FROM recette";

        List<recette> recetteList = new ArrayList<>();

        try (
                Connection connection = daoFactory.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);
                ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            while (resultSet.next()) {
                recette rec = map(resultSet);
                recetteList.add(rec);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur lors de la récupération des recettes", e);
        }

        return recetteList;
    }


    
    private static recette map(ResultSet resultSet) throws SQLException {
	    recette rec = new recette();
	    rec.setId_recette(resultSet.getInt("id_recette"));
	    rec.setNom_recette(resultSet.getString("nom_recette"));
	    rec.setDescription(resultSet.getString("description"));
	    rec.setPicture(resultSet.getBytes("picture"));
	    // Ajoutez d'autres propriétés si nécessaire
	    return rec;
	}
    
    @Override
    public recette getRecetteById(int recetteId) throws DAOException {
        final String SQL_SELECT_BY_ID = "SELECT id_recette, nom_recette, picture, description FROM recette WHERE id_recette = ?";

        try (
                Connection connection = daoFactory.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID)
        ) {
            preparedStatement.setInt(1, recetteId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return map(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur lors de la récupération de la recette par ID", e);
        }

        return null; // Retourne null si aucune recette correspondante n'est trouvée
    }


   
}

