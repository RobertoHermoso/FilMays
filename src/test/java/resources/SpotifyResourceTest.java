package resources;

import static org.junit.Assert.*;

import org.junit.Test;

import aiss.model.Spotify.SpotifyTrack;
import aiss.model.Spotify.PL.PlayListsUser;
import aiss.model.Spotify.U.User;
import aiss.model.resources.SpotifyResource;

public class SpotifyResourceTest {

	static SpotifyResource sr=new SpotifyResource("BQDcIXMnzNVuTz9qJjQNV7k0a2nNzVJyIZiuplul8Qmr0mOHePUIMPRcO9DFHJfMQab-K5bYKdnikKhJjdfjnYm6JapXk_tNF4YxFWgQ-2Vp1Whf5CnrkjKEojeAxHSEg57frWmjo1DwPe6bAkGOtxKXM1zQs66B8x1RCJA2P2UaWAB1Wh7HutjSJGYhXJ6Ihi77BLKy0tPW1Wrf70cto1RdFrrTRqi_7OJn8Tq_9jvyMAKn6uyDbgzaw3hfaNmHuwGRtXE");
	static User u1;
	static PlayListsUser pu1;
	static SpotifyTrack st;

	@Test
	public void testGetSearch() {
		st=sr.getSearch("Black Panther");
		assertNotNull("La busqueda es null",st);
		System.out.println("Duracion de la busqueda:"+st.getTracks().getItems().get(0).getDurationMs());
	}

	@Test
	public void testGetCurrentlyUser() {
		u1=sr.getCurrentlyUser();
		assertNotNull("el usuario es null",u1);
		System.out.println("Email del usuario:"+u1.getEmail());
	}

	@Test
	public void testGetPlayListUser() {
		pu1=sr.getPlayListUser();
		assertNotNull("La lista es null",pu1);
		System.out.println("Numero de elementos:"+pu1.getItems().size());
	}
	@Test
	public void testAddTrack() {
		sr.addTrack(sr.getCurrentlyUser().getId(), "12Chz98pHFMPJEknJQMWvI" , 
				sr.getPlayListUser().getItems().get(0).getId());
		
	}

	

}
