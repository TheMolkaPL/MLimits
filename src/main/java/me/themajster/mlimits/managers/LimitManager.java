package me.themajster.mlimits.managers;

import me.themajster.mlimits.Main;
import me.themajster.mlimits.objects.Limit;
import me.themajster.mlimits.utils.Util;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by TheMajster on 19.06.2017.
 */
public class LimitManager {

    private static List<Limit> limits;

    static {
        limits = new ArrayList<>();
    }

    public static void load() {
        limits.clear();
        for (final String s : Main.getPlugin().getConfig().getConfigurationSection("Limits").getKeys(false)) {
            limits.add(new Limit(s));
        }
    }

    public static List<Limit> getLimits() {
        return limits;
    }
    public static void check(Player p) {
        for (Limit limit : LimitManager.getLimits()) {
            Material mat = (limit.isNameOrId() ? Material.getMaterial(limit.getMaterial()) : Material.getMaterial(Integer.valueOf(limit.getMaterial())));
            int amount = Util.getAmount(p, mat, (short)limit.getData());
            if (p.hasPermission(limit.getVpermission())) {
                if (amount > limit.getVlimit()) {
                    ItemStack is = new ItemStack(mat, amount - limit.getVlimit(), (short) limit.getData());

                    Util.removeInventoryItems(p.getInventory(), mat, limit.getData(), limit.getVlimit());
                    String[] split = Util.addItem(p, p.getEnderChest(), is).split("-");

                    if (Integer.parseInt(split[0]) != 0) {
                        for (String s : limit.getMessageMoveItem()) {
                            p.sendMessage(Util.fixColors(s.replace("{AMOUNT}", split[0])));
                        }
                    }
                    if (Integer.parseInt(split[1]) != 0) {
                        for (String s : limit.getMessageDropItem()) {
                            p.sendMessage(Util.fixColors(s.replace("{AMOUNT}", split[1])));
                        }
                    }
                }
            }else{
                if (amount > limit.getPlimit()) {
                    ItemStack is = new ItemStack(mat, amount - limit.getPlimit(), (short) limit.getData());

                    Util.removeInventoryItems(p.getInventory(), mat, limit.getData(), limit.getPlimit());
                    String[] split = Util.addItem(p, p.getEnderChest(), is).split("-");

                    if (Integer.parseInt(split[0]) != 0) {
                        for (String s : limit.getMessageMoveItem()) {
                            p.sendMessage(Util.fixColors(s.replace("{AMOUNT}", split[0])));
                        }
                    }
                    if (Integer.parseInt(split[1]) != 0) {
                        for (String s : limit.getMessageDropItem()) {
                            p.sendMessage(Util.fixColors(s.replace("{AMOUNT}", split[1])));
                        }
                    }
                }
            }
        }
    }
}
