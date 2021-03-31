package stuff.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address extends BaseEntity{

    private String country;
    private String city;
    private String neighbourhood;
    private String street;
    private int number;
    private int postalCode;

    public Address() {
    }

    @Column(name = "country",nullable = false)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "city",nullable = false)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @Column(name = "neighbourhood")
    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    @Column(name = "street",nullable = false)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    @Column(name = "number",nullable = false)
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    @Column(name = "postal_code",nullable = false)
    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
}
