package objectsTest;

import characters.Hero;
import objects.SexyPoster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.Place;
import others.Script;

import static org.junit.jupiter.api.Assertions.*;

class SexyPosterTest {

    private SexyPoster sp;
    private Hero h;

    @BeforeEach
    void setUp() {
        Place a = new Place("Place", false, true);

        h = new Hero("Test", a);

        sp = new SexyPoster(Script.DEFAULT_SEXYPOSTER_NAME);
        a.addObject(sp);
    }

    @Test
    void take() {
        sp.take(h);
        assertTrue(h.getObjs().containsValue(sp));
        assertFalse(h.getPlace().getItems().containsValue(sp));
    }

    @Test
    void look() {
        sp.look();
    }

    @Test
    void use() {
        h.take(Script.DEFAULT_SEXYPOSTER_NAME);
        assertTrue(h.getObjs().containsValue(sp));
        sp.use(h);
        assertFalse(h.getObjs().containsValue(sp));
        assertEquals(Hero.DEFAULT_HP+20, h.getHP());
    }

    @Test
    void testUse() {
        sp.use(h, "Test");
    }

    @Test
    void toStringTest() {
        System.out.println(sp.toString());
    }
}