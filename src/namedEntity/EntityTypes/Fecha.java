package namedEntity.EntityTypes;
import namedEntity.NamedEntity;
import topic.Topic;
import java.sql.Date;

public class Fecha extends NamedEntity {
    Date fecha;

    public Fecha(String category, int frequency, String name, Topic topic, Date fecha) {
        super(category, frequency, name, topic);
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Fecha [fecha=" + fecha + ", category=" + category + ", frequency=" + frequency + "]";
    }
    
}
