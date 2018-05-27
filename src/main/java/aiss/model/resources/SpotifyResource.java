package aiss.model.resources;

import java.io.UnsupportedEncodingException;

import java.net.URLEncoder;
import java.util.Map;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.engine.header.TokenReader;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;


import aiss.model.Spotify.SpotifyTrack;
import aiss.model.Spotify.*;
import aiss.model.Spotify.PL.PlayListsUser;
import aiss.model.Spotify.U.User;

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
	
	public User getCurrentlyUser() {
		ClientResource cr=null;
		User sr=null;
		try {
			cr=new ClientResource("https://api.spotify.com/v1/me");
			String pAccessToken = "Bearer "+" " + access_token;
		    ChallengeResponse challengeResponse = new ChallengeResponse(
		                          new ChallengeScheme("", ""));
		    challengeResponse.setRawValue(pAccessToken);
		    cr.setChallengeResponse(challengeResponse);
			 sr=cr.get(User.class);
		}catch(Exception re) {
			System.err.println("Error de Spotify: " + cr.getResponse().getStatus());
			System.err.println(uri + "?access_token=" + access_token);
		}
		return sr;
	}
	
	public PlayListsUser getPlayListUser() {
		ClientResource cr=null;
		PlayListsUser sr=null;
		try {
			cr=new ClientResource("https://api.spotify.com/v1/me/playlists");
			String pAccessToken = "Bearer "+" " + access_token;
		    ChallengeResponse challengeResponse = new ChallengeResponse(
		                          new ChallengeScheme("", ""));
		    challengeResponse.setRawValue(pAccessToken);
		    cr.setChallengeResponse(challengeResponse);
			sr =cr.get(PlayListsUser.class);
		}catch(Exception re) {
			System.err.println("Error de Spotify: " + cr.getResponse().getStatus());
			System.err.println(uri + "?access_token=" + access_token);
		}
		return sr;
	}
	
	public boolean addTrack(String userID, String songId, String playListid) {
		ClientResource cr = null;
		boolean success = true;
		try {
			System.out.println("User:" + userID);
			System.out.println("SongId:" + songId);
			System.out.println("PlayListId:" + playListid);
			cr = new ClientResource("https://api.spotify.com/v1/users/"+userID+"/playlists/"+playListid+"/tracks?uris=spotify:track:"+songId);
			String pAccessToken = "Bearer "+" " + access_token;
		    ChallengeResponse challengeResponse = new ChallengeResponse(
		                          new ChallengeScheme("", ""));
		    challengeResponse.setRawValue(pAccessToken);
		    cr.setChallengeResponse(challengeResponse);
			cr.setEntityBuffering(true);
			cr.post(" ");
		} catch (ResourceException re) {
			System.err.println("Error when updating the playlist: " + cr.getResponse().getStatus());
			success = false;
		}

		return success;
	}
	
	
}
