package namedEntity.EntityTypes;
import java.sql.Date;

import namedEntity.NamedEntity;

public class Fecha extends NamedEntity {
    Date fecha;

    public Fecha(String category, int frequency, String name, Date fecha) {
        super(category, frequency, name);
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
