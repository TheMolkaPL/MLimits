package me.themajster.mlimits.listeners;

import me.themajster.mlimits.managers.LimitManager;
import me.themajster.mlimits.objects.Limit;
import me.themajster.mlimits.utils.Util;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by TheMajster on 23.05.2017.
 */
public class PlayerInteractListener implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        for(Limit limit : LimitManager.getLimits()){
            if(limit.isNameOrId()){
                String[] split = Util.splitMaterial(limit.getMaterial());
                int i = Util.getAmount(e.getPlayer(), Material.getMaterial(split[0]), Short.valueOf(split[1]));
                if(e.getPlayer().hasPermission(limit.getVpermission())){
                    if(i > limit.getVlimit()){
                        //e.getPlayer().getInventory().remove(new ItemStack(Material.getMaterial(split[0]), ));

                    }
                }

            }else{

            }
        }

    }
}
