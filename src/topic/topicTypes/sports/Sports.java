package topic.topicTypes.sports;

public class Sports extends topic.Topic {
    
    public Sports(String category, int frequency, String name) {
        super(category, frequency, name);
    }

    @Override
    public String toString() {
        return "sports [name=" + name + ", category=" + category + ", frequency=" + frequency + "]";
    }
    
}
