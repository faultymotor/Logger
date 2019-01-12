package frc.team4159.robot.Logger.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RobotLogger {
    static private FileHandler usb;
    static private LogFormatter formatter;

    static public void setup() throws IOException {
        formatter = new LogFormatter();

        String foldername = "/media/sda1/team4159_logs_" +  LogFormatter.calcDate(System.currentTimeMillis());
        File dir = new File(foldername);
        dir.mkdir();

        Logger battery = Logger.getLogger("team4159.battery");
        batteryFile = new FileHandler(foldername + "/batterylogs.csv"); // on usb drive
        battery.setFormatter(formatter);
        battery.setUseParentHandlers(false);
        battery.addHandler(batteryFile);
        battery.setLevel(Level.FINEST);
        battery.config("level,timestamp,voltage");
    }
}
