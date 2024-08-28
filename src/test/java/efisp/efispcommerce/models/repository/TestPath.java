package efisp.efispcommerce.models.repository;

import efisp.efispecommerce.models.repository.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPath {

    @Test
    public void testPath(){
        String path = Util.RESOURCES_PATH.value();
        String expected = "/efisp-ecommerce/resources/database";

        path = path.substring(path.length() - expected.length());

        assertEquals(expected, path);
    }
}
