package namedEntity;

import topic.Topic;

/*Esta clase modela la nocion de entidad nombrada*/

public class NamedEntity {
	protected String name;
	protected int frequency;
	protected String category;
	protected Topic topic;
	
	public NamedEntity(String category, int frequency, String name, Topic topic) {
		super();
		this.name = name;
		this.category = category;
		this.frequency = frequency;
		this.topic =  topic;
	}

	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getFrequency() {
		return this.frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public void incFrequency() {
		this.frequency++;
	}

	@Override
	public String toString() {
		return "NamedEntity [name=" + name + ", category=" + category + ", frequency=" + frequency + "]";
	}
	public void prettyPrint(){
		System.out.println(this.getCategory() + " " + this.getFrequency());
	}
	
	
}



