package stone.countries.services;

import java.util.ArrayList;

import stone.countries.models.Country;

public class PrintResults {
    public static void printCountries(ArrayList<Country> countries){
		for (int i = 0; i < 10; i++){  
		  String currency = "";
			for (int j = 0; j < countries.get(i).currencies.length; j++){
			  if (j > 0){
				currency = currency + ", ";
			  }
			  currency = currency + countries.get(i).currencies[j].name;
			} 		
		    System.out.println(countries.get(i).name + "  " +
				  countries.get(i).capital + "  " +
				  currency + "  " +
				  countries.get(i).population + "  " +
				  countries.get(i).area);            
		}
    }
}
