package efisp.efispcommerce.models.dao;

import efisp.efispecommerce.models.entitys.Address;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.dao.Dao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAddressDao implements TestDao {

    IDao<Address> addressIDao;

    @BeforeEach
    public void Initialize(){
        addressIDao = new Dao<>(Address.class);
    }

    @Override
    @Test
    public void add() {
        Address address = new Address(1L,"Rua 1", 123, "Cidade 1", "Estado 1", "12345678");
        Address address2 = new Address(2L,"Rua 2", 456, "Cidade 2", "Estado 2", "87654321");

        assertTrue(addressIDao.add(address));
        assertTrue(addressIDao.add(address2));
        assertEquals(addressIDao.getAll().getFirst().getId(), address.getId());
    }

    @Override
    @Test
    public void getById() {
        Address address = new Address(1L,"Rua 1", 123, "Cidade 1", "Estado 1", "12345678");
        Address address2 = new Address(2L,"Rua 2", 456, "Cidade 2", "Estado 2", "87654321");

        addressIDao.add(address);
        addressIDao.add(address2);

        var actual = addressIDao.getById(2);
        assertEquals(address2.getId(), actual.getId());
    }

    @Override
    @Test
    public void getAll() {
        Address address = new Address(1L,"Rua 1", 123, "Cidade 1", "Estado 1", "12345678");
        Address address2 = new Address(2L,"Rua 2", 456, "Cidade 2", "Estado 2", "87654321");

        addressIDao.add(address);
        addressIDao.add(address2);

        var expected = 2;
        var actual = addressIDao.getAll().size();

        assertEquals(expected, actual);
        assertEquals(address, addressIDao.getAll().getFirst());
    }

    @Override
    @Test
    public void update() {
        Address address = new Address(1L,"Rua 1", 123, "Cidade 1", "Estado 1", "12345678");
        Address address2 = new Address(2L,"Rua 2", 456, "Cidade 2", "Estado 2", "87654321");

        addressIDao.add(address);
        addressIDao.add(address2);

        Address address3 = new Address(3L,"Rua 3", 789, "Cidade 3", "Estado 3", "87654321");

        assertTrue(addressIDao.update(1L, address3));
        assertNull(addressIDao.getById(1L));
        assertEquals(addressIDao.getById(3L), address3);
    }

    @Override
    @Test
    public void delete() {
        Address address = new Address(1L,"Rua 1", 123, "Cidade 1", "Estado 1", "12345678");
        Address address2 = new Address(2L,"Rua 2", 456, "Cidade 2", "Estado 2", "87654321");

        addressIDao.add(address);
        addressIDao.add(address2);

        assertTrue(addressIDao.delete(1L));
        assertEquals(addressIDao.getById(2L), address2);
        assertEquals(addressIDao.getAll().size(), 1);
    }

}
