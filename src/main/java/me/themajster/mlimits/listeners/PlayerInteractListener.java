package me.themajster.mlimits.listeners;

import me.themajster.mlimits.managers.LimitManager;
import me.themajster.mlimits.objects.Limit;
import me.themajster.mlimits.utils.Util;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by TheMajster on 23.05.2017.
 */
public class PlayerInteractListener implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        //TODO Check type item click
        LimitManager.check(p);
    }
}
