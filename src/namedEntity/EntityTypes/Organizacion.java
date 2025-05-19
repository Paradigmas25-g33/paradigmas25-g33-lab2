package namedEntity.EntityTypes;
import namedEntity.NamedEntity;
import topic.Topic;

public class Organizacion extends NamedEntity {
    String nombre;
    int cant_miembros;
    String tipo;

    public Organizacion(String category, int frequency, String name, Topic topic, String nombre, int cant_miembros, String tipo) {
        super(category, frequency, name, topic);
        this.nombre = nombre;
        this.cant_miembros = cant_miembros;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCant_miembros() {
        return cant_miembros;
    }

    public void setCant_miembros(int cant_miembros) {
        this.cant_miembros = cant_miembros;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Organizacion [nombre=" + nombre + ", cant_miembros=" + cant_miembros + ", tipo=" + tipo
                + ", category=" + category + ", frequency=" + frequency + "]";
    } 
}
