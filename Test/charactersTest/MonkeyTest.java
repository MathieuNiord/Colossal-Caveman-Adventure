package charactersTest;

import characters.Hero;
import characters.Monkey;
import objects.Bescherelle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.Place;
import others.Script;

import static org.junit.jupiter.api.Assertions.*;

class MonkeyTest {


    private Place a;
    private Hero h;
    private Monkey monkey;

    @BeforeEach
    void setUp() {
        a = new Place("Place", false, true);

        monkey = new Monkey("Monkey",3,Script.MONKEY_TEXT01,
                Script.MONKEY_TEXT02, Script.MONKEY_TEXT03,Script.MONKEY_DESCRIPT);

        h = new Hero("Test", a);
    }

    @Test
    void toStringTest() {
        assertEquals(monkey.NAME, monkey.toString());
    }

    @Test
    void talk() {
        Bescherelle b1 = new Bescherelle("B1");
        a.addObject(b1);
        assertTrue(a.getItems().containsValue(b1));

        // case without Bescherelle
       monkey.talk(h);
        assertEquals(0, h.getBLevel());

        // case with Bescherelle
        h.take("B1");
        assertTrue(h.getObjs().containsValue(b1));
        assertEquals(Hero.DEFAULT_BESCHERELLE_LEVEL +1, h.getBLevel());
        monkey.talk(h);
    }

    @Test
    void look() {
        monkey.look();
    }
}