package me.themajster.mlimits;

import me.themajster.mlimits.data.Config;
import me.themajster.mlimits.listeners.PlayerInteractListener;
import me.themajster.mlimits.managers.LimitManager;
import me.themajster.mlimits.utils.tasks.CheckLimits;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by TheMajster on 19.06.2017.
 */
public class Main extends JavaPlugin {

    private static Main plugin;

    public void onEnable(){
        plugin = this;

        saveDefaultConfig();
        LimitManager.load();
        Config.loadCfg();
        registerListeners();
        registerTasks();
    }

    public void onDisable(){
        Bukkit.getScheduler().cancelAllTasks();
    }

    public static Main getPlugin(){
        return plugin;
    }
    private static void registerListeners(){
        if(Config.isCheckEvent()){
            PluginManager pm = Bukkit.getPluginManager();
            pm.registerEvents(new PlayerInteractListener(), getPlugin());
        }
    }
    private static void registerTasks(){
        if(Config.isCheckTask()){
            CheckLimits.enable();
        }
    }
}
