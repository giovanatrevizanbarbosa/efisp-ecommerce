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
        addressIDao = Dao.getInstance(Address.class);
    }

    @Override
    @Test
    public void add() {
        Address address = new Address(addressIDao.getNextId(),"Rua 1", 123, "Cidade 1", "Estado 1", "12345678");
        Address address2 = new Address(addressIDao.getNextId(),"Rua 2", 456, "Cidade 2", "Estado 2", "87654321");

        assertTrue(addressIDao.add(address));
        assertTrue(addressIDao.add(address2));
    }

    @Override
    @Test
    public void getById() {
        Long id = addressIDao.getNextId();
        Address address = new Address(id,"Rua 1", 123, "Cidade 1", "Estado 1", "12345678");

        addressIDao.add(address);

        assertEquals(address, addressIDao.getById(id));
    }

    @Override
    @Test
    public void getAll() {
        int expected = addressIDao.getAll().size() + 2;

        Address address = new Address(addressIDao.getNextId(),"Rua 1", 123, "Cidade 1", "Estado 1", "12345678");
        Address address2 = new Address(addressIDao.getNextId(),"Rua 2", 456, "Cidade 2", "Estado 2", "87654321");

        addressIDao.add(address);
        addressIDao.add(address2);

        int actual = addressIDao.getAll().size();

        assertEquals(expected, actual);
    }

    @Override
    @Test
    public void update() {

        Long id = addressIDao.getNextId();
        Address address = new Address(id,"Rua 1", 123, "Cidade 1", "Estado 1", "12345678");
        addressIDao.add(address);
        Address address2 = new Address(id,"Rua 3", 789, "Cidade 3", "Estado 3", "87654321");

        assertTrue(addressIDao.update(id, address2));
    }

    @Override
    @Test
    public void delete() {
        Long id = addressIDao.getNextId();
        Address address = new Address(id,"Rua 1", 123, "Cidade 1", "Estado 1", "12345678");

        addressIDao.add(address);

        assertTrue(addressIDao.delete(id));
    }

}
