package othersTerst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.Game;

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