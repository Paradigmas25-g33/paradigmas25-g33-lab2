package topic.topicTypes.politics;

public class Politics implements topic.Topic {
    private String category;
    private int frequency;
    private String name;

    public Politics(String category, int frequency, String name) {
        this.category = category;
        this.frequency = frequency;
        this.name = name;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getFrequency() {
        return frequency;
    }
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "politics [name=" + name + ", category=" + category + ", frequency=" + frequency + "]";
    }
    
}
