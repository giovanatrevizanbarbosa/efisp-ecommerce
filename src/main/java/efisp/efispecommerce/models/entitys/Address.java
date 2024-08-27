package efisp.efispecommerce.models.entitys;

import efisp.efispecommerce.models.repository.Writable;
import efisp.efispecommerce.models.repository.csv.Csv;

public class Address extends Writable {
    private final String street;
    private final String number;
    private final String city;
    private final String state;
    private final String zip;

    public Address(Long id, String street, String number, String city, String state, String zip) {
        super(id);
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
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

    @Override
    public Csv toCSV() {
        return new Csv(
            new String[]{"id", "street", "number", "city", "state", "zip"},
            new String[]{getId().toString(), street, number, city, state, zip}
        );
    }
}