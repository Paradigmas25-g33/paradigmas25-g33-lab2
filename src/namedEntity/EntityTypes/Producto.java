package namedEntity.EntityTypes;
import namedEntity.NamedEntity;
import topic.Topic;

public class Producto extends NamedEntity {
    String comercial;
    String productor;

    public Producto(String category, int frequency, String name, Topic topic, String comercial, String productor) {
        super(category, frequency, name, topic);
        this.comercial = comercial;
        this.productor = productor;
    }

    public String getComercial() {
        return comercial;
    }

    public void setComercial(String comercial) {
        this.comercial = comercial;
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    @Override
    public String toString() {
        return "Producto [comercial=" + comercial + ", productor=" + productor + ", category=" + category
                + ", frequency=" + frequency + "]";
    }  
}
