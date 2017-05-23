package me.themajster.mlimits;

import me.themajster.mlimits.managers.LimitManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by TheMajster on 23.05.2017.
 */
public class Main extends JavaPlugin {

    private static Main plugin;

    public void onEnable(){
        plugin = this;
        saveDefaultConfig();
        LimitManager.load();
    }

    public void onDisable(){

    }

    public static Main getPlugin(){
        return plugin;
    }
    private static void registerListeners(){
        PluginManager pm = Bukkit.getPluginManager();

    }
    private static void registerTasks(){

    }
}
