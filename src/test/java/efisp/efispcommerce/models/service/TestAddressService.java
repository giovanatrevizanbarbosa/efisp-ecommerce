package efisp.efispcommerce.models.service;

import efisp.efispecommerce.dto.AddressDTO;
import efisp.efispecommerce.models.service.AddressService;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestAddressService {

    static AddressService addressService = new AddressService();



    @Test
    public void addAddress() {
        AddressDTO address = new AddressDTO(UUID.randomUUID(), "Rua 1", "123", "Cidade 1", "Estado 1", "12345678");

        assertTrue(addressService.add(address));
    }

    @Test
    public void updateAddress() {
        UUID id = UUID.randomUUID();

        AddressDTO address = new AddressDTO(id, "Rua 1", "123", "Cidade 1", "Estado 1", "12345678");

        assertTrue(addressService.add(address));
        assertTrue(addressService.update(id, address));
    }

    @Test
    public void deleteAddress() {
        UUID id = UUID.randomUUID();

        AddressDTO address = new AddressDTO(id, "Rua 1", "123", "Cidade 1", "Estado 1", "12345678");

        assertTrue(addressService.add(address));
        assertTrue(addressService.delete(id));
    }

    @Test
    public void getAddress() {
        UUID id = UUID.randomUUID();

        AddressDTO address = new AddressDTO(id, "Rua 1", "123", "Cidade 1", "Estado 1", "12345678");

        assertTrue(addressService.add(address));
        assertEquals(address, addressService.getById(id));
    }

    @Test
    public void getAllAddresses() {
        int expected = addressService.getAll().size() + 2;

        AddressDTO address = new AddressDTO(UUID.randomUUID(), "Rua 1", "123", "Cidade 1", "Estado 1", "12345678");
        AddressDTO address2 = new AddressDTO(UUID.randomUUID(), "Rua 2", "456", "Cidade 2", "Estado 2", "87654321");

        addressService.add(address);
        addressService.add(address2);

        int actual = addressService.getAll().size();

        assertEquals(expected, actual);
    }

}
