package topic.topicTypes.politics;

public class National extends Politics {
    private String country;

    public National(String category, int frequency, String name, String country) {
        super(category, frequency, name);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "National [country=" + country + ", name=" + name + ", category=" + category + ", frequency=" + frequency + "]";
    }
}