package DAO.DAO_Period;

import java.util.List;
import Beans.period;
import DAO.DAOException;

public interface PeriodDAO {
    void create(period period) throws DAOException;

    period find(int idPeriod) throws DAOException;

    List<period> getAllPeriods() throws DAOException;

    void update(period period) throws DAOException;

    void delete(int idPeriod) throws DAOException;

	
}