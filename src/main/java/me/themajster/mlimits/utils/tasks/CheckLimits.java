package me.themajster.mlimits.utils.tasks;

import me.themajster.mlimits.Main;
import me.themajster.mlimits.data.Config;
import me.themajster.mlimits.managers.LimitManager;
import me.themajster.mlimits.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by TheMajster on 19.06.2017.
 */
public class CheckLimits {
    public static void enable(){
        Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), () ->{
            for(Player p : Util.getOnlinePlayers()){
                LimitManager.check(p);
            }
        },20* Config.getTimeCheck(), 20* Config.getTimeCheck());
    }
}
