package objectsTest;

import characters.Hero;
import characters.Monkey;
import objects.Banana;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.Place;

import static org.junit.jupiter.api.Assertions.*;

class BananaTest {

    private Banana b;
    private Place B;
    private Hero h;

    @BeforeEach
    void setUp() {
        Place a = new Place("Place", false, true);
        B = new Place("Experiments room", false, true);

        b = new Banana("Banana");
        a.addObject(b);

        h = new Hero("Test", a);
    }

    @Test
    void take() {
        b.take(h);
        assertTrue(h.getObjs().containsValue(b));
        assertFalse(h.getPlace().getItems().containsValue(b));
    }

    @Test
    void toStringTest() {
        System.out.println(b.toString());
    }

    @Test
    void look() {
        // Banana launch look alone
        b.look();

        // Hero launch banana look
        h.lookAt("Banana");
    }

    @Test
    void use() {
        b.use(h);
    }

    @Test
    void use2() {
        b.use(h);
    }
}