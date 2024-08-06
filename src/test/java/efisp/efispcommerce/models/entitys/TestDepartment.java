package efisp.efispcommerce.models.entitys;

import efisp.efispecommerce.models.entitys.Department;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDepartment {
    Department department;

    public void Initialize() {
        department = new Department("Hardware", "Hardwares department");
    }

    @Test
    public void TestDepartmentGetName() {
        Initialize();

        String expected = "Hardware";
        String actual = department.getName();

        assertEquals(expected, actual);
    }

    @Test
    public void TestDepartmentGetDescription() {
        Initialize();

        String expected = "Hardwares department";
        String actual = department.getDescription();

        assertEquals(expected, actual);
    }
}