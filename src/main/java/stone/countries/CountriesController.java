package stone.countries;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.util.ArrayList;
import stone.countries.models.Country;
import stone.countries.services.GetResults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountriesController {

	@GetMapping("/population")
	public ArrayList<Country> GetTenCountriesBiggestPopulation() throws JsonMappingException, JsonProcessingException {
		return GetResults.GetCountriesWithBiggestPopulation();
	}

    @GetMapping("/area")
	public ArrayList<Country> GetTenCountriesLargestArea() throws JsonMappingException, JsonProcessingException {
		return GetResults.GetCountriesWithLargestArea();
    }
    
    @GetMapping("/density")
	public ArrayList<Country> GetTenCountriesBiggestDensity() throws JsonMappingException, JsonProcessingException {
		return GetResults.GetCountriesWithBiggestDensity();
	}
}
