package logging;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import logging.RobotLogger;

public class Test {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public void test() {

        /* Levels (in descending order of priority):
        - SEVERE
        - WARNING
        - INFO
        - CONFIG
        - FINE
        - FINER
        - FINEST
         */

        LOGGER.setLevel(Level.SEVERE);
        LOGGER.severe("Severe Log");
        LOGGER.warning("Warning Log");
        LOGGER.info("Info Log");
        LOGGER.finest("Finest Log");

        LOGGER.setLevel(Level.INFO);
        LOGGER.severe("Severe Log");
        LOGGER.warning("Warning Log");
        LOGGER.info("Info Log");
        LOGGER.finest("Finest Log");
    }

    public static void main(String[] args) {
        Test tester = new Test();
        try {
            RobotLogger.setup();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Problems with creating the log files");
        }
        tester.test();
    }
}
