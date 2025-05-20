package topic.topicTypes.sports;

public class Soccer extends Sports {

    public Soccer(String name, String category, int frequency) {
        super(name, category, frequency);
    }

    @Override
    public String toString() {
        return "Soccer{" + "name='" + getName() + '\'' +", category='" + getCategory() + '\'' + ", frequency=" + getFrequency() + '}';
    }
}   