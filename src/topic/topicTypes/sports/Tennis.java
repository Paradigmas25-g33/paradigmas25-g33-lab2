package topic.topicTypes.sports;

public class Tennis extends Sports {

    public Tennis(String name, String category, int frequency) {
        super(name, category, frequency);
    }

    @Override
    public String toString() {
        return "Tennis{" + "name='" + getName() + '\'' +", category='" + getCategory() + '\'' + ", frequency=" + getFrequency() + '}';
    }
}   