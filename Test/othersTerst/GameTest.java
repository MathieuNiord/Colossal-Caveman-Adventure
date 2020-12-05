package othersTerst;

import characters.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.Game;
import others.Script;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game g;

    @BeforeEach
    void setUp() {
        g = new Game("Test");
    }

    @Test
    void help() {
        g.help();
    }

    @Test
    void displayEnvironment() {
        g.displayEnvironment();
    }
}