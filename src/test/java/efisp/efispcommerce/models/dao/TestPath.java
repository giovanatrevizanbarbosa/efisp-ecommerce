package efisp.efispcommerce.models.dao;

import efisp.efispecommerce.models.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPath {

    @Test
    public void testPath(){
        String path = Util.RESOURCES_PATH_FOR_TEST.value();
        String expected = "/efisp-ecommerce/resources/testDatabase";
        String orElse = "\\efisp-ecommerce\\resources\\testDatabase";

        path = path.substring(path.length() - expected.length());

        try{
            assertEquals(expected, path);
        } catch (AssertionError e){
            assertEquals(orElse, path);
        }
    }
}
