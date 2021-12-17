package logging;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;

public class MyLoggerTests {

    @BeforeAll
    static void setup(){
        MyLogger.setup();
    }

    @Test
    @DisplayName("Testing Severe level logging")
    void testingSevereLevelLogging() {
        MyLogger.log(Level.SEVERE, "Emergency emergency, this is not a drill!!!");
    }

    @Test
    @DisplayName("Finest level logging")
    void finestLevelLogging() {
        MyLogger.log(Level.FINEST, "I breathed");
    }

    @Test
    @DisplayName("Info level logging")
    void infoLevelLogging() {
        MyLogger.log(Level.INFO, "There was a nice squirrel outside today");
    }

}
