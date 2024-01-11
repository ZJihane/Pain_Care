package DAO.DAO_Recette;

import Beans.recette;
import DAO.DAOException;

import java.util.List;

public interface RecetteDAO {
  
    List<recette> getAllRecettes() throws DAOException;

	recette getRecetteById(int recetteId);
    
}
