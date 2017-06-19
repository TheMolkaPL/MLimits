package me.themajster.mlimits.objects;

import lombok.Getter;
import lombok.Setter;
import me.themajster.mlimits.Main;

import java.util.List;

/**
 * Created by TheMajster on 19.06.2017.
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
    private final List<String> messageMoveItem;
    private final List<String> messageDropItem;

    public Limit(final String name){
        this.name = name;
        this.material = Main.getPlugin().getConfig().getString("Limits." + name + ".material");
        this.nameOrId = Main.getPlugin().getConfig().getBoolean("Limits." + name + ".material-type");
        this.data = Main.getPlugin().getConfig().getInt("Limits." + name + ".data");
        this.plimit = Main.getPlugin().getConfig().getInt("Limits." + name + ".player-amount");
        this.vlimit = Main.getPlugin().getConfig().getInt("Limits." + name + ".vip-amount");
        this.vpermission = Main.getPlugin().getConfig().getString("Limits." + name + ".vip-permission");
        this.messageMoveItem = Main.getPlugin().getConfig().getStringList("Limits." + name + ".messages.move-item");
        this.messageDropItem = Main.getPlugin().getConfig().getStringList("Limits." + name + ".messages.drop-item");
    }
}
