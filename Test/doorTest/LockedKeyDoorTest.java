package doorTest;

import characters.Hero;
import doors.LockedKeyDoor;
import objects.Key;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.Place;
import others.Script;

import static org.junit.jupiter.api.Assertions.*;

class LockedKeyDoorTest {

    private Place b;
    private Place a;
    private Hero h;
    private LockedKeyDoor d;
    private Key k;

    @BeforeEach
    void setUp() {
        a = new Place("PlaceA", false, true);
        b = new Place("PlaceB", false, true);

        d = new LockedKeyDoor(1, b, null);

        a.addDoor(d, "right");
        b.addDoor(d, "left");

        k = new Key(Script.DEFAULT_KEY1_NAME);
        a.addObject(k);

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
        // case without key
        d.unlock();
        assertFalse(d.isUnlock());
        assertFalse(d.isOpen());

        // case with Key
        h.take(k.NAME);
        assertTrue(h.getObjs().containsValue(k));
        assertFalse(a.getItems().containsValue(k));
        assertEquals(Hero.DEFAULT_KEY_LEVEL+1, h.getKeyLevel());

        d.unlock(h.getKeyLevel());
        assertTrue(d.isUnlock());
        assertTrue(d.isOpen());
    }

    @Test
    void cross() {
        // case without key
        d.cross(h, "PlaceB");
        assertEquals(a, h.getPlace());

        // case with Key
        h.take(k.NAME);
        assertTrue(h.getObjs().containsValue(k));
        assertFalse(a.getItems().containsValue(k));
        assertEquals(Hero.DEFAULT_KEY_LEVEL+1, h.getKeyLevel());
        d.cross(h, "PlaceB");
        assertEquals(b, h.getPlace());
    }
}