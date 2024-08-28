package efisp.efispcommerce.models.entitys;

import efisp.efispecommerce.models.entitys.Brand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBrand {
    Brand brand;

    public void Initialize(){
        brand = new Brand(1L, "Nvidia");
    }

    @Test
    public void TestBrandGetName() {
        Initialize();

        String expected = "Nvidia";
        String actual = brand.getName();

        assertEquals(expected, actual);
    }
}