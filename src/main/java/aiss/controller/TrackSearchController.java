package aiss.controller;

import java.io.IOException;


import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.Spotify.SpotifyTrack;
import aiss.model.Spotify.PL.PlayListsUser;
import aiss.model.Spotify.U.*;
import aiss.model.resources.SpotifyResource;

/**
 * Servlet implementation class TrackSearchController
 */
public class TrackSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(TrackSearchController.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrackSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accessToken=(String)request.getSession().getAttribute("Spotify-token");
		if(accessToken!=null && !"".equals(accessToken)){
		SpotifyResource sr=new SpotifyResource(accessToken);
		SpotifyTrack SP=sr.getSearch(request.getParameter("busqueda"));
		User u = sr.getCurrentlyUser();
		PlayListsUser pl = sr.getPlayListUser();
		
		request.setAttribute("User", u);
		request.setAttribute("Tracks", SP);
		request.setAttribute("pl", pl);
		request.getRequestDispatcher("/TrackView.jsp").forward(request, response);
		}else {
			log.info("Trying to acces to Spotify without an acces token, redirecting to OAuth servlet");
			request.getRequestDispatcher("/AuthController/Spotify").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
