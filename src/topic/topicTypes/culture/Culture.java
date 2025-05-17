package topic.topicTypes.culture;

public class Culture extends topic.Topic {
    
    public Culture(String category, int frequency, String name) {
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
        return "Culture [name=" + name + ", category=" + category + ", frequency=" + frequency + "]";
    }
}
