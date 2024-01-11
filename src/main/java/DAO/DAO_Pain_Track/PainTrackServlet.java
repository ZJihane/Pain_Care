package DAO.DAO_Pain_Track;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;



import java.util.Date;
import java.util.List;

import Beans.PainTrack;
import Beans.user;
import DAO.DAOFactory;
import DAO.DAO_User.UserdaoImpl;




@WebServlet("/PainTrackServlet")
public class PainTrackServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private PainTrackDAO painTrackDAO;
	private UserdaoImpl userDAO;
	

    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.painTrackDAO = new PainTrackDAO(daoFactory);
        this.userDAO = new UserdaoImpl(daoFactory);
        
    }

  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  {
    	    String action = request.getParameter("action");
    	 
         if (action != null) {
             switch (action) {
                 case "create":
                       String painLevel = request.getParameter("painLevel");
                       String[] painLocations = request.getParameterValues("painLocations");
                      String[] symptoms = request.getParameterValues("symptoms");
                     String[] painWorsen = request.getParameterValues("painWorsen");
                    String[] feelings = request.getParameterValues("feelings");
                    
                    String id_user = request.getParameter("id_user");
                    int user1 = Integer.parseInt(id_user);
                    String dateStr = request.getParameter("date");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
				Date date = null;
				try {
					date = sdf.parse(dateStr);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				PainTrack painTrack = new PainTrack();
                   painTrack.setPainSeverity(Integer.parseInt(painLevel));
                    painTrack.setPainLocations(painLocations );
                    painTrack.setSymptomes(symptoms );
                     painTrack.setPainWorsen(painWorsen);
                      painTrack.setFeelings(feelings);
                      painTrack.setId_user(user1);
                      painTrack.setDate((Date) date);
                      painTrackDAO.create(painTrack);
                      
                      DAOFactory daoFactory = DAOFactory.getInstance();
                      
                      this.userDAO = new UserdaoImpl(daoFactory);
                      
                      List<user> users = userDAO.getAllUsers();
                      for (user currentUser : users) {
                          if (currentUser.getIduser()==user1) {
                              request.setAttribute("loggedInUser", currentUser);
                          }
                      }
                      
                      List<PainTrack> painTrackList = painTrackDAO.getAllPainTrack(user1);
                      
                      request.setAttribute("painTrackList", painTrackList);

                      
                      RequestDispatcher dispatcher = request.getRequestDispatcher("/userapp/pain_graph.jsp");
                      
                      dispatcher.forward(request, response);
                      break ;
                    
                	
              
               
               
            
        } 
         }}}

