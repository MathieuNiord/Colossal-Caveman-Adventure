package Characters;

import Doors.*;
import Objects.*;
import Others.*;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    private Place A;
    private Place B;
    private Hero h;
    private Door d;

    private Animal animtest;
    private Monkey m;

    private Weapon club;
    private Potion potion;
    private Banana banana;
    private Stick stick;
    private Flint flint;
    private Fuse fuse;
    private Bescherelle AnimtestB;
    private Key k1;
    private ElectricityMeter electricityMeter;
    private Locker locker;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        A = new Place("PlaceA", false, true);
        B = new Place("PlaceB", false, true);
        h = new Hero("ben", A);

        d = new Door(A, B);
        A.addDoor(d, "right");
        B.addDoor(d, "left");

        // création animaux
        Animal animtest = new Animal("AnimTest", 1, "talk without B", "talk with B", "descr");
        Monkey m = new Monkey("Monkey", 2, "Monkey talk without B", "Monkey talk with B", "Monkey hungry diag", "Moneky descrp");

        A.addAnimal(animtest);
        A.addAnimal(m);

        // création objet
        club = new Weapon("Club");
        potion = new Potion("Potion");
        banana = new Banana("Banana");
        stick = new Stick("Stick");
        flint = new Flint("Flint");
        fuse = new Fuse("Fuse");
        AnimtestB = new Bescherelle("Animtest-Bescherelle");
        k1 = new Key("Key1");
        electricityMeter = new ElectricityMeter("ElectricityMeter", A);
        locker = new Locker("Locker",h);

        A.addObject(club);
        A.addObject(potion);
        A.addObject(banana);
        A.addObject(stick);
        A.addObject(flint);
        A.addObject(fuse);
        A.addObject(AnimtestB);
        A.addObject(k1);
        A.addObject(electricityMeter);
        A.addObject(locker);
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
    void take() throws InterruptedException {

        h.take("Banana");
        System.out.println(h.getObjs().toString());
        assertTrue(h.getObjs().containsValue(banana));
        assertFalse(h.getPlace().getItems().containsValue(banana));
    }

    @org.junit.jupiter.api.Test
    void talk() {
    }

    @org.junit.jupiter.api.Test
    void go() {
    }

    @org.junit.jupiter.api.Test
    void use() {
    }

    @org.junit.jupiter.api.Test
    void testUse() {
    }

    @org.junit.jupiter.api.Test
    void lookAt() {
    }

    @org.junit.jupiter.api.Test
    void attack() {
    }

    @org.junit.jupiter.api.Test
    void heal() {
    }

    @org.junit.jupiter.api.Test
    void quit() {
    }
}