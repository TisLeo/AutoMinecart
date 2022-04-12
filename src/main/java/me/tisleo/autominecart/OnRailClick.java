package me.tisleo.autominecart;

import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

public class OnRailClick implements Listener {

    private final Plugin plugin;
    public static Entity oldMinecart;
    public static Player p;

    public OnRailClick(AutoMinecart plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        p = e.getPlayer();
        if (!(plugin.getConfig().getStringList("disabled_worlds").contains(p.getWorld().getName()))) {
            if (plugin.getConfig().getBoolean("players."+p.getUniqueId().toString()+".toggled")) {
                if (p.isOp() || p.hasPermission("autominecart.use")) {
                    if (!p.isInsideVehicle()) {
                        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                            if (e.getClickedBlock().getType() == Material.RAIL) {
                                if (!(p.getInventory().getItemInMainHand().getType() == Material.MINECART)) {
                                    Entity minecart = p.getWorld().spawn(e.getClickedBlock().getLocation(), EntityType.MINECART.getEntityClass());
                                    minecart.addPassenger(p);
                                    oldMinecart = minecart;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
