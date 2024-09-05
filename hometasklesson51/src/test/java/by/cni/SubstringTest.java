package by.cni;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubstringTest {

    private final Substring substring = new Substring();

    @Test
    void testWithoutUpperCase() {
        //given
        String fullstr = "Hello World";
        String substr = "o World";

        //when
        Boolean result = substring.presenceOfSubstring(fullstr, substr);

        //then
        assertTrue(result);
    }

    @Test
    void testWithUpperCase() {
        //given
        String fullstr = "Hello World";
        String substr = "o WORLD";

        //when
        Boolean result = substring.presenceOfSubstring(fullstr, substr);

        //then
        assertTrue(result);
    }

    @Test
    void testEmptyStringCase() {
        //given
        String fullstr = "Hello World";
        String substr = "";

        //when
        Boolean result = substring.presenceOfSubstring(fullstr, substr);

        //then
        assertTrue(result);
    }

    @Test
    void testNullPointerCase() {
        //given
        String fullstr = "Hello World";
        String substr = null;

        //when and then
        Assertions.assertThrows(NullPointerException.class,
                () -> {substring.presenceOfSubstring(fullstr, substr);});
    }
}