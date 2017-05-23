package me.themajster.mlimits.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by TheMajster on 23.05.2017.
 */
public class Util {

    public static String fixColors(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static List<String> fixColors(List<String> ls){
        List<String> list = new ArrayList<String>();
        for(String s : ls){
            list.add(fixColors(s));
        }
        return list;
    }
    public static String[] splitMaterial(String s){
        return s.split(":");
    }

    public static Collection<? extends Player> getOnlinePlayers() {
        final Object players = Bukkit.getOnlinePlayers();
        if (players instanceof Player[]) {
            return Arrays.asList((Player[])players);
        }
        return (Collection<? extends Player>)players;
    }

}
