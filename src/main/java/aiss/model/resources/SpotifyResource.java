package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.Spotify.SpotifyTrack;

public class SpotifyResource {

	private  String uri ="https://api.spotify.com/v1/search";
	
	private  String access_token=null;
	
	public SpotifyResource(String access_token) {
		this.access_token=access_token;
	}
	public SpotifyTrack getSearch(String search) {
		ClientResource cr=null;
		SpotifyTrack sr=null;
		try {
			String query=URLEncoder.encode(search, "UTF-8");
			cr=new ClientResource(uri+"?q="+query+"&type=track&access_token="+access_token);
			sr=cr.get(SpotifyTrack.class);
		}catch(ResourceException re) {
			System.err.println("Error de Spotify: " + cr.getResponse().getStatus());
			System.err.println(uri + "?access_token=" + access_token);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sr;
	}
}
