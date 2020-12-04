package doorTest;

import characters.Hero;
import doors.BurnableDoor;
import doors.Door;
import objects.FiredStick;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.Place;
import others.Script;

import static org.junit.jupiter.api.Assertions.*;

class BurnableDoorTest {

    private Place A;
    private Place B;
    private Hero h;
    private Door d;
    private FiredStick fs;

    @BeforeEach
    void setUp() {
        A = new Place("PlaceA", false, true);
        B = new Place("PlaceB", false, true);

        d = new BurnableDoor(B, null);

        A.addDoor(d, "right");
        B.addDoor(d, "left");

        fs = new FiredStick(Script.DEFAULT_FIREDSTICK_NAME);
        A.addObject(fs);

        h = new Hero("Ben", A);
    }

    @Test
    void open() {
        d.open();
        assertFalse(d.isOpen());
    }


    @Test
    void cross() {
        // case without firedStick
        d.cross(h, "PlaceB");

        // case with the firedStick
        h.take(Script.DEFAULT_FIREDSTICK_NAME);
        d.cross(h, "PlaceB");
        assertTrue(d.isOpen());
        assertFalse(h.getObjs().containsValue(fs));
        assertEquals(B, h.getPlace());

        h.go("PlaceA");
        assertEquals(B, h.getPlace());
    }
}