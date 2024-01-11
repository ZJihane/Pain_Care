package DAO.DAO_Blog;

import Beans.Blog;
import DAO.DAOException;

import java.util.List;

public interface BlogDAO {
    void addBlog(Blog blog) throws DAOException;
    Blog getBlogById(int blogId) throws DAOException;
    List<Blog> getAllBlogs() throws DAOException;

    void deleteBlog(int blogId) throws DAOException;
	
}
