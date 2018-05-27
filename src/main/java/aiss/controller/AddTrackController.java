package aiss.controller;

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.SpotifyResource;

/**
 * Servlet implementation class PlaylistAddSongController
 */
public class AddTrackController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(AddTrackController.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTrackController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String accessToken=(String)request.getSession().getAttribute("Spotify-token");
		// Request data
		String trackId = request.getParameter("songId");
		String playlistId = request.getParameter("plId");
		String userId= request.getParameter("userId");
		
		System.out.println("User:" + userId);
		System.out.println("SongId:" + trackId);
		System.out.println("PlayListId:" + playlistId);
				
		// Add song to playlist
		SpotifyResource sr = new SpotifyResource(accessToken);
		boolean success = sr.addTrack(userId, trackId, playlistId);
		
		if (success) {
			request.setAttribute("message", "Song added successfully");
			log.log(Level.FINE, "Song with id=" + trackId + " added to playlist with id=" + playlistId + ". Forwarding to playlist list view.");
		}
		else {
			request.setAttribute("message", "The song could not be added");
			log.log(Level.FINE, "The song with id=" + trackId + " could not be added to the playlist with id=" + playlistId + ". Perhaps it is duplicated. Forwarding to playlist list view.");
		}
		
		// Forward to contact list view
		request.getRequestDispatcher("index.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
