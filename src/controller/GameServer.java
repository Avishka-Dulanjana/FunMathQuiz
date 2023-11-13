package controller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Game that interfaces to an external Server to retrieve games
 * 
 * @author Marc Conrad
 *
 */
public class GameServer {
	
	/** 
	 * Basic utility method to read string for URL. 
	 */

	private static String readUrl(String urlString) {
		
	    try {

	        URL url = new URL(urlString);
	        InputStream inputStream = url.openStream();
	              
	        // take code https://stackoverflow.com/questions/309424/how-do-i-read-convert-an-inputstream-into-a-string-in-java
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
	 * Retrieves a game for any positive number less than 1000.
	 * 
	 * @param i
	 * @return a random game.
	 * @throws MalformedURLException
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
