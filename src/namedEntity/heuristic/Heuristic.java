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
        categoryMap.put("USA",       "Country");
        categoryMap.put("Russia",    "Country");
        categoryMap.put("Tuesday",   "Date");     
        categoryMap.put("Fortnite",  "Product");  

        // hardcodes
        categoryMap.put("Bill","Person");
        categoryMap.put("Steve","Person");
        categoryMap.put("Laurene","Person");
        categoryMap.put("Isabel","Person");

        categoryMap.put("BYD","Company");
        categoryMap.put("Tesla","Company");
        categoryMap.put("Meta","Company");
        categoryMap.put("Netflix","Company");
        categoryMap.put("Amazon","Company");
        categoryMap.put("Bloomberg","Company");
        categoryMap.put("Pfizer","Company");
        categoryMap.put("Linkedin","Company");

        categoryMap.put("Europe","Country");
        categoryMap.put("India","Country");
        categoryMap.put("China","Country");
        categoryMap.put("United States","Country");
        categoryMap.put("Canada","Country");
        categoryMap.put("America","Country");
        categoryMap.put("Spain","Country");
        categoryMap.put("Philadelphia","Country");

        categoryMap.put("House","Organization");
        categoryMap.put("Emerson Collective","Organization");
        categoryMap.put("Congress","Organization");
        categoryMap.put("M&S","Organization");
        categoryMap.put("Burlington","Organization");
        categoryMap.put("CNN","Organization");

        categoryMap.put("Day","Date");
        categoryMap.put("Week","Date");
        categoryMap.put("Month","Date");
        categoryMap.put("Year","Date");
        categoryMap.put("Weekend","Date");

        categoryMap.put("Instagram","Product");
        categoryMap.put("Facebook","Product");
        categoryMap.put("TikTok","Product");
        categoryMap.put("YouTube","Product");
    }

    public String getCategory(String entity) {
        // busco en el mapa, si no lo encuentro devuelvo "Other"
        return categoryMap.getOrDefault(entity, "Other");
    }

    public abstract boolean isEntity(String word);
}
