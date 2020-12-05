package charactersTest;

import characters.Animal;
import characters.Enemy;
import characters.Hero;
import doors.*;
import objects.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.*;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    private Place A;
    private Place B;
    private Hero h;

    @BeforeEach
    void setUp() {
        A = new Place("PlaceA", false, true);
        B = new Place("PlaceB", false, true);
        h = new Hero("Test", A);

        Door d = new Door(A, B);

        A.addDoor(d, "right");
        B.addDoor(d, "left");
    }

    @Test
    void increaseBescherelle() {
        h.increaseBescherelle();
        assertEquals(Hero.DEFAULT_BESCHERELLE_LEVEL +1, h.getBLevel());
    }

    @Test
    void increaseKey() {
        h.increaseKey();
        assertEquals(Hero.DEFAULT_KEY_LEVEL +1, h.getKeyLevel());
    }

    @Test
    void setLife() {
        h.setLife(10);
        assertEquals(Hero.DEFAULT_HP + 10, h.getHP());

        h.setLife(-10);
        assertEquals(Hero.DEFAULT_HP, h.getHP());

        h.setLife(-1000);
        assertFalse(h.isAlive());
    }

    @Test
    void setImmunised() {
        h.setImmunised();
        assertTrue(h.isImmun());
    }

    @Test
    void setPlace() {
        h.setPlace(A);
        assertEquals(A, h.getPlace());

        h.setPlace(B);
        assertEquals(B, h.getPlace());

        h.setPlace(null);
        assertNull(h.getPlace());
    }

    @Test
    void attack() {
        Enemy e = new Enemy("Zombie Nazi", 15, 3, null,
                Script.ZOMBIE_DEFAULT, Script.ZOMBIE_ATTACK,
                Script.ZOMBIE_DEFEAT,Script.ZOMBIEDESCRIPT);

        // null case
        h.attack(null);

        int hpEnemy = e.getHP();

        // case without Club
        h.attack(e);
        assertEquals(hpEnemy-Hero.DEFAULT_DAMAGE, e.getHP());

        // case with Club
        hpEnemy = e.getHP();
        Weapon w = new Weapon(Script.DEFAULT_CLUB_NAME);
        A.addObject(w);
        h.take(Script.DEFAULT_CLUB_NAME);

        h.attack(e);
        assertEquals(hpEnemy-Hero.DEFAULT_CLUB_DAMAGE, e.getHP());
    }

    @Test
    void go() {
        // add a second door
        Place C = new Place("PlaceC", false, true);
        Door d1 = new Door(A, C);
        A.addDoor(d1, "up");
        C.addDoor(d1, "down");
        assertEquals(2, A.getDoors().size());

        // case there is exit
        System.out.println("==== case there is exit ==== ");
        h.go("up");
        assertEquals(C, h.getPlace());
        h.go("down");
        assertEquals(A, h.getPlace());
        h.go("right");
        assertEquals(B, h.getPlace());
        h.go("left");
        assertEquals(A, h.getPlace());

        h.go("PlaceB");
        assertEquals(B, h.getPlace());
        h.go("PlaceA");
        assertEquals(A, h.getPlace());

        // case the room does not exist
        System.out.println("==== case the room does not exist ==== ");
        h.go("left");
        assertEquals(A, h.getPlace());
        h.go("down");
        assertEquals(A, h.getPlace());
        h.go("right");
        assertEquals(B, h.getPlace());
        h.go("right");
        assertEquals(B, h.getPlace());
        h.go("up");
        assertEquals(B, h.getPlace());

        h.go("NOROOM");
        assertEquals(B, h.getPlace());

        // case where there is no doors
        System.out.println("==== case where there is no doors ==== ");
        A.getDoors().remove("PlaceB");
        A.getDoors().remove("PlaceC");

        h.go("right");
        assertEquals(B, h.getPlace());
    }

    @Test
    void heal() {
        // case with SexyPoste
        SexyPoster sp = new SexyPoster(Script.DEFAULT_SEXYPOSTER_NAME);
        A.addObject(sp);
        h.take(sp.NAME);
        assertTrue(h.getObjs().containsValue(sp));

        h.heal();
        assertFalse(h.getObjs().containsValue(sp));
        assertEquals(Hero.DEFAULT_HP+20, h.getHP());

        // case without SexyPoster
        int hp = h.getHP();
        h.heal();
        assertEquals(hp, h.getHP());
    }

    @Test
    void lookAt() {
        // null case
        h.lookAt(null);

        // case with Animals
        Animal cat = new Animal("Cat",1,Script.CAT_TEXT01,Script.CAT_TEXT02,Script.CAT_DESCRIPT);
        A.addAnimal(cat);
        h.lookAt(cat.NAME);

        // case with objs
        Stick s = new Stick(Script.DEFAULT_FIREDSTICK_NAME);
        A.addObject(s);
        h.lookAt(s.NAME);

        // case with objs in inventory
        h.take(s.NAME);
        assertTrue(h.getObjs().containsValue(s));
        h.lookAt(s.NAME);

        // case with Enemy
        A.addAndCreateEnemy("Zombie Nazi", 15, 3, null,
                Script.ZOMBIE_DEFAULT, Script.ZOMBIE_ATTACK,
                Script.ZOMBIE_DEFEAT,Script.ZOMBIEDESCRIPT);
        h.lookAt("TEST");
    }

    @Test
    void take() {
        // case null
        h.take(null);

        Banana banana = new Banana(Script.DEFAULT_BANANA_NAME);
        A.addObject(banana);

        h.take("banana"); // object that doesn't exist
        assertFalse(h.getObjs().containsValue(banana));
        assertTrue(h.getPlace().getItems().containsValue(banana));

        h.take("Banana"); // object that exist in the room
        assertTrue(h.getObjs().containsValue(banana));
        assertFalse(h.getPlace().getItems().containsValue(banana));

        // case with Animals
        Animal cat = new Animal("Cat",1,Script.CAT_TEXT01,Script.CAT_TEXT02,Script.CAT_DESCRIPT);
        A.addAnimal(cat);
        h.take(cat.NAME);
    }

    @Test
    void talk() {
        // null case
        h.talk(null);

        // not Existing Animal
        h.talk("Bird");

        // Existing Animal
        Animal cat = new Animal("Cat",1,Script.CAT_TEXT01,Script.CAT_TEXT02,Script.CAT_DESCRIPT);
        A.addAnimal(cat);
        h.talk(cat.NAME);

    }

    @Test
    void use() {
        // null case
        h.use(null);

        // case ElectricMeter
        ElectricityMeter e = new ElectricityMeter(Script.DEFAULT_ELECTRICMETER_NAME, A);
        A.addObject(e);
        h.use(e.NAME);

        // case Animal
        Animal cat = new Animal("Cat",1,Script.CAT_TEXT01,Script.CAT_TEXT02,Script.CAT_DESCRIPT);
        A.addAnimal(cat);
        h.use(cat.NAME);


        // not existing use implementation
        Key k = new Key("Key1");
        A.addObject(k);
        h.take("Key1");
        h.use("Key1");

        // existing use implementation
        SexyPoster sp = new SexyPoster("SexyPoster");
        A.addObject(sp);
        h.take("SexyPoster");
        h.use("SexyPoster");
        assertEquals(Hero.DEFAULT_HP+20, h.getHP());
    }

    @Test
    void testUse() {
        // case null
        h.use(null, null);

        // case one null
        Stick stick = new Stick(Script.DEFAULT_STICK_NAME);
        A.addObject(stick);
        h.take(stick.NAME);
        SexyPoster sp = new SexyPoster("SexyPoster");
        A.addObject(sp);
        h.take("SexyPoster");

        h.use(stick.NAME, null);
        h.use(sp.NAME, null);
        assertTrue(h.getObjs().containsValue(stick));
        assertTrue(h.getObjs().containsValue(sp));

        // case with implementaion use with 2 parameters
        Flint flint = new Flint(Script.DEFAULT_FLINT_NAME);
        A.addObject(flint);

        h.take(flint.NAME);

        Place C = new Place("Mortuary", false, true);
        Door d = new Door(A, C);
        A.addDoor(d, "left");
        h.go("left");

        h.use(stick.NAME,flint.NAME);
        assertFalse(h.getObjs().containsValue(stick));
        assertFalse(h.getObjs().containsValue(flint));
        assertTrue(h.getObjs().containsKey(Script.DEFAULT_FIREDSTICK_NAME));
    }

    @Test
    void showInventory() {
        Flint flint = new Flint(Script.DEFAULT_FLINT_NAME);
        A.addObject(flint);
        h.take(flint.NAME);Stick stick = new Stick(Script.DEFAULT_STICK_NAME);
        A.addObject(stick);
        h.take(stick.NAME);
        SexyPoster sp = new SexyPoster("SexyPoster");
        A.addObject(sp);
        h.take("SexyPoster");

        assertNotNull(h.getObjs());
        h.showInventory();
    }
}