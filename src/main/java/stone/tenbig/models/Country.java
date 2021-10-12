package stone.tenbig.models;

public class Country {
    
    public String name;
    public String capital;
    public Integer population;
    public Double area;    
    public Currencie[] currencies;    
    public Double density;
    
    public Country(){
    }
    
    public Integer getPopulation(){
        return this.population;
    }
    public Double getArea(){
        return this.area;
    }
    public Double getDensity(){
        return this.density;
    }
}

