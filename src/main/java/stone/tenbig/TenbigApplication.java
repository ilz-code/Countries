package stone.tenbig;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonMappingException;
import stone.tenbig.models.Country;
import stone.tenbig.services.GetContent;
import stone.tenbig.services.GetResults;
import stone.tenbig.services.PrintResults;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TenbigApplication {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException{
		SpringApplication.run(TenbigApplication.class, args);

		ArrayList<Country> countries = GetContent.getUrlContents();  		
			
		GetResults.CalculateDensity(countries);
							
		System.out.println("\n 10 countries with biggest population:");
		GetResults.GetCountriesWithBiggestPopulation(countries);
		PrintResults.printCountries(countries);
	
		System.out.println("\n 10 countries with largest areas:");
		GetResults.GetCountriesWithLargestArea(countries);		
		PrintResults.printCountries(countries);
	
		System.out.println("\n 10 countries of most population density:");	
		GetResults.GetCountriesWithBiggestDensity(countries);	
		PrintResults.printCountries(countries);
	
		System.exit(0);  	
	}

}
