package json.another_dependent_package;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void findTag() {
        assertEquals("b", Main.findTag("<b>").orElse(""));
        assertEquals("b", Main.findTag("hello<b>").orElse(""));
        assertEquals("div", Main.findTag("hello<div><b></div>").orElse(""));
    }
}
