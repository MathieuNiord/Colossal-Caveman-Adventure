package doorTest;

import characters.Hero;
import doors.SecretCodeDoor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.Place;

import static org.junit.jupiter.api.Assertions.*;

class SecretCodeDoorTest {

    private Place b;
    private Place a;
    private Hero h;
    private SecretCodeDoor d;

    @BeforeEach
    void setUp() {
        a = new Place("PlaceA", false, true);
        b = new Place("PlaceB", false, true);

        d = new SecretCodeDoor("TEST", b, null);

        a.addDoor(d, "right");
        b.addDoor(d, "left");

        h = new Hero("Test", a);
    }

    @Test
    void open() {
        d.open();
        assertFalse(d.isOpen());
    }

    @Test
    void unlock() {
        d.unlock();
        assertFalse(d.isUnlock());
    }

    @Test
    void testUnlock() {
        // case null
        d.unlock(null);
        assertFalse(d.isUnlock());
        assertFalse(d.isOpen());

        // case Wrong code
        d.unlock("WRONG");
        assertFalse(d.isUnlock());
        assertFalse(d.isOpen());

        // case Good Code
        d.unlock("TEST");
        assertTrue(d.isUnlock());
        assertTrue(d.isOpen());
    }

    @Test
    void cross() {
        /* We can't use a scanner in Tests ?

        // case wrong place
        d.cross(h, "Pla");
        assertEquals(a, h.getPlace());

        // case good place
        d.cross(h, "PlaceB");
        assertTrue(d.isUnlock());
        assertTrue(d.isOpen());
        assertEquals(b, h.getPlace());

        */
    }
}