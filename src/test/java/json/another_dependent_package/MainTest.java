package json.another_dependent_package;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void findTag() {
        assertArrayEquals(new String[]{"b"}, Main.findTag("<b>").toArray());
        assertArrayEquals(new String[]{"b"}, Main.findTag("hello<b>").toArray());
        assertArrayEquals(
                new String[]{"div","b","/div"},
                Main.findTag("hello<div><b></div>").toArray());
    }

    @Test
    void HTMLElements() {
        assertEquals("div", Main.HTMLElements("<div><div><b></b></div></p>"));
        assertEquals("i", Main.HTMLElements("<div>abc</div><p><em><i>test test test</b></em></p>"));
        assertEquals("true", Main.HTMLElements("<div>abc</div><p><em><i>test test test</i></em></p>"));
    }
}
