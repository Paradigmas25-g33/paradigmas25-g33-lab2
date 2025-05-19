package topic.topicTypes.culture;

public class Music extends Culture {

    public Music(String name, String category, int frequency) {
        super(name, "Musica", frequency);
    }

    @Override
    public String toString() {
        return "Music [name=" + getName() + ", category=" + getCategory() + ", frequency=" + getFrequency() + "]";
    }
}