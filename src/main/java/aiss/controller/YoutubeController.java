package aiss.controller;

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import aiss.model.resources.Youtuberesource;
import aiss.model.youtube.VideoSearch;

/**
 * Servlet implementation class SearchController
 */
public class YoutubeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = Logger.getLogger(YoutubeController.class.getName());
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YoutubeController() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String query = request.getParameter("searchQuery");
		RequestDispatcher rd = null;
		
		// Search for videos in Youtube
		log.log(Level.FINE, "Searching for Youtube videos that contain " + query);
		Youtuberesource ytr = new Youtuberesource();
		VideoSearch ytResults = ytr.getVideo(query);

		if (ytResults!=null){
			rd = request.getRequestDispatcher("/success.jsp");
			request.setAttribute("items", ytResults.getItems());		
		} else {

			log.log(Level.SEVERE, "YT object: " + ytResults);
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
