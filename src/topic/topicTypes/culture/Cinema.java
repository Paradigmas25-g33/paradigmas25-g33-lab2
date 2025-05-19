package topic.topicTypes.culture;

public class Cinema extends Culture {

    public Cinema(String name, String category, int frequency) {
        super(name, "Cinema", frequency);
    }

    @Override
    public String toString() {
        return "Cinema [name=" + this.getName() + ", category=" + this.getCategory() + ", frequency=" + this.getFrequency() + "]";
    }

}
