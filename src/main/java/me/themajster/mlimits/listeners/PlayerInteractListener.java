package me.themajster.mlimits.listeners;

import me.themajster.mlimits.managers.LimitManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
/**
 * Created by TheMajster on 19.06.2017.
 */
public class PlayerInteractListener implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            LimitManager.check(p);
        }
    }
}
