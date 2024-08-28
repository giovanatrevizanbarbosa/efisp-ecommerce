package efisp.efispcommerce.models.repository;

import efisp.efispecommerce.models.entitys.Address;
import efisp.efispecommerce.models.repository.IRepository;
import efisp.efispecommerce.models.repository.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAddressRepo {

    IRepository<Address> addressIRepository;

    @BeforeEach
    public void Initialize(){
        addressIRepository = new Repository<>(Address.class);
    }

    @Test
    public void TestAddressRepoAdd() {
        Address address = new Address(1L,"Rua 1", 123, "Cidade 1", "Estado 1", "12345678");
        Address address2 = new Address(2L,"Rua 2", 456, "Cidade 2", "Estado 2", "87654321");

        var bool = addressIRepository.add(address);
        var bool2 = addressIRepository.add(address2);
        var expected = addressIRepository.getAll();

        assertTrue(bool);
        assertTrue(bool2);
        assertEquals(expected.getFirst().getId(), address.getId());
    }


    @Test
    public void TestAddressRepoGetById() {
        Address address = new Address(1L,"Rua 1", 123, "Cidade 1", "Estado 1", "12345678");
        Address address2 = new Address(2L,"Rua 2", 456, "Cidade 2", "Estado 2", "87654321");

        addressIRepository.add(address);
        addressIRepository.add(address2);

        var actual = addressIRepository.getById(1);
        assertEquals(address.getId(), actual.getId());
    }

    @Test
    public void TestAddressRepoGetAll() {
        Address address = new Address(1L,"Rua 1", 123, "Cidade 1", "Estado 1", "12345678");
        Address address2 = new Address(2L,"Rua 2", 456, "Cidade 2", "Estado 2", "87654321");

        addressIRepository.add(address);
        addressIRepository.add(address2);

        var expected = 2;
        var actual = addressIRepository.getAll().size();

        assertEquals(expected, actual);
        assertEquals(address, addressIRepository.getAll().getFirst());
    }

    @Test
    public void TestAddressRepoUpdate() {
        Address address = new Address(1L,"Rua 1", 123, "Cidade 1", "Estado 1", "12345678");
        Address address2 = new Address(2L,"Rua 2", 456, "Cidade 2", "Estado 2", "87654321");

        addressIRepository.add(address);
        addressIRepository.add(address2);

        Address address3 = new Address(3L,"Rua 3", 789, "Cidade 3", "Estado 3", "87654321");

        var bool = addressIRepository.update(1L, address3);
        var expected = addressIRepository.getById(3L);
        var expected2 = addressIRepository.getById(1L);

        assertTrue(bool);
        assertNull(expected2);
        assertEquals(expected, address3);
    }


    @Test
    public void TestAddressRepoDelete() {
        Address address = new Address(1L,"Rua 1", 123, "Cidade 1", "Estado 1", "12345678");
        Address address2 = new Address(2L,"Rua 2", 456, "Cidade 2", "Estado 2", "87654321");

        addressIRepository.add(address);
        addressIRepository.add(address2);

        assertTrue(addressIRepository.delete(1L));
        assertEquals(address2, addressIRepository.getById(2L));
        assertEquals(1, addressIRepository.getAll().size());
    }

}
