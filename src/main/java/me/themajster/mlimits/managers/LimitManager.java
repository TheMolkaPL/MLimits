package me.themajster.mlimits.managers;

import me.themajster.mlimits.Main;
import me.themajster.mlimits.objects.Limit;
import me.themajster.mlimits.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TheMajster on 23.05.2017.
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
            int i = 0;
            ItemStack is = null;
            if (limit.isNameOrId()) {
                i = Util.getAmount(p, Material.getMaterial(limit.getMaterial()), (short) limit.getData());
            } else {
                i = Util.getAmount(p, Material.getMaterial(Integer.valueOf(limit.getMaterial())), (short) limit.getData());
            }
            if (p.hasPermission(limit.getVpermission())) {
                if (i > limit.getVlimit()) {
                    if (limit.isNameOrId()) {
                        is = new ItemStack(Material.getMaterial(limit.getMaterial()), i - limit.getVlimit(), (short) limit.getData());
                    } else {
                        is = new ItemStack(Material.getMaterial(Integer.valueOf(limit.getMaterial())), i - limit.getVlimit(), (short) limit.getData());
                    }
                    int x = is.getAmount();
                    int xx= 0;
                    p.getInventory().remove(is);
                    for (int a = 0; a < p.getEnderChest().getSize(); a++) {
                        if (p.getEnderChest().getItem(a).getType().equals(is.getType()) && p.getEnderChest().getItem(a).getData().getData() == (short) limit.getData() && p.getEnderChest().getItem(a).getAmount() < is.getMaxStackSize()) {
                            if (limit.isNameOrId()) {
                                if (x != 0) {
                                    is = new ItemStack(Material.getMaterial(limit.getMaterial()), is.getMaxStackSize() - p.getEnderChest().getItem(a).getAmount(), (short) limit.getData());
                                    xx += is.getMaxStackSize() - p.getEnderChest().getItem(a).getAmount();
                                    x -= is.getMaxStackSize() - p.getEnderChest().getItem(a).getAmount();
                                }
                            } else {
                                if (x != 0) {
                                    is = new ItemStack(Material.getMaterial(Integer.valueOf(limit.getMaterial())), is.getMaxStackSize() - p.getEnderChest().getItem(a).getAmount(), (short) limit.getData());
                                    xx += is.getMaxStackSize() - p.getEnderChest().getItem(a).getAmount();
                                    x -= is.getMaxStackSize() - p.getEnderChest().getItem(a).getAmount();
                                }
                                p.getEnderChest().setItem(a, is);
                            }
                        } else {
                            if (limit.isNameOrId()) {
                                if (x != 0) {
                                    is = new ItemStack(Material.getMaterial(limit.getMaterial()), is.getMaxStackSize() - p.getEnderChest().getItem(a).getAmount(), (short) limit.getData());
                                    xx += is.getMaxStackSize() - p.getEnderChest().getItem(a).getAmount();
                                    x -= is.getMaxStackSize() - p.getEnderChest().getItem(a).getAmount();
                                }
                            } else {
                                if (x != 0) {
                                    is = new ItemStack(Material.getMaterial(Integer.valueOf(limit.getMaterial())), is.getMaxStackSize() - p.getEnderChest().getItem(a).getAmount(), (short) limit.getData());
                                    xx += is.getMaxStackSize() - p.getEnderChest().getItem(a).getAmount();
                                    x -= is.getMaxStackSize() - p.getEnderChest().getItem(a).getAmount();
                                }
                                p.getEnderChest().setItem(a, is);
                            }
                        }
                    }
                    if(xx != 0){
                        for(String s : limit.getMessageVipMoveItem()){
                            p.sendMessage(Util.fixColors(s.replace("{AMOUNT}", String.valueOf(xx))));
                        }
                        xx = 0;
                    }
                    if (x != 0) {
                        is = new ItemStack(Material.getMaterial(Integer.valueOf(limit.getMaterial())), x, (short) limit.getData());
                        Bukkit.getWorld(p.getWorld().getName()).dropItemNaturally(p.getLocation(), is);
                        for(String s : limit.getMessageVipDropItem()){
                            p.sendMessage(Util.fixColors(s.replace("{AMOUNT}", String.valueOf(x))));
                        }
                        x=0;
                    }
                }
            } else {
                if (i > limit.getPlimit()) {
                    if (limit.isNameOrId()) {
                        is = new ItemStack(Material.getMaterial(limit.getMaterial()), i - limit.getPlimit(), (short) limit.getData());
                    } else {
                        is = new ItemStack(Material.getMaterial(Integer.valueOf(limit.getMaterial())), i - limit.getPlimit(), (short) limit.getData());
                    }
                    int x = is.getAmount();
                    int xx= 0;
                    p.getInventory().remove(is);
                    for (int a = 0; a < p.getEnderChest().getSize(); a++) {
                        if (p.getEnderChest().getItem(a).getType().equals(is.getType()) && p.getEnderChest().getItem(a).getData().getData() == (short) limit.getData() && p.getEnderChest().getItem(a).getAmount() < is.getMaxStackSize()) {
                            if (limit.isNameOrId()) {
                                if (x != 0) {
                                    is = new ItemStack(Material.getMaterial(limit.getMaterial()), is.getMaxStackSize() - p.getEnderChest().getItem(a).getAmount(), (short) limit.getData());
                                    xx += is.getMaxStackSize() - p.getEnderChest().getItem(a).getAmount();
                                    x -= is.getMaxStackSize() - p.getEnderChest().getItem(a).getAmount();
                                }
                            } else {
                                if (x != 0) {
                                    is = new ItemStack(Material.getMaterial(Integer.valueOf(limit.getMaterial())), is.getMaxStackSize() - p.getEnderChest().getItem(a).getAmount(), (short) limit.getData());
                                    xx += is.getMaxStackSize() - p.getEnderChest().getItem(a).getAmount();
                                    x -= is.getMaxStackSize() - p.getEnderChest().getItem(a).getAmount();
                                }
                                p.getEnderChest().setItem(a, is);
                            }
                        } else {
                            if (limit.isNameOrId()) {
                                if (x != 0) {
                                    is = new ItemStack(Material.getMaterial(limit.getMaterial()), is.getMaxStackSize() - p.getEnderChest().getItem(a).getAmount(), (short) limit.getData());
                                    xx += is.getMaxStackSize() - p.getEnderChest().getItem(a).getAmount();
                                    x -= is.getMaxStackSize() - p.getEnderChest().getItem(a).getAmount();
                                }
                            } else {
                                if (x != 0) {
                                    is = new ItemStack(Material.getMaterial(Integer.valueOf(limit.getMaterial())), is.getMaxStackSize() - p.getEnderChest().getItem(a).getAmount(), (short) limit.getData());
                                    xx += is.getMaxStackSize() - p.getEnderChest().getItem(a).getAmount();
                                    x -= is.getMaxStackSize() - p.getEnderChest().getItem(a).getAmount();
                                }
                                p.getEnderChest().setItem(a, is);
                            }
                        }
                    }
                    if(xx != 0){
                        for(String s : limit.getMessagePlayerMoveItem()){
                            p.sendMessage(Util.fixColors(s.replace("{AMOUNT}", String.valueOf(xx))));
                        }
                        xx = 0;
                    }
                    if (x != 0) {
                        is = new ItemStack(Material.getMaterial(Integer.valueOf(limit.getMaterial())), x, (short) limit.getData());
                        Bukkit.getWorld(p.getWorld().getName()).dropItemNaturally(p.getLocation(), is);
                        for(String s : limit.getMessagePlayerDropItem()){
                            p.sendMessage(Util.fixColors(s.replace("{AMOUNT}", String.valueOf(x))));
                        }
                        x=0;
                    }
                }
            }
        }
    }
}
