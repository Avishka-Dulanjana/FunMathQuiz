package game;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * The `GameServer` class interacts with an external server to retrieve games.
 * It uses the Tomato API provided by Marc Conrad to fetch game data.
 * 
 * The `getRandomGame` method fetches a random game from the server and returns it
 * as a `Game` object, which includes the game's location (URL) and the solution.
 * 
 * The `readUrl` method is a utility function to read the content from a URL and
 * convert it into a string.
 * 
 * @author Marc Conrad
 */
public class GameServer {
	
	/**
     * Basic utility method to read string from a URL.
     * 
     * @param urlString The URL from which to read the content.
     * @return The content of the URL as a string.
     */

	private static String readUrl(String urlString) {
		
	    try {

	        URL url = new URL(urlString);
	        InputStream inputStream = url.openStream();     
	        // References (https://stackoverflow.com/questions/309424/how-do-i-read-convert-an-inputstream-into-a-string-in-java)
	        // to convert InputStream to String.
	        ByteArrayOutputStream result = new ByteArrayOutputStream();
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = inputStream.read(buffer)) != -1) {
	            result.write(buffer, 0, length);
	        }	  
	        return result.toString("UTF-8");
	        
	    } catch (Exception e) {
	        System.out.println("An Error occured: "+e.toString());
	        e.printStackTrace();
	        return null; 
	    }

	}

	/**
     * Retrieves a random game from the external server.
     * 
     * @return A `Game` object representing the fetched game.
     * @throws MalformedURLException If there is an issue with the URL.
     */
	
	public Game getRandomGame() throws MalformedURLException {
		String tomatoapi = "https://marcconrad.com/uob/tomato/api.php?out=csv"; // Tomato API 
		String dataraw = readUrl(tomatoapi); 
		String[] data = dataraw.split(","); 
		
		URL quest = new URL(data[0]); 
		int solution  = Integer.parseInt(data[1]);  
		
		return new Game(quest, solution);
	}


}
