package doorTest;

import characters.Hero;
import doors.DestructableDoor;
import objects.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.Place;
import others.Script;

import static org.junit.jupiter.api.Assertions.*;

class DestructableDoorTest {

    private Place b;
    private Place a;
    private Hero h;
    private DestructableDoor d;
    private Weapon w;

    @BeforeEach
    void setUp() {
        a = new Place("placea", false, true);
        b = new Place("placeb", false, true);

        d = new DestructableDoor(b, null);

        a.addDoor(d, "right");
        b.addDoor(d, "left");

        w = new Weapon(Script.DEFAULT_CLUB_NAME);
        a.addObject(w);

        h = new Hero("Test", a);
    }

    @Test
    void open() {
        d.open();
        assertFalse(d.isOpen());
    }

    @Test
    void cross() {
        // case without club
        d.cross(h,"PlaceB");
        assertEquals(a, h.getPlace());

        // case with club
        h.take(w.NAME);
        assertTrue(h.getObjs().containsValue(w));
        assertFalse(a.getItems().containsValue(w));
        d.cross(h, "PlaceB");
        assertTrue(d.isUnlock());
        assertTrue(d.isOpen());
        assertEquals(b, h.getPlace());

    }
}