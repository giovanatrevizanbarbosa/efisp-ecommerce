package efisp.efispcommerce.models.entitys;

import efisp.efispecommerce.models.entitys.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAddress {
    Address address;

    @BeforeEach
    public void Initialize(){
        address = new Address(UUID.randomUUID(), "Rua Yoki", 700, "Araraquara", "SP", "14800200");
    }

    @Test
    public void TestAddressGetStreet() {
        String expected = "Rua Yoki";
        String actual = address.getStreet();

        assertEquals(expected, actual);
    }

    @Test
    public void TestAddressGetNumber() {
        int expected = 700;
        int actual = address.getNumber();

        assertEquals(expected, actual);
    }

    @Test
    public void TestAddressGetCity() {
        String expected = "Araraquara";
        String actual = address.getCity();

        assertEquals(expected, actual);
    }

    @Test
    public void TestAddressGetState() {
        String expected = "SP";
        String actual = address.getState();

        assertEquals(expected, actual);
    }

    @Test
    public void TestAddressGetZip() {
        String expected = "14800200";
        String actual = address.getZip();

        assertEquals(expected, actual);
    }
}