package doorTest;

import characters.Hero;
import doors.InfectedRoomDoor;
import objects.Potion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.Place;
import others.Script;

import static org.junit.jupiter.api.Assertions.*;

class InfectedRoomDoorTest {

    private Place b;
    private Place a;
    private Hero h;
    private InfectedRoomDoor d;
    private Potion p;

    @BeforeEach
    void setUp() {
        a = new Place("PlaceA", false, true);
        b = new Place("PlaceB", false, true);

        d = new InfectedRoomDoor(b, null);

        a.addDoor(d, "right");
        b.addDoor(d, "left");

        p = new Potion(Script.DEFAULT_POTION_NAME);
        a.addObject(p);

        h = new Hero("Test", a);
    }

    @Test
    void open() {
        d.open();
        assertFalse(d.isOpen());
    }

    @Test
    void cross() {
        // case without potion
        d.cross(h, "PlaceB");
        assertEquals(a, h.getPlace());

        // case with Potion
        h.take("Potion");
        assertTrue(h.getObjs().containsValue(p));
        assertFalse(a.getItems().containsValue(p));
        h.use("Potion");
        assertTrue(h.isImmun());

        d.cross(h, "PlaceB");
        assertTrue(d.isUnlock());
        assertTrue(d.isOpen());
        assertEquals(b, h.getPlace());

    }
}