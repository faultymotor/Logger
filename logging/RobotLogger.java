package frc.team4159.robot.Logger.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import frc.team4159.robot.Logger.logging.LogFormatter;

public class RobotLogger {
    static private FileHandler usb;
    static private LogFormatter formatter;

    static public void setup() throws IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        usb = new FileHandler("/media/sda1/usb.csv"); // on usb drive

        formatter = new LogFormatter();
        usb.setFormatter(formatter);

        logger.setUseParentHandlers(false);
        logger.addHandler(usb);

        logger.setLevel(Level.FINEST);

        logger.config("level,timestamp,message");
    }
}
