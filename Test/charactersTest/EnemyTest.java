package charactersTest;

import characters.Enemy;
import objects.Fuse;
import objects.Key;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.Script;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {

    private Enemy ac;
    private Enemy z;
    private Enemy fb;

    @BeforeEach
    void setUp() {
        Key k1 = new Key("Key1");
        Key k2 = new Key("Key2");
        Fuse fuse = new Fuse("Fuse");

        ac = new Enemy("Account guy", 10, 1, k1,
                Script.ACCOUNTGUY_DEFAULT, Script.ACCOUNTGUY_ATTACK,
                Script.ACCOUNTGUY_DEFEAT,Script.ACCOUNTGUY_DESCRIPT);
        z = new Enemy("Zombie Nazi", 15, 3, fuse,
                Script.ZOMBIE_DEFAULT, Script.ZOMBIE_ATTACK, Script.ZOMBIE_DEFEAT,Script.ZOMBIEDESCRIPT);
        fb = new Enemy("SUPER-NAZI", 20, 6, k2,
                Script.BOSS_DEFAULT, Script.BOSS_ATTACCK, Script.BOSS_DEFEAT,Script.BOSS_DESCRIPT);
    }

    @Test
    void takeDamage() {
        assertEquals(10, ac.getHP());
        assertEquals(15, z.getHP());
        assertEquals(20, fb.getHP());
        assertFalse(ac.isDefeat());
        assertFalse(z.isDefeat());
        assertFalse(fb.isDefeat());

        // case without defeat
        ac.takeDamage(1);
        z.takeDamage(1);
        fb.takeDamage(1);

        assertEquals(10-1, ac.getHP());
        assertEquals(15-1, z.getHP());
        assertEquals(20-1, fb.getHP());
        assertFalse(ac.isDefeat());
        assertFalse(z.isDefeat());
        assertFalse(fb.isDefeat());

        // case with Defeat
        ac.takeDamage(100);
        z.takeDamage(100);
        fb.takeDamage(100);

        assertTrue(ac.isDefeat());
        assertTrue(z.isDefeat());
        assertTrue(fb.isDefeat());
    }

    @Test
    void heal() {
        assertEquals(10, ac.getHP());
        ac.takeDamage(1);
        assertEquals(9, ac.getHP());
        ac.heal(2);
        assertEquals(10, ac.getHP());
    }

    @Test
    void loot() {

        // case with obj
        ac.loot();
        assertNull(ac.getItem());
        z.loot();
        assertNull(z.getItem());
        fb.loot();
        assertNull(fb.getItem());

        // case without obj
        ac.loot();
        assertNull(ac.getItem());

    }

    @Test
    void opening() {
        ac.opening();
        z.opening();
        fb.opening();
    }

    @Test
    void attack() {
        ac.attack();
        z.attack();
        fb.attack();
    }

    @Test
    void defeat() {
        ac.defeat();
        z.defeat();
        fb.defeat();
    }

    @Test
    void look() {
        ac.look();
        z.look();
        fb.look();
    }
}