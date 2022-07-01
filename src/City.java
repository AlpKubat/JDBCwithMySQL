public class City {
    private String id;
    private String name;
    private String countryCode;
    private String population;

    City(String id, String name, String countryCode, String population)
    {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.population = population;
    }

    public String getId() {return id;}
    public String getName() {return name;}
    public String getCountryCode() {return countryCode;}
    public String getPopulation() {return population;}
}
