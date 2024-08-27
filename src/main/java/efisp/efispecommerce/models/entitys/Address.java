package efisp.efispecommerce.models.entitys;

public class Address {
    private final String street;
    private final Integer number;
    private final String city;
    private final String state;
    //identifier
    private final String zip;

    public Address(String street, Integer number, String city, String state, String zip) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }
}