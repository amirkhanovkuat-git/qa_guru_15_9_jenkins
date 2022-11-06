package tests.simple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class DisabledTests {

    @Test
    @Disabled
    void test1() {
        assertFalse(false);
    }

    @Test
    @Disabled("Any text here")
    void test2() {
        assertFalse(false);
    }

}
