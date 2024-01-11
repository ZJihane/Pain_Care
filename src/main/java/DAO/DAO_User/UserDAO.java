package DAO.DAO_User;

import java.util.List;

import Beans.user;
import DAO.DAOException;

public interface UserDAO {
    
	void create(user user) throws DAOException;

    List<user> getAllUsers() throws DAOException;

	void delete(int idUser) throws DAOException;

	void update(user user) throws DAOException;

	user edit(int idUser) throws DAOException;

	user find(int idUser) throws DAOException;

   }
