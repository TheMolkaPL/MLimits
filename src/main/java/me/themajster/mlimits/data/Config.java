package me.themajster.mlimits.data;

import lombok.Getter;
import lombok.Setter;
import me.themajster.mlimits.Main;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * Created by TheMajster on 23.05.2017.
 */
public class Config {

    private static boolean checkTask;
    private static boolean checkEvent;
    private static int timeCheck;


    public static void loadCfg(){
        FileConfiguration fc = Main.getPlugin().getConfig();
        checkTask = fc.getBoolean("Config.check.task");
        checkEvent = fc.getBoolean("Config.check.event");
        timeCheck = fc.getInt("Config.time");
    }

    public static void reloadCfg(){
        Main.getPlugin().reloadConfig();
        loadCfg();
    }

    public static int getTimeCheck() {
        return timeCheck;
    }

    public static boolean isCheckEvent() {
        return checkEvent;
    }

    public static boolean isCheckTask() {
        return checkTask;
    }
}
