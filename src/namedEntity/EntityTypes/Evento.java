package namedEntity.EntityTypes;
import namedEntity.NamedEntity;
import java.sql.Date;

public class Evento extends NamedEntity {
    String forma_canonica;
    Date fecha;
    String recurrente;

    public Evento(String category, int frequency, String name, String forma_canonica, Date fecha, String recurrente) {
        super(category, frequency, name);
        this.forma_canonica = forma_canonica;
        this.fecha = fecha;
        this.recurrente = recurrente;
    }

    public String getForma_canonica() {
        return forma_canonica;
    }

    public void setForma_canonica(String forma_canonica) {
        this.forma_canonica = forma_canonica;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getRecurrente() {
        return recurrente;
    }

    public void setRecurrente(String recurrente) {
        this.recurrente = recurrente;
    }

    @Override
    public String toString() {
        return "Evento [forma_canonica=" + forma_canonica + ", fecha=" + fecha + ", recurrente=" + recurrente
                + ", category=" + category + ", frequency=" + frequency + "]";
    }
}
