package me.themajster.mlimits.utils;

import org.bukkit.ChatColor;

import java.util.ArrayList;
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

}
