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
        if(!checkFile()){
            System.out.println("["+getDescription().getName()+ "] Wykryto zmiany w plugin.yml");
            plugin = null;
        }
        System.out.println("["+getDescription().getName()+ "] zostal wlaczony!");
        saveDefaultConfig();
        LimitManager.load();
        Config.loadCfg();
        registerListeners();
        registerTasks();
    }

    public void onDisable(){
        System.out.println("["+getDescription().getName()+ "] zostal wylaczony!");
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
    private static boolean checkFile(){
        if(getPlugin().getDescription().getName().contains("MLimits") && getPlugin().getDescription().getAuthors().contains("TheMajster") && getPlugin().getDescription().getVersion().contains("0.3") &&
                getPlugin().getDescription().getMain().contains("me.themajster.mlimits.Main")) return true;
        return false;
    }
}