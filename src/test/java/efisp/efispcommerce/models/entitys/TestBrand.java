package efisp.efispcommerce.models.entitys;

import efisp.efispecommerce.models.entitys.Brand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBrand {
    Brand brand;

    @BeforeEach
    public void Initialize(){
        brand = new Brand(UUID.randomUUID(), "Nvidia");
    }

    @Test
    public void TestBrandGetName() {
        String expected = "Nvidia";
        String actual = brand.getName();

        assertEquals(expected, actual);
    }
}