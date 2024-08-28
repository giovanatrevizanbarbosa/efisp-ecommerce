package efisp.efispcommerce.models.dao;

import efisp.efispecommerce.models.entitys.Address;
import efisp.efispecommerce.models.repository.IRepository;
import efisp.efispecommerce.models.repository.Repository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestAddressRepo {

    IRepository<Address> addressIRepository;

    public void Initialize(){
        addressIRepository = new Repository<>(Address.class);
    }

    @Test
    public void TestAddressRepoAdd() {
        Initialize();

        Address address = new Address(1L,"Rua 1", "123", "Cidade 1", "Estado 1", "12345678");
        Address address2 = new Address(1L,"Rua 2", "456", "Cidade 2", "Estado 2", "87654321");

        var bool = addressIRepository.add(address);
        var bool2 = addressIRepository.add(address2);
        var expected = addressIRepository.getAll();

        assertTrue(bool);
        assertTrue(bool2);
        assertEquals(expected.getFirst().getId(), address.getId());
    }


    @Test
    public void TestAddressRepoGetById() {
        Initialize();

        Address address = new Address(1L,"Rua 1", "123", "Cidade 1", "Estado 1", "12345678");
        Address address2 = new Address(1L,"Rua 2", "456", "Cidade 2", "Estado 2", "87654321");

        addressIRepository.add(address);
        addressIRepository.add(address2);

        var actual = addressIRepository.getById(1);
        assertEquals(address.getId(), actual.getId());
    }


}
