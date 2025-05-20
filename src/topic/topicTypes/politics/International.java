package topic.topicTypes.politics;

public class International extends Politics {

    public International(String category, int frequency, String name) {
        super(category, frequency, name);
    }

    

    @Override
    public String toString() {
        return "International [Name=" + this.getName() + ", Category=" + this.getCategory() + ", Frequency=" + this.getFrequency() + "]";
    }
}