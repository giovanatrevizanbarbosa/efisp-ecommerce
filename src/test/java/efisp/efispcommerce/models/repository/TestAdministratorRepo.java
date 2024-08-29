package efisp.efispcommerce.models.repository;

import efisp.efispecommerce.models.entitys.Administrator;
import efisp.efispecommerce.models.entitys.Title;
import efisp.efispecommerce.models.repository.IRepository;
import efisp.efispecommerce.models.repository.Repository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAdministratorRepo implements TestRepo {

    IRepository<Administrator> administratorIRepository = new Repository<>(Administrator.class);
    static IRepository<Title> titleIRepository = new Repository<>(Title.class);

    @BeforeAll
    public static void Initialize(){
        titleIRepository.add(new Title(1L, "ADMIN", 1));
    }

    @Override
    @Test
    public void add() {
        Administrator administrator = new Administrator(1L, "Cauã", "caua.email.com", "Password123", titleIRepository.getAll().getFirst());
        Administrator administrator2 = new Administrator(2L, "João", "joao.email.com", "Password123", titleIRepository.getAll().getFirst());

        assertTrue(administratorIRepository.add(administrator));
        assertTrue(administratorIRepository.add(administrator2));
        assertFalse(administratorIRepository.add(administrator));
    }

    @Override
    @Test
    public void update() {
        Administrator administrator = new Administrator(1L, "Cauã", "caua.email.com", "Password123", titleIRepository.getAll().getFirst());
        Administrator administrator2 = new Administrator(2L, "João", "joao.email.com", "Password123", titleIRepository.getAll().getFirst());

        administratorIRepository.add(administrator);
        administratorIRepository.add(administrator2);

        Administrator administrator3 = new Administrator(3L, "Kauam", "caua.email.com", "Password123", titleIRepository.getAll().getFirst());

        assertTrue(administratorIRepository.update(1L, administrator3));
    }

    @Override
    @Test
    public void delete() {
        Administrator administrator = new Administrator(1L, "Cauã", "caua.email.com", "Password123", titleIRepository.getAll().getFirst());
        Administrator administrator2 = new Administrator(2L, "João", "joao.email.com", "Password123", titleIRepository.getAll().getFirst());

        administratorIRepository.add(administrator);
        administratorIRepository.add(administrator2);

        assertTrue(administratorIRepository.delete(1L));
    }

    @Override
    @Test
    public void getById() {
        Administrator administrator = new Administrator(1L, "Cauã", "caua.email.com", "Password123", titleIRepository.getAll().getFirst());
        Administrator administrator2 = new Administrator(2L, "João", "joao.email.com", "Password123", titleIRepository.getAll().getFirst());

        administratorIRepository.add(administrator);
        administratorIRepository.add(administrator2);

        var actual = administratorIRepository.getById(2L);
        assertEquals(administrator2.getId(), actual.getId());
    }

    @Override
    @Test
    public void getAll() {
        Administrator administrator = new Administrator(1L, "Cauã", "caua.email.com", "Password123", titleIRepository.getAll().getFirst());
        Administrator administrator2 = new Administrator(2L, "João", "joao.email.com", "Password123", titleIRepository.getAll().getFirst());

        administratorIRepository.add(administrator);
        administratorIRepository.add(administrator2);

        var expected = 2;
        var actual = administratorIRepository.getAll().size();

        assertEquals(expected, actual);
        assertEquals(administrator, administratorIRepository.getAll().getFirst());
        assertEquals(administrator2, administratorIRepository.getAll().getLast());
    }

}
