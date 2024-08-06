package efisp.efispcommerce;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHello {
    @Test
    public void testHello(){
        String expected = "Hello World!";
        String actual = "Hello World!";

        assertEquals(expected, actual);
    }
}
