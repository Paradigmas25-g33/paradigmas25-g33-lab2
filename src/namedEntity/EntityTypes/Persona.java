package namedEntity.EntityTypes;
import namedEntity.NamedEntity;
import topic.Topic;

public class Persona extends NamedEntity {
    int id;
    String firstname;
    String lastname;
    String title;

    public Persona(String category, int frequency, String name, Topic topic, int id, String firstname, String lastname, String title) {
        super(category, frequency, name, topic);
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Persona [id=" + id + ", category=" + category + ", frequency=" + frequency + "]";
    }
}