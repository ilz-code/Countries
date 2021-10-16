package stone.countries;

import stone.countries.models.Country;
import stone.countries.services.GetContent;
import stone.countries.services.GetResults;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CountriesApplicationTests {
	
		ArrayList<Country> countries;

		@Test
	void getContent_MustReturn31Country() throws JsonMappingException, JsonProcessingException{
       Integer actual = GetContent.getUrlContents().size();
	   assertEquals(31, actual);
	}

	@Test
	void calculateDensity_MustReturnCorrectValue() throws JsonMappingException, JsonProcessingException{
		countries = GetContent.getUrlContents();
		GetResults.CalculateDensity(countries);
		Double actual = countries.get(13).density;
		assertEquals(5615.0, actual);
	}
	
	@Test
	void getBiggestPopulation() throws JsonMappingException, JsonProcessingException{
		countries = GetResults.GetCountriesWithBiggestPopulation();
		Integer actual = countries.get(0).population;
		assertEquals(83240525, actual);
	}

	@Test
	void getLargestArea() throws JsonMappingException, JsonProcessingException{
		countries = GetResults.GetCountriesWithLargestArea();
		Double actual = countries.get(0).area;
		assertEquals(640679.0, actual);
	}
	
	@Test
	void getCountryWithBiggestDensity() throws JsonMappingException, JsonProcessingException{
		countries = GetResults.GetCountriesWithBiggestDensity();
		String actual = countries.get(0).name;
		assertEquals("Gibraltar", actual);
	}
	}

