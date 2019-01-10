package logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RobotLogger {
    static private FileHandler usb;

    static public void setup() throws IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        logger.setLevel(Level.FINEST);

        usb = new FileHandler("usb.txt"); // on usb drive

        logger.addHandler(usb);
    }
}
