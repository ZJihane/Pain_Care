package DAO.DAO_Diagnostic;

import java.util.List;
import Beans.diagnostic;
import DAO.DAOException;

public interface DiagnosticDAO {
    void create(diagnostic diagnostic) throws DAOException;

    diagnostic find(int idDiagnostic) throws DAOException;

    List<diagnostic> getAllDiagnostics() throws DAOException;

    void update(diagnostic diagnostic) throws DAOException;

    void delete(int idDiagnostic) throws DAOException;

	
}