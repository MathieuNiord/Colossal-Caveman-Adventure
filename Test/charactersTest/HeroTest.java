package charactersTest;

import characters.Animal;
import characters.Enemy;
import characters.Hero;
import doors.*;
import objects.*;
import others.*;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    private Place A;
    private Place B;

    private Hero h;

    private Enemy e;

    private Banana banana;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        A = new Place("PlaceA", false, true);
        B = new Place("PlaceB", false, true);
        h = new Hero("Test", A);

        Door d = new Door(A, B);
        A.addDoor(d, "right");
        B.addDoor(d, "left");

        e = new Enemy("ennemyTest", 100, 1, null,
                "EnemyTest Script defaut", "EnemyTest Script Attack",
                "EnemyTest Script Defeat", "EnemyTest Script Description");

        // création animaux
        Animal animtest = new Animal("AnimTest", 1, "talk without B", "talk with B", "descr");

        A.addAnimal(animtest);

        // création objet
        Weapon club = new Weapon("Club");
        banana = new Banana("Banana");
        Stick stick = new Stick("Stick");
        Flint flint = new Flint("Flint");
        Key k1 = new Key("Key1");

        A.addObject(club);
        A.addObject(banana);
        A.addObject(stick);
        A.addObject(flint);
        A.addObject(k1);

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {

    }

    @org.junit.jupiter.api.Test
    void increaseBescherelle() {
        h.increaseBescherelle();
        h.increaseBescherelle();
        h.increaseBescherelle();
        int expected = 3;
        assertEquals(expected, h.getBLevel());
    }

    @org.junit.jupiter.api.Test
    void increaseKey() {
        h.increaseKey();
        h.increaseKey();
        h.increaseKey();
        int expected = 3;
        assertEquals(expected, h.getKeyLevel());
    }

    @org.junit.jupiter.api.Test
    void setLife() {

        h.setLife(10);
        assertEquals(Hero.DEFAULT_HP + 10, h.getHP());

        h.setLife(-10);
        assertEquals(Hero.DEFAULT_HP, h.getHP());
    }

    @org.junit.jupiter.api.Test
    void setImmunised() {
        h.setImmunised();
        assertTrue(h.isImmun());
    }

    @org.junit.jupiter.api.Test
    void setPlace() {
        h.setPlace(A);
        assertEquals(A, h.getPlace());

        h.setPlace(B);
        assertEquals(B, h.getPlace());

        h.setPlace(null);
        assertNull(h.getPlace());
    }

    @org.junit.jupiter.api.Test
    void attack() {
        // null case
        h.attack(null);

        int hpEnemy = e.getHP();

        // case without Club
        h.attack(e);
        assertEquals(hpEnemy-Hero.DEFAULT_DAMAGE, e.getHP());

        // case with Club
        hpEnemy = e.getHP();

        h.take("Club");
        h.attack(e);
        assertEquals(hpEnemy-Hero.DEFAULT_CLUB_DAMAGE, e.getHP());

    }

    @org.junit.jupiter.api.Test
    void go() {
        // null case
        h.go(null);
        assertEquals(A, h.getPlace());

        // Existing Place
        h.go("PlaceB");
        assertEquals(B, h.getPlace());

        // not existing place
        h.go("Kitchen");
        assertEquals(B, h.getPlace());

    }

    @org.junit.jupiter.api.Test
    void heal() {
        //TODO
    }

    @org.junit.jupiter.api.Test
    void lookAt() {
        // null case
        h.lookAt(null);
    }

    @org.junit.jupiter.api.Test
    void take() {

        h.take("banana"); // object that doesn't exist
        assertFalse(h.getObjs().containsValue(banana));
        assertTrue(h.getPlace().getItems().containsValue(banana));

        h.take("Banana"); // object that exist in the room
        assertTrue(h.getObjs().containsValue(banana));
        assertFalse(h.getPlace().getItems().containsValue(banana));

    }

    @org.junit.jupiter.api.Test
    void talk() {
        // null case
        h.talk(null);

        // not Existing Animal
        h.talk("Bird");

        // Existing Animal
        h.talk("AnimTest");

    }

    @org.junit.jupiter.api.Test
    void use() {
        // null case
        h.use(null);

        // not existing use implementation
        h.take("Key1");
        h.use("Key1");

    }

    @org.junit.jupiter.api.Test
    void testUse() {
        h.take("Flint");
        h.take("Stick");
        h.use("Flint", "Stick");
    }

    @org.junit.jupiter.api.Test
    void loose() {
        //TODO
    }

    @org.junit.jupiter.api.Test
    void win() {
        //TODO
    }

    @org.junit.jupiter.api.Test
    void quit() {
        h.quit();
        assertEquals(0, h.getHP());
    }
}