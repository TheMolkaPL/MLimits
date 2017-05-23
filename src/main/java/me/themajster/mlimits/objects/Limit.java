package me.themajster.mlimits.objects;

import lombok.Getter;
import lombok.Setter;
import me.themajster.mlimits.Main;

import java.util.List;

/**
 * Created by TheMajster on 23.05.2017.
 */
@Getter
@Setter
public class Limit {

    private final String name;
    private final boolean nameOrId;
    private final String material;
    private final int data;
    private final int plimit;
    private final int vlimit;
    private final String vpermission;
    private final List<String> messagePlayerMoveItem;
    private final List<String> messagePlayerDropItem;
    private final List<String> messageVipMoveItem;
    private final List<String> messageVipDropItem;

    public Limit(final String name){
        this.name = name;
        this.nameOrId = Main.getPlugin().getConfig().getBoolean("Limits." + name + ".type-material");
        this.material = Main.getPlugin().getConfig().getString("Limits." + name + ".material");
        this.data = Main.getPlugin().getConfig().getInt("Limits." + name + ".data");
        this.plimit = Main.getPlugin().getConfig().getInt("Limits." + name + ".player-amount");
        this.vlimit = Main.getPlugin().getConfig().getInt("Limits." + name + ".vip-amount");
        this.vpermission = Main.getPlugin().getConfig().getString("Limits." + name + ".vip-permission");
        this.messagePlayerMoveItem = Main.getPlugin().getConfig().getStringList("Limits." + name + ".messages.player-move-item");
        this.messagePlayerDropItem = Main.getPlugin().getConfig().getStringList("Limits." + name + ".messages.player-drop-item");
        this.messageVipMoveItem = Main.getPlugin().getConfig().getStringList("Limits." + name + ".messages.vip-move-item");
        this.messageVipDropItem = Main.getPlugin().getConfig().getStringList("Limits." + name + ".messages.vip-drop-item");
    }
}
