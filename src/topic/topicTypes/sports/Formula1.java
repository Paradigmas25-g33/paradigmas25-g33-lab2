package topic.topicTypes.sports;

public class Formula1 extends Sports {

    public Formula1(String name, String category, int frequency) {
        super(name, category, frequency);
    }
    
    @Override
    public String toString() {
        return "Formula1{" +
                "name='" + this.getName()+ '\'' +
                ", category='" + this.getCategory() + '\'' +
                ", frequency=" + this.getFrequency() +
                '}';
    }
}