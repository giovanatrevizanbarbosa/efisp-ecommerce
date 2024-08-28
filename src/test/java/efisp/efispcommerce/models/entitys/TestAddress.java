package efisp.efispcommerce.models.entitys;

import efisp.efispecommerce.models.entitys.Address;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAddress {
    Address address;

    public void Initialize(){
        address = new Address(1L, "Rua Yoki", 700, "Araraquara", "SP", "14800200");
    }

    @Test
    public void TestAddressGetStreet() {
        Initialize();

        String expected = "Rua Yoki";
        String actual = address.getStreet();

        assertEquals(expected, actual);
    }

    @Test
    public void TestAddressGetNumber() {
        Initialize();

        int expected = 700;
        int actual = address.getNumber();

        assertEquals(expected, actual);
    }

    @Test
    public void TestAddressGetCity() {
        Initialize();

        String expected = "Araraquara";
        String actual = address.getCity();

        assertEquals(expected, actual);
    }

    @Test
    public void TestAddressGetState() {
        Initialize();

        String expected = "SP";
        String actual = address.getState();

        assertEquals(expected, actual);
    }

    @Test
    public void TestAddressGetZip() {
        Initialize();

        String expected = "14800200";
        String actual = address.getZip();

        assertEquals(expected, actual);
    }
}