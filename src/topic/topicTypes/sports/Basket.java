package topic.topicTypes.sports;

public class Basket extends Sports {

    public Basket(String name, String category, int frequency) {
        super(name, category, frequency);
    }

    @Override
    public String toString() {
        return "Basket{" + "name='" + getName() + '\'' +", category='" + getCategory() + '\'' + ", frequency=" + getFrequency() + '}';
    }
}   