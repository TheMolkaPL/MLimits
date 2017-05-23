package me.themajster.mlimits.utils.tasks;

import me.themajster.mlimits.Main;
import org.bukkit.Bukkit;

/**
 * Created by TheMajster on 23.05.2017.
 */
public class CheckLimits {
    public static void enable(){
        Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), () ->{

        },20, 20);
    }
}
