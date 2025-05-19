package namedEntity.EntityTypes;
import namedEntity.NamedEntity;
import topic.Topic;

public class Lugar extends NamedEntity{
    String country;
    String city;
    String address;

    public Lugar(String category, int frequency, String name, Topic topic, String country, String city, String address) {
        super(category, frequency, name, topic);
        this.country = country;
        this.city = city;
        this.address = address;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Lugar [country=" + country + ", city=" + city + ", address=" + address + ", category=" + category + ", frequency=" + frequency + "]";
    }
}
