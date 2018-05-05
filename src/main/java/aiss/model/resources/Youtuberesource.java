package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import java.net.URLEncoder;
import java.util.logging.Level;
import org.restlet.resource.ResourceException;
import aiss.model.youtube.VideoSearch;

public class Youtuberesource {
	private static final Logger log = Logger.getLogger(Youtuberesource.class.getName());

	private static final String APIKEY = "AIzaSyA1_YOHdoFUKoUKn0isFWHAa8X3V960VxI";
	private static final String URL_YOUTUBE = "https://www.googleapis.com/youtube/v3/search?part=snippet&q=%QUERY+trailer&maxResults=1&order=relevance&key=%APIKEY";

	

	public VideoSearch getVideo(String param) throws UnsupportedEncodingException {
		String query = URLEncoder.encode(param, "UTF-8");
		ClientResource cr = null;
		VideoSearch res = null;
		try {
			cr = new ClientResource(URL_YOUTUBE.replace("%QUERY", query).replace("%APIKEY", APIKEY));
			res = cr.get(VideoSearch.class);
			log.log(Level.FINE, "Búsqueda de vídeos de " + query + " realizada correctamente.");
		} catch (ResourceException e) {
			log.log(Level.WARNING, "Error al obtener los vídeos: " + cr.getResponse().getStatus());
			throw e;
		}
		return res;
	}

	

}
