package logging;

import java.io.IOException;
import java.util.logging.*;

public class MyLogger {
    private static final Logger logger = Logger.getLogger("MyLogger");

    public static void setup() {
        logger.setLevel(Level.ALL);
        logger.setUseParentHandlers(false);
        try {
            Handler fileHandler = new FileHandler("src/main/java/logging/myLog.log", true);
            fileHandler.setLevel(Level.FINEST);
            fileHandler.setFormatter(new CustomFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.WARNING);
        logger.addHandler(consoleHandler);
    }

    public static void log(Level logLevel, String toLog){
        logger.log(logLevel, toLog);
    }
}
