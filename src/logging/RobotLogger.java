package logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import logging.LogFormatter;

public class RobotLogger {
    static private FileHandler usb;
    static private LogFormatter formatter;

    static public void setup() throws IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        usb = new FileHandler("usb.txt"); // on usb drive

        formatter = new LogFormatter();
        usb.setFormatter(formatter);

        logger.setUseParentHandlers(false);
        logger.addHandler(usb);

        logger.setLevel(Level.FINEST);

    }
}
