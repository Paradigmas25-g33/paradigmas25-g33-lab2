package topic.topicTypes.sports;

public class Sports implements topic.Topic {
    String name;
    String category;
    int frequency;

    public Sports(String name, String category, int frequency) {
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

    public int getFrequency() {
        return frequency;
    }
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String toString() {
        return "Nombre: " + this.name + ", Categoria: " + this.category;
    }
}