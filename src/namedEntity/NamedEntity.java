package namedEntity;


/*Esta clase modela la nocion de entidad nombrada*/

public class NamedEntity {
	protected String name;
	protected String category; 
	protected int frequency;
	
	public NamedEntity(String category, int frequency, String name) {
		super();
		this.name = name;
		this.category = category;
		this.frequency = frequency;
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



