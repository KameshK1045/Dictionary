package apiexample;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class APIExcercise {
    
	public String dictionary(String word) {
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL("https://api.api-ninjas.com/v1/dictionary?word="+word);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("accept", "application/json");
			connection.setRequestProperty("X-Api-Key","dG/9bx/U7245SEIIUQsrSQ==AoMAOcUMrVr3Yn2x");
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String line;
	        while ((line = reader.readLine()) != null) {
	            sb.append(line);
	            sb.append("\n");
	        }
	        System.out.println(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sb.toString();
		
	}
}
