package efisp.efispcommerce.models.repository;

import efisp.efispecommerce.models.entitys.Address;
import efisp.efispecommerce.models.repository.IRepository;
import efisp.efispecommerce.models.repository.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAddressRepo implements TestRepo{

    IRepository<Address> addressIRepository;

    @BeforeEach
    public void Initialize(){
        addressIRepository = new Repository<>(Address.class);
    }

    @Override
    @Test
    public void add() {
        Address address = new Address(1L,"Rua 1", 123, "Cidade 1", "Estado 1", "12345678");
        Address address2 = new Address(2L,"Rua 2", 456, "Cidade 2", "Estado 2", "87654321");

        assertTrue(addressIRepository.add(address));
        assertTrue(addressIRepository.add(address2));
        assertEquals(addressIRepository.getAll().getFirst().getId(), address.getId());
    }

    @Override
    @Test
    public void getById() {
        Address address = new Address(1L,"Rua 1", 123, "Cidade 1", "Estado 1", "12345678");
        Address address2 = new Address(2L,"Rua 2", 456, "Cidade 2", "Estado 2", "87654321");

        addressIRepository.add(address);
        addressIRepository.add(address2);

        var actual = addressIRepository.getById(2);
        assertEquals(address2.getId(), actual.getId());
    }

    @Override
    @Test
    public void getAll() {
        Address address = new Address(1L,"Rua 1", 123, "Cidade 1", "Estado 1", "12345678");
        Address address2 = new Address(2L,"Rua 2", 456, "Cidade 2", "Estado 2", "87654321");

        addressIRepository.add(address);
        addressIRepository.add(address2);

        var expected = 2;
        var actual = addressIRepository.getAll().size();

        assertEquals(expected, actual);
        assertEquals(address, addressIRepository.getAll().getFirst());
    }

    @Override
    @Test
    public void update() {
        Address address = new Address(1L,"Rua 1", 123, "Cidade 1", "Estado 1", "12345678");
        Address address2 = new Address(2L,"Rua 2", 456, "Cidade 2", "Estado 2", "87654321");

        addressIRepository.add(address);
        addressIRepository.add(address2);

        Address address3 = new Address(3L,"Rua 3", 789, "Cidade 3", "Estado 3", "87654321");

        assertTrue(addressIRepository.update(1L, address3));
        assertNull(addressIRepository.getById(1L));
        assertEquals(addressIRepository.getById(3L), address3);
    }

    @Override
    @Test
    public void delete() {
        Address address = new Address(1L,"Rua 1", 123, "Cidade 1", "Estado 1", "12345678");
        Address address2 = new Address(2L,"Rua 2", 456, "Cidade 2", "Estado 2", "87654321");

        addressIRepository.add(address);
        addressIRepository.add(address2);

        assertTrue(addressIRepository.delete(1L));
        assertEquals(addressIRepository.getById(2L), address2);
        assertEquals(addressIRepository.getAll().size(), 1);
    }

}
