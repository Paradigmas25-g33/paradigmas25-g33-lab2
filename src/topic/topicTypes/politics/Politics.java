package topic.topicTypes.politics;

public class Politics extends topic.Topic {
    public Politics(String category, int frequency, String name) {
        super(category, frequency, name);
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
