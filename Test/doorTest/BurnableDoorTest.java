package doorTest;

import characters.Hero;
import doors.BurnableDoor;
import objects.FiredStick;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.Place;
import others.Script;

import static org.junit.jupiter.api.Assertions.*;

class BurnableDoorTest {

    private Place B;
    private Hero h;
    private BurnableDoor d;
    private FiredStick fs;

    @BeforeEach
    void setUp() {
        Place a = new Place("placea", false, true);
        B = new Place("placeb", false, true);

        d = new BurnableDoor(B, null);

        a.addDoor(d, "right");
        B.addDoor(d, "left");

        fs = new FiredStick(Script.DEFAULT_FIREDSTICK_NAME);
        a.addObject(fs);

        h = new Hero("Test", a);
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