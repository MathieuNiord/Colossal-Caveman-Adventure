package objectsTest;

import characters.Hero;
import objects.ElectricityMeter;
import objects.Fuse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.Place;
import others.Script;

import static org.junit.jupiter.api.Assertions.*;

class ElectricityMeterTest {

    private ElectricityMeter e;
    private Hero h;


    @BeforeEach
    void setUp() {
        Place a = new Place("Place", false, false);

        e = new ElectricityMeter(Script.DEFAULT_ELECTRICMETER_NAME, a);
        a.addObject(e);

        h = new Hero("Test", a);
    }

    @Test
    void setHasFuse() {
        e.setHasFuse();
        assertTrue(e.getHasFuse());
    }

    @Test
    void look() {
        // case without Fuse
        e.look();

        // case with Fuse
        e.setHasFuse();
        e.look();
    }

    @Test
    void take() {
        h.take(Script.DEFAULT_ELECTRICMETER_NAME);
        assertFalse(h.getObjs().containsValue(e));
        assertTrue(h.getPlace().getItems().containsValue(e));
    }

    @Test
    void use() {
        e.use(h);
    }

    @Test
    void testUse() {
        Fuse f = new Fuse(Script.DEFAULT_FUSE_NAME);
        h.getPlace().addObject(f);

        h.take(Script.DEFAULT_FUSE_NAME);
        assertTrue(h.getObjs().containsValue(f));
        assertFalse(h.getPlace().getItems().containsValue(f));

        assertFalse(e.getPlace().isEnlightened());

        e.use(h, Script.DEFAULT_FUSE_NAME);
        assertFalse(h.getObjs().containsValue(f));
        assertTrue(e.getHasFuse());
        assertTrue(e.getPlace().isEnlightened());

        // case when the Fuse is set
        e.use(h);
    }

    @Test
    void toStringTest() {
        System.out.println(e.toString());
    }
}