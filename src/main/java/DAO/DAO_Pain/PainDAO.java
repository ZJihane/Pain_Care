package DAO.DAO_Pain;

import java.util.List;
import Beans.pain;
import DAO.DAOException;

public interface PainDAO {
    void create(pain pain) throws DAOException;

    pain find(int idPain) throws DAOException;

    List<pain> getAllPains() throws DAOException;

    void update(pain pain) throws DAOException;

    void delete(int idPain) throws DAOException;

	
}