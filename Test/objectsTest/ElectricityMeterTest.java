package objectsTest;

import characters.Hero;
import objects.ElectricityMeter;
import objects.Fuse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.Place;

import static org.junit.jupiter.api.Assertions.*;

class ElectricityMeterTest {

    private ElectricityMeter e;
    private Hero h;


    @BeforeEach
    void setUp() {
        Place a = new Place("Place", false, false);

        e = new ElectricityMeter("ElecTest", a);
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
        h.take("ElecTest");
        assertFalse(h.getObjs().containsValue(e));
        assertTrue(h.getPlace().getItems().containsValue(e));
    }

    @Test
    void use() {
        Fuse f = new Fuse("Fuse");
        h.getPlace().addObject(f);

        h.take("Fuse");
        assertTrue(h.getObjs().containsValue(f));
        assertFalse(h.getPlace().getItems().containsValue(f));

        assertFalse(e.getPlace().isEnlightened());

        e.use(h);
        assertFalse(h.getObjs().containsValue(f));
        assertTrue(e.getHasFuse());
        assertTrue(e.getPlace().isEnlightened());

        // case when the Fuse is set
        e.use(h);
    }

    @Test
    void testUse() {
        e.use(h, "Test");
    }
}