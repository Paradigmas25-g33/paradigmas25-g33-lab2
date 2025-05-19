package topic.topicTypes.politics;

public class National extends Politics {
    private String country;

    public National(String category, int frequency, String name) {
        super(category, frequency, name);
    }

    @Override
    public String toString() {
        return "National [name=" + this.getName() + ", category=" + this.getCategory() + ", frequency=" + this.getFrequency() + "]";
    }
}