package doorTest;

import doors.CondemnedDoor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.Place;

import static org.junit.jupiter.api.Assertions.*;

class CondemnedDoorTest {

    private CondemnedDoor d;

    @BeforeEach
    void setUp() {
        Place a = new Place("PlaceA", false, true);
        Place b = new Place("PlaceB", false, true);

        d = new CondemnedDoor(b, null);

        a.addDoor(d, "right");
        b.addDoor(d, "left");
    }

    @Test
    void open() {
        d.open();
        assertFalse(d.isOpen());
    }

    @Test
    void cross() {
        d.open();
        assertFalse(d.isOpen());
    }
}