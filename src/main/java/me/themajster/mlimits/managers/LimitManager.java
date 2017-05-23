package me.themajster.mlimits.managers;

import me.themajster.mlimits.Main;
import me.themajster.mlimits.objects.Limit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TheMajster on 23.05.2017.
 */
public class LimitManager {

    private static List<Limit> limits;

    static{
        limits = new ArrayList<>();
    }

    public static void load(){
        limits.clear();
        for (final String s : Main.getPlugin().getConfig().getConfigurationSection("Limits").getKeys(false)) {
            limits.add(new Limit(s));
        }
    }

    public static List<Limit> getLimits() {
        return limits;
    }
}
