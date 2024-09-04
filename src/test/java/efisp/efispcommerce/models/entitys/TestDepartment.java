package efisp.efispcommerce.models.entitys;

import efisp.efispecommerce.models.entitys.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDepartment {
    Department department;

    @BeforeEach
    public void Initialize() {
        department = new Department(UUID.randomUUID(), "Hardware", "Hardwares department");
    }

    @Test
    public void TestDepartmentGetName() {
        String expected = "Hardware";
        String actual = department.getName();

        assertEquals(expected, actual);
    }

    @Test
    public void TestDepartmentGetDescription() {
        String expected = "Hardwares department";
        String actual = department.getDescription();

        assertEquals(expected, actual);
    }
}