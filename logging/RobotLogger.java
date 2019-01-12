package frc.team4159.robot.Logger.logging;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RobotLogger {
    static public void setup() throws IOException {
        LogFormatter formatter = new LogFormatter();

        String foldername = "/media/sda1/team4159_logs_" +  LogFormatter.calcDate(System.currentTimeMillis());
        File dir = new File(foldername);
        dir.mkdir();

        Logger battery = Logger.getLogger("team4159.battery");
        FileHandler batteryFile = new FileHandler(foldername + "/batterylogs.csv"); // on usb drive
        batteryFile.setFormatter(formatter);
        battery.setUseParentHandlers(false);
        battery.addHandler(batteryFile);
        battery.setLevel(Level.FINEST);
        battery.config("level,timestamp,voltage");
    }
}
