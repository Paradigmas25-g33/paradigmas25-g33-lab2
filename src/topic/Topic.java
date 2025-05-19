package topic;

public interface Topic {
	
	// obtener nombre
	String getName();
	
	// obtener categoria
	String getCategory();

	void setName(String name);

	void setCategory(String category);
	
	// to string
	public String toString();

}
