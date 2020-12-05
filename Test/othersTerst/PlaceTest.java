package othersTerst;

import characters.Animal;
import characters.Enemy;
import doors.Door;
import objects.Flint;
import objects.Stick;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.Place;
import others.Script;

import static org.junit.jupiter.api.Assertions.*;

class PlaceTest {

    private Place A;
    private Place B;

    @BeforeEach
    void setUp() {
        A = new Place("PlaceA", false, false);
        B = new Place("PlaceB", true, true);
    }

    @Test
    void setEnlightened() {
        assertFalse(A.isEnlightened());
        A.setEnlightened();
        assertTrue(A.isEnlightened());
    }

    @Test
    void getDestinationName() {
        Door d = new Door(A, B);
        A.addDoor(d, "up");
        B.addDoor(d, "up");

        assertEquals(B.getName(), A.getDestinationName(d));
        assertEquals(A.getName(), B.getDestinationName(d));

        Door d1 = new Door(A, null);
        A.addDoor(d1, "up");

        assertEquals(A.getName(), A.getDestinationName(d1));
    }

    @Test
    void addAnimal() {
        assertFalse(A.isContainsAnimals());
        assertNull(A.getAnimals());

        Animal cat = new Animal("Cat",1, Script.CAT_TEXT01,
                Script.CAT_TEXT02,Script.CAT_DESCRIPT);

        A.setEnlightened();

        // case with null
        A.addAnimal(null);
        assertFalse(A.isContainsAnimals());
        assertNull(A.getAnimals());

        // case with cat
        A.addAnimal(cat);
        assertTrue(A.isContainsAnimals());
        assertNotNull(A.getAnimals());
        assertTrue(A.getAnimals().containsValue(cat));
        assertEquals(cat, A.getAnimals().get(cat.NAME));

    }

    @Test
    void addAndCreateEnemy() {
        assertFalse(A.isContainsEnemies());

        A.addAndCreateEnemy("Zombie", 15, 3, null,
                Script.ZOMBIE_DEFAULT, Script.ZOMBIE_ATTACK,
                Script.ZOMBIE_DEFEAT,Script.ZOMBIEDESCRIPT);
        assertTrue(A.isContainsEnemies());
        assertNotNull(A.getEnemies());
        assertEquals("Zombie", A.getEnemies().NAME);
    }

    @Test
    void setEnemy() {
        assertFalse(A.isContainsEnemies());
        assertNull(A.getEnemies());

        // case null
        A.setEnemy(null);
        assertFalse(A.isContainsEnemies());
        assertNull(A.getEnemies());

        // case with enemy
        Enemy e = new Enemy("Zombie", 15, 3, null,
                Script.ZOMBIE_DEFAULT, Script.ZOMBIE_ATTACK,
                Script.ZOMBIE_DEFEAT,Script.ZOMBIEDESCRIPT);
        A.setEnemy(e);
        assertTrue(A.isContainsEnemies());
        assertNotNull(A.getEnemies());
        assertEquals(e, A.getEnemies());
    }

    @Test
    void addObject() {
        assertFalse(A.isContainsObjs());
        assertNull(A.getItems());

        Stick stick = new Stick(Script.DEFAULT_STICK_NAME);

        A.setEnlightened();

        // case with null
        A.addObject(null);
        assertFalse(A.isContainsObjs());
        assertNull(A.getItems());

        // case with cat
        A.addObject(stick);
        assertTrue(A.isContainsObjs());
        assertNotNull(A.getItems());
        assertTrue(A.getItems().containsValue(stick));
        assertEquals(stick, A.getItems().get(stick.NAME));
    }

    @Test
    void addDoor() {
        assertFalse(A.isContainsDoors());
        assertNull(A.getDoors());

        Door d = new Door(A, B);

        A.setEnlightened();

        // case with null
        A.addDoor(null, "top");
        assertFalse(A.isContainsDoors());
        assertNull(A.getDoors());

        // case with top
        A.addDoor(d, "up");
        assertTrue(A.isContainsDoors());
        assertNotNull(A.getDoors());
        assertNotNull(A.getUpDoors());
        assertTrue(A.getDoors().containsValue(d));
        assertTrue(A.getUpDoors().containsValue(d));
        assertEquals(d, A.getDoors().get(A.getDestinationName(d)));

        // case with down
        Door d1 = new Door(A, B);

        A.addDoor(d1, "down");
        assertTrue(A.isContainsDoors());
        assertNotNull(A.getDoors());
        assertNotNull(A.getDownDoors());
        assertTrue(A.getDoors().containsValue(d1));
        assertTrue(A.getDownDoors().containsValue(d1));
        assertEquals(d1, A.getDoors().get(A.getDestinationName(d1)));

        // case with left
        Door d2 = new Door(A, B);

        A.addDoor(d2, "down");
        assertTrue(A.isContainsDoors());
        assertNotNull(A.getDoors());
        assertNotNull(A.getDownDoors());
        assertTrue(A.getDoors().containsValue(d2));
        assertTrue(A.getDownDoors().containsValue(d2));
        assertEquals(d2, A.getDoors().get(A.getDestinationName(d2)));

        // case with right
        Door d3 = new Door(A, B);

        A.addDoor(d3, "down");
        assertTrue(A.isContainsDoors());
        assertNotNull(A.getDoors());
        assertNotNull(A.getDownDoors());
        assertTrue(A.getDoors().containsValue(d3));
        assertTrue(A.getDownDoors().containsValue(d3));
        assertEquals(d3, A.getDoors().get(A.getDestinationName(d3)));
    }

    @Test
    void toStringAnimal() {
        // case without Animal
        assertFalse(A.isContainsAnimals());
        assertNull(A.getAnimals());
        System.out.println(A.toStringAnimal());

        // case with animals
        Animal cat = new Animal("Cat",1, Script.CAT_TEXT01,
                Script.CAT_TEXT02,Script.CAT_DESCRIPT);
        Animal mouse = new Animal("Mouse",2,Script.MOUSE_TEXT01,
                Script.MOUSE_TEXT02,Script.MOUSE_DESCRIPT);

        A.addAnimal(cat);
        A.addAnimal(mouse);

        assertTrue(A.isContainsAnimals());
        assertNotNull(A.getAnimals());
        System.out.println(A.toStringAnimal());
    }

    @Test
    void toStringObj() {
        // case without Objs
        assertFalse(A.isContainsObjs());
        assertNull(A.getItems());
        System.out.println(A.toStringObj());

        // case with Objs
        Stick stick = new Stick(Script.DEFAULT_STICK_NAME);
        Flint flint = new Flint(Script.DEFAULT_FLINT_NAME);

        A.addObject(stick);
        A.addObject(flint);

        assertTrue(A.isContainsObjs());
        assertNotNull(A.getItems());
        System.out.println(A.toStringObj());
    }

    @Test
    void toStringDoors() {
        // case without Doors
        assertFalse(A.isContainsDoors());
        assertNull(A.getDoors());
        System.out.println(A.toStringDoors());

        // case with Doors
        Door d1 = new Door(A, B);
        Door d2 = new Door(A, B);

        A.addDoor(d1, "up");
        A.addDoor(d2, "down");

        assertTrue(A.isContainsDoors());
        assertNotNull(A.getDoors());
        System.out.println(A.toStringDoors());
    }

    @Test
    void toStringEnemies() {
        // case without Ennemies
        assertFalse(A.isContainsEnemies());
        assertNull(A.getEnemies());
        System.out.println(A.toStringEnemies());

        // case with Ennemies
        A.addAndCreateEnemy("Zombie Nazi", 15, 3, null,
                Script.ZOMBIE_DEFAULT, Script.ZOMBIE_ATTACK,
                Script.ZOMBIE_DEFEAT,Script.ZOMBIEDESCRIPT);

        assertTrue(A.isContainsEnemies());
        assertNotNull(A.getEnemies());
        System.out.println(A.toStringEnemies());
    }

    @Test
    void testToString() {
        Animal cat = new Animal("Cat",1, Script.CAT_TEXT01,
                Script.CAT_TEXT02,Script.CAT_DESCRIPT);
        Animal mouse = new Animal("Mouse",2,Script.MOUSE_TEXT01,
                Script.MOUSE_TEXT02,Script.MOUSE_DESCRIPT);

        A.addAnimal(cat);
        A.addAnimal(mouse);

        Stick stick = new Stick(Script.DEFAULT_STICK_NAME);
        Flint flint = new Flint(Script.DEFAULT_FLINT_NAME);

        A.addObject(stick);
        A.addObject(flint);


        Door d1 = new Door(A, B);
        Door d2 = new Door(A, B);

        A.addDoor(d1, "up");
        A.addDoor(d2, "down");

        A.addAndCreateEnemy("Zombie Nazi", 15, 3, null,
                Script.ZOMBIE_DEFAULT, Script.ZOMBIE_ATTACK,
                Script.ZOMBIE_DEFEAT,Script.ZOMBIEDESCRIPT);

        // case when the place is not enlightened
        System.out.println(A.toString());

        // case when the place is enlightened
        A.setEnlightened();
        System.out.println(A.toString());
    }
}