package stone.tenbig.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import stone.tenbig.models.Country;
import stone.tenbig.services.GetContent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

public class GetContent {

	private static String filter = "name,capital,currencies,population,area";
	private static String theUrl = "https://restcountries.com/v2/regionalbloc/eu?fields=" + filter;
    public static ArrayList<Country> getUrlContents() throws JsonMappingException, JsonProcessingException  
		{  
		  StringBuilder content = new StringBuilder();  	 
		  try  
		  {  
			URL url = new URL(theUrl);  
			URLConnection urlConnection = url.openConnection(); 	
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));  
			String line;  		
			while ((line = bufferedReader.readLine()) != null)  
			{  
			  content.append(line + "\n");  
			}  
			bufferedReader.close();  
		  }  
		  catch(Exception e)  
		  {  
			e.printStackTrace();  
		  }  

		  ObjectMapper mapper = new ObjectMapper();   						
			ArrayList<Country> countries = mapper.readValue(content.toString(), new TypeReference<ArrayList<Country>>(){});
		  return countries;  
		}  	 		
}
