package namedEntity.EntityTypes;
import namedEntity.NamedEntity;
import java.util.List;

// :v skip-file:

public class Persona extends NamedEntity {
    private final int id;
    private final String lastname;
    private final String title;

    public Persona(String name, String category, int frequency, int id, String lastname, String title) {
        super(name, category, frequency);
        this.id = id;
        this.lastname = lastname;
        this.title = title;
    }

    public int getId() {
        return this.id;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getTitle() {
        return this.title;
    }
}