package stone.countries.services;

import stone.countries.models.*;
import java.util.ArrayList;
import java.util.Collections;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class GetResults {
    
    public static void CalculateDensity(ArrayList<Country> countries){
        countries.forEach((c) -> {
            if (c.area != null){
                  c.density = (double)Math.round(c.population / c.area);
            }	
              });
    }

    public static ArrayList<Country> GetCountriesWithBiggestPopulation() throws JsonMappingException, JsonProcessingException{
      ArrayList<Country> countries = GetContent.getUrlContents();
        Collections.sort(countries, (c1, c2) -> {
            return c2.getPopulation().compareTo(c1.getPopulation());			
        });	
        return countries;
    }

    public static ArrayList<Country> GetCountriesWithLargestArea() throws JsonMappingException, JsonProcessingException{
      ArrayList<Country> countries = GetContent.getUrlContents();
        Collections.sort(countries, (c1, c2) -> {
            if (c1.getArea() == null ){
                c1.area = 0.0;
            } 
            if (c2.getArea() == null){
              c2.area = 0.0;
            }
                  return c2.getArea().compareTo(c1.getArea());            
        });
          return countries;	 
    }

    public static ArrayList<Country> GetCountriesWithBiggestDensity() throws JsonMappingException, JsonProcessingException{
      ArrayList<Country> countries = GetContent.getUrlContents();
      CalculateDensity(countries);
        Collections.sort(countries, (c1, c2) -> {
            if (c1.density == null){
              c1.density = 0.0;
            }
            if (c2.density == null){
              c2.density = 0.0;
            }
                return c2.getDensity().compareTo(c1.getDensity());			
        });	    
        return countries;
    }
}
