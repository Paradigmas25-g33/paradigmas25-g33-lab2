package topic.topicTypes.politics;

public class International extends Politics {
    private String region;

    public International(String category, int frequency, String name, String region) {
        super(category, frequency, name);
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "International [region=" + region + ", name=" + name + ", category=" + category + ", frequency=" + frequency + "]";
    }
}