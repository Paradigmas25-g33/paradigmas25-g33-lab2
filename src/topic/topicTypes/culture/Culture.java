package topic.topicTypes.culture;

public class Culture implements topic.Topic {
    private String name;
    private String category;
    private int frequency;

    public Culture(String name, String category, int frequency) {
        this.name = name;
        this.category = category;
        this.frequency = frequency;
    }
    // obtener nombre
	public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCategory(String category) {
        this.category = category;
    }
	// obtener categoria
	public String getCategory() {
        return this.category;
    }
    
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getFrequency() {
        return this.frequency;
    }

	public String toString() {
        return "Culture [name=" + name + ", category=" + category + ", frequency=" + frequency + "]";
    }
}
