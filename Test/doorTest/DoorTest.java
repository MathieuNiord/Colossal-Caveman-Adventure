package doorTest;

import characters.Hero;
import doors.Door;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.Place;

import static org.junit.jupiter.api.Assertions.*;

class DoorTest {

    private Place A;
    private Place B;
    private Place C;
    private Hero h;
    private Door d;
    private Door d1;

    @BeforeEach
    void setUp() {
        A = new Place("PlaceA", false, true);
        B = new Place("PlaceB", false, true);
        C = new Place("PlaceC", false, true);

        d = new Door(A, B);
        d1 = new Door(C, null);

        A.addDoor(d1, "top");
        A.addDoor(d, "right");
        B.addDoor(d, "left");

        h = new Hero("Ben", A);
    }

    @Test
    void open() {
        System.out.println(d.getPlaces());
        System.out.println(d1.getPlaces());

        d.open();
        assertTrue(d.isOpen());
        d1.open();
        assertTrue(d1.isOpen());
    }

    @Test
    void cross() {
        d.cross(h, "PlaceB");
        assertEquals(B, h.getPlace());

        d.cross(h, "PlaceA");
        assertEquals(A, h.getPlace());

        d1.cross(h, "PlaceC");
        assertEquals(C, h.getPlace());

        d1.cross(h, "TESt");
        assertEquals(C, h.getPlace());

        d1.cross(h, null);
        assertEquals(C, h.getPlace());

        System.out.println(h.getPlace().getDoors());
        h.go("PlaceA");
        assertEquals(C, h.getPlace());

    }
}