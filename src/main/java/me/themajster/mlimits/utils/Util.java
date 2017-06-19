package me.themajster.mlimits.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by TheMajster on 19.06.2017.
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

    public static Collection<? extends Player> getOnlinePlayers() {
        final Object players = Bukkit.getOnlinePlayers();
        if (players instanceof Player[]) {
            return Arrays.asList((Player[])players);
        }
        return (Collection<? extends Player>)players;
    }

    public static int getAmount(Player p, Material mat, int data){
        int i = 0;
        for(ItemStack is : p.getInventory().getContents()){
            if(is != null && is.getItemMeta() != null && is.getType().equals(mat) && is.getData().getData() == (short)data){
                i += is.getAmount();
            }
        }
        return i;
    }

    public static String addItem(Player p, Inventory inv, ItemStack is) {
        int toAdded = is.getAmount();
        int all = is.getAmount();
        int toDrop = 0;
        int toMove = 0;
        ItemStack item = null;
        for(int i = 0; i < inv.getSize(); i++){
            ItemStack itemStack = inv.getItem(i);
            if(toAdded == 0) break;
            if(itemStack == null){
                if(toAdded >= is.getMaxStackSize()){
                    item = new ItemStack(is.getType(), is.getMaxStackSize(), is.getData().getData());
                    toAdded -= is.getMaxStackSize();
                    toMove += is.getMaxStackSize();
                    inv.addItem(item);
                }else{
                    item = new ItemStack(is.getType(), toAdded, is.getData().getData());
                    toAdded -= item.getAmount();
                    toMove += item.getAmount();
                    inv.addItem(item);
                }
            }else if(itemStack != null){
                if(itemStack.getAmount() == is.getMaxStackSize()) continue;
                int toStack = itemStack.getMaxStackSize() - itemStack.getAmount();
                if(toAdded >= toStack){
                    item = new ItemStack(is.getType(), itemStack.getAmount() + toStack, is.getData().getData());
                    toAdded -= toStack;
                    toMove += toStack;
                    inv.setItem(i, item);
                }else{
                    item = new ItemStack(is.getType(), itemStack.getAmount() +toAdded, is.getData().getData());
                    toMove += toAdded;
                    toAdded -= toAdded;
                    inv.setItem(i, item);
                }
            }
        }
        if(all - toMove != 0){
            item = new ItemStack(is.getType(), all - toMove, is.getData().getData());
            toDrop += all - toMove;
            Bukkit.getWorld(p.getWorld().getName()).dropItemNaturally(p.getLocation(), item);
        }
        return new String(toMove+"-"+toDrop);
    }

    public static void removeInventoryItems(PlayerInventory inv, Material type, int data, int limit) {
        boolean removed = false;
        for (ItemStack is : inv.getContents()) {
            if (is != null && is.getType() == type && is.getData().getData() == (short) data) {
                if(!removed) {
                    if (is.getAmount() > limit) {
                        inv.removeItem(new ItemStack(is.getType(), is.getAmount() - limit, (short) data));
                        removed = true;
                    }else{
                        inv.removeItem(is);
                    }
                }else{
                    inv.removeItem(is);
                }
            }
        }
    }

}
