package namedEntity.heuristic;
import java.util.HashMap;
import java.util.Map;

public abstract class Heuristic {

    // categoryMap mutable
    private static final Map<String, String> categoryMap = new HashMap<>();
    static {
        categoryMap.put("Microsoft", "Company");
        categoryMap.put("Apple",     "Company");
        categoryMap.put("Google",    "Company");
        categoryMap.put("OpenAI",    "Company");   
        categoryMap.put("Musk",      "Person");
        categoryMap.put("Biden",     "Person");
        categoryMap.put("Trump",     "Person");
        categoryMap.put("Messi",     "Person");
        categoryMap.put("Federer",   "Person");
        categoryMap.put("USA",       "Place");
        categoryMap.put("Russia",    "Place");
        categoryMap.put("Tuesday",   "Date");     
        categoryMap.put("Fortnite",  "Product");  

        // hardcodes
        categoryMap.put("Bill","Person");
        categoryMap.put("Steve","Person");
        categoryMap.put("Laurene","Person");
        categoryMap.put("Isabel","Person");
        categoryMap.put("McMahon","Person");
        categoryMap.put("Billy","Person");


        categoryMap.put("BYD","Company");
        categoryMap.put("Tesla","Company");
        categoryMap.put("Meta","Company");
        categoryMap.put("Netflix","Company");
        categoryMap.put("Amazon","Company");
        categoryMap.put("Bloomberg","Company");
        categoryMap.put("Pfizer","Company");
        categoryMap.put("Linkedin","Company");
        categoryMap.put("Walmart","Company");
        categoryMap.put("Mattel","Company");
        categoryMap.put("Biotech","Company");
        categoryMap.put("23andMe","Company");

        categoryMap.put("Europe","Place");
        categoryMap.put("India","Place");
        categoryMap.put("China","Place");
        categoryMap.put("Canada","Place");
        categoryMap.put("America","Place");
        categoryMap.put("Spain","Place");
        categoryMap.put("Philadelphia","Place");
        categoryMap.put("Kong","Place");
        categoryMap.put("Gulf","Place");
        categoryMap.put("Qatar","Place");
        categoryMap.put("Persian","Place");

        categoryMap.put("House","Company");
        categoryMap.put("Emerson Collective","Company");
        categoryMap.put("Congress","Company");
        categoryMap.put("M&S","Company");
        categoryMap.put("Burlington","Company");
        categoryMap.put("CNN","Company");
        categoryMap.put("Airbnb","Company");
        categoryMap.put("CBS","Company");
        categoryMap.put("CATL","Company");

        categoryMap.put("Day","Date");
        categoryMap.put("Week","Date");
        categoryMap.put("Month","Date");
        categoryMap.put("Year","Date");
        categoryMap.put("Weekend","Date");
        categoryMap.put("April","Date");
        categoryMap.put("March","Date");

        categoryMap.put("Instagram","Product");
        categoryMap.put("Facebook","Product");
        categoryMap.put("TikTok","Product");
        categoryMap.put("YouTube","Product");
        categoryMap.put("Bitcoin","Product");
        categoryMap.put("Crypto","Product");
        categoryMap.put("Cars","Product");

    }

    public String getCategory(String entity) {
        // busco en el mapa, si no lo encuentro devuelvo "Other"
        return categoryMap.getOrDefault(entity, "Other");
    }

    public abstract boolean isEntity(String word);
}
