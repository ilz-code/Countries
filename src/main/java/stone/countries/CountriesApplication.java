package stone.countries;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonMappingException;
import stone.countries.models.Country;
import stone.countries.services.GetResults;
import stone.countries.services.PrintResults;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountriesApplication {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		SpringApplication.run(CountriesApplication.class, args);

		ArrayList<Country> countries;   		
							
		System.out.println("\n 10 countries with biggest population:");
		countries = GetResults.GetCountriesWithBiggestPopulation();
		PrintResults.printCountries(countries);
	
		System.out.println("\n 10 countries with largest areas:");
		countries = GetResults.GetCountriesWithLargestArea();		
		PrintResults.printCountries(countries);
	
		System.out.println("\n 10 countries of most population density:");	
		countries = GetResults.GetCountriesWithBiggestDensity();	
		PrintResults.printCountries(countries);
	}

}
