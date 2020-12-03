package objectsTest;

import characters.Hero;
import objects.Locker;
import objects.Stick;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.Place;

import static org.junit.jupiter.api.Assertions.*;

class LockerTest {

    private Hero h;
    private Locker l;
    private Stick s;

    @BeforeEach
    void setUp() {
        Place a = new Place("Place", false, true);
        h = new Hero("Test", a);
        l = new Locker("Locker", h);
        a.addObject(l);


    }

    @Test
    void addObj() {
        assertNull(l.getObjs());

        s = new Stick("Stick");
        l.addObj(s);
        assertNotNull(l.getObjs());
        assertEquals(1, l.getObjs().size());
        assertEquals(s, l.getObjs().get(0));
    }

    @Test
    void look() {
        // case objs null
        l.look();

        // case avec objet
        s = new Stick("Stick");
        l.addObj(s);

        l.look();
        assertNull(l.getObjs());
        assertTrue(h.getObjs().containsValue(s));
    }

    @Test
    void take() {
        l.take(h);
    }

    @Test
    void use() {
        l.use(h);
    }

    @Test
    void testUse() {
        l.use(h, "Test");
    }

    @Test
    void testToString() {
        System.out.println(l.toString());
    }
}