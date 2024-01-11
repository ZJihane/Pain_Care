package DAO.DAO_History;

import java.util.List;
import Beans.history;
import DAO.DAOException;

public interface HistoryDAO {

    void create(history history) throws DAOException;

    history find(int id_history) throws DAOException;

    List<history> getAllHistories() throws DAOException;

    void update(history history) throws DAOException;

    void delete(int id_history) throws DAOException;
}
